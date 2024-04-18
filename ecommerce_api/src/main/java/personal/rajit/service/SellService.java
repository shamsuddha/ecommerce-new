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
import personal.rajit.controller.request_dto.SellSearchDto;
import personal.rajit.controller.request_dto.SellSearchDto;
import personal.rajit.entity.QSell;
import personal.rajit.entity.Sell;
import personal.rajit.entity.Sell;
import personal.rajit.repository.SellRepository;
import personal.rajit.service.common.EntityValidationService;

import java.util.List;

import static personal.rajit.service.predicate.SellPredicate.makePredicate;

@Service
@AllArgsConstructor
public class SellService {
    private final EntityManager entityManager;
    private final EntityValidationService entityValidationService;
    private final SellRepository sellRepository;

    @org.springframework.transaction.annotation.Transactional
    public Sell saveSell(Sell sell) {
        return this.sellRepository.save(sell);
    }

    @org.springframework.transaction.annotation.Transactional
    public Sell updateSell(Sell sell) {
        var sellDb = entityValidationService.validateSell(sell.getId());
        sellDb.setName(sell.getName());
        sellDb.setCode(sell.getCode());
        sellDb = sellRepository.save(sellDb);
        return sellDb;
    }

    @org.springframework.transaction.annotation.Transactional
    public String deleteSell(Sell sell) {
        var sellDb = entityValidationService.validateSell(sell.getId());
        sellDb.setEnabled(Boolean.FALSE);
        sellRepository.save(sellDb);
        return "Sell deleted successfully";
    }

    public Page<Sell> searchSell(SellSearchDto sellSearchDto) {
        Predicate predicate = makePredicate(sellSearchDto);
        Pageable pageable = PageRequest.of(sellSearchDto.getPage(), sellSearchDto.getSize());
        final QSell qSell = QSell.sell;
        var query = new JPAQuery<Sell>(entityManager)
                .from(qSell)
                .where(predicate)
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .orderBy(qSell.createdDate.desc());
        return new PageImpl<>(query.fetch(), pageable, query.fetchCount());
    }


}
