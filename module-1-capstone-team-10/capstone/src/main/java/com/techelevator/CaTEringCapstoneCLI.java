package com.techelevator;

import com.techelevator.view.*;

import java.math.BigDecimal;
import java.util.Scanner;

public class CaTEringCapstoneCLI {


    // PROPERTIES
    private static MoneyAccount moneyAccount = new MoneyAccount();
    private Products products;
    private InventoryMap inventoryMap = new InventoryMap();

    // CONSTRUCTOR
    //TODO: Needed?
    public CaTEringCapstoneCLI() {

        moneyAccount = new MoneyAccount();

    }

    // METHODS
    public void feedMoney(BigDecimal moneyDeposited) {
        moneyAccount.addMoney(moneyDeposited);
        String moneyDepositedStr = "$" + moneyDeposited + ".00";
        System.out.println(moneyDepositedStr);
    }

    public void subtractMoney(BigDecimal moneySpent) {
        moneyAccount.subtractPrice(moneySpent);
        String moneySubtractedStr = "- $" + moneySpent;
        System.out.println(moneySubtractedStr);
    }


    public MoneyAccount getMoneyMethods() {
        return moneyAccount;
    }

    public BigDecimal getBalanceInCents() {
        BigDecimal balance = moneyAccount.balance;
        return balance;
    }

//    ***************************MENU***************************

    // PROPERTIES
    private Menu menu;
    private Scanner scanner;


    // METHODS
    public CaTEringCapstoneCLI(Menu menu) {
        this.menu = menu;
        this.scanner = new Scanner(System.in);
        this.inventoryMap.restockInventory();
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        CaTEringCapstoneCLI cli = new CaTEringCapstoneCLI(menu);
        cli.run();
    }

    public void run() {

        boolean keepGoing = true;

        do {

            this.menu.displayLevel1();
            String level1Input = scanner.nextLine();

            // MAIN MENU
            if (level1Input.equalsIgnoreCase("D")) {
                System.out.println(inventoryMap.getMapStr());
            } else if (level1Input.equalsIgnoreCase("P")) {
                this.menu.displayLevelPurchase();
                String purchaseLevelInput = scanner.nextLine();

// ****************************** SUB MENU IF P IS PRESSED **************************************************

                if (purchaseLevelInput.equalsIgnoreCase("M")) {
                    System.out.println("Please Insert U.S. Dollar Bill Amount: (1), (5), (10), or (20).");
                    Scanner subMenuScanner = new Scanner(System.in);
                    int moneyDeposited = Integer.parseInt(subMenuScanner.nextLine());
                    BigDecimal previousBalance = moneyAccount.getBalance().divide(new BigDecimal("100"));
                    try {
                        if (moneyDeposited == 1) {
                            moneyAccount.addMoney(new BigDecimal("100"));
                            System.out.println(moneyAccount.balanceString());
                            AuditLog.addToLog("FEED MONEY:                  ", previousBalance, moneyAccount.getBalance().divide(new BigDecimal("100")));
                        } else if (moneyDeposited == 5) {
                            moneyAccount.addMoney(new BigDecimal("500"));
                            System.out.println(moneyAccount.balanceString());
                            AuditLog.addToLog("FEED MONEY:                  ", previousBalance, moneyAccount.getBalance().divide(new BigDecimal("100")));
                        } else if (moneyDeposited == 10) {
                            moneyAccount.addMoney(new BigDecimal("1000"));
                            System.out.println(moneyAccount.balanceString());
                            AuditLog.addToLog("FEED MONEY:                  ", previousBalance, moneyAccount.getBalance().divide(new BigDecimal("100")));
                        } else if (moneyDeposited == 20) {
                            moneyAccount.addMoney(new BigDecimal("2000"));
                            System.out.println(moneyAccount.balanceString());
                            AuditLog.addToLog("FEED MONEY:                  ", previousBalance, moneyAccount.getBalance().divide(new BigDecimal("100")));
                        } else {
                            System.out.println("Please Insert Valid Currency");
                        }
                    } catch (Exception e) {
                        System.out.println("Please Insert Valid Currency");
                    }
//***************************************** S MENU PRESSED *********************************************************

                } else if (purchaseLevelInput.equalsIgnoreCase("S")) {
                    BigDecimal previousBalance = moneyAccount.getBalance().divide(new BigDecimal("100"));
                    System.out.println(inventoryMap.getMapStr());
                    System.out.println("Please enter the item code.");

                    try {
                        Scanner selectionScanner = new Scanner(System.in);
                        String selectedProduct = selectionScanner.nextLine();

                        Products product = inventoryMap.getInventory().get(selectedProduct);
                        System.out.println(product.getName());

                        if (product.getQuantity() == 0) {
                            System.out.println(product.getName() + " IS NO LONGER AVAILABLE");

                        } else if (moneyAccount.getBalance().compareTo(product.getPrice()) < 0) {
                            System.out.println("Insufficient Funds \n");

                        } else if (product.getQuantity() > 0) {
                            // REMOVE QUANTITY
                            product.setQuantity(product.getQuantity() - 1);
                            AuditLog.addToLog(product.getName() + " " +  product.getItemSlot()+"        ", previousBalance, moneyAccount.getBalance().divide(new BigDecimal("100")));

                            // REMOVE PRICE FROM BALANCE
                            BigDecimal price = product.getPrice();
                            moneyAccount.subtractPrice(price);

                            // PRINT ITEM CLASS MESSAGE
                            if (selectedProduct.contains("1")) {
                                System.out.println("Munchy, Munchy, so Good! \n");
                            } else if (selectedProduct.contains("2")) {
                                System.out.println("Sandwich So Delicious, Yum! \n");
                            } else if (selectedProduct.contains("3")) {
                                System.out.println("Drinky, Drinky, Slurp Slurp! \n");
                            } else if (selectedProduct.contains("4")) {
                                System.out.println("Sugar, Sugar, so Sweet! \n");
                            }
                        }
                        } catch(Exception e){
                            System.out.println("Invalid Input");
                            break;
                        }
// ****************************************** F MENU PRESSED ***************************************************

                    } else if (purchaseLevelInput.equalsIgnoreCase("F")) {
                        System.out.println(moneyAccount.changeReturn());

                    } else {
                        System.out.println("Invalid Command!");
                    }
                }

                // EXIT PROGRAM
                else if (level1Input.equalsIgnoreCase("E")) {
                    keepGoing = false;
                } else {
                    System.out.println("Invalid Command!");
                }
            } while (keepGoing) ;

        }
    }
