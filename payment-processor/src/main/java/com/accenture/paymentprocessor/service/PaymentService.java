package com.accenture.paymentprocessor.service;

import com.accenture.model.Payment;
import com.accenture.model.Transaction;
import com.accenture.paymentprocessor.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PaymentService {

    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @JmsListener(destination = "TransactionQueue", containerFactory = "processorFactory")
    public void registerPayment(Transaction transaction) {
        Payment payment = new Payment();
        payment.setTransactionId(transaction.getId());
        payment.setAmount(transaction.getAmount());
        payment.setUserId(transaction.getUserId());
        System.out.println(transaction + "in payment service");
        paymentRepository.save(payment);
    }

    public Payment viewPayment(Integer id) {
        return paymentRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public Payment updatePayment(Integer id, Payment payment) {
        return paymentRepository.findById(id).map(existing -> {
            existing.setUserId(payment.getUserId());
            existing.setTransactionId(payment.getTransactionId());
            existing.setAmount(payment.getAmount());
            return paymentRepository.save(existing);
        }).orElseThrow(NoSuchElementException::new);
    }

    public void deletePayment(Integer id) {
        Optional<Payment> opt = paymentRepository.findById(id);
        if (opt.isPresent()) {
            paymentRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("Payment not registered.");
        }
    }
}
