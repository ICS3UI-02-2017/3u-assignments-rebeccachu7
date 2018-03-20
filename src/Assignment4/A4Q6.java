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
public class A4Q6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // use a Scanner to read info
        Scanner input = new Scanner (System.in);
        
        // tell the user to ask for the speed limit 
        System.out.println("Please enter the speed limit");
        // make a String to store a name
        int limit = input.nextInt();
        
        // tell the user to ask for the speed at which the person was driving
        System.out.println("Please enter the speed at which you were driving");
        // make a String to store a name
        int speed = input.nextInt();
        
        // determine what the speed is, compared to the speed limit and decide if the driver will be fined
        int difference = speed - limit;
        
        if (difference == 0){
            System.out.println("Congradulations, you are within the speed limit!");
        }
        if (difference > 0 && difference < 20){
            System.out.println("You are speeding over the speed limit by 1-20km/h, and will be charged $100.");
        }
        if (difference > 21 && difference < 31){
            System.out.println("You are speeding over the speed limit by 21-31km/h, and will be charged $270.");
        }
        if (difference > 31){
            System.out.println("You are speeding over the speed limit by 31km/h or more, and will be charged $100.");
        }
    }
}
