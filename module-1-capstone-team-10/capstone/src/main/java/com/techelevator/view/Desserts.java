package com.techelevator.view;

import java.math.BigDecimal;

public class Desserts extends Products{


    public Desserts(String itemSlot, String name, BigDecimal price, int quantity) {
        super(itemSlot, name, price, quantity);
    }

    @Override
    public String getMessage(){
       return "Sugar, Sugar, so Sweet!";

    }

}
