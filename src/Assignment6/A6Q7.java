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
public class A6Q7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // use a Scanner to read info
        Scanner input = new Scanner(System.in);

        // make a String to store the number
        int size = input.nextInt();
        
        // create the array
        int[] prime = new int[size];
        
        // add numbers into array
        for (int i = 0; i < prime.length; i++) {
             prime[i] = (i + 2);
        }
        
        // create the boolean array
        boolean[] primenum = new boolean [size];
            for (int p = 0; p < prime.length; p++) {
            primenum[p] = true;
        }
            
        // only if true, output numbers
        for (int p1 = 0; p1 < prime.length; p1++) {
            if (primenum[p1] == true){
                System.out.println(prime[p1]);
            }
            
        // if the number is not prime, do not output it
        for (int p2 = 0; p2 < prime.length; p2++) {
                if (prime[p2] % prime[p1] == 0) {
                    primenum[p2] = false;
            }
        }
        
    }
        
}
}
