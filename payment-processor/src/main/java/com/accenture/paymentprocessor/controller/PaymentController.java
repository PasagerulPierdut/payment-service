package com.accenture.paymentprocessor.controller;

import com.accenture.model.Payment;
import com.accenture.model.Transaction;
import com.accenture.paymentprocessor.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private PaymentService paymentService;

    private final JmsTemplate template;

    public PaymentController(PaymentService paymentService, JmsTemplate template) {
        this.paymentService = paymentService;
        this.template = template;
    }

    @PostMapping("/new")
    ResponseEntity<String> registerPayment(@RequestBody Transaction transaction) {
        paymentService.registerPayment(transaction);
        return new ResponseEntity<>("Payment registered successfully", HttpStatus.OK);

    }

    @GetMapping
    ResponseEntity<List<Payment>> getAllPayments() {
        return new ResponseEntity<>(paymentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Payment> findPayment(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(paymentService.viewPayment(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable("id") Integer id,
                                                 @RequestBody Payment payment) {
        return new ResponseEntity<>(paymentService.updatePayment(id, payment), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable Integer id) {
        paymentService.deletePayment(id);
        return new ResponseEntity<>("Payment with ID" + id + "deleted,", HttpStatus.OK);
    }
}
