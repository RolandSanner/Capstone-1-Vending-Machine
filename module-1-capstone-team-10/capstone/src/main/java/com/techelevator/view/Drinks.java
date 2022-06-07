package com.techelevator.view;

import java.math.BigDecimal;

public class Drinks extends Products{


    public Drinks(String itemSlot, String name, BigDecimal price, int quantity) {
        super(itemSlot, name, price, quantity);
    }

    @Override
    public String getMessage(){
        return "Drinky, Drinky, Slurp Slurp!";
    }

}
