/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package supercaveadventure.entities;


import supercaveadventure.entities.PlayerCharacter;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author Juho
 */
public class PlayerCharacterTest {
    private PlayerCharacter playerCharacter;
    
    
    public PlayerCharacterTest() {
        playerCharacter = new PlayerCharacter(100, 100);
    }
    
    public void isPlayerAtPosition(int x, int y) {
        assertTrue(playerCharacter.getX() == x);
        assertTrue(playerCharacter.getY() == y);
    }
    
    @Test
    public void playerMovesRight() {
        playerCharacter.move(50, 0);
        isPlayerAtPosition(150, 100);
    }
    
    @Test
    public void playerMovesDown() {
        playerCharacter.move(0, 50);
        isPlayerAtPosition(100, 150);
    }
    
    @Test
    public void playerMovesLeft() {
        playerCharacter.move(-50, 0);
        isPlayerAtPosition(50, 100);
    }
    
    @Test
    public void playerMovesUp() {
        playerCharacter.move(0, -50);
        isPlayerAtPosition(100, 50);
    }
    
    
    
    @Test
    public void playerShouldNotGoOverBorders() {
        playerCharacter.move(5000, 0);
        assertTrue(playerCharacter.getX() != 5100);
        playerCharacter.move(0, 5000);
        assertTrue(playerCharacter.getY() != 5100);
        playerCharacter.move(-10000, 0);
        assertTrue(playerCharacter.getX() >= 11);
        playerCharacter.move(0, -10000);
        assertTrue(playerCharacter.getY() >= 11);
        
    }
    
    @Test
    public void playerOrientationSpriteShouldBeCorrect() {
       
        playerCharacter.move(50, 0);
        assertEquals(playerCharacter.getRightOrientationImage(), playerCharacter.getUsedImage());
        playerCharacter.move(0, 50);
        assertEquals(playerCharacter.getDownOrientationImage(), playerCharacter.getUsedImage());
        playerCharacter.move(-50, 0);
        assertEquals(playerCharacter.getLeftOrientationImage(), playerCharacter.getUsedImage());
        playerCharacter.move(0, -50);
        assertEquals(playerCharacter.getUpOrientationImage(), playerCharacter.getUsedImage());
    }
   
}