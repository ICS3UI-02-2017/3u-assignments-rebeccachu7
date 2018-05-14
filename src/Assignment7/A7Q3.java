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
public class A7Q3 {
    
    // create the factors method
    public static void factors(int number){

        // create the array for tne number entered
        int[] num = new int[number];
        
        // continue to add numbers into array
        for (int i = 0; i < num.length; i++) {
             num[i] = i + 1;
        }
        // output if the number is a factor
        for (int i = 0; i < num.length; i++) {
                if (number % num[i] == 0) {
                System.out.println(num[i]);
        }
        }
        }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create new scanner
        Scanner in = new Scanner(System.in);
        
        // ask for the number in which they want to find all the factors of
        System.out.println("What is the number you would like to find the factors of?");
        int number = in.nextInt();
        
        // output the factors of the number entered
        factors(number);
    }
}
