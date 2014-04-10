/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package supercaveadventure.entities;

import java.util.Random;

/**
 *The four possible directions
 */
public enum Direction {
    LEFT,
    RIGHT,
    UP,
    DOWN;

    private Direction() {
    }
    
    public static Direction getRandomDirection() {
        Random r = new Random();
        int randomNumber = r.nextInt(4);
        
        switch(randomNumber) {
            case 0:
                return LEFT;
            case 1:
                return RIGHT;
            case 2:
                return UP;
            default:
                return DOWN;
        }   
   
    }
}
