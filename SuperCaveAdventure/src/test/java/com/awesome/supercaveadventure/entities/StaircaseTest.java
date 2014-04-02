/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.awesome.supercaveadventure.entities;

import com.awesome.supercaveadventure.entities.Staircase;
import com.awesome.supercaveadventure.entities.PlayerCharacter;
import com.awesome.supercaveadventure.logic.GameLogic;
import com.awesome.supercaveadventure.logic.GameLoop;
import com.awesome.supercaveadventure.rooms.Room;
import com.awesome.supercaveadventure.testobjects.TestRoom;
import org.junit.Test;
import static org.junit.Assert.*;

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
        nextRoom = new TestRoom();
        staircase = new Staircase(30, 30, nextRoom, gameLogic);
    }

    @Test
    public void aCollisionWithThePlayerShouldChangeTheRoom() {
        Room currentRoom = gameLogic.getCurrentRoom();
        staircase.onOverlap(new PlayerCharacter(0, 0));
        assertNotSame(currentRoom, gameLogic.getCurrentRoom());
    }
}