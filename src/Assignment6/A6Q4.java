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
public class A6Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // use a Scanner to read info
        Scanner input = new Scanner(System.in);

        // tell the user what to do?
        System.out.println("Please enter the 10 marks in which you want to be examined:");

        // create a new Array with an interval of 10
        int[] marks = new int[10];

        for (int i = 0; i < marks.length; i++) {
            marks[i] = input.nextInt();
        }
        // calculate the marks of people from least to greatest with swapping
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
        System.out.println("The ten numbers from least to greatest are: " + Arrays.toString(marks));
    }
}