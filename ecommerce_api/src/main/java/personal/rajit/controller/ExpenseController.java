package personal.rajit.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import personal.rajit.controller.request_dto.ExpenseSearchDto;
import personal.rajit.entity.Expense;
import personal.rajit.service.ExpenseService;

@RestController
@RequestMapping("/expense")
@AllArgsConstructor
public class ExpenseController {

  private final ExpenseService expenseService;

  @PostMapping("/save")
  public ResponseEntity<Expense> save(@RequestBody Expense expense) {
      return new ResponseEntity(expenseService.saveExpense(expense), HttpStatusCode.valueOf(200));
  }

  @PostMapping("/update")
  public ResponseEntity<Expense> update(@RequestBody Expense expense) {
      return new ResponseEntity(expenseService.updateExpense(expense), HttpStatusCode.valueOf(200));
  }

  @PostMapping("/delete")
  public ResponseEntity<String> deleteExpense(@RequestBody Expense expense) {
      return new ResponseEntity(expenseService.deleteExpense(expense), HttpStatusCode.valueOf(200));
  }

  @PostMapping("/search")
  public ResponseEntity<Page<Expense>> search(@RequestBody ExpenseSearchDto expenseSearchDto) {
      return new ResponseEntity(expenseService.searchExpense(expenseSearchDto), HttpStatusCode.valueOf(200));
  }

}
