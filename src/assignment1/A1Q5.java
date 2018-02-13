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
public class A1Q5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a City for the Robot
        City kw = new City();
        
        // Put a robot in KW
        RobotSE chu = new RobotSE (kw, 0, 1, Direction.WEST);
        
        // put a letter "M" on chu
        chu.setLabel("M");
        
        // Put another robot in KW
        RobotSE timmy = new RobotSE (kw, 3, 3, Direction.EAST);
        
        // put a letter "K" on timmy
        timmy.setLabel("K");
        
        // create the walls
        new Wall(kw, 2, 3, Direction.WEST);
        new Wall(kw, 2, 3, Direction.NORTH);
        new Wall(kw, 2, 3, Direction.EAST);
        new Wall(kw, 3, 3, Direction.EAST);
        new Wall(kw, 3, 3, Direction.SOUTH);
        
        // create all the things in the initial situation
        new Thing(kw, 0, 0);
        new Thing(kw, 1, 0);
        new Thing(kw, 1, 1);
        new Thing(kw, 1, 2);
        new Thing(kw, 2, 2);
        
        // move chu and pick up things at  (0,0), (1,0)
        chu.move();
        chu.pickThing();
        chu.turnLeft();
        chu.move();
        chu.turnLeft();
        chu.pickThing();
        
        // move timmy so that he picks up things at (2,2)
        timmy.turnLeft();
        timmy.turnLeft();
        timmy.move();
        timmy.turnRight();
        timmy.move();
        timmy.pickThing();
        
        // move chu to pick up thing at (1,1)
        chu.move();
        chu.pickThing();
        
        // move timmy to pick up thing at (1,2)
        timmy.move();
        timmy.pickThing();
        timmy.turnLeft();
    }
}
