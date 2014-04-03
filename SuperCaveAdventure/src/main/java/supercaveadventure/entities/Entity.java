
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
