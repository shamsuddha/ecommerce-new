package personal.rajit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import personal.rajit.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> , QuerydslPredicateExecutor<Customer> {
}
