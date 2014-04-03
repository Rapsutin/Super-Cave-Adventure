/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package supercaveadventure.entities;

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
        Enemy1 enemy1 = new Enemy1(100, 100);
        enemy1.onOverlap(playerCharacter);
        assertTrue(!playerCharacter.isAlive());
    }
    
    @Test
    public void anotherEnemyShouldNotBeKilledWhenColliding() {
        
        Enemy1 enemy1 = new Enemy1(100, 100);
        Enemy1 collidingEnemy = new Enemy1(100, 100);
        enemy1.onOverlap(collidingEnemy);
        assertTrue(collidingEnemy.isAlive());
        assertTrue(enemy1.isAlive());
    }
    
    
}