/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Quizes;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;

/**
 *
 * @author chur7632
 */
public class Quiz1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        City kw = new City();
        
        // Put a robot in KW
        RobotSE chu = new RobotSE (kw, 4, 0, Direction.EAST);
        
        // create the staircase (walls)
        new Wall(kw, 4, 2, Direction.WEST);
        new Wall(kw, 4, 2, Direction.NORTH);
        new Wall(kw, 3, 3, Direction.WEST);
        new Wall(kw, 3, 3, Direction.NORTH);
        new Wall(kw, 2, 4, Direction.WEST);
        new Wall(kw, 2, 4, Direction.NORTH);
        new Wall(kw, 2, 5, Direction.EAST);
        new Wall(kw, 2, 5, Direction.NORTH);
        new Wall(kw, 3, 6, Direction.EAST);
        new Wall(kw, 3, 6, Direction.NORTH);
        new Wall(kw, 4, 7, Direction.EAST);
        new Wall(kw, 4, 7, Direction.NORTH);
        
        // create things for chu to pick up
        new Thing (kw, 4, 1);
        new Thing (kw, 3, 2);
        new Thing (kw, 2, 3);
        new Thing (kw, 1, 4);
        
        // move chu along the staircase and pick lights (things) up along the way to the top
        chu.move();
        chu.pickThing();
        chu.turnLeft();
        chu.move();
        chu.turnRight();
        chu.move();
        chu.pickThing();
        chu.turnLeft();
        chu.move();
        chu.turnRight();
        chu.move();
        chu.pickThing();
        chu.turnLeft();
        chu.move();
        chu.turnRight();
        chu.move();
        chu.pickThing();
        
        // move chu down the staircase while putting lights (things) down along the way
        chu.move();
        chu.putThing();
        chu.move();
        chu.turnRight();
        chu.move();
        chu.turnLeft();
        chu.putThing();
        chu.move();
        chu.turnRight();
        chu.move();
        chu.turnLeft();
        chu.putThing();
        chu.move();
        chu.turnRight();
        chu.move();
        chu.turnLeft();
        chu.putThing();
        chu.move();
    }
}
