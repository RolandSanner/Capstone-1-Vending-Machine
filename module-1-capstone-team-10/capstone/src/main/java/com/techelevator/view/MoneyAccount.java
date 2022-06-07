package com.techelevator.view;

import java.math.BigDecimal;

public class MoneyAccount {

    //Properties
    public BigDecimal balance = new BigDecimal("0.00"); // DO NOT REMOVE REDUNDANCY, MAKES BALANCE NULL

    //Constructor
    public MoneyAccount() {
        this.balance = getBalance();
    }

    // GETTER
    public BigDecimal getBalance() {
        return balance;
    }

    //Methods

    public void addMoney(BigDecimal depositAmount) {
        balance = balance.add(depositAmount);
    }

    public void subtractPrice(BigDecimal price) {
        balance = balance.subtract(price);
    }

    //Returning balance as a string
    public String balanceString() {
        String balanceString = "Current Money Provided: $" + getBalance().divide(new BigDecimal("100"));
        return balanceString;
    }

    // Change return

    public String changeReturn() {
        BigDecimal coinAccount = getBalance();

        int dollarReturn = 0;                   //ADDED DOLLAR TO THE RETURN BECAUSE README SAID SO | EF: YES! GROOVY.
        int quarterReturn = 0;
        int dimeReturn = 0;
        int nickleReturn = 0;
        String returnChange = "";

        BigDecimal dollar = new BigDecimal("100");
        BigDecimal quarter = new BigDecimal("25");
        BigDecimal dime = new BigDecimal("10");
        BigDecimal nickel = new BigDecimal("5");

        BigDecimal previousBalance = getBalance().divide(new BigDecimal("100"));

        while (coinAccount.compareTo(new BigDecimal("0")) > 0) {
            if (coinAccount.compareTo(dollar) >= 0) {
                dollarReturn++;
                coinAccount = coinAccount.subtract(dollar);
            }else if (coinAccount.compareTo(quarter) >= 0) {
                quarterReturn++;
                coinAccount = coinAccount.subtract(quarter);
            } else if (coinAccount.compareTo(dime) >= 0) {
                dimeReturn++;
                coinAccount = coinAccount.subtract(dime);
            } else if (coinAccount.compareTo(nickel) >= 0) {
                nickleReturn++;
                coinAccount = coinAccount.subtract(nickel);
            }

        }
        // ** ONE THING WE NEED TO INCORPORATE IS PREVIOUS BALANCE AND CURRENT BALANCE FOR THE AUDIT LOG **

        returnChange = "Your change is: " + dollarReturn + " dollars, " + quarterReturn + " quarters, " + dimeReturn + " dimes, and " + nickleReturn + " nickles.";
        this.balance = coinAccount;
        AuditLog.addToLog("GIVE CHANGE:                  ", previousBalance, coinAccount);
        return returnChange;
    }

}



