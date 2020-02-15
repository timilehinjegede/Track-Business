package com.timilehinjegede.track_business.db;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "product")
public class Product {

    @PrimaryKey
    @NonNull
    private String name;
    private double quantity;
    private String quantityType;
    private double unitPrice;

    public Product(String name, double quantity, String quantityType, double unitPrice) {
        this.name = name;
        this.quantity = quantity;
        this.quantityType = quantityType;
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getQuantityType() {
        return quantityType;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}
