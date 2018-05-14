/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6;

import java.util.Scanner;

/**
 *
 * @author chur7632
 */
public class A6Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // use a Scanner to read info
        Scanner input = new Scanner(System.in);

        // ask the person to enter the two numbers they want to be sorted
        System.out.println("Please enter the two numbers in which you want to be examined:");

        // make a array to store the number
        int[] numbers = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextInt();
        }
        // sort the numbers with least - greatest
        for (int a = 0; a < numbers.length - 1; a++) {
            if (numbers[a] > numbers[a+1]) {
                numbers [a+1] += 1;
                
        // output the number in the correct order
        System.out.println("The two numbers from least to greatest are: " + numbers [a+1] + " " + numbers [a]);
        
        
    }
}
}
}