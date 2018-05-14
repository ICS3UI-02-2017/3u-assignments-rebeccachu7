/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment4;

import java.util.Scanner;

/**
 *
 * @author chur7632
 */
public class A4Q7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // use a Scanner to read info
        Scanner input = new Scanner (System.in);
        
        // player integer
        int player = 1;
                
        // begin asking the player for the number they rolled
        while (player <= 100){
            
            System.out.println("Enter the number you've rolled on the dice:");
            String roll = input.nextLine();
            int dice = Integer.parseInt (roll);
            if (dice >= 1 && dice <=6) {
                player += dice;
                System.out.println("You are at " + player);
            }
            // tell the player what position they will be at if they land on a ladder
            if (player == 9) {
                player = player + 25;
                System.out.println("You are now on position 34");
            }
            if (player == 40) {
                player = player + 24;
                System.out.println("You are now on position 64");
            }
            if (player == 67) {
                player = player + 19;
                System.out.println("You are now on position 86");
            }
            // tell the player what postition they will be in if they step on a snake
            if (player == 54) {
                player = player - 35;
                System.out.println("You stepped on a snake and now your position is 19");
            }
            if (player == 90) {
                player = player - 42;
                System.out.println("You stepped on a snake and now your position is 48");
            }
            if (player == 99) {
                player = player - 22;
                System.out.println("You stepped on a snake and now your position is 77");
            }
            // if the player enters a number that is above 100, then the system will tell them to try again
            if (player > 100) {
                player -= dice;
                System.out.println("Try again.");
            }
            // quit the game if the player enters "0"
            while (dice == 0) {
                System.out.println("You have quit the game.");
            }
            // tell the player they've won the game when their position is 100
            while (player == 100) {
                System.out.println("You win the game!");
            }
}
}
}