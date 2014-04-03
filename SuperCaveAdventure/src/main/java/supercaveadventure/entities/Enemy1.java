/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package supercaveadventure.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import supercaveadventure.graphics.DrawDepth;


public class Enemy1 extends Entity implements MovableEntity, Mortal{
    
    private boolean alive;

    public Enemy1(double x, double y) {
        super(x, y);
        alive = true;
    }

    @Override
    public void onOverlap(Entity collidingEntity) {
        if(collidingEntity instanceof PlayerCharacter) {
            Mortal killedPlayer = (Mortal) collidingEntity;
            killedPlayer.setAlive(false);
        }
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setPaint(Color.BLACK);
        graphics.fillRect((int)x, (int)y, 30, 30);
    }

    @Override
    public DrawDepth getDrawDepth() {
        return DrawDepth.ENEMY;
    }

    @Override
    public void move() {
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
