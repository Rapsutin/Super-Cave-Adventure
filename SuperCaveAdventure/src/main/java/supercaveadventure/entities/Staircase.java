
package supercaveadventure.entities;

import supercaveadventure.entities.Entity;
import supercaveadventure.entities.PlayerCharacter;
import supercaveadventure.graphics.ImageLoader;
import supercaveadventure.graphics.DrawDepth;
import supercaveadventure.logic.GameLogic;
import supercaveadventure.rooms.Room;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * When the PlayerCharacter walks into this, 
 * the current room is changed to another.
 */
public class Staircase extends Entity {

    
   
    private Room nextRoom;
    private GameLogic gameLogic;
    private BufferedImage img;
    

    public Staircase(int x, int y, Room nextRoom, GameLogic gameLogic) {
        super(x, y);
        height = 50;
        width = 50;
        this.nextRoom = nextRoom;
        this.gameLogic = gameLogic;
        img = ImageLoader.loadImage("resources/staircaseDoor.png");
    }

    @Override
    public void onOverlap(Entity collidingEntity) {
        
        if(collidingEntity.getClass() == PlayerCharacter.class) {
            gameLogic.changeCurrentRoom(nextRoom);
        }
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.drawImage(img, (int)x, (int)y, null);
    }

    @Override
    public DrawDepth getDrawDepth() {
        return DrawDepth.DOOR;
    }
}
