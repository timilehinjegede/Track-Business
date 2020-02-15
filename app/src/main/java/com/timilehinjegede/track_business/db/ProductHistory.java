package com.timilehinjegede.track_business.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "producthistory")
public class ProductHistory {

    @PrimaryKey
    private String name;
    private String quantity;
    private int quantityType;
    private double unitPrice;
    private double discount;
    private double totalPrice;
    private String soldTo;
    private String purchasedFrom;
    private String goodsCategory;

    public ProductHistory(String name, String quantity, int quantityType, double unitPrice, double discount, double totalPrice, String soldTo, String purchasedFrom, String goodsCategory) {
        this.name = name;
        this.quantity = quantity;
        this.quantityType = quantityType;
        this.unitPrice = unitPrice;
        this.discount = discount;
        this.totalPrice = totalPrice;
        this.soldTo = soldTo;
        this.purchasedFrom = purchasedFrom;
        this.goodsCategory = goodsCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public int getQuantityType() {
        return quantityType;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getSoldTo() {
        return soldTo;
    }

    public String getPurchasedFrom() {
        return purchasedFrom;
    }

    public String getGoodsCategory() {
        return goodsCategory;
    }
}
