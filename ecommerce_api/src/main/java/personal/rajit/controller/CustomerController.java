package personal.rajit.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.rajit.controller.request_dto.CustomerSearchDto;
import personal.rajit.entity.Customer;
import personal.rajit.service.CustomerService;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<Customer> save(@RequestBody Customer customer) {
        System.out.println(customer.getId());
        System.out.println(customer.getName());
        return new ResponseEntity(customerService.saveCustomer(customer), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/update")
    public ResponseEntity<Customer> update(@RequestBody Customer customer) {
        return new ResponseEntity(customerService.updateCustomer(customer), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteCustomer(@RequestBody Customer customer) {
        return new ResponseEntity(customerService.deleteCustomer(customer), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/search")
    public ResponseEntity<Page<Customer>> search(@RequestBody CustomerSearchDto customerSearchDto) {
        return new ResponseEntity(customerService.searchCustomer(customerSearchDto), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/make-active")
    public ResponseEntity<Page<Customer>> makeActive(@RequestBody Customer customer) {
        return new ResponseEntity(customerService.makeActiveCustomer(customer), HttpStatusCode.valueOf(200));
    }
}
