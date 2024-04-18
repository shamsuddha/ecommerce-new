package personal.rajit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import personal.rajit.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, String> , QuerydslPredicateExecutor<Payment> {
}
