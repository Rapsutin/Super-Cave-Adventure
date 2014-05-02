

package supercaveadventure.graphics.sprites;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import supercaveadventure.graphics.ImageLoader;


public class GroundSprite extends Sprite{
    
    private BufferedImage ground;

    public GroundSprite() {
        super();
        ground = ImageLoader.loadImage("../resources/ground.png");
    }
    
    

    @Override
    public void draw(Graphics2D graphics) {
        graphics.drawImage(ground, 0, 0, null);
    }
    
}
