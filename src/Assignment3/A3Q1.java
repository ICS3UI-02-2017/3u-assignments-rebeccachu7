/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Wall;

/**
 *
 * @author chur7632
 */
public class A3Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a City for the Robot
        City kw = new City();

        // Put a robot in KW
        RobotSE chu = new RobotSE(kw, 0, 2, Direction.WEST);
        
        // create walls of the square
        new Wall (kw, 1, 1, Direction.NORTH);
        new Wall (kw, 1, 1, Direction.WEST);
        new Wall (kw, 1, 2, Direction.NORTH);
        new Wall (kw, 1, 2, Direction.EAST);
        new Wall (kw, 2, 1, Direction.SOUTH);
        new Wall (kw, 2, 1, Direction.WEST);
        new Wall (kw, 2, 2, Direction.SOUTH);
        new Wall (kw, 2, 2, Direction.EAST);
        
        // use a for loop to move
        int numberOfLaps = 2;
            while (numberOfLaps > 0){
                chu.move(2);
                chu.turnLeft();
                chu.move(3);
                chu.turnLeft();
                chu.move(3);
                
            }
        
}
}
