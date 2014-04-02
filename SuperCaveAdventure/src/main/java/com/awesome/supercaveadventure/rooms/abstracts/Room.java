package com.awesome.supercaveadventure.rooms.abstracts;

import com.awesome.supercaveadventure.entity.abstracts.Entity;
import com.awesome.supercaveadventure.graphics.interfaces.Drawable;
import java.util.ArrayList;

/**
 * Rooms are small levels that contain enemies and other entities.
 */
public abstract class Room implements Drawable {

    

    
    
    public abstract ArrayList<Entity> getEntities();
    
    /**
     * Tells where the PlayerCharacter should be initially placed.
     * @return X-coordinate.
     */
    public abstract int getPlayerStartXPos();
    
    /**
     * Tells where the PlayerCharacter should be initially placed.
     * @return Y-coordinate.
     */
    public abstract int getPlayerStartYPos();
}
