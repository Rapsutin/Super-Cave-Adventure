package supercaveadventure.rooms;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import supercaveadventure.entities.Entity;
import supercaveadventure.graphics.Drawable;
import java.util.ArrayList;
import supercaveadventure.entities.Mortal;
import supercaveadventure.entities.Staircase;
import supercaveadventure.graphics.DrawDepth;
import supercaveadventure.graphics.ImageLoader;
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
    private BufferedImage ground;
    protected ArrayList<Entity> enemyList;
    

    public Room(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
        winConditionMet = false;
        playerStartXPos = 100;
        playerStartYPos = 180;
        ground = ImageLoader.loadImage("resources/ground.png");
        entities = new ArrayList<>();
        enemyList = new ArrayList<>();
    }
    
    /**
     * Checks if the win condition of the room
     * has been reached.
     */
    public abstract void checkWinCondition();
    
    
    
    public void createStaircaseIfWinConditionReached(boolean winCondition, Staircase newStaircase) {
        if(winCondition) {
            winConditionMet = true;
            gameLogic.addEntity(newStaircase);
        }
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }
    
    public void addNewEnemyEntity(Entity enemy) {
        enemyList.add(enemy);
        entities.add(enemy);
    }
    
    public void drawGround(Graphics2D graphics) {
        graphics.drawImage(ground, 0, 0, null);
    }
    
    public boolean areAllEnemiesDead() {
        for(Entity enemy : enemyList) {
            if(isEnemyAlive(enemy)) return false;
        }
        return true;
    }

    protected boolean isEnemyAlive(Entity enemy) {
        if (enemy instanceof Mortal) {
            Mortal mortalEnemy = (Mortal) enemy;
            if (mortalEnemy.isAlive()) {
                return true;
            }
        }
        return false;
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

    @Override
    public DrawDepth getDrawDepth() {
        return DrawDepth.ROOM;
    }
    
    

    
}
