/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;
import java.awt.Color;

/**
 * Learning how to use the robots
 * @author Rebecca
 */
public class RobotExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a City for the Robot
        City kw = new City();
        
        // Put a robot in KW
        RobotSE chu = new RobotSE (kw, 2, 3, Direction.EAST);
        
        // create a wall
        new Wall(kw, 2, 5, Direction.WEST);
        
        // create a thing
        new Thing(kw, 2, 4);
        
        // move the robot forward one space
        chu.move();
        
        //move the robot n number of spaces
        // chu.move(4);
        
        // turn the robot to the left
        chu.turnLeft();
        
        // put the letter C on chu
        chu.setLabel("C");
        
        //set the colour of the robot
        chu.setColor(Color.blue);
        
        // pick up the thing
        chu.pickThing();
        
        // move once again
        chu.move();
        
        // put the thing down
        chu.putThing();
        chu.move();
    }
}
