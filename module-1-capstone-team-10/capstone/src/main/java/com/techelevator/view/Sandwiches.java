package com.techelevator.view;

import java.math.BigDecimal;

public class Sandwiches extends Products{


    public Sandwiches(String itemSlot, String name, BigDecimal price, int quantity) {
        super(itemSlot, name, price, quantity);
    }

    @Override
    public String getMessage(){
        return  "Sandwich So Delicious, Yum!";

    }
}
