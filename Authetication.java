package Project_AccountInfo;
import java.util.Scanner;
import java.io.Console;
import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;



public class Authetication {

    private String Pin;
    private Console console;
    private char[] Charpassword;
    private String password;
    private int pinchecker = 0;/*******************************EDITED***************************/

    public void Welcome(){
        System.out.println("Welcome to XXX Bank");
        
    }

    public void loginRequest(){/*******************************EDITED***************************/
        
        Scanner input = new Scanner(System.in);

        try{
            System.out.print("Pin: ");
            this.Pin = input.nextLine();
            pinchecker = Integer.parseInt(this.Pin);

        }catch (NumberFormatException e){
            //e.printStackTrace();
            System.out.println("*****************************************************************");
            System.out.println("Error: <Pin entered is not a number>");
            System.out.println("You got 1 more attempt");
            System.out.println("*****************************************************************");
            System.out.print("Pin: ");

            /*attempt 2: Last attempt*/
            try{
                this.Pin = input.nextLine();
                pinchecker = Integer.parseInt(this.Pin);
            }catch (NumberFormatException m){
                //m.printStackTrace();
                System.out.println("*****************************************************************");
                System.out.println("Warning: <Session ended due to excessive amount of incorrect pin attempts>");
                System.out.println("*****************************************************************");

                return;
            }
            
            
        }
        this.console = System.console();
        this.Charpassword = this.console.readPassword("Password: <Password will not be displayed when typed for security reasons>");
        this.password = String.valueOf(this.Charpassword); 
        AuthenticateAndLogin(this.Pin, this.password);
    }

    public void logoutmessage(){
        System.out.println("*****You have successfully logged out. Thank you for banking with us*****");
    }

    private void AuthenticateAndLogin(String Pin, String password){

        
        String String_password = new String(password);

        if(Pin.equals("57") && String_password.equals("password")){ //Make a CSV file

           Menu menu = new Menu(Pin, String_password);
           Authetication.programStack.add(menu);
           menu.printMenu();
            
        }
        else{
            System.out.println("You have entered the wrong pin or password");
        }
    }

    public static ArrayList programStack = new ArrayList<>();
    public static void main(String[] args){
        Authetication Atm = new Authetication();
        
        Authetication.programStack.add(Atm);
        Atm.Welcome();
        Atm.loginRequest();
    }
    
}
