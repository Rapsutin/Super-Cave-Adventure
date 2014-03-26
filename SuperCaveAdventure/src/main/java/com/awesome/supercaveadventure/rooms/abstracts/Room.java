package com.awesome.supercaveadventure.rooms.abstracts;

import com.awesome.supercaveadventure.entity.abstracts.Entity;
import com.awesome.supercaveadventure.graphics.interfaces.Drawable;
import java.util.ArrayList;

/**
 *
 * @author Juho
 */
public abstract class Room implements Drawable {

    

    
    
    public abstract ArrayList<Entity> getEntities();

    public abstract int getPlayerStartXPos();

    public abstract int getPlayerStartYPos();
}
