/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Wall;

/**
 *
 * @author chur7632
 */
public class A1Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a City for the Robot
        City kw = new City();
        
        // Put a robot in KW
        RobotSE chu = new RobotSE (kw, 0, 2, Direction.WEST);
        
        // create the walls
        new Wall(kw, 1, 1, Direction.WEST);
        new Wall (kw, 1, 1, Direction.NORTH);
        new Wall (kw, 1, 2, Direction.NORTH);
        new Wall (kw, 1, 2, Direction.EAST);
        new Wall (kw, 2, 1, Direction.WEST);
        new Wall (kw, 2, 1, Direction.SOUTH);
        new Wall (kw, 2, 2, Direction.SOUTH);
        new Wall (kw, 2, 2, Direction.EAST);
        
        //move robot counterclockwise around the walls
        chu.move();
        chu.move();
        chu.turnLeft();
        chu.move();
        chu.move();
        chu.move();
        chu.turnLeft();
        chu.move();
        chu.move();
        chu.move();
        chu.turnLeft();
        chu.move();
        chu.move();
        chu.move();
        chu.turnLeft();
        chu.move();
    }
}
