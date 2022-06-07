package com.techelevator.view;

import java.math.BigDecimal;

public abstract class Products {

    //Properties
    private String name;
    private BigDecimal price;
    private String itemSlot;
    private String itemClass;
    private int quantity;

    public Products(String itemSlot, String name, BigDecimal price, int quantity) {
        this.name = name;
        this.price = price;
        this.itemSlot = itemSlot;
        this.quantity = quantity;
    }

    public abstract String getMessage();


    //Setters *******************************************
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setItemSlot(String itemSlot) {
        this.itemSlot = itemSlot;
    }

    public void setItemClass(String itemClass) {
        this.itemClass = itemClass;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //Getters *******************************************
    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price.multiply(new BigDecimal("100"));
    }

    public String getItemSlot() {
        return itemSlot;
    }

    public String getItemClass() {
        return itemClass;
    }

    public int getQuantity() {
        return quantity;
    }

}



