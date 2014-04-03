/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package supercaveadventure.testobjects;

import supercaveadventure.entities.Entity;
import supercaveadventure.graphics.DrawDepth;
import java.awt.Graphics2D;
import supercaveadventure.entities.Mortal;


public class TestEntity extends Entity implements Mortal{
    
    private boolean alive;

    public TestEntity(double x, double y, int width, int height) {
        super(x, y);
        alive = true;
        super.height = height;
        super.width = width;
    }
    
    @Override
    public DrawDepth getDrawDepth() {
        return DrawDepth.PLAYER;
    }

    @Override
    public void onOverlap(Entity collidingEntity) {
    }

    @Override
    public void draw(Graphics2D graphics) {
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    @Override
    public void setAlive(boolean isAlive) {
        alive = isAlive;
    }

}
