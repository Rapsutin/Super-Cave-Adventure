/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package supercaveadventure.entities;

import supercaveadventure.logic.GameLogic;
import supercaveadventure.logic.GameLoop;
import org.junit.Test;
import static org.junit.Assert.*;
import supercaveadventure.testobjects.TestEntity;
import supercaveadventure.testobjects.TestRoom;

/**
 *
 * @author Juho
 */
public class MortalTest {
    private GameLoop gameLoop;
    private GameLogic gameLogic;
    
    public MortalTest() {
        gameLoop = new GameLoop();
        gameLogic = gameLoop.getGameLogic();
        gameLogic.changeCurrentRoom(new TestRoom(gameLogic));
    }
    
    @Test
    public void aliveEntitiesShouldStayAlive() {
        gameLogic.addEntity(new TestEntity(10, 10, 10, 10));
        gameLogic.addEntity(new TestEntity(10, 10, 10, 10));
        gameLogic.addEntity(new TestEntity(10, 10, 10, 10));
        assertTrue(gameLogic.getEntities().size() == 3 + 1);
        
        gameLogic.removeDeadEntities();
        assertTrue(gameLogic.getEntities().size() == 3 + 1);
    }
    
    @Test
    public void oneDeadEntityShouldBeRemoved() {
        TestEntity deadEntity = new TestEntity(10, 10, 10, 10);
        deadEntity.setAlive(false);
        gameLogic.addEntity(deadEntity);
        gameLogic.addEntity(new TestEntity(10, 10, 10, 10));
        gameLogic.addEntity(new TestEntity(10, 10, 10, 10));
        assertTrue(gameLogic.getEntities().size() == 3 + 1);
        
        gameLogic.removeDeadEntities();
        assertTrue(gameLogic.getEntities().size() == 2 + 1);
    }
    
    @Test
    public void allDeadEntitiesShouldBeRemoved() {
        TestEntity deadEntity0 = new TestEntity(10, 10, 10, 10);
        deadEntity0.setAlive(false);
        TestEntity deadEntity1 = new TestEntity(10, 10, 10, 10);
        deadEntity1.setAlive(false);
        TestEntity deadEntity2 = new TestEntity(10, 10, 10, 10);
        deadEntity2.setAlive(false);
        
        gameLogic.addEntity(deadEntity0);
        gameLogic.addEntity(deadEntity1);
        gameLogic.addEntity(deadEntity2);
        assertTrue(gameLogic.getEntities().size() == 3 + 1);
        
        gameLogic.removeDeadEntities();
        assertTrue(gameLogic.getEntities().size() == 0 + 1);
    }
   
}