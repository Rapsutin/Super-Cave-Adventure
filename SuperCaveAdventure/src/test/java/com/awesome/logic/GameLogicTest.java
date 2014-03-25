/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.awesome.logic;

import com.awesome.supercaveadventure.entity.abstracts.Entity;
import com.awesome.supercaveadventure.entity.player.PlayerCharacter;
import com.awesome.supercaveadventure.logic.GameLogic;
import com.awesome.supercaveadventure.logic.GameLoop;
import com.awesome.supercaveadventure.rooms.Room;
import com.awesome.testobjects.TestEntity;
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
        GameLoop gameLoop = new GameLoop();
        gameLogic = gameLoop.getGameLogic();
        testRoom = new TestRoom();
    }
    
    
    
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
    
    
    @Test
    public void CollisionShouldNotBeDetectedIfNothingOverlapsTest1() {
        TestEntity entity1 = new TestEntity(8, 0, 1, 1);
        TestEntity entity2 = new TestEntity(100, 0, 1, 1);
        testRoom.addEntity(entity1);
        testRoom.addEntity(entity2);
        gameLogic.changeCurrentRoom(testRoom);
        
        assertTrue(!gameLogic.doEntitiesOverlap(entity1, entity2));
    }
    @Test
    public void CollisionShouldNotBeDetectedIfNothingOverlapsTest2() {
        TestEntity entity1 = new TestEntity(0, 8, 1, 1);
        TestEntity entity2 = new TestEntity(0, 100, 1, 1);
        testRoom.addEntity(entity1);
        testRoom.addEntity(entity2);
        gameLogic.changeCurrentRoom(testRoom);
        
        assertTrue(!gameLogic.doEntitiesOverlap(entity1, entity2));
    }
    
    @Test
    public void isCollisionDetectedIfRightSideOverlaps() {
        TestEntity entity1 = new TestEntity(4, 0, 5, 10);
        TestEntity entity2 = new TestEntity(8, 0, 5, 10);
        testRoom.addEntity(entity1);
        testRoom.addEntity(entity2);
        gameLogic.changeCurrentRoom(testRoom);
        
        assertTrue(gameLogic.doEntitiesOverlap(entity1, entity2));
    }
    
    @Test
    public void isCollisionDetectedIfBottomOverlaps() {
        TestEntity entity1 = new TestEntity(4, 5, 5, 5);
        TestEntity entity2 = new TestEntity(4, 8, 4, 10);
        testRoom.addEntity(entity1);
        testRoom.addEntity(entity2);
        gameLogic.changeCurrentRoom(testRoom);
        
        assertTrue(gameLogic.doEntitiesOverlap(entity1, entity2));
    }
    
    @Test
    public void isCollisionDetectedIfAnEntityIsInsideAnotherEntity() {
        TestEntity entity1 = new TestEntity(4, 4, 100, 100);
        TestEntity entity2 = new TestEntity(8, 8, 4, 10);
        testRoom.addEntity(entity1);
        testRoom.addEntity(entity2);
        gameLogic.changeCurrentRoom(testRoom);
        
        assertTrue(gameLogic.doEntitiesOverlap(entity1, entity2) ||
                    gameLogic.doEntitiesOverlap(entity2, entity1));
    }
    @Test
    public void isCollisionDetectedIfAnEntityOfEqualSizeIsAtTheSamePoint() {
        TestEntity entity1 = new TestEntity(4, 4, 100, 100);
        TestEntity entity2 = new TestEntity(4, 4, 100, 100);
        testRoom.addEntity(entity1);
        testRoom.addEntity(entity2);
        gameLogic.changeCurrentRoom(testRoom);
        
        assertTrue(gameLogic.doEntitiesOverlap(entity1, entity2) ||
                    gameLogic.doEntitiesOverlap(entity2, entity1));
    }
    
    
}