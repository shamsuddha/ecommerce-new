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
import personal.rajit.controller.request_dto.SupplierSearchDto;
import personal.rajit.entity.QSupplier;
import personal.rajit.entity.Supplier;
import personal.rajit.repository.SupplierRepository;
import personal.rajit.service.common.EntityValidationService;

import java.util.List;
import static personal.rajit.service.predicate.SupplierPredicate.makePredicate;

@Service
@AllArgsConstructor
public class SupplierService {

    private final EntityManager entityManager;
    private final EntityValidationService entityValidationService;
    private final SupplierRepository supplierRepository;

    @org.springframework.transaction.annotation.Transactional
    public Supplier saveSupplier(Supplier supplier) {
        return this.supplierRepository.save(supplier);
    }

    @org.springframework.transaction.annotation.Transactional
    public Supplier updateSupplier(Supplier supplier) {
        var supplierDb = entityValidationService.validateSupplier(supplier.getId());
        supplierDb.setName(supplier.getName());
        supplierDb.setCompany(supplier.getCompany());
        supplierDb.setAddress(supplier.getAddress());
        supplierDb.setPhoneNumber(supplier.getPhoneNumber());
        supplierDb.setCurrentBalance(supplier.getCurrentBalance());
        supplierDb = supplierRepository.save(supplierDb);
        return supplierDb;
    }

    @org.springframework.transaction.annotation.Transactional
    public String deleteSupplier(Supplier supplier) {
        var supplierDb = entityValidationService.validateSupplier(supplier.getId());
        supplierDb.setEnabled(Boolean.FALSE);
        supplierRepository.save(supplierDb);
        return "Supplier deleted successfully";
    }

    public Page<Supplier> searchSupplier(SupplierSearchDto supplierSearchDto) {
        Predicate predicate = makePredicate(supplierSearchDto);
        Pageable pageable = PageRequest.of(supplierSearchDto.getPage(), supplierSearchDto.getSize());
        final QSupplier qSupplier = QSupplier.supplier;
        var query = new JPAQuery<Supplier>(entityManager)
                .from(qSupplier)
                .where(predicate)
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .orderBy(qSupplier.createdDate.desc());
        return new PageImpl<>(query.fetch(), pageable, query.fetchCount());
    }

}
