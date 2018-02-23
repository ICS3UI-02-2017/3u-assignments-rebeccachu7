package Examples;


import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chur7632
 */
public class ConditionsExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create a city
        City kw = new City();
        
        // create a robot
        RobotSE chu = new RobotSE (kw, 2, 1, Direction.EAST);
        
        // create a wall infront
        new Wall (kw, 2, 5, Direction.EAST);
        
        // place a couple of things
        new Thing(kw, 2, 2);
        new Thing(kw, 2, 4);
        
        //move while the front is clear
        while (chu.frontIsClear())
            // if front is clear, do this
            chu.move();
        
        // is there something to pick up?
        if (chu.canPickThing()){
            chu.pickThing();
        }
        // when front is not clear
    chu.turnRight();
    
    if(chu.countThingsInBackpack() == 1){
        chu.move();
    } else if(chu.countThingsInBackpack() == 2){
        chu.move(2);
    }

    }
    
    
    
    }

