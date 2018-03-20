/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;

/**
 *
 * @author chur7632
 */
public class A3Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a City for the Robot
        City kw = new City();

        // Put a robot in KW
        RobotSE chu = new RobotSE(kw, 1, 1, Direction.EAST, 20);
        
        // tell chu to place 5 things along 4 streets
        int numberOfLaps = 4;
            while (numberOfLaps > 0){
            chu.putThing();
            chu.move();
            chu.putThing();
            chu.move();
            chu.putThing();
            chu.move();
            chu.putThing();
            chu.move();
            chu.putThing();
            chu.turnAround();
            chu.move(4);
            chu.turnLeft();
            chu.move();
            chu.turnLeft();
        numberOfLaps = numberOfLaps - 1;
            }
    }
}
