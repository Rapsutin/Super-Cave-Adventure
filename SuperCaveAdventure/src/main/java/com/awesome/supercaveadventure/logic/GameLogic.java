/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.awesome.supercaveadventure.logic;

import com.awesome.supercaveadventure.entity.abstracts.Entity;
import com.awesome.supercaveadventure.entity.player.PlayerCharacter;
import com.awesome.supercaveadventure.graphics.GameFrame;
import com.awesome.supercaveadventure.rooms.abstracts.Room;
import com.awesome.supercaveadventure.rooms.Room00;
import com.awesome.supercaveadventure.userinput.PlayerMover;
import java.util.ArrayList;


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
    
    private void initializeGame() {
        playerCharacter = new PlayerCharacter(0, 0);
        changeCurrentRoom(new Room00(this));
    }

    public void updateGame(double delta) {
        playerMover.movePlayer(delta);
        checkForOverlaps();
    }
    
    public void checkForOverlaps() {
        for(Entity entity1: entities) {
            for(Entity entity2: entities) {
                if(doEntitiesOverlap(entity1, entity2) && entity1 != entity2) {
                    entity1.onOverlap(entity2);
                    entity2.onOverlap(entity1);
                }
            }
        }
    }
    
    /**
     * Checks if entity2 overlaps entity1's 
     * right or bottom side
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
