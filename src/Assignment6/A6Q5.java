/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6;

import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author chur7632
 */
public class A6Q5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // use a Scanner to read info
        Scanner input = new Scanner(System.in);

        // tell the person to enter all the heights
        System.out.println("Please enter the number of marks in which you want to be sorted:");

        // make a String to store the number
        int numberOfMarks = input.nextInt();

        // tell the user what to do?
        System.out.println("Please enter the marks in which you want to be examined:");

        // create the Array
        int[] marks = new int[numberOfMarks];

        for (int i = 0; i < marks.length; i++) {
            marks[i] = input.nextInt();
        }
        // calculate the marks of people from least to greatest
        for (int x = 0; x < marks.length - 1; x++) {
            for (int y = x + 1; y < marks.length; y++) {
                if (marks[x] > marks[y]) {
                    int swap = 0;
                    swap = marks[x];
                    marks[x] = marks[y];
                    marks[y] = swap;
                }
            }
        }
        // output the numbers from least to greatest
        System.out.println("The numbers entered sorted from least to greatest are: " + Arrays.toString(marks));
        
        // calculate the median
        if ((numberOfMarks % 2) == 0) {
            int x = numberOfMarks/2;
            int media = marks [x-1] + marks [x];
            media = media/2;
            System.out.println("The median of this set of marks is " + media);
        }
        else if (!((numberOfMarks % 2) == 0)){
            int x = Math.round (numberOfMarks/2);
            int media = marks [x];
        
            // output the median
        System.out.println("The median of the marks is " + media);
}
}
}