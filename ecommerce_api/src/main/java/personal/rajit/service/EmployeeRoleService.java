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
import personal.rajit.controller.request_dto.EmployeeRoleSearchDto;
import personal.rajit.controller.request_dto.EmployeeRoleSearchDto;
import personal.rajit.entity.EmployeeRole;
import personal.rajit.entity.EmployeeRole;
import personal.rajit.entity.QEmployeeRole;
import personal.rajit.repository.EmployeeRoleRepository;
import personal.rajit.service.common.EntityValidationService;

import java.util.List;

import static personal.rajit.service.predicate.EmployeeRolePredicate.makePredicate;

@Service
@AllArgsConstructor
public class EmployeeRoleService {

    private final EntityManager entityManager;
    private final EntityValidationService entityValidationService;
    private final EmployeeRoleRepository employeeRoleRepository;

    @org.springframework.transaction.annotation.Transactional
    public EmployeeRole saveEmployeeRole(EmployeeRole employeeRole) {
        return this.employeeRoleRepository.save(employeeRole);
    }

    @org.springframework.transaction.annotation.Transactional
    public EmployeeRole updateEmployeeRole(EmployeeRole employeeRole) {
        var employeeRoleDb = entityValidationService.validateEmployeeRole(employeeRole.getId());
      //  employeeRoleDb.setName(employeeRole.getName());
        employeeRoleDb = employeeRoleRepository.save(employeeRoleDb);
        return employeeRoleDb;
    }

    @org.springframework.transaction.annotation.Transactional
    public String deleteEmployeeRole(EmployeeRole employeeRole) {
        var employeeRoleDb = entityValidationService.validateEmployeeRole(employeeRole.getId());
        employeeRoleDb.setEnabled(Boolean.FALSE);
        employeeRoleRepository.save(employeeRoleDb);
        return "EmployeeRole deleted successfully";
    }

    public Page<EmployeeRole> searchEmployeeRole(EmployeeRoleSearchDto employeeRoleSearchDto) {
        Predicate predicate = makePredicate(employeeRoleSearchDto);
        Pageable pageable = PageRequest.of(employeeRoleSearchDto.getPage(), employeeRoleSearchDto.getSize());
        final QEmployeeRole qEmployeeRole = QEmployeeRole.employeeRole;
        var query = new JPAQuery<EmployeeRole>(entityManager)
                .from(qEmployeeRole)
                .where(predicate)
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .orderBy(qEmployeeRole.createdDate.desc());
        return new PageImpl<>(query.fetch(), pageable, query.fetchCount());
    }

}
