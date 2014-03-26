
package com.awesome.supercaveadventure.entity.abstracts;

import com.awesome.supercaveadventure.graphics.interfaces.Drawable;

/**
 * Every non-room object inside a room is considered an entity.
 */
public abstract class Entity implements Drawable{
    public abstract void onOverlap(Entity collidingEntity);
    public abstract double getX();
    public abstract double getY();
    public abstract int getHeight();
    public abstract int getWidth();
    
    
    
    
    
}
