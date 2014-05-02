

package supercaveadventure.rooms;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import supercaveadventure.entities.Enemy2;
import supercaveadventure.entities.Staircase;
import supercaveadventure.logic.GameLogic;


public class Room02 extends Room{
    private Staircase staircaseToNextRoom;

    public Room02(GameLogic gameLogic) {
        super(gameLogic);
        addNewEnemyEntity(new Enemy2(500, 300, gameLogic));
        addNewEnemyEntity(new Enemy2(700, 300, gameLogic));
        
        staircaseToNextRoom = new Staircase(50, 50, new Room03(gameLogic), gameLogic);
    }

    @Override
    public void checkWinCondition() {
        boolean winCondition =  areAllEnemiesDead();
        createStaircaseIfWinConditionReached(winCondition, staircaseToNextRoom);
    }

    @Override
    public void draw(Graphics2D graphics) {
        drawGround(graphics);
    }

    
    
}
