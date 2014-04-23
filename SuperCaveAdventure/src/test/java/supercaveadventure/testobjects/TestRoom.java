
package supercaveadventure.testobjects;

import supercaveadventure.entities.Entity;
import supercaveadventure.graphics.DrawDepth;
import supercaveadventure.rooms.Room;
import java.awt.Graphics2D;
import java.util.ArrayList;
import supercaveadventure.logic.GameLogic;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
