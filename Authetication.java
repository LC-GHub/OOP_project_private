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

    public void Welcome(){
        System.out.println("Welcome to XXX Bank");
        
    }

    public void loginRequest(){
        Scanner input = new Scanner(System.in);
        System.out.print("Pin: ");
        this.Pin = input.nextLine();
        this.console = System.console();
        this.Charpassword = this.console.readPassword("Password: ");
        this.password = String.valueOf(this.Charpassword);
        
        AuthenticateAndLogin(this.Pin, this.password);
    }
    public void logoutmessage(){
        System.out.println("You have successfully logged out. Thank you for banking with us.");
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
