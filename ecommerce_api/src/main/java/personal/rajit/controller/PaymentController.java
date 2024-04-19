package personal.rajit.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.rajit.controller.request_dto.PaymentSearchDto;
import personal.rajit.entity.Payment;
import personal.rajit.service.PaymentService;

@RestController
@RequestMapping("/payment")
@AllArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/save")
    public ResponseEntity<Payment> save(@RequestBody Payment payment) {
        return new ResponseEntity(paymentService.savePayment(payment), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/update")
    public ResponseEntity<Payment> update(@RequestBody Payment payment) {
        return new ResponseEntity(paymentService.updatePayment(payment), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody Payment payment) {
        return new ResponseEntity(paymentService.deletePayment(payment), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/search")
    public ResponseEntity<Page<Payment>> search(@RequestBody PaymentSearchDto paymentSearchDto) {
        return new ResponseEntity(paymentService.searchPayment(paymentSearchDto), HttpStatusCode.valueOf(200));
    }
  
}
