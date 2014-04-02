

package supercaveadventure.rooms;

import supercaveadventure.entities.Entity;
import supercaveadventure.graphics.ImageLoader;
import supercaveadventure.graphics.DrawDepth;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * The second room.
 */
public class Room01 extends Room{
    
    private ArrayList<Entity> entities;
    private int playerStartXPos;
    private int playerStartYPos;
    private BufferedImage ground;

    public Room01() {
        entities = new ArrayList<>();
        ground = ImageLoader.loadImage("resources/ground.png");
        playerStartXPos = 100;
        playerStartYPos = 180;
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
