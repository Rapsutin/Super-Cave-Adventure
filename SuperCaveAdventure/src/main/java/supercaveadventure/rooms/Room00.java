
package supercaveadventure.rooms;

import supercaveadventure.entities.Staircase;
import supercaveadventure.logic.GameLogic;
import java.awt.Graphics2D;
import supercaveadventure.entities.ExitStaircase;
import supercaveadventure.graphics.sprites.Room00Sprite;
import supercaveadventure.graphics.sprites.Sprite;

/**
 * The first room in the game
 */
public class Room00 extends Room{
    
    
    private Sprite room00Sprite; 
    public Room00(GameLogic gameLogic) {
        super(gameLogic);
        playerStartXPos = 100;
        playerStartYPos = 180;
        room00Sprite = new Room00Sprite(this);
        entities.add(new Staircase(300, 180, new Room01(gameLogic), gameLogic));
        entities.add(new ExitStaircase(300, 280));
    }
    
    
    
    @Override
    public void draw(Graphics2D graphics) {
        drawGround(graphics);
        room00Sprite.draw(graphics);
    }


    @Override
    public void checkWinCondition() {
    }
    
}
