package Project_AccountInfo;
import java.util.Scanner;
import Project_AccountInfo.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Menu {

    private int choice;
    private static Scanner x;
    private static String filePath = "C:\\Users\\chewc\\OneDrive\\Desktop\\OOP\\javacode\\School\\src\\Project_AccountInfo\\Project_AccountInfo\\database.csv";
    /******this one need to change to ur own file path*******/
    Scanner input2 = new Scanner(System.in);
    private String Pin;
    private String Password;

    public Menu(String Pin, String Password){
        this.Pin = Pin;
        this.Password = Password;
    }

    public String getPin(){
        return this.Pin;
    }
    public String getPassword(){
        return this.Password;
    }

    public void printMenu(){
        System.out.println("Welcome " + findFromCSV_Name(this.getPin(), this.getPassword()) + ",");
        System.out.println("What can we help you with today? ");
        System.out.println("1. AccountInfo");
        System.out.println("2. Transfer funds");
        System.out.println("3. Settings");

        this.choice = input2.nextInt();
        selectionFunction(this.choice);
    }

    private void selectionFunction(int choice){
        switch(this.choice){
            case 1:
            //<create AccountInfo object>
            //System.out.println("Go into Accountinfo object");
            Account Account = new Account(this.Pin, this.Password);
            Authetication.programStack.add(Account);
            Account.getAccountInfo();

            break;
            case 2:
            //<create TransferFund object>
            System.out.println("Go into Transfer object");
            
            break;
            case 3:
            //<create Settings>
            System.out.println("Go into Settings object");
            break;
        }
    }
    
    public static String findFromCSV_Name(String searchTerm1, String searchTerm2) {

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
                return nameOfHolder;
            } else {
                System.out.println("Record Not Found!!!");
            }

        } catch (FileNotFoundException e) { //| NoSuchElementException
            e.printStackTrace();
        }
        return nameOfHolder;
}}
