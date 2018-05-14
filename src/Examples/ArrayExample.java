/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

import java.util.Scanner;

/**
 *
 * @author chur7632
 */
public class ArrayExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // scanner for input
        Scanner input = new Scanner (System.in);
        
        // make an array to store expanses
        double [] expanses = new double [6];
        
        // let the user know to get the costs
        System.out.println("Please enter the 6 costs for the prom:");
        
        // use for loop for input
        for (int i = 0; i < expanses.length; i++) {
            expanses [i] = input.nextDouble();
    }
        // instead of
        expanses [0] = input.nextDouble();
        expanses [1] = input.nextDouble();
        expanses [2] = input.nextDouble();
        expanses [3] = input.nextDouble();
        expanses [4] = input.nextDouble();
        expanses [5] = input.nextDouble();
        
        // add all the expanses
        double sum = 0;
        for (int i = 0; i < expanses.length; i++) {
            // get the expanse
            double expanse = expanses [i];
            
            // add it to the sum
            sum = sum + expanse;
            
            // or
            sum = sum + expanses [i];
        }
        
        // output stuff
        System.out.println("Prom cost " + sum);
        
        // take the sum and divide by 35, always round up
        double ticketsNeeded = Math.ceil (sum / 35);
        System.out.println("You need to sell " + ticketsNeeded + "tickets");
        
        // different way:
        // array to store expanses names
        double[] expansess = new double [6];
        
        // array to store expanse names
        String [] names = {
            "food", "DJ", "hall", "decorations", "staff", "misc."
        };
        for (int i = 0; i < expansess.length; i++) {
            // get the name of the cost
            String costName = names [i];
            
            // ask user
            System.out.println("How much does" + costName + "cost");
            expansess [i] = input.nextDouble();
    }
}
}