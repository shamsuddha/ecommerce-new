package personal.rajit.service;

import java.util.List;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import personal.rajit.controller.request_dto.EmployeeSearchDto;
import personal.rajit.controller.request_dto.EmployeeSearchDto;
import personal.rajit.entity.Employee;
import personal.rajit.entity.QEmployee;
import personal.rajit.repository.EmployeeRepository;
import personal.rajit.service.common.EntityValidationService;

import static personal.rajit.service.predicate.EmployeePredicate.makePredicate;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EntityManager entityManager;
    private final EntityValidationService entityValidationService;
    private final EmployeeRepository employeeRepository;

    @org.springframework.transaction.annotation.Transactional
    public Employee saveEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @org.springframework.transaction.annotation.Transactional
    public Employee updateEmployee(Employee employee) {
        var employeeDb = entityValidationService.validateEmployee(employee.getId());
        employeeDb.setName(employee.getName());
        employeeDb.setEmail(employee.getEmail());
        employeeDb.setPhone(employee.getPhone());
        employeeDb.setAddress(employee.getAddress());
        employeeDb.setImage(employee.getImage());
        employeeDb = employeeRepository.save(employeeDb);
        return employeeDb;
    }

    @org.springframework.transaction.annotation.Transactional
    public String deleteEmployee(Employee employee) {
        var employeeDb = entityValidationService.validateEmployee(employee.getId());
        employeeDb.setEnabled(Boolean.FALSE);
        employeeRepository.save(employeeDb);
        return "Employee deleted successfully";
    }

    public Page<Employee> searchEmployee(EmployeeSearchDto employeeSearchDto) {
        Predicate predicate = makePredicate(employeeSearchDto);
        Pageable pageable = PageRequest.of(employeeSearchDto.getPage(), employeeSearchDto.getSize());
        final QEmployee qEmployee = QEmployee.employee;
        var query = new JPAQuery<Employee>(entityManager)
                .from(qEmployee)
                .where(predicate)
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .orderBy(qEmployee.createdDate.desc());
        return new PageImpl<>(query.fetch(), pageable, query.fetchCount());
    }
}
