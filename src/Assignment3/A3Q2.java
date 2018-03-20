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
public class A3Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a City for the Robot
        City kw = new City();

        // Put a robot in KW
        RobotSE chu = new RobotSE(kw, 0, 0, Direction.EAST);

        // create 10 things where the robot is
        new Thing(kw, 0, 0);
        new Thing(kw, 0, 0);
        new Thing(kw, 0, 0);
        new Thing(kw, 0, 0);
        new Thing(kw, 0, 0);
        new Thing(kw, 0, 0);
        new Thing(kw, 0, 0);
        new Thing(kw, 0, 0);
        new Thing(kw, 0, 0);
        new Thing(kw, 0, 0);
        
        // tell chu to pick up thing and place it in the next avenue, back and forth until it has done so 10 times
        int numberOfMoves = 10;
            while (numberOfMoves > 0){
            chu.pickThing();
            chu.move();
            chu.putThing();
            chu.turnAround();
            chu.move();
            chu.turnAround();
        numberOfMoves = numberOfMoves - 1;
    }
            // move to final situation
            chu.move();
}
}