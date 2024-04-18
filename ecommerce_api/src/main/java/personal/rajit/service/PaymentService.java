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
import personal.rajit.controller.request_dto.PaymentSearchDto;
import personal.rajit.controller.request_dto.PaymentSearchDto;
import personal.rajit.entity.Payment;
import personal.rajit.entity.Payment;
import personal.rajit.entity.QPayment;
import personal.rajit.repository.PaymentRepository;
import personal.rajit.service.common.EntityValidationService;

import java.util.List;

import static personal.rajit.service.predicate.PaymentPredicate.makePredicate;

@Service
@AllArgsConstructor
public class PaymentService {
    private final EntityManager entityManager;
    private final EntityValidationService entityValidationService;
    private final PaymentRepository paymentRepository;


    @org.springframework.transaction.annotation.Transactional
    public Payment savePayment(Payment payment) {
        return this.paymentRepository.save(payment);
    }

    @org.springframework.transaction.annotation.Transactional
    public Payment updatePayment(Payment payment) {
        var paymentDb = entityValidationService.validatePayment(payment.getId());
        paymentDb.setTransactionType(payment.getTransactionType());
        paymentDb.setPurpose(payment.getPurpose());
        paymentDb = paymentRepository.save(paymentDb);
        return paymentDb;
    }

    @org.springframework.transaction.annotation.Transactional
    public String deletePayment(Payment payment) {
        var paymentDb = entityValidationService.validatePayment(payment.getId());
        paymentDb.setEnabled(Boolean.FALSE);
        paymentRepository.save(paymentDb);
        return "Payment deleted successfully";
    }

    public Page<Payment> searchPayment(PaymentSearchDto paymentSearchDto) {
        Predicate predicate = makePredicate(paymentSearchDto);
        Pageable pageable = PageRequest.of(paymentSearchDto.getPage(), paymentSearchDto.getSize());
        final QPayment qPayment = QPayment.payment;
        var query = new JPAQuery<Payment>(entityManager)
                .from(qPayment)
                .where(predicate)
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .orderBy(qPayment.createdDate.desc());
        return new PageImpl<>(query.fetch(), pageable, query.fetchCount());
    }
}
