package com.ltp.globalsuperstore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

public class Inventory {
    private String id;
    private String category;
    private String productName;
    private double price;
    private double discount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderDate;

    public Inventory() {
        this.id = UUID.randomUUID().toString();
    }

    public Inventory(String category, String productName, double price, double discount, Date orderDate) {
        this.category = category;
        this.productName = productName;
        this.price = price;
        this.discount = discount;
        this.orderDate = orderDate;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return this.discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Date getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getFormatDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(orderDate);
    }

}
