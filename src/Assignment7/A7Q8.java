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
public class A7Q8 {

    // create the allDigitsOdd method
    public static boolean allDigitsOdd(int number) {
        
        // create the boolean where it is true if all digits of the number entered are odd
        boolean evenOrOdd = true;
        // create the integer remainder where it is the remainder of the the number entered when divided by 10
        int remainder = number % 10;
        
        // multiply the number entered by -1 if it is a negative number, to make it positive
        if (number < 0) {
            number = number * -1;
            }
        
        for (int i = 0; i < number; i++) {

            if (number > 9  || number < -9) {
                number = number - remainder;
                number /= 10;
            }
            // if the digits are odd, then the number entered is true
            if (!(remainder % 2 == 0)) {
                evenOrOdd = true;
            }
            // if the digits are even, then the number entered is false
            if (remainder % 2 == 0) {
                evenOrOdd = false;
                break;
            }
        }
        return evenOrOdd;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create new scanner
        Scanner in = new Scanner(System.in);

        // ask for the number in which they want to be evaluated
        System.out.println("Please enter the number you want to be evaluated:");
        int number = in.nextInt();
        
        // output either true or false depending on if the digits in the number are all odd
        System.out.println(allDigitsOdd(number));
    }
}
