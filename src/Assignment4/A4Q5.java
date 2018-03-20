/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment4;

import java.util.Scanner;

/**
 *
 * @author chur7632
 */
public class A4Q5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // use a Scanner to read info
        Scanner input = new Scanner (System.in);
        
        
        // tell the user to ask for the name of the person
        System.out.println("Please enter your name");
        // make a String to store a name
        String name = input.nextLine();
        
        // tell the user the second question to ask
        System.out.println("What was your first test out of?");
        // make double to store number
        double number1 = input.nextDouble();
        // ask what mark they got out of the total
        System.out.println("What mark did you get out of the total?");
        // make double to store number
        double number11 = input.nextDouble();
        
       // tell the user the third question to ask
        System.out.println("What was your second test out of?");
        // make double to store number
        double number2 = input.nextDouble();
        // ask what mark they got out of the total
        System.out.println("What mark did you get out of the total?");
        // make double to store number
        double number12 = input.nextDouble();
        
        // tell the user the fourth question to ask
        System.out.println("What was your third test out of?");
        // make double to store number
        double number3 = input.nextDouble();
        // ask what mark they got out of the total
        System.out.println("What mark did you get out of the total?");
        // make double to store number
        double number13 = input.nextDouble();
        
        // tell the user the fifth question to ask
        System.out.println("What was your fourth test out of?");
        // make double to store number
        double number4 = input.nextDouble();
        // ask what mark they got out of the total
        System.out.println("What mark did you get out of the total?");
        // make double to store number
        double number14 = input.nextDouble();
        
        // tell the user the fourth question to ask
        System.out.println("What was your fifth test out of?");
        // make double to store number
        double number5 = input.nextDouble();
        // ask what mark they got out of the total
        System.out.println("What mark did you get out of the total?");
        // make double to store number
        double number15 = input.nextDouble();
        
        
        // calculate the percentages of all marks they got
        double percent1 = (number11 / number1) * 100;
        
        double percent2 = (number12 / number2) * 100;
        
        double percent3 = (number13 / number3) * 100;
        
        double percent4 = (number14 / number4) * 100;
        
        double percent5 = (number15 / number5) * 100;
        
        // make a variable to add up all costs
        double total = (percent1 + percent2 + percent3 + percent4 + percent5) / 5;
        
        // tell the user what the total of all costs are
        System.out.println("Test Scores for " + name + "\nTest 1: " + percent1 + "%" + "\nTest 2: " + percent2 + "%" + "\nTest 3: " + percent3 + "%" + "\nTest 4: " + percent4 + "%" + "\nTest 5: " + percent5 + "%");
        System.out.println("\nYour average mark overall is " + total + "%");        
    }
}
