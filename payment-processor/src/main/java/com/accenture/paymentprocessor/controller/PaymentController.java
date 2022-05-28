package com.accenture.paymentprocessor.controller;

import com.accenture.model.Payment;
import com.accenture.model.Transaction;
import com.accenture.paymentprocessor.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PaymentController {

    private PaymentService paymentService;

    private final JmsTemplate template;

    public PaymentController(PaymentService paymentService, JmsTemplate template) {
        this.paymentService = paymentService;
        this.template = template;
    }

    @PostMapping("/payments/new")
    ResponseEntity<String> registerPayment(@RequestBody Transaction transaction) {
        paymentService.registerPayment(transaction);
        return new ResponseEntity<>("Payment registered successfully", HttpStatus.OK);

    }


}
