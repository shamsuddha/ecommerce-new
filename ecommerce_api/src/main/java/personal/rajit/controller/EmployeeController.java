package personal.rajit.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.rajit.controller.request_dto.EmployeeSearchDto;
import personal.rajit.entity.Employee;
import personal.rajit.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {
      //  System.out.println(employee.getId());
      //  System.out.println(employee.getName());
        return new ResponseEntity(employeeService.saveEmployee(employee), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/update")
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {
        return new ResponseEntity(employeeService.updateEmployee(employee), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteEmployee(@RequestBody Employee employee) {
        return new ResponseEntity(employeeService.deleteEmployee(employee), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/search")
    public ResponseEntity<Page<Employee>> search(@RequestBody EmployeeSearchDto employeeSearchDto) {
        return new ResponseEntity(employeeService.searchEmployee(employeeSearchDto), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/make-active")
    public ResponseEntity<Page<Employee>> makeActive(@RequestBody Employee employee) {
        return new ResponseEntity(employeeService.makeActiveCustomer(employee), HttpStatusCode.valueOf(200));
    }

}
