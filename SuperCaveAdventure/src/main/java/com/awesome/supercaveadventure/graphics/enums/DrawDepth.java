
package com.awesome.supercaveadventure.graphics.enums;

/**
 *
 * DrawDepth tells the order of sprites (which one is on top) 
 * when drawing them on top of each other.
 */
public enum DrawDepth {

    ROOM(0),
    DOOR(70),
    PLAYER(100);
    
    private final int depth;
    
    DrawDepth(int depth) {
        this.depth = depth;
    }

    public int getDepth() {
        return depth;
    }
    
    

    
    
    
}
