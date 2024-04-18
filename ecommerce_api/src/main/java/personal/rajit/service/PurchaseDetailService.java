package personal.rajit.service;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.rajit.controller.request_dto.PurchaseDetailSearchDto;
import personal.rajit.controller.request_dto.PurchaseDetailSearchDto;
import personal.rajit.controller.request_dto.PurchaseSearchDto;
import personal.rajit.entity.PurchaseDetail;
import personal.rajit.entity.PurchaseDetail;
import personal.rajit.entity.Purchase;
import personal.rajit.entity.QPurchaseDetail;
import personal.rajit.repository.PurchaseDetailRepository;
import personal.rajit.repository.PurchaseDetailRepository;
import personal.rajit.service.common.EntityValidationService;

import java.util.List;

import static personal.rajit.service.predicate.PurchaseDetailPredicate.makePredicate;

@Service
@AllArgsConstructor
public class PurchaseDetailService {

    private final EntityManager entityManager;
    private final EntityValidationService entityValidationService;
    private final PurchaseDetailRepository purchaseDetailRepository;

    @org.springframework.transaction.annotation.Transactional
    public PurchaseDetail savePurchaseDetail(PurchaseDetail purchaseDetail) {
        return this.purchaseDetailRepository.save(purchaseDetail);
    }

    @org.springframework.transaction.annotation.Transactional
    public PurchaseDetail updatePurchaseDetail(PurchaseDetail purchaseDetail) {
        var purchaseDetailDb = entityValidationService.validatePurchaseDetail(purchaseDetail.getId());
        purchaseDetailDb.setQuantity(purchaseDetail.getQuantity());
        purchaseDetailDb.setUnitPrice(purchaseDetail.getUnitPrice());
        purchaseDetailDb.setDiscount(purchaseDetail.getDiscount());
        purchaseDetailDb = purchaseDetailRepository.save(purchaseDetailDb);
        return purchaseDetailDb;
    }

    @org.springframework.transaction.annotation.Transactional
    public String deletePurchaseDetail(PurchaseDetail purchaseDetail) {
        var purchaseDetailDb = entityValidationService.validatePurchaseDetail(purchaseDetail.getId());
        purchaseDetailDb.setEnabled(Boolean.FALSE);
        purchaseDetailRepository.save(purchaseDetailDb);
        return "PurchaseDetail deleted successfully";
    }

    public Page<PurchaseDetail> searchPurchaseDetail(PurchaseDetailSearchDto purchaseDetailSearchDto) {
        Predicate predicate = makePredicate(purchaseDetailSearchDto);
        Pageable pageable = PageRequest.of(purchaseDetailSearchDto.getPage(), purchaseDetailSearchDto.getSize());
        final QPurchaseDetail qPurchaseDetail = QPurchaseDetail.purchaseDetail;
        var query = new JPAQuery<PurchaseDetail>(entityManager)
                .from(qPurchaseDetail)
                .where(predicate)
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .orderBy(qPurchaseDetail.createdDate.desc());
        return new PageImpl<>(query.fetch(), pageable, query.fetchCount());
    }



}
