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
public class A4Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // use a Scanner to read info
        Scanner input = new Scanner (System.in);
        
        // tell the user what to do?
        System.out.println("Please enter the measurement in inches in which you would like to convert");
        
        // make a variable to convert the inches into centimetres
        double inches = input.nextInt();
        double centimetres = 2.54 * inches;
        
        // tell the user
        System.out.println("This measurement in centimetres is " + centimetres);
    }
}
