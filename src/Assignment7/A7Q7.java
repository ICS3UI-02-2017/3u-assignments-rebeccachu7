/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment7;

import java.util.Scanner;

/**
 *
 * @author chur7632
 */
public class A7Q7 {
    
    // create the firstDigit method
    public static int firstDigit(int number) {
        // if the number is negative, multiply it by -1 to make it positive
        if (number < 0) {
            number = number * -1;      
            }
        // continue to divide the number by 10 until it reaches the first digit
        for (int i = 0; i < number; i++) {

            if (number > 9  || number < -9) {
                int remainder = number % 10;
                number = number - remainder;
                number /= 10;
            }
        }
        return number;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create new scanner
        Scanner in = new Scanner(System.in);

        // ask for the number in which they want to find the first digit of
        System.out.println("Please enter the number you want to be calculated:");
        int number = in.nextInt();
        
        // output the first digit of the number they entered
        System.out.println("The first digit of the integer you entered is " + firstDigit(number) + ".");
    }
}
