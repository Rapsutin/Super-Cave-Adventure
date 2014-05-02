

package supercaveadventure.rooms;

import java.awt.Graphics2D;
import supercaveadventure.entities.Enemy1;
import supercaveadventure.entities.Enemy2;
import supercaveadventure.entities.Staircase;
import supercaveadventure.graphics.sprites.Room03Sprite;
import supercaveadventure.graphics.sprites.Sprite;
import supercaveadventure.logic.GameLogic;

/**
 *
 * @author local
 */
public class Room03 extends Room{
    
    
    private Staircase staircaseToNextRoom;
    private Sprite room03Sprite;
    
    public Room03(GameLogic gameLogic) {
        super(gameLogic);
        addNewEnemyEntity(new Enemy2(500, 300, gameLogic));
        addNewEnemyEntity(new Enemy1(700, 300, gameLogic));
        addNewEnemyEntity(new Enemy1(600, 400, gameLogic));
        addNewEnemyEntity(new Enemy1(600, 300, gameLogic));
        
        room03Sprite = new Room03Sprite(this);
    }

    @Override
    public void checkWinCondition() {
        boolean winCondition = areAllEnemiesDead();
        if(winCondition && !winConditionMet) {
            staircaseToNextRoom = new Staircase(400, 300, new Room00(gameLogic), gameLogic);
            createStaircaseIfWinConditionReached(winCondition, staircaseToNextRoom);
        }
        
    }

    @Override
    public void draw(Graphics2D graphics) {
        drawGround(graphics);
        room03Sprite.draw(graphics);
    }
    
}
