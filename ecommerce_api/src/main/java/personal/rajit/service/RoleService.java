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
import personal.rajit.controller.request_dto.RoleSearchDto;
import personal.rajit.controller.request_dto.RoleSearchDto;
import personal.rajit.entity.Role;
import personal.rajit.entity.QRole;
import personal.rajit.entity.Role;
import personal.rajit.repository.RoleRepository;
import personal.rajit.service.common.EntityValidationService;

import java.util.List;

import static personal.rajit.service.predicate.RolePredicate.makePredicate;

@Service
@AllArgsConstructor
public class RoleService {

    private final EntityManager entityManager;
    private final EntityValidationService entityValidationService;
    private final RoleRepository roleRepository;

    @org.springframework.transaction.annotation.Transactional
    public Role saveRole(Role role) {
        return this.roleRepository.save(role);
    }

    @org.springframework.transaction.annotation.Transactional
    public Role updateRole(Role role) {
        var roleDb = entityValidationService.validateRole(role.getId());
        roleDb.setName(role.getName());
        roleDb = roleRepository.save(roleDb);
        return roleDb;
    }

    @org.springframework.transaction.annotation.Transactional
    public String deleteRole(Role role) {
        var roleDb = entityValidationService.validateRole(role.getId());
        roleDb.setEnabled(Boolean.FALSE);
        roleRepository.save(roleDb);
        return "Role deleted successfully";
    }

    public Page<Role> searchRole(RoleSearchDto roleSearchDto) {
        Predicate predicate = makePredicate(roleSearchDto);
        Pageable pageable = PageRequest.of(roleSearchDto.getPage(), roleSearchDto.getSize());
        final QRole qRole = QRole.role;
        var query = new JPAQuery<Role>(entityManager)
                .from(qRole)
                .where(predicate)
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .orderBy(qRole.createdDate.desc());
        return new PageImpl<>(query.fetch(), pageable, query.fetchCount());
    }


}
