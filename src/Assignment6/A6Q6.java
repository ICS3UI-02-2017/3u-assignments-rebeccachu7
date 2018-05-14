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
public class A6Q6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // use a Scanner to read info
        Scanner input = new Scanner(System.in);

        // tell the person to enter all the heights
        System.out.println("Please enter the size of your class:");

        // make a String to store the number
        int sizeOfClass = input.nextInt();

        // ask how many marks they want to be examined
        System.out.println("Please enter the marks in which you want to be examined:");

        // make an Array to store the number
        int[] marks = new int[sizeOfClass];

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
        int lowest = marks [0];
        int highest = marks [marks.length - 1];
                
        // output the lowest and highest marks entered
        System.out.println("The lowest mark is: " + lowest + " ,and the highest mark is: " + highest);
        
        // output the numbers from least to greatest
        System.out.println("The marks of the class sorted from least to greatest are: " + Arrays.toString(marks));
        
        // calculate the average
        // add all items in the array and divide them by the number of students
        double average = 0;
        
        for (int i = 0; i < marks.length; i++){
            average = average + marks [i];
                    }
            average /= marks.length;
        
        // output the average with 2 decimal places
            System.out.printf("The average mark of the class is %.2f \n" , average); 
        }
    }