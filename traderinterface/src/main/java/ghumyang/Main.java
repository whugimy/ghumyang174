package ghumyang;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import ghumyang.interfaces.CustomerInterface;

public class Main {
    public static void main(String args[]) throws IOException {
        Global.clearScreen();
        MAINPAGE();
    }
    
    public static void MAINPAGE() throws IOException {
        String input = "start";
        while (!input.equals("e")) {
            // Menu output
            System.out.println();
            System.out.println("Hello! Welcome to Garrett and Michael's Trader Interface.");
            System.out.println();
            System.out.println("Options:");
            System.out.println("   (0) Login to a customer account");
            System.out.println("   (1) Login to a manager account");
            System.out.println("   (2) Update the market info");
            System.out.println("   (e) Exit the program");
            System.out.println();
            // Option input
            input = Global.getLineSetInputs(new ArrayList<>(Arrays.asList("0","1","2","e")));
            
            // Navigation based on input
            switch(input) {
                case "0":
                    System.out.println("moving to customer account login");
                    CustomerInterface.Login();
                    break;
                case "1":
                    System.out.println("moving to manager account login");
                    break;
                case "2":
                    System.out.println("moving to update market info");
                    break;
            }
        }

    }

    
}

