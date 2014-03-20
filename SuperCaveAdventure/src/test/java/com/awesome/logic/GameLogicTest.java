/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.awesome.logic;

import com.awesome.supercaveadventure.entity.abstracts.Entity;
import com.awesome.supercaveadventure.entity.player.PlayerCharacter;
import com.awesome.supercaveadventure.logic.GameLogic;
import com.awesome.supercaveadventure.rooms.Room;
import com.awesome.testobjects.TestRoom;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juho
 */
public class GameLogicTest {
    
    private GameLogic gameLogic;
    private TestRoom testRoom;
    
    @Before
    public void setUp() {
        gameLogic = new GameLogic();
        testRoom = new TestRoom();
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void playerCharacterShouldBeInEntitiesWhenStarting() {
        ArrayList<Entity> entities = gameLogic.getEntities();
        PlayerCharacter playerCharacter = gameLogic.getPlayerCharacter();
        assertTrue(entities.contains(playerCharacter));
    }
    
    @Test
    public void playerCharacterShouldBeTransportedWhileChangingRooms() {
        ArrayList<Entity> entities = gameLogic.getEntities();
        PlayerCharacter playerCharacter = gameLogic.getPlayerCharacter();
        gameLogic.changeCurrentRoom(testRoom);
        assertTrue(entities.contains(playerCharacter));
    }
    
    @Test
    public void changeCurrentRoomShouldChangeTheCurrentRoom() {
        Room previous = gameLogic.getCurrentRoom();
        gameLogic.changeCurrentRoom(new TestRoom());
        assertNotSame(previous, gameLogic.getCurrentRoom());
    }
}