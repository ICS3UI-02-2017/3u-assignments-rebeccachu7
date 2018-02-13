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
public class A1Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a City for the Robot
        City kw = new City();
        
        // Put a robot in KW
        RobotSE chu = new RobotSE (kw, 3, 0, Direction.EAST);
        
        // create the walls of the mountain
        new Wall(kw, 3, 2, Direction.WEST);
        new Wall(kw, 3, 2, Direction.NORTH);
        new Wall(kw, 2, 3, Direction.WEST);
        new Wall(kw, 1, 3, Direction.WEST);
        new Wall(kw, 1, 3, Direction.NORTH);
        new Wall(kw, 1, 3, Direction.EAST);
        new Wall(kw, 2, 4, Direction.NORTH);
        new Wall(kw, 2, 4, Direction.EAST);
        new Wall(kw, 3, 4, Direction.EAST);
        
        // create thing
        new Thing(kw, 3, 1);
        
        // pick up thing
        chu.move();
        chu.pickThing();

        // move around the mountain while carrying the thing
        chu.turnLeft();
        chu.move();
        chu.turnRight();
        chu.move();
        chu.turnLeft();
        chu.move();
        chu.move();
        chu.turnRight();
        chu.move();
        
        //place thing down at the top of the mountain
        chu.putThing();
        chu.move();
        
        // continue moving around the perimeter of the mountain
        chu.turnRight();
        chu.move();
        chu.turnLeft();
        chu.move();
        chu.turnRight();
        chu.move();
        chu.move();
        
        // put robot in final position
        chu.turnLeft();
    }
}
