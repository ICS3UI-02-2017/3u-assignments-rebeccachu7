/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;

/**
 *
 * @author chur7632
 */
public class A2Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a City for the Robot
        City kw = new City();

        // Put a robot in KW
        RobotSE chu = new RobotSE(kw, 8, 7, Direction.EAST);
        
        // tell chu to turn to face north if it isn't
        while (!chu.isFacingNorth()){
               chu.turnRight();
        }
        // tell chu to move forward to street 0
        while (chu.getStreet() != 0){
        chu.move();
    }
        // tell chu to turn left so that it's facing (0,0)
        chu.turnLeft();
        
        // while chu is not at avenue 0, make chu move
        while (chu.getAvenue() !=0){
        chu.move();
        }
        }
    }
