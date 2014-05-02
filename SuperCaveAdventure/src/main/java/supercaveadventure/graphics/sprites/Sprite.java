
package supercaveadventure.graphics.sprites;

import java.awt.Graphics2D;
import java.util.concurrent.Callable;
import supercaveadventure.graphics.Drawable;

/**
 * Includes drawing instructions.
 * @author local
 */
public abstract class Sprite {
    
    private Drawable drawableObject;

    public Sprite(Drawable drawableObject) {
        this.drawableObject = drawableObject;
    }
    
    /**
     * Draws the sprite.
     * @param graphics 
     */
    public abstract void draw(Graphics2D graphics);
    
    
    
}
