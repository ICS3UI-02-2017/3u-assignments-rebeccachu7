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
public class A4Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // use a Scanner to read info
        Scanner input = new Scanner (System.in);
        
        
        // tell the user the first question to ask
        System.out.println("How much does food cost?");
        // make double to store number
        double number1 = input.nextDouble();
        
        // tell the user the second question to ask
        System.out.println("How much does the DJ cost?");
        // make double to store number
        double number2 = input.nextDouble();
        
       // tell the user the third question to ask
        System.out.println("How much does the hall cost to rent?");
        // make double to store number
        double number3 = input.nextDouble();
        
        // tell the user the fourth question to ask
        System.out.println("How much do the decorations cost?");
        // make double to store number
        double number4 = input.nextDouble();
        
        // tell the user the fifth question to ask
        System.out.println("How much does it cost for staff?");
        // make double to store number
        double number5 = input.nextDouble();
        
        // tell the user the fourth question to ask
        System.out.println("How much for any miscellaneous costs?");
        // make double to store number
        double number6 = input.nextDouble();
        
        // make a variable to add up all costs
        double total = number1 + number2 + number3 + number4 + number5 + number6;
        
        // make a variable to divide total cost by number of tickets
        double tickets = Math.ceil (total / 35);
        
        // tell the user what the total of all costs are
        System.out.println("The total cost for the prom is " + total + " and the amount of tickets needed to sell in order to break even is " + tickets );
    }
}
