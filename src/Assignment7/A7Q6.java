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
public class A7Q6 {
    
    // create the lastDigit method
    // calculate the last digit in the integer entered
    public static int lastDigit(int number){
        // find the remainder of the number enetered by dividing the number by 10 and finding the remainder
        int remainder = number % 10;
         if (number < 0){
        remainder = remainder * -1;
    }
        return remainder;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create a new scanner
        Scanner in = new Scanner(System.in);
        
        // ask the person to enter the number they would like to be calculated
        System.out.println("Please enter the number you would like to be calculated:");
        int number = in.nextInt();
        
        // output the last digit of the number entered, calculated int the method
        System.out.println("The last digit of the number you entered is " + lastDigit(number));
    
}
}