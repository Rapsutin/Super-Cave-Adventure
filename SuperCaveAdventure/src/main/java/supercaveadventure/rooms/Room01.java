

package supercaveadventure.rooms;

import supercaveadventure.graphics.ImageLoader;
import supercaveadventure.graphics.DrawDepth;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import supercaveadventure.entities.Enemy1;
import supercaveadventure.entities.Staircase;
import supercaveadventure.logic.GameLogic;

/**
 * The second room.
 */
public class Room01 extends Room{
    
    private Staircase toNextRoom;

    public Room01(GameLogic gameLogic) {
        super(gameLogic);
        playerStartXPos = 100;
        playerStartYPos = 180;
        addNewEnemyEntity(new Enemy1(600, 400, gameLogic));
        addNewEnemyEntity(new Enemy1(600, 300, gameLogic));
        
        toNextRoom = new Staircase(400, 200, new Room02(gameLogic), gameLogic);
        
    }

    @Override
    public void draw(Graphics2D graphics) {
        drawGround(graphics);
    }

    @Override
    public void checkWinCondition() {
        boolean winCondition = areAllEnemiesDead();
        createStaircaseIfWinConditionReached(winCondition, toNextRoom);
    }

}
