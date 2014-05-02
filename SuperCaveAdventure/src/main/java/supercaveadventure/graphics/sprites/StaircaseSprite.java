

package supercaveadventure.graphics.sprites;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import supercaveadventure.entities.Staircase;
import supercaveadventure.graphics.ImageLoader;


public class StaircaseSprite extends Sprite{

    private Staircase staircase;
    private BufferedImage staircaseImage;
    
    public StaircaseSprite(Staircase staircase) {
        super(staircase);
        this.staircase = staircase;
        staircaseImage = ImageLoader.loadImage("resources/staircaseDoor.png");
    }
    
    
    
    @Override
    public void draw(Graphics2D graphics) {
         graphics.drawImage(staircaseImage, (int)staircase.getX(), (int)staircase.getY(), null);
    }
    
}
