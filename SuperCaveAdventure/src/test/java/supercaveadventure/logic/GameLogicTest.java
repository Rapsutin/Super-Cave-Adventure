/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package supercaveadventure.logic;

import supercaveadventure.entities.Entity;
import supercaveadventure.entities.PlayerCharacter;
import supercaveadventure.testobjects.TestEntity;
import supercaveadventure.testobjects.TestRoom;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import supercaveadventure.entities.Enemy1;
import supercaveadventure.rooms.Room;

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
        testRoom = new TestRoom(gameLogic);
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
        assertTrue(playerCharacter.getX() == testRoom.getPlayerStartXPos());
        assertTrue(playerCharacter.getY() == testRoom.getPlayerStartYPos());
    }
    
    @Test
    public void changeCurrentRoomShouldChangeTheCurrentRoom() {
        Room previous = gameLogic.getCurrentRoom();
        gameLogic.changeCurrentRoom(new TestRoom(gameLogic));
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
        entitiesOverlap(entity1, entity2);
    }
    @Test
    public void isCollisionDetectedIfLeftSideOverlaps() {
        TestEntity entity2 = new TestEntity(4, 0, 5, 10);
        TestEntity entity1 = new TestEntity(8, 0, 5, 10);
        entitiesOverlap(entity1, entity2);
    }
    
    @Test
    public void isCollisionDetectedIfBottomOverlaps() {
        TestEntity entity1 = new TestEntity(4, 5, 5, 5);
        TestEntity entity2 = new TestEntity(4, 8, 4, 10);
        entitiesOverlap(entity1, entity2);
    }
    @Test
    public void isCollisionDetectedIfTopOverlaps() {
        TestEntity entity2 = new TestEntity(4, 5, 5, 5);
        TestEntity entity1 = new TestEntity(4, 8, 4, 10);
        entitiesOverlap(entity1, entity2);
    }
    public void entitiesOverlap(TestEntity entity1, TestEntity entity2) {
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
    
    @Test
    public void movableEntitiesAreMovedWhenUpdating() {
        Enemy1 enemy1 = new Enemy1(200, 200, gameLogic);
        Enemy1 enemy2 = new Enemy1(200, 200, gameLogic);
        testRoom.addEntity(enemy1);
        testRoom.addEntity(enemy2);
        gameLogic.changeCurrentRoom(testRoom);
        
        gameLogic.updateGame(1);
        assertTrue((enemy1.getX() != 200) || (enemy1.getY() != 200));
        assertTrue((enemy2.getX() != 200) || (enemy2.getY() != 200));
    }

    
    
    
}