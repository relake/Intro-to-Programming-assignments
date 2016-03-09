/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lake.mileagecalc;

import java.util.Scanner;

/** LakeMileageCalc - Takes kilometers driven and liters of gas used and
 * converts to miles per gallon.
 *
 * @author Ragan E. Lake
 * version 1.0, Java Assn 1
 */
public class LakeMileageCalc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**Conversion units for kilometers and liters*/
        double MILES_TO_KILOMETERS = 1.609;
        double GALLONS_TO_LITERS = 3.785;
        
        Scanner keyboard = new Scanner(System.in);
        
        /**Get user input for kilometers driven and liters of gas used.*/
        System.out.print("What is the number of kilometers driven? ");
        double kilometersDriven = keyboard.nextDouble();
        
        System.out.print ("What is the number of liters of gas used? ");
        double litersUsed = keyboard.nextDouble();
        
        /**Conversion formulas*/
        double milesDriven = kilometersDriven / MILES_TO_KILOMETERS;
        double gallonsUsed = litersUsed / GALLONS_TO_LITERS;
        double milesPerGallon = milesDriven / gallonsUsed;
        
        /**Output*/
        System.out.printf("%nNumber of miles driven is %.2f", milesDriven);
        System.out.printf("%nNumber of gallons of gas used is %.2f", gallonsUsed);
        System.out.printf("%nNumber of miles per gallon is %.2f", milesPerGallon);
    }
    
}
