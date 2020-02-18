package com.timilehinjegede.track_business.db;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "purchaseshistory")
public class PurchasesHistory {

    @PrimaryKey
    @NonNull
    private String name;
    private double quantityPurchased;
    private String quantityType;
    private double unitPricePurchased;
    private double discountPurchased;
    private double totalPrice;
    private String purchasedFrom;
    private String goodsCategory;
    private String date;
    private String time;

    public PurchasesHistory(@NonNull String name, double quantityPurchased, String quantityType, double unitPricePurchased, double discountPurchased, double totalPrice, String purchasedFrom, String goodsCategory, String date, String time) {
        this.name = name;
        this.quantityPurchased = quantityPurchased;
        this.quantityType = quantityType;
        this.unitPricePurchased = unitPricePurchased;
        this.discountPurchased = discountPurchased;
        this.totalPrice = totalPrice;
        this.purchasedFrom = purchasedFrom;
        this.goodsCategory = goodsCategory;
        this.date = date;
        this.time = time;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public double getQuantityPurchased() {
        return quantityPurchased;
    }

    public String getQuantityType() {
        return quantityType;
    }

    public double getUnitPricePurchased() {
        return unitPricePurchased;
    }

    public double getDiscountPurchased() {
        return discountPurchased;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getPurchasedFrom() {
        return purchasedFrom;
    }

    public String getGoodsCategory() {
        return goodsCategory;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}