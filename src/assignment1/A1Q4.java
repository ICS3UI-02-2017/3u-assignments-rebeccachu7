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
public class A1Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a City for the Robot
        City kw = new City();
        
        // Put a robot in KW
        RobotSE chu = new RobotSE (kw, 0, 0, Direction.SOUTH);
        RobotSE timmy = new RobotSE (kw, 0, 1, Direction.SOUTH);
        
        // create the walls
        new Wall(kw, 0, 1, Direction.WEST);
        new Wall(kw, 1, 1, Direction.WEST);
        new Wall(kw, 1, 1, Direction.SOUTH);
        
        //start moving chu
        chu.move();
        chu.move();
        
        // start moving timmy
        timmy.move();
        timmy.turnLeft();
        timmy.move();
        timmy.turnRight();
        timmy.move();
        
        // turn chu towards timmy
        chu.turnLeft();
        
        // turn timmy towards chu
        timmy.turnRight();
        
        // make chu and timmy collide
        chu.move();
        timmy.move();
        
    }
}
