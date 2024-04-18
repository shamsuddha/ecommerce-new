package personal.rajit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import personal.rajit.entity.EmployeeRole;

public interface EmployeeRoleRepository extends JpaRepository<EmployeeRole, String>, QuerydslPredicateExecutor<EmployeeRole> {
}
