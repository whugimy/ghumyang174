package ghumyang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Global {

    // input Reader for Global use
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // Date and Market Open variables
    public static Date date = Date.valueOf("2000-1-1");
    public static boolean marketOpen = false;

    // prompts user input, forces user to input one of the Strings listed in validInputs or calls for input again, then returns that input
    public static String getLineSetInputs(ArrayList<String> validInputs) throws IOException {
        String rawInput = br.readLine();
        if (!validInputs.contains(rawInput)) {
            System.out.println("--- INVALID INPUT ---");
            return getLineSetInputs(validInputs);
        }
        return rawInput;
    }

    // prompts user for username and password, then returns String[] {username, password}
    public static String[] getLogin() throws IOException {
        Global.clearScreen();
        System.out.println();
        System.out.println("enter username:");
        String username = br.readLine();
        System.out.println();
        System.out.println("enter password:");
        String password = br.readLine();
        return new String[]{username, password};
    }

    // small helper to clear all inputs
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    
    // small helper to create confirmation screen
    public static void awaitConfirmation() throws IOException {
        System.out.println();
        System.out.println("Press enter to head back");
        br.readLine();
    }

    // prompts the user for the given list of fields, then returns a HashMap of those values.
    public static HashMap<String,String> promptValues(String title, ArrayList<String> fields) throws IOException {
        clearScreen();
        System.out.println(String.format("Enter the following info for %s", title));
        HashMap<String,String> values = new HashMap<>();
        for (String field : fields) {
            System.out.println();
            System.out.println(String.format("Enter %s", field));
            String value = br.readLine();
            values.put(field, value);
        }
        return values;
    }

    // given HashMap of fields and values, allows user to confirm, try again, or abort.
    public static boolean confirmInfo(String title, HashMap<String,String> values) {
        clearScreen();
        System.out.println(String.format("Are these the desired values for %s?", title));
        System.out.println();
        for (Map.Entry<String,String> valueSet : values.entrySet()) {
            System.out.println(String.format("%10s | %10s", valueSet.getKey(), valueSet.getValue()));
        }
        return true;
    }
    
}