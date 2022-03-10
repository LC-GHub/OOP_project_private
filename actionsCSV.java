import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class actionsCSV {

    private static Scanner x;
    private static String filePath = "C:\\Users\\nazir\\Desktop\\database.csv";

    public static void main(String[] args) {
        findFromCSV("57", "password");
        // readFromCSV();
    }

    public static void findFromCSV(String searchTerm1, String searchTerm2) {

        boolean found = false;
        String pin = "";
        String password = "";
        String accountNumber = "";
        String nameOfHolder = "";
        String balance = "";
        String withdrawalLimit = "";
        String overseasTransferLimit = "";

        try {

            x = new Scanner(new File(filePath));
            x.useDelimiter("[,\n]");

            while (x.hasNext() && !found) {

                pin = x.next();
                password = x.next();
                accountNumber = x.next();
                nameOfHolder = x.next();
                balance = x.next();
                withdrawalLimit = x.next();
                overseasTransferLimit = x.next();

                if (pin.equals(searchTerm1) && password.equals(searchTerm2)) {
                    found = true;
                }

            }

            if (found) {
                System.out.println("Account Number: " + accountNumber + "\n"
                        + "Name: " + nameOfHolder + "\n" + "Balance: $" + balance);
            } else {
                System.out.println("Record Not Found!!!");
            }

        } catch (FileNotFoundException | NoSuchElementException e) {
            e.printStackTrace();
        }

    }

    public static String findFromCSVAccountNo(String searchTerm1, String searchTerm2) {

        boolean found = false;
        String pin = "";
        String password = "";
        String accountNumber = "";
        String nameOfHolder = "";
        String balance = "";
        String withdrawalLimit = "";
        String overseasTransferLimit = "";

        try {

            x = new Scanner(new File(filePath));
            x.useDelimiter("[,\n]");

            while (x.hasNext() && !found) {

                pin = x.next();
                password = x.next();
                accountNumber = x.next();
                nameOfHolder = x.next();
                balance = x.next();
                withdrawalLimit = x.next();
                overseasTransferLimit = x.next();

                if (pin.equals(searchTerm1) && password.equals(searchTerm2)) {
                    found = true;
                }

            }

            if (found) {
                return this.accountNumber;
            } else {
                System.out.println("Record Not Found!!!");
            }

        } catch (FileNotFoundException | NoSuchElementException e) {
            e.printStackTrace();
        }

    }


}