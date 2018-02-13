/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;

/**
 *
 * @author chur7632
 */
public class A1Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // Create a City for the Robot
        City kw = new City();
        
        // Put a robot in KW
        RobotSE chu = new RobotSE (kw, 1, 2, Direction.SOUTH);
        
        // create the walls
        new Wall (kw, 1, 1, Direction.NORTH);
        new Wall (kw, 1, 1, Direction.WEST);
        new Wall (kw, 1, 2, Direction.NORTH);
        new Wall (kw, 1, 2, Direction.EAST);
        new Wall (kw, 2, 1, Direction.WEST);
        new Wall (kw, 2, 1, Direction.SOUTH);
        new Wall (kw, 1, 2, Direction.SOUTH);
        
        // create thing
         new Thing(kw, 2, 2);
         
         //move robot towards thing
         chu.turnRight();
         chu.move();
         chu.turnLeft();
         chu.move();
         chu.turnLeft();
         chu.move();
         
         // pick thing up
         chu.pickThing();
         
         // take thing and bring it back to "bed"
         chu.turnRight();
         chu.turnRight();
         chu.move();
         chu.turnRight();
         chu.move();
         chu.turnRight();
         chu.move();
         
         //go back to original position
         chu.turnRight();
         chu.turnRight();
    }
}
