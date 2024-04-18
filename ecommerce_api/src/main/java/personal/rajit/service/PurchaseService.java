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
import personal.rajit.controller.request_dto.PurchaseSearchDto;
import personal.rajit.controller.request_dto.PurchaseSearchDto;
import personal.rajit.entity.Purchase;
import personal.rajit.entity.Purchase;
import personal.rajit.entity.PurchaseDetail;
import personal.rajit.entity.QPurchase;
import personal.rajit.repository.PurchaseDetailRepository;
import personal.rajit.repository.PurchaseRepository;
import personal.rajit.service.common.EntityValidationService;

import java.util.List;

import static personal.rajit.service.predicate.PurchasePredicate.makePredicate;

@Service
@AllArgsConstructor
public class PurchaseService {

    private final EntityManager entityManager;
    private final EntityValidationService entityValidationService;
    private final PurchaseRepository purchaseRepository;
    private final PurchaseDetailRepository purchaseDetailRepository;

    @org.springframework.transaction.annotation.Transactional
    public Purchase savePurchase(Purchase purchase) {
        return this.purchaseRepository.save(purchase);
    }

    @org.springframework.transaction.annotation.Transactional
    public Purchase updatePurchase(Purchase purchase) {
        var purchaseDb = entityValidationService.validatePurchase(purchase.getId());
        purchaseDb.setNote(purchase.getNote());
        purchaseDb.setTotalAmount(purchase.getTotalAmount());
        purchaseDb.setOtherCost(purchase.getOtherCost());
        purchaseDb = purchaseRepository.save(purchaseDb);
        return purchaseDb;
    }

    @org.springframework.transaction.annotation.Transactional
    public String deletePurchase(Purchase purchase) {
        var purchaseDb = entityValidationService.validatePurchase(purchase.getId());
        purchaseDb.setEnabled(Boolean.FALSE);
        purchaseRepository.save(purchaseDb);
        return "Purchase deleted successfully";
    }

    public Page<Purchase> searchPurchase(PurchaseSearchDto purchaseSearchDto) {
        Predicate predicate = makePredicate(purchaseSearchDto);
        Pageable pageable = PageRequest.of(purchaseSearchDto.getPage(), purchaseSearchDto.getSize());
        final QPurchase qPurchase = QPurchase.purchase;
        var query = new JPAQuery<Purchase>(entityManager)
                .from(qPurchase)
                .where(predicate)
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .orderBy(qPurchase.createdDate.desc());
        return new PageImpl<>(query.fetch(), pageable, query.fetchCount());
    }

    

   public Purchase saveWithDetail(Purchase purchase) {
       purchase.getPurchaseDetailList().forEach(e -> System.out.println("from prop " + e.getId()));
       //purchase.getPurchaseDetailListSerde().forEach(e -> System.out.println("from serde " + e.getId()));
       Purchase purchaseSaved = this.purchaseRepository.save(purchase);

       List<PurchaseDetail> purchaseDetailList = purchase.getPurchaseDetailList().stream().map(e -> {
           e.setPurchase(new Purchase(purchaseSaved.getId()));
           return e;
       }).toList();

       List<PurchaseDetail> purchaseDetailListSaved = this.purchaseDetailRepository.saveAll(purchaseDetailList);
       purchaseSaved.setPurchaseDetailList(purchaseDetailListSaved);
       return purchaseSaved;
   }

}
