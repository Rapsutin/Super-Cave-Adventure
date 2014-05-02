

package supercaveadventure.rooms;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import supercaveadventure.entities.Enemy1;
import supercaveadventure.logic.GameLogic;
import supercaveadventure.logic.GameLoop;
import supercaveadventure.testobjects.TestRoom;

public class RoomTest {
    
    private GameLogic gameLogic;
    
    public RoomTest() {
        GameLoop gameLoop = new GameLoop();
        gameLogic = gameLoop.getGameLogic();
    }
    
    @Test
    public void allEnemiesAreDeadWhenThereAreNoEnemies() {
        Room testedRoom = new TestRoom(gameLogic);
        gameLogic.changeCurrentRoom(new TestRoom(gameLogic));
        assertTrue(testedRoom.areAllEnemiesDead());
    }
    @Test
    public void allEnemiesAreDeadWhenThereIs1Dead0Alive() {
        Room testedRoom = new TestRoom(gameLogic);
        Enemy1 enemy = new Enemy1(30, 30, gameLogic);
        testedRoom.addNewEnemyEntity(enemy);
        
        enemy.setAlive(false);
        gameLogic.changeCurrentRoom(new TestRoom(gameLogic));
        assertTrue(testedRoom.areAllEnemiesDead());
    }
    
    
    
    
    @Test
    public void allEnemiesAreDeadWhenThereIs3Dead0Alive() {
        Room testedRoom = new TestRoom(gameLogic);
        
        Enemy1 enemy1 = new Enemy1(30, 30, gameLogic);
        Enemy1 enemy2 = new Enemy1(30, 30, gameLogic);
        Enemy1 enemy3 = new Enemy1(30, 30, gameLogic);
        
        testedRoom.addNewEnemyEntity(enemy1);
        testedRoom.addNewEnemyEntity(enemy2);
        testedRoom.addNewEnemyEntity(enemy3);
        
        enemy1.setAlive(false);
        enemy2.setAlive(false);
        enemy3.setAlive(false);
        
        gameLogic.changeCurrentRoom(new TestRoom(gameLogic));
        assertTrue(testedRoom.areAllEnemiesDead());
    }
    
    
    
    
    @Test
    public void allEnemiesAreDeadIsFalseWhenThereIs1AliveAnd2Dead() {
        Room testedRoom = new TestRoom(gameLogic);
        
        Enemy1 enemy1 = new Enemy1(30, 30, gameLogic);
        Enemy1 enemy2 = new Enemy1(30, 30, gameLogic);
        Enemy1 enemy3 = new Enemy1(30, 30, gameLogic);
        
        testedRoom.addNewEnemyEntity(enemy1);
        testedRoom.addNewEnemyEntity(enemy2);
        testedRoom.addNewEnemyEntity(enemy3);
        
        enemy1.setAlive(false);
        enemy2.setAlive(false);
        
        gameLogic.changeCurrentRoom(new TestRoom(gameLogic));
        assertTrue(!testedRoom.areAllEnemiesDead());
        
    }
    
    @Test
    public void allEnemiesAreDeadIsFalseWhenThereIs1Alive() {
        Room testedRoom = new TestRoom(gameLogic);
        
        Enemy1 enemy1 = new Enemy1(30, 30, gameLogic);
        testedRoom.addNewEnemyEntity(enemy1);
        gameLogic.changeCurrentRoom(new TestRoom(gameLogic));
        
        assertTrue(!testedRoom.areAllEnemiesDead());
        
    }
    
    
    
}
