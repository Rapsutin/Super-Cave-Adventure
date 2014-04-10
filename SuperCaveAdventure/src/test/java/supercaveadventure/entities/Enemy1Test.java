/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package supercaveadventure.entities;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import supercaveadventure.logic.GameLogic;
import supercaveadventure.logic.GameLoop;
import supercaveadventure.testobjects.TestRoom;

/**
 *
 * @author Juho
 */
public class Enemy1Test {
    
    private GameLoop gameLoop;
    private GameLogic gameLogic;
    public Enemy1Test() {
        gameLoop = new GameLoop();
        gameLogic = gameLoop.getGameLogic();
        gameLogic.changeCurrentRoom(new TestRoom());
    }
    
    @Test
    public void playerShouldBeKilledWhenColliding() {
        PlayerCharacter playerCharacter = gameLogic.getPlayerCharacter();
        Enemy1 enemy1 = new Enemy1(100, 100, gameLogic);
        enemy1.onOverlap(playerCharacter);
        assertTrue(!playerCharacter.isAlive());
    }
    
    @Test
    public void anotherEnemyShouldNotBeKilledWhenColliding() {
        
        Enemy1 enemy1 = new Enemy1(100, 100, gameLogic);
        Enemy1 collidingEnemy = new Enemy1(100, 100, gameLogic);
        enemy1.onOverlap(collidingEnemy);
        assertTrue(collidingEnemy.isAlive());
        assertTrue(enemy1.isAlive());
    }
    
    @Test
    public void directionsTowardPlayerAreReturnedCorrectly() {
        PlayerCharacter playerCharacter = gameLogic.getPlayerCharacter();
        playerCharacter.setX(300);
        playerCharacter.setY(300);
        
        Enemy1 enemy1 = new Enemy1(200, 200, gameLogic);
        ArrayList<Direction> possibleDirections = enemy1.getAllDirectionsTowardsPlayer();
        assertTrue(possibleDirections.contains(Direction.DOWN));
        assertTrue(possibleDirections.contains(Direction.RIGHT));
        
        enemy1 = new Enemy1(400, 200, gameLogic);
        possibleDirections = enemy1.getAllDirectionsTowardsPlayer();
        assertTrue(possibleDirections.contains(Direction.DOWN));
        assertTrue(possibleDirections.contains(Direction.LEFT));
        
        enemy1 = new Enemy1(200, 400, gameLogic);
        possibleDirections = enemy1.getAllDirectionsTowardsPlayer();
        assertTrue(possibleDirections.contains(Direction.UP));
        assertTrue(possibleDirections.contains(Direction.RIGHT));
        
        enemy1 = new Enemy1(400, 400, gameLogic);
        possibleDirections = enemy1.getAllDirectionsTowardsPlayer();
        assertTrue(possibleDirections.contains(Direction.UP));
        assertTrue(possibleDirections.contains(Direction.LEFT));
    }
    
    @Test
    public void movesToSetCurrentDirection() {
        Enemy1 enemy1 = new Enemy1(300, 300, gameLogic);
        enemy1.setCurrentDirection(Direction.DOWN);
        enemy1.moveToCurrentDirection(1);
        assertTrue(enemy1.getY() > 300);
        
        enemy1 = new Enemy1(300, 300, gameLogic);
        enemy1.setCurrentDirection(Direction.UP);
        enemy1.moveToCurrentDirection(1);
        assertTrue(enemy1.getY() < 300);
        
        enemy1 = new Enemy1(300, 300, gameLogic);
        enemy1.setCurrentDirection(Direction.RIGHT);
        enemy1.moveToCurrentDirection(1);
        assertTrue(enemy1.getX() > 300);
        
        enemy1 = new Enemy1(300, 300, gameLogic);
        enemy1.setCurrentDirection(Direction.LEFT);
        enemy1.moveToCurrentDirection(1);
        assertTrue(enemy1.getX() < 300);
    }
    
    
    
    
}