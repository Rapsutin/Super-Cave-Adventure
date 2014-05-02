/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package supercaveadventure.entities;

import supercaveadventure.logic.GameLogic;
import supercaveadventure.logic.GameLoop;
import supercaveadventure.testobjects.TestRoom;
import org.junit.Test;
import static org.junit.Assert.*;
import supercaveadventure.rooms.Room;

/**
 *
 * @author Juho
 */
public class StaircaseTest {

    private GameLoop gameLoop;
    private GameLogic gameLogic;
    private TestRoom nextRoom;
    private Staircase staircase;

    public StaircaseTest() {
        gameLoop = new GameLoop();
        gameLogic = gameLoop.getGameLogic();
        nextRoom = new TestRoom(gameLogic);
        staircase = new Staircase(30, 30, nextRoom, gameLogic);
    }

    @Test
    public void aCollisionWithThePlayerShouldChangeTheRoom() {
        Room currentRoom = gameLogic.getCurrentRoom();
        staircase.onOverlap(new PlayerCharacter(0, 0, gameLogic));
        assertNotSame(currentRoom, gameLogic.getCurrentRoom());
    }
}