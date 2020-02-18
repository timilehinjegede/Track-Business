package com.timilehinjegede.track_business.db;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "saleshistory")
public class SalesHistory {

    @PrimaryKey
    @NonNull
    private String name;
    private double quantitySold;
    private String quantityType;
    private double unitPriceSold;
    private double discountSold;
    private double totalPrice;
    private String soldTo;
    private String goodsCategory;
    private String date;
    private String time;

    public SalesHistory(@NonNull String name, double quantitySold, String quantityType, double unitPriceSold, double discountSold, double totalPrice, String soldTo, String goodsCategory, String date, String time) {
        this.name = name;
        this.quantitySold = quantitySold;
        this.quantityType = quantityType;
        this.unitPriceSold = unitPriceSold;
        this.discountSold = discountSold;
        this.totalPrice = totalPrice;
        this.soldTo = soldTo;
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

    public double getQuantitySold() {
        return quantitySold;
    }

    public String getQuantityType() {
        return quantityType;
    }

    public double getUnitPriceSold() {
        return unitPriceSold;
    }

    public double getDiscountSold() {
        return discountSold;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getSoldTo() {
        return soldTo;
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
