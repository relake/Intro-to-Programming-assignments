package lakehealthcalculator;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/** LakeHealthCalculator - Calculates a person's BMI (body mass index) given
     * the person's weight, height and age.  If the person's BMI is above the normal range, 
     * it asks the user if he/she would like to get their BMI in the normal range.
     * Also computes how many calories men and women require per day to maintain
     * their weight or to get their weight within the normal range if they are outside
     * of it. 
     * @author Ragan E. Lake
     * @version 1.0, Java Assn 4
     */

import java.util.Scanner;
import static java.lang.Math.*;

public class LakeHealthCalculator {
 
    public static void main(String[] args) {
      
        Scanner keyboard = new Scanner (System.in);
     
        final double POUNDS_TO_KILOGRAMS = 2.2; //constant to convert pounds to kilograms.
        final double INCHES_TO_METERS = 0.0254; //constant to convert inches to meters.
        
        //Description of program for the user.
        System.out.println("This program implements a Health Assistance Calculator");
        System.out.println();
        System.out.println("Given a weight, height, and age, it will compute:");
        System.out.println("BMI - body mass index");
        System.out.println("Calories needed per day to adjust or maintain weight.");
        System.out.println();
        
        //Prompts user for weight in pounds.
        System.out.print("Please enter your weight in pounds: ");
        double weight = keyboard.nextDouble();
        weight = weight / POUNDS_TO_KILOGRAMS;
        
        //Prompts user for height in inches.
        System.out.print ("Please enter your height in inches: ");
        double height = keyboard.nextDouble();
        height = height * INCHES_TO_METERS;
   
        //Prompts user for age in inches.
        System.out.print("Please enter your age in years: ");
        int userAge;
        userAge = keyboard.nextInt();
        
        //Prompts user for gender.
        System.out.print ("Please enter your gender (M/F): ");
        char userGender = keyboard.next().charAt(0);
    
        //Prompts user for activity level.
        System.out.println();
        System.out.println("Select your activity level: ");
        System.out.println("1 - sedentary");
        System.out.println("2 - moderately active (light exercise 1-3 days a week)");
        System.out.println("3 - active (moderate exercise 3-5 days a week");
        System.out.println("4 - very active (heavy exercise 6-7 days a week");
        System.out.println("Enter choice from above: ");
        char userActivityLevel = keyboard.next().charAt(0);
    
        //Creates new LakePerson named thisUser.
        LakePerson thisUser = new LakePerson (weight, height, userAge, userGender, userActivityLevel);
  
        //Calls LakePerson methods to compute BMI and display BMI and caloric requirements.
        double thisUserBMI = LakePerson.computeBMI();
        int thisUserCaloriesPerDay;
        thisUserCaloriesPerDay = LakePerson.calculateCaloricRequirements();
    
        //Function call to display results.
        System.out.println();
        displayCaloriesPerDay(thisUserBMI, thisUserCaloriesPerDay);
    }  
            
     /**Method to display BMI and calories per day.  Also calculates caloric requirements
        if user wants to lose or gain weight.
        * @param thisUserBMI = user's BMI
        * @param thisUserCaloriesPerDay = user's required daily caloric intake
        */
    
    public static void displayCaloriesPerDay (double thisUserBMI, int thisUserCaloriesPerDay) {
       
        double LOWEST_BMI = 18.5; //constant for lowest BMI in range
        double HIGHEST_BMI = 24.9; //constant for highest BMI in range
        int CALORIES_PER_POUND = 3500; //constant to convert number of calories per pound
        
        Scanner keyboard = new Scanner (System.in);    
       
        //Outputs normal BMI range and this user's BMI.
        System.out.println("\nA BMI in the range of " + LOWEST_BMI + " to " + HIGHEST_BMI + " is considered normal.");
        System.out.printf("\nYour BMI is %.1f", thisUserBMI);
        
        //Determines whether user's BMI is below the normal range.
        if (thisUserBMI < LOWEST_BMI) {
            String BMIRange = "below normal";
            System.out.println("\nYour BMI range is " + BMIRange);
            System.out.println("\nWould you like to try and reach the normal range (Y/N)? ");
            char tryToReachNormalRange = keyboard.next().charAt(0); 
            
            //If the user wants to get their BMI to the normal range, calculates 
            //number of calories necessary to do so.
            if (tryToReachNormalRange == 'y') {
                System.out.println("Please enter the number of pounds you would like to gain per week: ");
                int poundsToGain = keyboard.nextInt();
                int newCaloriesPerDay = thisUserCaloriesPerDay + ((poundsToGain * CALORIES_PER_POUND) / 7);
                System.out.println("To gain " + poundsToGain + " lbs per week, you should consume " + newCaloriesPerDay + " calories a day.");
            } else {
                System.out.println ("You need " + thisUserCaloriesPerDay + " calories per day to maintain weight.");
            }
        
        //Determines if the user's BMI is above the normal range.    
        } else if (thisUserBMI > HIGHEST_BMI) {
            String BMIRange= "above normal";
            System.out.println("\nYour BMI range is " + BMIRange);
            System.out.println("\nWould you like to try and reach the normal range (Y/N)? ");
            char tryToReachNormalRange = keyboard.next().charAt(0); 
        
            //If the user wants to get their BMI to the normal range, calculates 
            //number of calories necessary to do so.
            if (tryToReachNormalRange == 'y') {
                System.out.println("Please enter the number of pounds you would like to lose per week");
                int poundsToLose = keyboard.nextInt();
                int newCaloriesPerDay = thisUserCaloriesPerDay - ((poundsToLose * CALORIES_PER_POUND) / 7);
                System.out.println("To lose " + poundsToLose + " lbs per week, you should consume " + newCaloriesPerDay + " calories a day.");
                } else {
                    System.out.println ("You need " + thisUserCaloriesPerDay + " calories per day to maintain weight.");
                }
        
        //If user's BMI is in the normal range, calculates calories needed to maintain weight.
        } else {
            String BMIRange = "normal";
            System.out.println("\nYour BMI is " + BMIRange);
            System.out.println ("You need " + thisUserCaloriesPerDay + " calories per day to maintain weight.");
        }
    }

    
}
    