
package supercaveadventure.logic;

import supercaveadventure.entities.Entity;
import supercaveadventure.entities.PlayerCharacter;
import supercaveadventure.graphics.GameFrame;
import supercaveadventure.rooms.Room;
import supercaveadventure.rooms.Room00;
import supercaveadventure.userinput.PlayerMover;
import java.util.ArrayList;
import supercaveadventure.entities.Mortal;
import supercaveadventure.entities.MovableEntity;

/**
 * Handles the game logic on a high level.
 */
public class GameLogic {
    
    private PlayerCharacter playerCharacter;
    private Room currentRoom;
    private ArrayList<Entity> entities;
    private PlayerMover playerMover;

    public GameLogic(GameFrame keyListenerLocation) {
        entities = new ArrayList<>();
        initializeGame();
        playerMover = new PlayerMover(playerCharacter, keyListenerLocation.getPlayerKeyListener());
    }
    
    /**
     * Sets the initial game up.
     */
    private void initializeGame() {
        playerCharacter = new PlayerCharacter(0, 0, this);
        changeCurrentRoom(new Room00(this));
    }
    
    /**
     * Updates all the entities currently in game.
     * @param delta Time-dependent scalar.
     */
    public void updateGame(double delta) {
        playerMover.controlPlayerCharacter(delta);
        moveAllMovableEntities(delta);
        checkForOverlaps();
        removeDeadEntities();
        currentRoom.checkWinCondition();
    }
    
    /**
     * Notifies entities of overlaps.
     */
    public void checkForOverlaps() {
        for(Entity entity1: entities) {
            for(Entity entity2: entities) {
                if(doEntitiesOverlap(entity1, entity2) && entity1 != entity2) {
                    entity2.onOverlap(entity1);
                }
            }
        }
    }
    
    /**
     * Removes all dead entities.
     */
    public void removeDeadEntities() {
        ArrayList<Mortal> deadEntities = new ArrayList<>();
        for(Entity e : entities) {
            addToDeadEntitiesListIfDead(e, deadEntities);
        }
        for(Mortal m : deadEntities) {
            removeEntity((Entity) m);
        }
        
    }
    
    /**
     * Adds the entity to deadEntities if it is dead.
     * @param e 
     * @param deadEntities 
     */
    private void addToDeadEntitiesListIfDead(Entity e, ArrayList<Mortal> deadEntities) {
        if(e instanceof Mortal) {
            Mortal mortalEntity = (Mortal)e;
            if(!mortalEntity.isAlive()) {
                deadEntities.add(mortalEntity);
            }
        }
    }
    
    /**
     * Moves all the movable entities in the 
     * current room except PlayerCharacter
     * 
     * @param delta Time-dependent scalar
     */
    public void moveAllMovableEntities(double delta) {
        for (Entity e : entities) {
            if(e instanceof MovableEntity) {
                MovableEntity entityToBeMoved = (MovableEntity) e;
                entityToBeMoved.move(delta);
            }
        }
    }
    
    /**
     * Checks if entity2 overlaps
     * right or bottom side of entity1
     * @param entity1
     * @param entity2
     * @return True if they overlap, otherwise False
     */
    public boolean doEntitiesOverlap(Entity entity1, Entity entity2) {
        if(entity2.getX() > entity1.getX() + entity1.getWidth() - 1     ||
           entity2.getY() > entity1.getY() + entity1.getHeight() - 1    ||
           entity1.getX() > entity2.getX() + entity2.getWidth() - 1     ||
           entity1.getY() > entity2.getY() + entity2.getHeight() - 1) {
            
            return false;
        }
        return true;
    }
    
    /**
     * Changes the current room and sets up
     * everything.
     * @param newRoom The room to be loaded.
     */
    public void changeCurrentRoom(Room newRoom) {
        currentRoom = newRoom;
        entities = currentRoom.getEntities();
        addEntity(playerCharacter);
        playerCharacter.setX(currentRoom.getPlayerStartXPos());
        playerCharacter.setY(currentRoom.getPlayerStartYPos());
    }
    
    public void addEntity(Entity entity) {
        entities.add(entity);
    }
    
    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }
    
    public PlayerCharacter getPlayerCharacter() {
        return playerCharacter;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    

    

}
