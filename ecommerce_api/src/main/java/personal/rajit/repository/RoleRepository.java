package personal.rajit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import personal.rajit.entity.Role;

public interface RoleRepository extends JpaRepository<Role, String> , QuerydslPredicateExecutor<Role> {
}