/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package supercaveadventure.entities;

import java.awt.Graphics2D;
import supercaveadventure.graphics.sprites.Enemy2Sprite;
import supercaveadventure.graphics.sprites.Sprite;
import supercaveadventure.logic.GameLogic;

/**
 *
 * @author local
 */
public class Enemy2 extends Enemy1{
    
    private int health;
    private Sprite sprite;
    
    public Enemy2(double x, double y, GameLogic gameLogic) {
        super(x, y, gameLogic);
        health = 2;
        sprite = new Enemy2Sprite(this);
    }

    @Override
    public void onOverlap(Entity collidingEntity) {
        killCollidingPlayerCharacter(collidingEntity);
        reduceHealthWhenBulletHits(collidingEntity);
    }
    
    public void reduceHealthWhenBulletHits(Entity collidingEntity) {
        if(collidingEntity instanceof Bullet) {
            reduceHealth();
        }
    }
    
    public void reduceHealth() {
        health--;
        if(health == 0) {
            setAlive(false);
        }
    }

    @Override
    public void draw(Graphics2D graphics) {
        sprite.draw(graphics);
    }
    
    public int getHealth() {
        return health;
    }
    
    
    
    
    
    
    
}
