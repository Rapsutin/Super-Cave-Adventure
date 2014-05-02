package supercaveadventure.rooms;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import supercaveadventure.entities.Entity;
import supercaveadventure.graphics.Drawable;
import java.util.ArrayList;
import supercaveadventure.entities.Mortal;
import supercaveadventure.entities.Staircase;
import supercaveadventure.graphics.DrawDepth;
import supercaveadventure.graphics.sprites.GroundSprite;
import supercaveadventure.graphics.sprites.Sprite;
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
    protected Sprite groundSprite;
    

    public Room(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
        winConditionMet = false;
        playerStartXPos = 100;
        playerStartYPos = 180;
        groundSprite = new GroundSprite();
        entities = new ArrayList<>();
        enemyList = new ArrayList<>();
    }
    
    /**
     * Checks if the win condition of the room
     * has been reached.
     */
    public abstract void checkWinCondition();
    
    
    /**
     * Checks if winCondition has been reached and
     * adds a staircase to the game if winCondition has
     * been met.
     * @param winCondition Condition to be fulfilled before winning this room.
     * @param newStaircase The staircase to the next room.
     */
    public void createStaircaseIfWinConditionReached(boolean winCondition, Staircase newStaircase) {
        if(winCondition) {
            winConditionMet = true;
            gameLogic.addEntity(newStaircase);
        }
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }
    
    /**
     * Adds a hostile entity into the game.
     * @param enemy Entity to be added.
     */
    public void addNewEnemyEntity(Entity enemy) {
        enemyList.add(enemy);
        entities.add(enemy);
    }
    
    /**
     * Draws a basic ground texture.
     * @param graphics 
     */
    public void drawGround(Graphics2D graphics) {
        groundSprite.draw(graphics);
    }
    
    /**
     * Checks if all enemies 
     * in the room have died.
     * @return True if they're dead, otherwise false.
     */
    public boolean areAllEnemiesDead() {
        for(Entity enemy : enemyList) {
            if(isEnemyAlive(enemy)) return false;
        }
        return true;
    }
    
    /**
     * Checks if an entity is alive.
     * @param enemy 
     * @return True if it is alive, otherwise false.
     */
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

    public boolean getWinConditionMet() {
        return winConditionMet;
    }
    
    

    
}
