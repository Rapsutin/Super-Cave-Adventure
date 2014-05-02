/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package supercaveadventure.graphics.sprites;

import java.awt.Color;
import java.awt.Graphics2D;
import supercaveadventure.entities.Enemy1;

/**
 *
 * @author local
 */
public class Enemy1Sprite extends Sprite{
    
    private Enemy1 enemy1;

    public Enemy1Sprite(Enemy1 enemy1) {
        super(enemy1);
        this.enemy1 = enemy1;
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setPaint(Color.BLACK);
        graphics.fillRect((int) enemy1.getX(), (int) enemy1.getY(), enemy1.getWidth(), enemy1.getHeight());
    }
    
}
