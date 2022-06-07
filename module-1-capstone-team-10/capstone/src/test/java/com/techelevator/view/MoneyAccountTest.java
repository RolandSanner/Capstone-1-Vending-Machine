package com.techelevator.view;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class MoneyAccountTest {
    private MoneyAccount moneyAccount;

    @Before
    public void setup(){
        this.moneyAccount = new MoneyAccount();
    }

    @Test
    public void makeChange_balance_is_1dollar_50cent_return_1_dollar_2_quarters() {


        assertEquals("1 Dollar 2 Quarters returned.",moneyAccount.getBalance());


    }

    @Test
    public void changeReturn_balance_is_10dollar_15cent_return_10_dollars_1_dime_1nickel() {


        assertEquals("Your change is: 10 dollars, 1 dime and, 1 nickle.",moneyAccount.getBalance());

    }


}
