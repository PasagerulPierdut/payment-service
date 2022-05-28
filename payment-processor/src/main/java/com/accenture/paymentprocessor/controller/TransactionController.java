package com.accenture.paymentprocessor.controller;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transactions")
public class TransactionController {

    private final JmsTemplate jmsTemplate;

    public TransactionController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

//    @PostMapping("/broadcaster")
//    public void broadcastNewTransaction(@RequestBody Transaction transaction) {
//        jmsTemplate.receive("TransactionQueue");
//        System.out.println("HERE");
//    }
}
