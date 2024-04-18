package personal.rajit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import personal.rajit.entity.Customer;
import personal.rajit.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> ,
        QuerydslPredicateExecutor<Product> {
}
