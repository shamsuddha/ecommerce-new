package personal.rajit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import personal.rajit.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> , QuerydslPredicateExecutor<Employee> {
}
