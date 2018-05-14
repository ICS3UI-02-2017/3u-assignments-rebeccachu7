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
public class A6Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // use a Scanner to read info
        Scanner input = new Scanner (System.in);
        
        // ask how many students there are in the class
        System.out.println("Please enter how many students there are in the class");
        
        // make a String to store the number
        int students = input.nextInt();
        
        // ask the person to enter the marks for each of the students entered
        System.out.println("Please enter the marks of the student(s)");
        
        // make an array to store the number
        double [] marks = new double [students];
        
        for (int i = 0; i < marks.length; i++){
            marks [i] = input.nextInt();
            
        }
        // add all items in the array and divide them by the number of students
        double average = 0;
        
        for (int i = 0; i < marks.length; i++){
            average = average + marks [i];
                    }
            average /= marks.length;
        
        // output the number with 2 decimal places
            System.out.printf("The average mark for the student(s) is %.2f \n" , average);           
        }
}
