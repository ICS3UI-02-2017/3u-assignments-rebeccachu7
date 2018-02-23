/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;

/**
 *
 * @author chur7632
 */
public class LoopsExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        City kw = new City();
        RobotSE chu = 
                new RobotSE (kw, 1, 1, Direction.EAST);
        
        // counted while loop
        int numberOfMoves = 5;
        // if there are still moves to do
        while (numberOfMoves > 0){
            chu.move();
            numberOfMoves = numberOfMoves - 1;
    }
        chu.turnAround();
        
        // couting the other way
        numberOfMoves = 0;
        while (numberOfMoves < 5){
            chu.move();
            numberOfMoves = numberOfMoves + 1;
            
}
        chu.turnAround();
        // use a for loop to move
        for(int count = 0; count < 5; count ++){
            chu.move();  
}
        int x = 10;
        x = x + 5; // adds 5
        x += 5; // adds 5
        x -= 10; // subtract 10 shortcut
        x = x - 10;
        
        x*= 2; // multiply by 2
        x = x * 2; //multiply by 2
        
        x /= 4; // divide by 4
        x = x / 4; // divide by 4
        
        // modulus or module
        int remainder = 5 % 2;
        int quotient = 5 / 2;
        
        // both must be true in order to perform this action
        if (chu.frontIsClear() && chu.canPickThing()){
            
        }
        
        // only one needs to be true to perform this action
        if (chu.frontIsClear() || chu.canPickThing()){
            
        }
}
}