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
public class A7Q1 {
    // create the circleArea method
    // calculate the are of a circle, given a radius
    public static double circleArea(double r){
        // create the formula to find the area of the circle
        double area = r*r*Math.PI;
        // send back the area that was calculated
        return area;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create new scanner
        Scanner in = new Scanner(System.in);
        
        // ask for the radius of the circle in which they would like to enter
        System.out.println("What is the radius of the circle that you would like to be calculated?");
        double r = in.nextDouble();
        double areaOfCircle = circleArea(r);
        // output the area of the circle, calculated in the method
        System.out.println("The area of your circle is: " + areaOfCircle);
    }
}
