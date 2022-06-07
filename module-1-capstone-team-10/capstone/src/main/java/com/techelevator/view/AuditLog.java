package com.techelevator.view;

import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditLog {

    private static File logFile = new File("Audit.txt");

    public static void createLogFile() {
        if (logFile.exists()) {
            logFile.delete();
        }
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // EXAMPLES GIVEN
    // >01/01/2016 12:00:15 PM MONEY FED:         $5.00 $10.00
    // >01/01/2016 12:00:20 PM Bruschetta     B4 $10.00 $8.50
    // >01/01/2016 12:01:25 PM Turkey Sandwich B2 $8.50 $7.50
    // >01/01/2016 12:01:35 PM CHANGE GIVEN:      $7.50 $0.00

    public static void addToLog(String message, BigDecimal previousBalance, BigDecimal currentBalance) {
        if (!logFile.exists()) {
            createLogFile();
        } else if (logFile.exists()) {
            try (PrintWriter outPut = new PrintWriter(new FileOutputStream(logFile, true))) {
                DecimalFormat df = new DecimalFormat("0.00");
                LocalDateTime dateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
                String dateText = dateTime.format(formatter);
                outPut.println(">" + dateText + " " + message + " " + df.format(previousBalance) + " " + df.format(currentBalance));

            } catch (FileNotFoundException e) {
                System.out.printf("File not found");
            }
        }
    }
}
