
package supercaveadventure.entities;

import supercaveadventure.graphics.DrawDepth;
import supercaveadventure.logic.GameLogic;
import supercaveadventure.rooms.Room;
import java.awt.Graphics2D;
import supercaveadventure.graphics.sprites.Sprite;
import supercaveadventure.graphics.sprites.StaircaseSprite;

/**
 * When the PlayerCharacter walks into this, 
 * the current room is changed to another.
 */
public class Staircase extends Entity {

    
   
    private Room nextRoom;
    private GameLogic gameLogic;
    private Sprite staircaseSprite;
    

    public Staircase(int x, int y, Room nextRoom, GameLogic gameLogic) {
        super(x, y);
        height = 50;
        width = 50;
        this.nextRoom = nextRoom;
        this.gameLogic = gameLogic;
        staircaseSprite = new StaircaseSprite(this);
    }

    @Override
    public void onOverlap(Entity collidingEntity) {
        if(collidingEntity.getClass() == PlayerCharacter.class) {
            gameLogic.changeCurrentRoom(nextRoom);
        }
    }

    @Override
    public void draw(Graphics2D graphics) {
        staircaseSprite.draw(graphics);
    }

    @Override
    public DrawDepth getDrawDepth() {
        return DrawDepth.DOOR;
    }
}
