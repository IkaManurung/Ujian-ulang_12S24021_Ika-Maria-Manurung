package smartwallet.driver;

import java.util.*;
import smartwallet.model.*;

/**
 * Nama : Ika Maria Manurung
 * NIM : 12S24021
 */

public class smartwallet {
public static void main(String[] _args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Account> accounts = new LinkedHashMap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("---")) {
                break;
            }
            
            String[] parts = line.split("#");
            String command = parts[0];

            if (command.equals("create-account")) {
                Account acc = new Account(parts[1], parts[2]);
                accounts.put(parts[2], acc);
            } else if (command.equals("deposit")) {
                String username = parts[1];
                double amount = Double.parseDouble(parts[2]);
                Account acc = accounts.get(username);
                if (acc != null) {
                    acc.deposit(amount);
                }
            } else if (command.equals("withdraw")) {
                String username = parts[1];
                double amount = Double.parseDouble(parts[2]);
                Account acc = accounts.get(username);
                if (acc != null) {
                    acc.withdraw(amount);
                }
            }
        }

        for (Account acc : accounts.values()) {
            System.out.println(acc.getUsername() + "|" + acc.getName() + "|" + acc.getBalance());
        }
    
    }

}