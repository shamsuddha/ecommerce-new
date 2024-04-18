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
import personal.rajit.controller.request_dto.CustomerSearchDto;
import personal.rajit.entity.Customer;
import personal.rajit.entity.QCustomer;
import personal.rajit.repository.CustomerRepository;
import personal.rajit.service.common.EntityValidationService;

import java.util.List;

import static personal.rajit.service.predicate.CustomerPredicate.makePredicate;

@Service
@AllArgsConstructor
public class CustomerService {

    private final EntityManager entityManager;
    private final EntityValidationService entityValidationService;
    private final CustomerRepository customerRepository;

    @org.springframework.transaction.annotation.Transactional
    public Customer saveCustomer(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @org.springframework.transaction.annotation.Transactional
    public Customer updateCustomer(Customer customer) {
        var customerDb = entityValidationService.validateCustomer(customer.getId());
        customerDb.setName(customer.getName());
        customerDb.setEmail(customer.getEmail());
        customerDb.setPhone(customer.getPhone());
        customerDb.setAddress(customer.getAddress());
        customerDb.setCurrentBalance(customer.getCurrentBalance());
        customerDb.setImage(customer.getImage());
        customerDb = customerRepository.save(customerDb);
        return customerDb;
    }

    @org.springframework.transaction.annotation.Transactional
    public String deleteCustomer(Customer customer) {
        var customerDb = entityValidationService.validateCustomer(customer.getId());
        customerDb.setEnabled(Boolean.FALSE);
        customerRepository.save(customerDb);
        return "Customer deleted successfully";
    }

    public Page<Customer> searchCustomer(CustomerSearchDto customerSearchDto) {
        Predicate predicate = makePredicate(customerSearchDto);
        Pageable pageable = PageRequest.of(customerSearchDto.getPage(), customerSearchDto.getSize());
        final QCustomer qCustomer = QCustomer.customer;
        var query = new JPAQuery<Customer>(entityManager)
                .from(qCustomer)
                .where(predicate)
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .orderBy(qCustomer.createdDate.desc());
        return new PageImpl<>(query.fetch(), pageable, query.fetchCount());
    }

}
