package com.techelevator.view;

import com.techelevator.CaTEringCapstoneCLI;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class  Menu {

    MoneyAccount moneyAccount = new MoneyAccount();
        // MAIN MENU
        public void displayLevel1() {
            System.out.println("Hello welcome to the CaTEring Machine! \n(D) Display CaTEring items \n(P) Purchase \n(E) Exit");
        }

        // SUB LEVEL for PURCHASE
        public void displayLevelPurchase() {
            System.out.println("(M) Feed Money \n(S) Select Item \n(F) Finish Transaction");

        }
}
