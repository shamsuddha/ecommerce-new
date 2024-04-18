package personal.rajit.service.common;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import personal.rajit.entity.*;
import personal.rajit.exception.UserInformException;
import personal.rajit.repository.*;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EntityValidationService {

    private final ProductCategoryRepository productCategoryRepository;
    private final CustomerRepository customerRepository;
    private final ExpenseRepository expenseRepository;
    private final PaymentRepository paymentRepository;
    private final PurchaseRepository purchaseRepository;
    private final PurchaseDetailRepository purchaseDetailRepository;
    private final ProductRepository productRepository;
    private final SellRepository sellRepository;
    private final SellDetailRepository sellDetailRepository;
    private final SupplierRepository supplierRepository;
    private final StockRepository stockRepository;
    private final EmployeeRepository employeeRepository;
    private final RoleRepository roleRepository;
    private final EmployeeRoleRepository employeeRoleRepository;

    public ProductCategory validateProductCategory(String id) {
        Objects.requireNonNull(id);
        return productCategoryRepository.findById(id)
                .orElseThrow(() -> new UserInformException(String
                        .format("Product Category not found with id: [%s]", id)));
    }

    public Customer validateCustomer(String id) {
        Objects.requireNonNull(id);
        return customerRepository.findById(id)
                .orElseThrow(() -> new UserInformException(String
                        .format("Customer not found with id: [%s]", id)));
    }

    public Expense validateExpense(String id) {
        Objects.requireNonNull(id);
        return expenseRepository.findById(id)
                .orElseThrow(() -> new UserInformException(String
                        .format("Expense not found with id: [%s]", id)));
    }

    public Payment validatePayment(String id) {
        Objects.requireNonNull(id);
        return paymentRepository.findById(id)
                .orElseThrow(() -> new UserInformException(String
                        .format("Payment not found with id: [%s]", id)));
    }

    public Purchase validatePurchase(String id) {
        Objects.requireNonNull(id);
        return purchaseRepository.findById(id)
                .orElseThrow(() -> new UserInformException(String
                        .format("Purchase not found with id: [%s]", id)));
    }

    public PurchaseDetail validatePurchaseDetail(String id) {
        Objects.requireNonNull(id);
        return purchaseDetailRepository.findById(id)
                .orElseThrow(() -> new UserInformException(String
                        .format("PurchaseDetail not found with id: [%s]", id)));
    }

    public Product validateProduct(String id) {
        Objects.requireNonNull(id);
        return productRepository.findById(id)
                .orElseThrow(() -> new UserInformException(String
                        .format("Product not found with id: [%s]", id)));
    }

    public Sell validateSell(String id) {
        Objects.requireNonNull(id);
        return sellRepository.findById(id)
                .orElseThrow(() -> new UserInformException(String
                        .format("Sell not found with id: [%s]", id)));
    }

    public Stock validateStock(String id) {
        Objects.requireNonNull(id);
        return stockRepository.findById(id)
                .orElseThrow(() -> new UserInformException(String
                        .format("Stock not found with id: [%s]", id)));
    }

    public SellDetail validateSellDetail(String id) {
        Objects.requireNonNull(id);
        return sellDetailRepository.findById(id)
                .orElseThrow(() -> new UserInformException(String
                        .format("SellDetail not found with id: [%s]", id)));
    }

    public Supplier validateSupplier(String id) {
        Objects.requireNonNull(id);
        return supplierRepository.findById(id)
                .orElseThrow(() -> new UserInformException(String
                        .format("Supplier not found with id: [%s]", id)));
    }

    public Employee validateEmployee(String id) {
        Objects.requireNonNull(id);
        return employeeRepository.findById(id)
                .orElseThrow(() -> new UserInformException(String
                        .format("Employee not found with id: [%s]", id)));
    }

    public Role validateRole(String id) {
        Objects.requireNonNull(id);
        return roleRepository.findById(id)
                .orElseThrow(() -> new UserInformException(String
                        .format("Role not found with id: [%s]", id)));
    }

    public EmployeeRole validateEmployeeRole(String id) {
        Objects.requireNonNull(id);
        return employeeRoleRepository.findById(id)
                .orElseThrow(() -> new UserInformException(String
                        .format("EmployeeRole not found with id: [%s]", id)));
    }
}