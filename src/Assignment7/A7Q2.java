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
public class A7Q2 {

    // create the examGrade method
    // calculate the are of a circle, given a radius
    public static void examGrade(int mark){
        // tell the system what letters are associated with each mark
        if (mark > 80){
            System.out.println("Superb! The mark you enetered is an A.");
    }
        if (mark > 69 && mark < 80){
            System.out.println("Good Job! The mark ou entered is a B.");
    }
        if (mark > 59 && mark < 70){
            System.out.println("Nice Try! The mark you entered is a C.");
    }
        if (mark > 49 && mark < 60){
            System.out.println("Better luck next time! The mark you have entered is a D.");
    }
        if (mark < 50){
            System.out.println("OH NO! The mark you entered is an F.");
    }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create new scanner
        Scanner in = new Scanner(System.in);
        
        // ask for the radius of the circle in which they would like to enter
        System.out.println("What is the mark you would like to be assessed?");
        int mark = in.nextInt();
        // output the letter that the mark is associated with
        examGrade(mark);
    }
}
