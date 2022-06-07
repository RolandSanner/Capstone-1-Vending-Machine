package com.techelevator.view;

import com.techelevator.CaTEringCapstoneCLI;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryMap {

    private static String fileName = "catering.csv";
    private static File inventoryFile = new File(fileName);
    private static int quantity = 7;


    private Map<String, Products> inventory = new HashMap<>();

    public  void restockInventory() {
//        Map<String, Products> inventoryMap = new HashMap<>();
        try {
            Scanner scanner = new Scanner(inventoryFile);
            while (scanner.hasNext()) {
                String lineName = scanner.nextLine();
                String[] splitString = lineName.split(",");

                if (splitString[2].equals("Drink")) {
                    Products drinks = new Drinks(splitString[0],splitString[1], BigDecimal.valueOf(Double.parseDouble(splitString[3])), quantity);
                    this.inventory.put(splitString[0], drinks);

                } else if (splitString[2].equals("Sandwich")) {
                    Products sandwich = new Sandwiches(splitString[0],splitString[1], BigDecimal.valueOf(Double.parseDouble(splitString[3])), quantity);
                    this.inventory.put(splitString[0], sandwich);

                } else if (splitString[2].equals("Munchy")) {
                    Products munchies = new Munchies(splitString[0],splitString[1],BigDecimal.valueOf(Double.parseDouble(splitString[3])), quantity);
                    this.inventory.put(splitString[0], munchies);

                } else if (splitString[2].equals("Dessert")) {
                    Products desserts = new Desserts(splitString[0],splitString[1], BigDecimal.valueOf(Double.parseDouble(splitString[3])), quantity);
                    this.inventory.put(splitString[0], desserts);
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("Incorrect File!");
        }
    }

    public Map<String, Products> getInventory() {
        return inventory;
    }

    public String getMapStr() {

        String mapString = "";

        for (Map.Entry<String, Products> entry : this.inventory.entrySet()) {
            mapString += entry.getKey() + ": " + entry.getValue().getName() + " | Price: $" + entry.getValue().getPrice().divide(new BigDecimal("100")) + " | Quantity: " + entry.getValue().getQuantity() + "\n";
        }
        return mapString;
    }

}
