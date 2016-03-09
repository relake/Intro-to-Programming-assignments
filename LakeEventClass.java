/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lakeeventmanager;

/**
 * LakeEventClass - creates an event object and contains methods to get and display ticket sale income,
 * money donated, expenses, and event overall and individual totals.
 * @author Ragan E. Lake
 * @version 1.0, Java Assn 7
 */
import java.util.Scanner;
import java.io.*; 

public class LakeEventClass {
    static final int MAX_NUMBER_OF_DONATIONS = 200;  //Constant for maximum number of donations.
    private double myTicketPrice;  //Ticket price.
    private int numberTicketsSold;  //Number of tickets sold.
    double [] donationsTotal = new double [MAX_NUMBER_OF_DONATIONS];  //Array with maximum number of MAX_NUMBER_OF_DONATIONS.
    static int donationsNumber;    //The number of donations in the array.
    private double totalExpenses;  //Tracks expenses.
    
    /**Constructor for LakeEventClass.
     @param ticketPrice - price of tickets
     */
    public LakeEventClass (double ticketPrice) {
        myTicketPrice = ticketPrice;
        numberTicketsSold = 0;
        donationsNumber = 0;
        totalExpenses = 0;    
    }
    
    /**Totals the number of tickets.
     @param  numberTickets - the number of tickets sold
     */
    public void addTicketsSold (int numberTickets) {
        numberTicketsSold += numberTickets; 
    }
      
    /**Totals the number of donations unless the maximum number in the array is reached.
     * If the maximum number is reached, it throws an exception.
     * @param donationAmount - the amount of the donation to be added to the array. 
     * @return true
     */
    public boolean addDonations (double donationAmount) {          
            if (donationsNumber >= MAX_NUMBER_OF_DONATIONS - 1) {    
                throw new ArrayIndexOutOfBoundsException ("Amount could not be stored.");  
            }             
            donationsTotal[donationsNumber] = donationAmount;
            donationsNumber++;
            return true;
    }
    
    /**Totals the expenses.
     @param expenseAmount - the amount of the expenses to be added to total
     @return totalExpenses - the total expenses.
    */
    public double addExpenses (double expenseAmount) {
        totalExpenses += expenseAmount;
        return totalExpenses;
    }
    
    /**Gets the number of donations. 
     * @return donationsNumber - the number of donations added to the array.
     */
    public int getNumberOfDonations (){ 
        return donationsNumber;
    }    
    
    /**Calculates the total ticket sale income.
     @return - total ticket income.
     */
    public double getTotalTicketSaleIncome() {
        return myTicketPrice * numberTicketsSold;
    }
    
    /**Totals the money donated.
    @return sum - the total money donated.
    */
    public double getTotalMoneyDonated () {
        double sum = 0;
        for (int i = 0; i < donationsNumber; i++) {          
            sum = sum + donationsTotal[i];
        } 
        return sum;
    }
    
    /**Calculates the lowest donation amount.
     @minValue - the lowest donation amount.
     */
    public double minDonation () {
        double minValue = donationsTotal[0];
        for (int cell = 0; cell < donationsNumber; cell++) {           
            if (donationsTotal[cell] < minValue) {
                minValue = donationsTotal[cell];
            } 
        }
        return minValue;
    }
    
    /**Calculates the average donation amount.
     @return averageDonation - the average donation amount.
     */
    public double averageDonation () {
        double averageDonation = 0;
        for (int cell = 0; cell < donationsNumber; cell++) {
            averageDonation += donationsTotal[cell];
        } 
        averageDonation /= donationsNumber;
        return averageDonation;
    }
    
    /**Calculates the maximum donation amount.
     @return maxValue - the highest donation amount.*/
    public double maxDonation () {
        double maxValue = 0;
        for (int cell = 0; cell < donationsNumber; cell++) {
            if (donationsTotal[cell] > maxValue) {
                maxValue = donationsTotal[cell];
            } 
        }
        return maxValue;
    }
    
    /*Method to display values*/
    public void displayValues () {
        String divider = "--------";
        System.out.println();
        System.out.println("Event Overall Outcome:  ");
        System.out.println("  Donation Analysis:");
        System.out.printf("     Lowest donation:  %12.2f", minDonation());
        System.out.println();
        System.out.printf("     Average Donations:  %10.2f", averageDonation());
        System.out.printf("\n     Highest Donations:  %10.2f", maxDonation());
        System.out.println("\n  Profit/Loss Results:");
        System.out.printf("     " + numberTicketsSold + " tickets sold");
        System.out.printf("%15.2f", getTotalTicketSaleIncome());
        System.out.printf("\n      " + getNumberOfDonations());
        System.out.printf(" donations %16.2f", getTotalMoneyDonated());
        System.out.println(" +");
        System.out.printf("%35s%n", divider);   
        System.out.printf("  Total income:  %18.2f", (getTotalTicketSaleIncome() + getTotalMoneyDonated()));
        System.out.println();
        System.out.printf("  Total expenses:  %16.2f", totalExpenses);
        System.out.println(" -");
        System.out.printf("%35s%n", divider);
        System.out.printf("  Event profits:  %17.2f", ((getTotalTicketSaleIncome() + getTotalMoneyDonated()) - totalExpenses)) ;
        System.out.println();
    }
}

