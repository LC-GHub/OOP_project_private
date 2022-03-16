package Project_AccountInfo;
import java.util.Scanner;
import Project_AccountInfo.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.security.InvalidAlgorithmParameterException;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class Menu {

    private int choice;
    private static Scanner x;
    private boolean validoption = false;
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

    /*******************************EDITED***************************/
    public void printMenu(){ 
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Welcome " + findFromCSV_Name(this.getPin(), this.getPassword()));
        System.out.println("--------------------------------------------------------------------");
        while(validoption == false){
            System.out.println("*****************************************************************");
            System.out.println("What can we help you with today? ");
            System.out.println("1. AccountInfo");
            System.out.println("2. Transfer funds");
            System.out.println("3. Settings");
            System.out.println("--------------------------------------------------------------");
            System.out.println("Press \"9\" to logout");
            try{
                this.choice = input2.nextInt();
                if(this.choice > 3 && this.choice != 9 || this.choice < 1 && this.choice != 9){
                    throw new InvalidAlgorithmParameterException("Error: <Option is not valid, please choose available option>");
                }
                else if(this.choice == 9){
                    this.Menulogout();
                }
                else{
                    validoption = true;
                }
            }catch(InvalidAlgorithmParameterException e){
                System.out.println("*****************************************************************");
                System.out.println(e.getMessage());
                validoption = false;
            }
              
        }
        validoption = false;
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

   /********************EDITTED*********************************/
    public void Menulogout(){
        Authetication.programStack.remove(1);//remove menu
        Authetication Atm = (Authetication) Authetication.programStack.get(0);
        Atm.logoutmessage();
        Atm.Welcome();
        Atm.loginRequest();
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

        } catch (FileNotFoundException | NoSuchElementException e) { 
            e.printStackTrace();
        }
        return nameOfHolder;
}}
