

package supercaveadventure.entities;

import org.junit.Test;
import static org.junit.Assert.*;
import supercaveadventure.logic.GameLogic;
import supercaveadventure.logic.GameLoop;
import supercaveadventure.testobjects.TestEntity;
import supercaveadventure.testobjects.TestRoom;

public class BulletTest {
    private GameLogic gameLogic;
    private GameLoop gameLoop;

    public BulletTest() {
        gameLoop = new GameLoop();
        gameLogic = gameLoop.getGameLogic();
    }
    
    @Test 
    public void bulletMovesToRight() {
        TestRoom testRoom = new TestRoom(gameLogic);
        Bullet testBullet = new Bullet(300, 300, Direction.RIGHT);
        testRoom.addEntity(testBullet);
        
        gameLogic.changeCurrentRoom(testRoom);
        gameLogic.moveAllMovableEntities(1);
        
        assertTrue(testBullet.getX() > 300);
        
    }
    @Test 
    public void bulletMovesToLeft() {
        TestRoom testRoom = new TestRoom(gameLogic);
        Bullet testBullet = new Bullet(300, 300, Direction.LEFT);
        testRoom.addEntity(testBullet);
        
        gameLogic.changeCurrentRoom(testRoom);
        gameLogic.moveAllMovableEntities(1);
        
        assertTrue(testBullet.getX() < 300);
        
    }
    @Test 
    public void bulletMovesDownwards() {
        TestRoom testRoom = new TestRoom(gameLogic);
        Bullet testBullet = new Bullet(300, 300, Direction.DOWN);
        testRoom.addEntity(testBullet);
        
        gameLogic.changeCurrentRoom(testRoom);
        gameLogic.moveAllMovableEntities(1);
        
        assertTrue(testBullet.getY() > 300);
        
    }
    @Test 
    public void bulletMovesUpwards() {
        TestRoom testRoom = new TestRoom(gameLogic);
        Bullet testBullet = new Bullet(300, 300, Direction.UP);
        testRoom.addEntity(testBullet);
        
        gameLogic.changeCurrentRoom(testRoom);
        gameLogic.moveAllMovableEntities(1);
        
        assertTrue(testBullet.getY() < 300);
        
    }
    
    @Test
    public void bulletNotDestroyedAfterHitWithStaircase() {
        TestRoom testRoom = new TestRoom(gameLogic);
        Bullet testBullet = new Bullet(300, 300, Direction.UP);
        Staircase testStaircase = new Staircase(299, 299, testRoom, gameLogic);
        
        testRoom.addEntity(testStaircase);
        testRoom.addEntity(testBullet);
        
        gameLogic.changeCurrentRoom(testRoom);
        
        gameLogic.moveAllMovableEntities(1);
        
        gameLogic.checkForOverlaps();
        assertTrue(testBullet.isAlive());
    }
    @Test
    public void bulletDestroyedAfterAHitWithANonStaircaseEntity() {
        TestRoom testRoom = new TestRoom(gameLogic);
        Bullet testBullet = new Bullet(300, 330, Direction.UP);
        TestEntity testEntity = new TestEntity(299, 299, 40, 40);
        
        testRoom.addEntity(testEntity);
        testRoom.addEntity(testBullet);
        
        gameLogic.changeCurrentRoom(testRoom);
        
        gameLogic.moveAllMovableEntities(1);
        
        gameLogic.checkForOverlaps();
        assertTrue(!testBullet.isAlive());
    }
    
    @Test
    public void bulletShouldBeDestroyedWhenItHitsABorder() {
        TestRoom testRoom = new TestRoom(gameLogic);
        Bullet testBullet = new Bullet(300, 300, Direction.UP);
        
        testRoom.addEntity(testBullet);
        gameLogic.changeCurrentRoom(testRoom);
        
        testBullet.move(1000);
        
        assertTrue(!testBullet.isAlive());
    }
    
    
}
