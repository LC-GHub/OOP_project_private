package Project_AccountInfo;
import Project_AccountInfo.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.InvalidAlgorithmParameterException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Account implements FileOperations_inter{

    private double Balance;
    private String AccountNumber;
    private String Name;
    private int choice;
    private boolean validoption2 = false; /****EDITTED*********/
    private static Scanner x;
    private String Pin;
    private String Password;
    private static String filePath = "C:\\Users\\chewc\\OneDrive\\Desktop\\OOP\\javacode\\School\\src\\Project_AccountInfo\\Project_AccountInfo\\database.csv";
    /******this one need to change to ur own file path*******/

    public Account(String Pin, String Password){
        this.Pin = Pin;
        this.Password = Password;
    }

    public String getPin(){
        return this.Pin;
    }
    public String getPassword(){
        return this.Password;
    }
    

    public void back(){
        Authetication.programStack.remove(2); //remove module
        Menu menu = (Menu)Authetication.programStack.get(1); 
        menu.printMenu();
    }
    public void logout(){
        Authetication.programStack.remove(2);//remove module
        Authetication.programStack.remove(1);//remove menu
        Authetication Atm = (Authetication) Authetication.programStack.get(0);
        Atm.logoutmessage();
        Atm.Welcome();
        Atm.loginRequest();


    }

    public void getAccountInfo(){ /***********************EDITTED**************************** */

        while(this.validoption2 == false){
            findFromCSV(this.getPin(), this.getPassword());
            System.out.println("--------------------------------------------------------------");
            System.out.println("Press \"0\" to back, Press \"9\" to logout");
            Scanner input = new Scanner(System.in);
            try{
                this.choice = input.nextInt();
                if(this.choice != 0 && this.choice != 9){
                    throw new InvalidAlgorithmParameterException("Error: <Option is not valid, please choose available option>");
                }else{
                    this.validoption2 = true;
                }
            }catch(InvalidAlgorithmParameterException e){
                this.validoption2 = false;
                System.out.println("*****************************************************************");
                System.out.println(e.getMessage());
                System.out.println("*****************************************************************");
            }
        }

        if(this.choice == 0){
            this.validoption2 = false;
            this.back();
        }
        else if(this.choice == 9){
            this.validoption2 = false;
            this.logout();
        }
        
        
    }
    
    public String getAccountNumber(){
        return findFromCSVAccountNo(this.getPin(), this.getPassword());
    }

    public String getName(){
        return findFromCSV_item(this.getPin(), this.getPassword());
    }

    public void findFromCSV(String searchTerm1, String searchTerm2) {

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
                        + "Name: " + nameOfHolder + "\n" + "Balance: $" + balance + "\nWithdrawl Limit: " + withdrawalLimit + "\nOverseas Transfer Limit: " + overseasTransferLimit);
            } else {
                System.out.println("Record Not Found!!!");
            }

        } catch (FileNotFoundException| NoSuchElementException e) { 
            e.printStackTrace();
        }

    }

    public String findFromCSVAccountNo(String searchTerm1, String searchTerm2) {

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
                return accountNumber;
            } else {
                System.out.println("Record Not Found!!!");
            }

        } catch (FileNotFoundException | NoSuchElementException e) { 
            e.printStackTrace();
        }
        return accountNumber;

    }

    public String findFromCSV_item(String searchTerm1, String searchTerm2) {

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

        } catch (FileNotFoundException| NoSuchElementException e) { 
            e.printStackTrace();
        }
        return nameOfHolder;

    
    }
    
}
