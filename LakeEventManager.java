/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lakeeventmanager;

/**
 */
import java.util.Scanner;
import java.io.*; 

public class LakeEventManager {

    /**
     * LakeEventManager - Reads an input file and calculates the number of tickets
     * sold, the number of donations, and the expenses associated with an event. 
     * Display the ticket sale income, money donated income, expenses, and maximum,
     * minimum and average donation for an event.
     * @author Ragan Lake
     * @version 1.0, Java Assn 7
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner (System.in);
        
        System.out.printf("This program reads in a text file that contains the number ");
        System.out.printf("\n of tickets sold, the number of donations and the expenses");
        System.out.printf("\nassociated with an event differentiated by code.");
        System.out.println();
        System.out.printf("\nThe program lists the amount of the lowest donation, the ");
        System.out.printf("\namount of the highest donation, the average donation, ");
        System.out.printf("\nthe number of tickets sold, the number of donations, the ");
        System.out.printf("\ntotal income and total expenses and the event profits.");
        System.out.println();
        System.out.println("Please enter the price of a single ticket:  ");
        double price = keyboard.nextDouble();
        
        //Creates new LakeEventClass object.
        LakeEventClass event = new LakeEventClass (price);
          
        File inFile = null;  //Initializes File object's value.
        Scanner fin = null; //Initializes Scanner object's value.
        int count = 0;  //Initializes count of number of valid lines..
        char type = 'a';  //Initializes type value.
        double amount = 0;  //Initializes amount value.
        
        inFile = new File ("Event2.txt");  //Creates new File object inFile with input file Event.txt.
        
        try {
            fin = new Scanner (inFile);  //Creates new Scanner object fin with input file inFile.
        } catch (FileNotFoundException fnfe) {  //Catches file not found exception.
            System.err.println("Failed to open file " + inFile);           
        }
        
        while (fin.hasNext() ){            //Reads a line in from the file until there are no more lines.
            type = fin.next().charAt(0);      
            amount = fin.nextDouble();

            if (type =='D') {  //To add amounts with a type 'D' for donation.
                try {
                    event.addDonations(amount);
                    count++;              
                } catch (ArrayIndexOutOfBoundsException e) { //Catches array index out of bounds exception if the limit of the array has been reached.
                    System.err.println("No more donations can be added because the maximum number of donations has been reached.");                              
                }                
            } else if (type == 'T') {  //To add amounts with a type 'T' for number of tickets.     
                event.addTicketsSold((int) amount);
                event.getTotalTicketSaleIncome();              
                count++;
            } else if (type == 'E') {  //To add amounts witha  type 'E' for expenses.
                event.addExpenses(amount);
                count++;   
            } else {
                System.out.println();
                System.out.printf("The identifier " + type + " is invalid, ");  //Notifies the user
                System.out.printf("so " + type);
                System.out.printf(" and the amount of %.2f", amount); //that the value will be skipped
                System.out.printf(" will be skipped.");  //because the type is not 'D', 'T' or 'E.'
            }
        }
 
        fin.close(); //Closes input file.
        
        System.out.println();
        System.out.println("The number of lines of data read was:  " + count);
        System.out.println();
  
        event.displayValues();   //Method to display values.
   }
}
