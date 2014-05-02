
package supercaveadventure.testobjects;

import supercaveadventure.entities.Entity;
import supercaveadventure.graphics.DrawDepth;
import java.awt.Graphics2D;
import java.util.ArrayList;
import supercaveadventure.logic.GameLogic;
import supercaveadventure.rooms.Room;

/**
 *
 * @author Juho
 */
public class TestRoom extends Room{
    

    public TestRoom(GameLogic gameLogic) {
        super(gameLogic);
        playerStartXPos = 40;
        playerStartYPos = 40;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    @Override
    public void draw(Graphics2D graphics) {
    } 

    @Override
    public DrawDepth getDrawDepth() {
        return DrawDepth.ROOM;
    }

    @Override
    public void checkWinCondition() {
    }
}
