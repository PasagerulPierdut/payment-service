package com.accenture.model;
import com.accenture.paymentprocessor.TransactionType;

import java.time.LocalDateTime;

public class Transaction  extends BaseEntity {

    private Integer userId;

    private TransactionType transactionType;

    private double amount;

    private LocalDateTime createdAt;

    private boolean confirmed;

    private Product product;

    public Transaction() {
    }

    public Transaction(Integer userId, TransactionType transactionType, double amount, LocalDateTime createdAt, boolean confirmed, Product product) {
        this.userId = userId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.createdAt = createdAt;
        this.confirmed = confirmed;
        this.product = product;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "userId=" + userId +
                ", transactionType=" + transactionType +
                ", amount=" + amount +
                ", createdAt=" + createdAt +
                ", confirmed=" + confirmed +
                ", product=" + product +
                '}';
    }
}



