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
public class A4Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // use a Scanner to read info
        Scanner input = new Scanner (System.in);
        
        // tell the user what to do?
        System.out.println("Please enter your name");
        
        // make a String to store a name
        String name = input.nextLine();
        
        // say hello
        System.out.println("Hello! " + name);
    }
}
