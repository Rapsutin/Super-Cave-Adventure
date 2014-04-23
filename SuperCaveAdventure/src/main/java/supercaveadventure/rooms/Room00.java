
package supercaveadventure.rooms;

import supercaveadventure.entities.Entity;
import supercaveadventure.entities.Staircase;
import supercaveadventure.graphics.ImageLoader;
import supercaveadventure.graphics.DrawDepth;
import supercaveadventure.logic.GameLogic;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * The first room in the game
 */
public class Room00 extends Room{
    
    private BufferedImage ground;
    

    public Room00(GameLogic gameLogic) {
        super(gameLogic);
        playerStartXPos = 100;
        playerStartYPos = 180;
        ground = ImageLoader.loadImage("resources/ground.png");
    }
    
    
    
    @Override
    public void draw(Graphics2D graphics) {
        graphics.drawImage(ground, 0, 0, null);
        
    }

    @Override
    public DrawDepth getDrawDepth() {
        return DrawDepth.ROOM;
    }

    @Override
    public void checkWinCondition() {
        if(winConditionMet == false) {
            entities.add(new Staircase(300, 180, new Room01(gameLogic), gameLogic));
            winConditionMet = true;
        }
    }
    
}
