/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package supercaveadventure.graphics.sprites;

import java.awt.Color;
import java.awt.Graphics2D;
import supercaveadventure.entities.Bullet;

/**
 *
 * @author local
 */
public class BulletSprite extends Sprite{
    
    private Bullet bullet;
    public BulletSprite(Bullet bullet) {
        super(bullet);
        this.bullet = bullet;
    }
    
    @Override
    public void draw(Graphics2D graphics) {
        graphics.setPaint(Color.BLACK);
        graphics.fillOval((int) bullet.getX(), (int) bullet.getY(), bullet.getWidth(), bullet.getHeight());
    }
    
}
