/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.awesome.supercaveadventure.logic;

import com.awesome.supercaveadventure.entity.abstracts.Entity;
import com.awesome.supercaveadventure.entity.player.PlayerCharacter;
import com.awesome.supercaveadventure.graphics.GameFrame;
import com.awesome.supercaveadventure.rooms.Room;
import com.awesome.supercaveadventure.rooms.StartRoom;
import com.awesome.userinput.PlayerMover;
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
        changeCurrentRoom(new StartRoom());
    }

    public void updateGame(double delta) {
        playerMover.movePlayer(delta);
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
