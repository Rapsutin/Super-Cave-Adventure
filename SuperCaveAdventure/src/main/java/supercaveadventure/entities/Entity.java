
package supercaveadventure.entities;

import supercaveadventure.graphics.Drawable;

/**
 * Every object inside a room is considered an entity.
 */
public abstract class Entity implements Drawable{
    
    protected double x;
    protected double y;
    protected int width;
    protected int height;

    public Entity(double x, double y) {
        this.x = x;
        this.y = y;
        width = 0;
        height = 0;
    }
    
    public abstract void onOverlap(Entity collidingEntity);
    
    protected void checkBorders() {
        int maximumX = 790;
        int maximumY = 438;
        int minimumX = 11;
        int minimumY = 11;
        
        if(x + width > maximumX) {
            x = maximumX - width;
        }
        if(y + height > maximumY) {
            y = maximumY - height;
        }
        if(x < minimumX) {
            x = minimumX;
        }
        if(y < minimumY) {
            y = minimumY;
        }
    }
    
    public boolean overlapsBorder() {
        int maximumX = 790;
        int maximumY = 438;
        int minimumX = 11;
        int minimumY = 11;
        
        if(x + width > maximumX) {
            return true;
        }
        if(y + height > maximumY) {
            return true;
        }
        if(x < minimumX) {
            return true;
        }
        if(y < minimumY) {
            return true;
        }
        return false;
    }
    
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    
    
    
}
