

package supercaveadventure.graphics.sprites;

import java.awt.Color;
import java.awt.Graphics2D;
import supercaveadventure.entities.Enemy2;

public class Enemy2Sprite extends Sprite{
    
    private Enemy2 entityOfSprite;
    
    public Enemy2Sprite(Enemy2 entityOfSprite) {
        super(entityOfSprite);
        this.entityOfSprite = entityOfSprite;
    }
    
    
    @Override
    public void draw(Graphics2D graphics) {
        setColorForCurrentHealth(graphics);
        graphics.fillRect((int) entityOfSprite.getX(), (int) entityOfSprite.getY(), entityOfSprite.getWidth(), entityOfSprite.getHeight());
    }
    
    private void setColorForCurrentHealth(Graphics2D graphics) {
        if(entityOfSprite.getHealth() == 2) {
            graphics.setPaint(Color.RED);
        } else {
            graphics.setPaint(Color.BLACK);
        }
    }
    
}
