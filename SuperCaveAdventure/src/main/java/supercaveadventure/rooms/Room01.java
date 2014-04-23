

package supercaveadventure.rooms;

import supercaveadventure.graphics.ImageLoader;
import supercaveadventure.graphics.DrawDepth;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import supercaveadventure.entities.Enemy1;
import supercaveadventure.entities.Staircase;
import supercaveadventure.logic.GameLogic;

/**
 * The second room.
 */
public class Room01 extends Room{
    
    private BufferedImage ground;
    private Enemy1 enemy1;
    private Enemy1 enemy2;

    public Room01(GameLogic gameLogic) {
        super(gameLogic);
        ground = ImageLoader.loadImage("resources/ground.png");
        playerStartXPos = 100;
        playerStartYPos = 180;
        enemy1 = new Enemy1(600, 400, gameLogic);
        enemy2 = new Enemy1(600, 300, gameLogic);
        entities.add(enemy1);
        entities.add(enemy2);
        
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.drawImage(ground, 0, 0, null);
    }

    @Override
    public DrawDepth getDrawDepth() {
        return DrawDepth.ROOM;
    }

    @Override
    public void checkWinCondition() {
        if(!enemy1.isAlive() && !enemy2.isAlive() && !winConditionMet) {
            winConditionMet = true;
            gameLogic.addEntity(new Staircase(400, 200, new Room00(gameLogic), gameLogic));
        }
    }

}
