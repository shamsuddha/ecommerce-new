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
import personal.rajit.controller.request_dto.StockSearchDto;
import personal.rajit.controller.request_dto.StockSearchDto;
import personal.rajit.entity.QStock;
import personal.rajit.entity.Stock;
import personal.rajit.entity.Stock;
import personal.rajit.repository.StockRepository;
import personal.rajit.service.common.EntityValidationService;

import java.util.List;

import static personal.rajit.service.predicate.StockPredicate.makePredicate;

@Service
@AllArgsConstructor
public class StockService {

    private final EntityManager entityManager;
    private final EntityValidationService entityValidationService;
    private final StockRepository stockRepository;


    @org.springframework.transaction.annotation.Transactional
    public Stock saveStock(Stock stock) {
        return this.stockRepository.save(stock);
    }

    @org.springframework.transaction.annotation.Transactional
    public Stock updateStock(Stock stock) {
        var stockDb = entityValidationService.validateStock(stock.getId());
        stockDb.setName(stock.getName());
        stockDb.setCode(stock.getCode());
        stockDb = stockRepository.save(stockDb);
        return stockDb;
    }

    @org.springframework.transaction.annotation.Transactional
    public String deleteStock(Stock stock) {
        var stockDb = entityValidationService.validateStock(stock.getId());
        stockDb.setEnabled(Boolean.FALSE);
        stockRepository.save(stockDb);
        return "Stock deleted successfully";
    }

    public Page<Stock> searchStock(StockSearchDto stockSearchDto) {
        Predicate predicate = makePredicate(stockSearchDto);
        Pageable pageable = PageRequest.of(stockSearchDto.getPage(), stockSearchDto.getSize());
        final QStock qStock = QStock.stock;
        var query = new JPAQuery<Stock>(entityManager)
                .from(qStock)
                .where(predicate)
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .orderBy(qStock.createdDate.desc());
        return new PageImpl<>(query.fetch(), pageable, query.fetchCount());
    }

}
