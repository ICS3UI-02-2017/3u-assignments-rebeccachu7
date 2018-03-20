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
public class A4Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // use a Scanner to read info
        Scanner input = new Scanner (System.in);
        
        // tell the user what to do?
        System.out.println("Please enter 4 numbers in separate lines");
        
        // make 4 Strings to store numbers
        String number1 = input.nextLine();
        String number2 = input.nextLine();
        String number3 = input.nextLine();
        String number4 = input.nextLine();
        
        // tell the user what the numbers they entered were
        System.out.println("The numbers you enetered were " + number1 + "," + number2+ "," + number3 + "," + number4 + ".");
 
    }
}
