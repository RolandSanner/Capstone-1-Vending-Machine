package com.techelevator.view;

import java.math.BigDecimal;

public class Munchies extends Products{

    public Munchies(String itemSlot, String name, BigDecimal price, int quantity) {
        super(itemSlot, name, price, quantity);
    }

    @Override
    public String getMessage(){
        return "Munchy, Munchy, so Good!";

    }




}
