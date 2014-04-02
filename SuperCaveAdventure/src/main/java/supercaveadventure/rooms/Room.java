package supercaveadventure.rooms;

import supercaveadventure.entities.Entity;
import supercaveadventure.graphics.Drawable;
import java.util.ArrayList;

/**
 * Rooms are small levels that contain enemies and other entities.
 */
public abstract class Room implements Drawable {

    

    
    
    public abstract ArrayList<Entity> getEntities();
    
    /**
     * Tells where the PlayerCharacter should be initially placed.
     * @return X-coordinate.
     */
    public abstract int getPlayerStartXPos();
    
    /**
     * Tells where the PlayerCharacter should be initially placed.
     * @return Y-coordinate.
     */
    public abstract int getPlayerStartYPos();
}
