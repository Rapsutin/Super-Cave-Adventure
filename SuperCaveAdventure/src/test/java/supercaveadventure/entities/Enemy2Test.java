

package supercaveadventure.entities;

import supercaveadventure.logic.GameLogic;
import supercaveadventure.logic.GameLoop;
import org.junit.Test;
import static org.junit.Assert.*;

public class Enemy2Test {
    private GameLoop gameLoop;
    private GameLogic gameLogic;
    private Enemy2 enemy2;

    public Enemy2Test() {
        gameLoop = new GameLoop();
        gameLogic = gameLoop.getGameLogic();
        enemy2 = new Enemy2(100, 100, gameLogic);
    }
    
    @Test
    public void reducingHealthByOneWorks() {
        assertTrue(enemy2.getHealth() == 2);
        enemy2.reduceHealth();
        assertTrue(enemy2.getHealth() == 1);
        assertTrue(enemy2.isAlive());
    }
    
    @Test
    public void reducingHealthByTwoKills() {
        enemy2.reduceHealth();
        enemy2.reduceHealth();
        assertTrue(!enemy2.isAlive());
    }
    
    @Test
    public void reducingHealthWhenBulletHits() {
        enemy2.reduceHealthWhenBulletHits(new Bullet(105, 105, Direction.DOWN));
        assertTrue(enemy2.getHealth() == 1);
    }
    
    @Test
    public void healthNotReducedIfHitWithNonBullet() {
        enemy2.reduceHealthWhenBulletHits(new Enemy1(105, 105, gameLogic));
        assertTrue(enemy2.getHealth() == 2);
    }
    
    
    
    
}
