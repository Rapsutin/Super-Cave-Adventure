package supercaveadventure.rooms;

import supercaveadventure.entities.Entity;
import supercaveadventure.graphics.Drawable;
import java.util.ArrayList;
import supercaveadventure.logic.GameLogic;

/**
 * Rooms are small levels that contain enemies and other entities.
 */
public abstract class Room implements Drawable {
    protected ArrayList<Entity> entities;
    protected int playerStartXPos;
    protected int playerStartYPos;
    protected boolean winConditionMet;
    protected GameLogic gameLogic;

    public Room(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
        winConditionMet = false;
        playerStartXPos = 100;
        playerStartYPos = 180;
        entities = new ArrayList<>();
    }
    
    public abstract void checkWinCondition();

    public ArrayList<Entity> getEntities() {
        return entities;
    }
    
    
    /**
     * Tells where the PlayerCharacter should be initially placed.
     * @return X-coordinate.
     */
    public int getPlayerStartXPos() {
        return playerStartXPos;
    }

    /**
     * Tells where the PlayerCharacter should be initially placed.
     * @return Y-coordinate.
     */
    public int getPlayerStartYPos() {
        return playerStartYPos;
    }
    
    

    
}
