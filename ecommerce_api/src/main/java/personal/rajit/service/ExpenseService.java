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
import personal.rajit.controller.request_dto.ExpenseSearchDto;
import personal.rajit.controller.request_dto.ExpenseSearchDto;
import personal.rajit.entity.Expense;
import personal.rajit.entity.Expense;
import personal.rajit.entity.QExpense;
import personal.rajit.repository.ExpenseRepository;
import personal.rajit.service.common.EntityValidationService;

import java.util.List;

import static personal.rajit.service.predicate.ExpensePredicate.makePredicate;

@Service
@AllArgsConstructor
public class ExpenseService {
    private final EntityManager entityManager;
    private final EntityValidationService entityValidationService;
    private final ExpenseRepository expenseRepository;


    @org.springframework.transaction.annotation.Transactional
    public Expense saveExpense(Expense expense) {
        return this.expenseRepository.save(expense);
    }

    @org.springframework.transaction.annotation.Transactional
    public Expense updateExpense(Expense expense) {
        var expenseDb = entityValidationService.validateExpense(expense.getId());
        expenseDb.setPurpose(expense.getPurpose());
        expenseDb.setAmount(expense.getAmount());
        expenseDb = expenseRepository.save(expenseDb);
        return expenseDb;
    }

    @org.springframework.transaction.annotation.Transactional
    public String deleteExpense(Expense expense) {
        var expenseDb = entityValidationService.validateExpense(expense.getId());
        expenseDb.setEnabled(Boolean.FALSE);
        expenseRepository.save(expenseDb);
        return "Expense deleted successfully";
    }

    public Page<Expense> searchExpense(ExpenseSearchDto expenseSearchDto) {
        Predicate predicate = makePredicate(expenseSearchDto);
        Pageable pageable = PageRequest.of(expenseSearchDto.getPage(), expenseSearchDto.getSize());
        final QExpense qExpense = QExpense.expense;
        var query = new JPAQuery<Expense>(entityManager)
                .from(qExpense)
                .where(predicate)
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .orderBy(qExpense.createdDate.desc());
        return new PageImpl<>(query.fetch(), pageable, query.fetchCount());
    }

}
