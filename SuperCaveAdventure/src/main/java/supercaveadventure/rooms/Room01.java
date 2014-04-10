

package supercaveadventure.rooms;

import supercaveadventure.entities.Entity;
import supercaveadventure.graphics.ImageLoader;
import supercaveadventure.graphics.DrawDepth;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import supercaveadventure.entities.Bullet;
import supercaveadventure.entities.Direction;
import supercaveadventure.entities.Enemy1;
import supercaveadventure.logic.GameLogic;

/**
 * The second room.
 */
public class Room01 extends Room{
    
    private ArrayList<Entity> entities;
    private int playerStartXPos;
    private int playerStartYPos;
    private BufferedImage ground;

    public Room01(GameLogic gameLogic) {
        entities = new ArrayList<>();
        ground = ImageLoader.loadImage("resources/ground.png");
        playerStartXPos = 100;
        playerStartYPos = 180;
        
        entities.add(new Enemy1(400, 400, gameLogic));
        entities.add(new Enemy1(400, 300, gameLogic));
        
    }

    @Override
    public ArrayList<Entity> getEntities() {
        return entities;
    }

    @Override
    public int getPlayerStartXPos() {
        return playerStartXPos;
    }

    @Override
    public int getPlayerStartYPos() {
        return playerStartYPos;
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.drawImage(ground, 0, 0, null);
    }

    @Override
    public DrawDepth getDrawDepth() {
        return DrawDepth.ROOM;
    }

}
