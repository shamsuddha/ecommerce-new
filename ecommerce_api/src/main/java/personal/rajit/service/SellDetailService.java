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
import personal.rajit.controller.request_dto.SellDetailSearchDto;
import personal.rajit.controller.request_dto.SellDetailSearchDto;
import personal.rajit.entity.SellDetail;
import personal.rajit.entity.QSellDetail;
import personal.rajit.entity.SellDetail;
import personal.rajit.repository.SellDetailRepository;
import personal.rajit.service.common.EntityValidationService;

import java.util.List;

import static personal.rajit.service.predicate.SellDetailPredicate.makePredicate;

@Service
@AllArgsConstructor
public class SellDetailService {

    private final EntityManager entityManager;
    private final EntityValidationService entityValidationService;
    private final SellDetailRepository sellDetailRepository;

    @org.springframework.transaction.annotation.Transactional
    public SellDetail saveSellDetail(SellDetail sellDetail) {
        return this.sellDetailRepository.save(sellDetail);
    }

    @org.springframework.transaction.annotation.Transactional
    public SellDetail updateSellDetail(SellDetail sellDetail) {
        var sellDetailDb = entityValidationService.validateSellDetail(sellDetail.getId());
        sellDetailDb.setName(sellDetail.getName());
        sellDetailDb.setCode(sellDetail.getCode());
        sellDetailDb = sellDetailRepository.save(sellDetailDb);
        return sellDetailDb;
    }

    @org.springframework.transaction.annotation.Transactional
    public String deleteSellDetail(SellDetail sellDetail) {
        var sellDetailDb = entityValidationService.validateSellDetail(sellDetail.getId());
        sellDetailDb.setEnabled(Boolean.FALSE);
        sellDetailRepository.save(sellDetailDb);
        return "SellDetail deleted successfully";
    }

    public Page<SellDetail> searchSellDetail(SellDetailSearchDto sellDetailSearchDto) {
        Predicate predicate = makePredicate(sellDetailSearchDto);
        Pageable pageable = PageRequest.of(sellDetailSearchDto.getPage(), sellDetailSearchDto.getSize());
        final QSellDetail qSellDetail = QSellDetail.sellDetail;
        var query = new JPAQuery<SellDetail>(entityManager)
                .from(qSellDetail)
                .where(predicate)
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .orderBy(qSellDetail.createdDate.desc());
        return new PageImpl<>(query.fetch(), pageable, query.fetchCount());
    }

}
