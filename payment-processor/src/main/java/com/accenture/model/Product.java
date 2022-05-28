package com.accenture.model;

import com.accenture.model.Transaction;

import java.time.LocalDateTime;
import java.util.List;

public class Product  extends BaseEntity {

    private String name;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    private List<Transaction> transactions;

    public Product() {
    }

    public Product(String name, String description, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @Override
    public String toString() {
        return "Product " +
                ", name: " + name + '\'' +
                ", description:'" + description + '\'' +
                ", createdAt: " + createdAt +
                ", modifiedAt: " + modifiedAt +
                '}';
    }
}
