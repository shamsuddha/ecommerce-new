package personal.rajit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import personal.rajit.entity.Customer;
import personal.rajit.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, String> , QuerydslPredicateExecutor<Stock> {
}
