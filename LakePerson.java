package lakehealthcalculator;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**LakePerson - creates an object that can be used to calculate the user's BMI
 * and caloric requirements.
 *
 * @author Ragan E. Lake
 * @version 1.0, Java Assn 4
 */
public class LakePerson {
    private static double userHeight; //User height.
    private static double userWeight; //User weight.
    private static int userAge; //User age.
    private static char userGender; //User gender.
    private static double userPhysicalActivityFactor; //User physical activity factor.

    /**LakePerson constructor.*/
    LakePerson(double weight, double height, int age, char gender, char userActivityLevel) {
           //@param weight - user's weight
           //@param height - user's height
           //@param age - user's age
           //@param gender - user's gender
           //@param userActivityLevel - user's activity level
        
           userWeight = weight;
           userHeight = height;
           userAge = age;
           userGender = gender;
           userPhysicalActivityFactor = 0;
        
        //Determines user's activity level.   
        switch (userActivityLevel) {
            case '1':
                userPhysicalActivityFactor = 1.2;
                break;
            case '2':
                userPhysicalActivityFactor = 1.375;
                break;
            case '3':
                userPhysicalActivityFactor = 1.55;
                break;
            case '4':
                userPhysicalActivityFactor = 1.725;
                break;
            case '5':
                System.out.print ("Invalid choice");
        }
           
    }
    
    //Method to compute user's BMI.
    static double computeBMI() {
        double BMI = (userWeight) / Math.pow(userHeight, 2.0);
        return BMI;
    }
    
    //Method to compute caloric requirements.
    static int calculateCaloricRequirements () {
          
        final int METERS_TO_CENTIMETERS = 100; //Constant to convert meters to centimeters.
        
        double bmr = 0;
        
        //Determines which calculation to use based on gender.
        if  (userGender == 'm') {
            bmr = (13.397 * userWeight) + (4.799 * (userHeight * METERS_TO_CENTIMETERS)) - (5.677 * userAge) + 88.362;
        } else {
            bmr = (9.247 * userWeight) + (3.098 * (userHeight * METERS_TO_CENTIMETERS)) - (4.330 * userAge) + 447.593;
        } 
        
        //Variable to compute caloric requirements per day.
        double caloricRequirementPerDay = bmr * userPhysicalActivityFactor;
        return (int) Math.round(caloricRequirementPerDay);   
    }
}
