package personal.rajit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import personal.rajit.entity.Customer;
import personal.rajit.entity.PurchaseDetail;

public interface PurchaseDetailRepository extends JpaRepository<PurchaseDetail, String> , QuerydslPredicateExecutor<PurchaseDetail> {
}
