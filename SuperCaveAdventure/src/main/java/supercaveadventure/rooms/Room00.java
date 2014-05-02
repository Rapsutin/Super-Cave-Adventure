
package supercaveadventure.rooms;

import java.awt.Font;
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
    
    

    public Room00(GameLogic gameLogic) {
        super(gameLogic);
        playerStartXPos = 100;
        playerStartYPos = 180;
        entities.add(new Staircase(300, 180, new Room01(gameLogic), gameLogic));
    }
    
    
    
    @Override
    public void draw(Graphics2D graphics) {
        drawGround(graphics);
        graphics.setFont(new Font("Arial", Font.BOLD, 30));
        
        graphics.drawString("Use the arrow keys to move and spacebar to shoot.", 35, 60);
        
        graphics.drawString("Start", 360, 215);
    }


    @Override
    public void checkWinCondition() {
    }
    
}
