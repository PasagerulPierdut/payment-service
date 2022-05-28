package com.accenture.paymentprocessor;

import com.accenture.model.Transaction;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionReceiver {


//    @JmsListener(destination = "TransactionQueue", containerFactory = "processorFactory")
    public void consumeTransaction(Transaction transaction) {

        System.out.println("Received: " + transaction + "from MainApp");
    }
}
