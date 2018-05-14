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
public class MethodsExample {

    // the helloWorld method to say hello
    public static void helloWorld(){
        System.out.println("Hello world!");
    }
    // say hello to the user
    public static void sayHello(String name){
        System.out.println("Hello " + name);
    }
    
    // calculate the positive root of the quadratic formula
    public static double positiveQuadFormula(double a, double b, double c){
        double discrim = b*b - 4*a*c;
        double root = (-b + Math.sqrt(discrim))/(2*a);
        // send back the root
        return root;
    }
    
    // calculate the positive and negative root of the quadratic formula
    public static double[] quadFormula(double a, double b, double c){
        // create the array to store both roots
        double[] roots = new double[2];
        //calculate the roots
        double discrim = b*b - 4*a*c;
        roots[0] = (-b + Math.sqrt(discrim))/(2*a);
        roots[1] = (-b - Math.sqrt(discrim))/(2*a);
        // send back the roots
        return roots;
    }        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // void: return type
        // main: name of the method
        // String[] args arguments of parameters
        // ex. area of a circle
            // public double areaCircle (double radius)
        // ex. area of rectangle
            // public double areaRect (double length, double width)
        
        Scanner in = new Scanner(System.in);
        
        // call the hello world method
        helloWorld();
        
        System.out.println("What is your name?");
        String user = in.nextLine();
        sayHello(user);
        
        // calculate the root of 3x^2+7x+1.5
        double pRoot = positiveQuadFormula(1, -5, -50);
        System.out.println("The positive root is: " + pRoot);
        
        double[] roots = quadFormula (1, -5, -50);
        System.out.println("The roots are " + roots[0] + roots[1]);
    }
}
