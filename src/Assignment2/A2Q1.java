/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;

/**
 *
 * @author chur7632
 */
public class A2Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a City for the Robot
        City kw = new City();

        // Put a robot in KW
        RobotSE chu = new RobotSE(kw, 1, 1, Direction.EAST);

        // create 10 things in front of robot
        new Thing(kw, 1, 2);
        new Thing(kw, 1, 3);
        new Thing(kw, 1, 4);
        new Thing(kw, 1, 5);
        new Thing(kw, 1, 6);
        new Thing(kw, 1, 7);
        new Thing(kw, 1, 8);
        new Thing(kw, 1, 9);
        new Thing(kw, 1, 10);
        new Thing(kw, 1, 11);

        // while the robot is moving until(1, 6), move forward and pick things up
        while (chu.countThingsInBackpack()<=6){
               chu.move();
               chu.pickThing();
           }
        // make chu move 4 more spaces to the finishing position
        chu.move();
        chu.move();
        chu.move();
        chu.move();
        }
        
    }
