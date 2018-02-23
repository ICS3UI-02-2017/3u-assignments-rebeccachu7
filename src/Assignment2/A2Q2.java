/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;

/**
 *
 * @author chur7632
 */
public class A2Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a City for the Robot
        City kw = new City();

        // Put a robot in KW
        RobotSE chu = new RobotSE(kw, 3, 1, Direction.EAST);
        
        // create walls (hurdles)
        new Wall(kw, 3, 1, Direction.SOUTH);
        new Wall(kw, 3, 1, Direction.EAST);
        new Wall(kw, 3, 2, Direction.SOUTH);
        new Wall(kw, 3, 2, Direction.EAST);
        new Wall(kw, 3, 3, Direction.SOUTH);
        new Wall(kw, 3, 4, Direction.SOUTH);
        new Wall(kw, 3, 4, Direction.EAST);
        new Wall(kw, 3, 5, Direction.SOUTH);
        new Wall(kw, 3, 6, Direction.SOUTH);
        new Wall(kw, 3, 7, Direction.SOUTH);
        new Wall(kw, 3, 7, Direction.EAST);
        new Wall(kw, 3, 8, Direction.SOUTH);
        new Wall(kw, 3, 9, Direction.SOUTH);

        // create thing at the end of the hurdles
        new Thing (kw, 3, 9);
        
        // tell chu to move forward if the front is clear
        while (!chu.canPickThing()){
        
            if (chu.frontIsClear()){
                chu.move();
            }     
            
        // tell chu to jump over hurdles when the front is not clear
        while (!chu.frontIsClear()){
            chu.turnLeft();
            chu.move();
            chu.turnRight();
            chu.move();
            chu.turnRight();
            chu.move();
            chu.turnLeft();
        }
            }
        }
    }

