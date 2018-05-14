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
public class A6Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // use a Scanner to read info
        Scanner input = new Scanner(System.in);

        // tell the person to enter all the heights
        System.out.println("Please enter the number of people in which you want to be calculated");

        // make a String to store the number
        int people = input.nextInt();

        // tell the user what to do?
        System.out.println("Please enter the heights of each of the people in cm:");

        // make a array to store the number
        int[] heights = new int[people];

        for (int i = 0; i < heights.length; i++) {
            heights[i] = input.nextInt();

        }
        // add all items in the array and divide them by the number of students
        double average = 0;

        for (int i = 0; i < heights.length; i++) {
            average = average + heights[i];
        }
        average /= heights.length;

        // calculate the heights of people that are above average
        for (int a = 0; a < heights.length; a++) {
            if (heights[a] > average) {
                average += 1;
                
        // output the number with 2 decimal places
        System.out.println("The heights of the people who are above average height are: " + heights[a] + "cm");
            }
        }
    }
}