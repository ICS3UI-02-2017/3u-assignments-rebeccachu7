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
public class A7Q5 {
    
    // create the chaotic method
    // calculate the random numbers in asterisks
    public static void chaotic(int lines, int a, int n){
        
        // print out the number of asterisks the user entered
        for (int i = 0; i < lines; i++) {
             
            // create the random number of asterisks in each line
        int randNum = (int)(Math.random()*(n - a + 1))+ a;
            for (int j = 0; j < randNum; j++) {
                // output the random number of asterisks
                   System.out.print("*");              
            }
            // add a space between each line of asterisks
            System.out.println("");
            }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create a new scanner
        Scanner in = new Scanner(System.in);
        
        // ask how mane lines of asterisks they would like to have outputed
        System.out.println("Please enter how many lines of asterisks you would like to have outputted:");
        int lines = in.nextInt();
        
        // ask for the double represnting the initial principal (P)
        System.out.println("Please enter the lowest number in your range:");
        int a = in.nextInt();
        
        // ask the person to enter the greatest number in the range of asterisks
        System.out.println("Please enter the greatest number in your range:");
        int n = in.nextInt();
        
        chaotic(lines, a, n);
    }
}
