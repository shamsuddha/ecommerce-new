package personal.rajit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import personal.rajit.entity.Customer;
import personal.rajit.entity.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, String> , QuerydslPredicateExecutor<Purchase> {
}
