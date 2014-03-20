
package com.awesome.logic;

import com.awesome.supercaveadventure.entity.abstracts.Entity;
import com.awesome.supercaveadventure.entity.player.PlayerCharacter;
import com.awesome.supercaveadventure.graphics.DrawPanel;
import com.awesome.supercaveadventure.graphics.interfaces.Drawable;
import com.awesome.supercaveadventure.logic.GameLoop;
import com.awesome.supercaveadventure.rooms.Room;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import com.awesome.testobjects.TestRoom;

/**
 *
 * @author Juho
 */
public class GameLoopTest {
    
    private GameLoop gameLoop;
    private TestRoom testRoom;
    
    public GameLoopTest() {
    }
    
    
    @Before
    public void setUp() {
        gameLoop = new GameLoop();
        testRoom = new TestRoom();
    }
    
    @After
    public void tearDown() {
    }
    
    
    
    @Test
    public void playerCharacterShouldBeInEntitiesWhenStarting() {
        ArrayList<Entity> entities = gameLoop.getEntities();
        PlayerCharacter playerCharacter = gameLoop.getPlayerCharacter();
        assertTrue(entities.contains(playerCharacter));
    }
    
    @Test
    public void playerCharacterShouldBeTransportedWhileChangingRooms() {
        ArrayList<Entity> entities = gameLoop.getEntities();
        PlayerCharacter playerCharacter = gameLoop.getPlayerCharacter();
        gameLoop.changeCurrentRoom(testRoom);
        assertTrue(entities.contains(playerCharacter));
    }
    
    @Test
    public void changeCurrentRoomShouldChangeTheCurrentRoom() {
        Room previous = gameLoop.getCurrentRoom();
        gameLoop.changeCurrentRoom(new TestRoom());
        assertNotSame(previous, gameLoop.getCurrentRoom());
    }
    
    @Test
    public void oneAddedEntityShouldBeInDrawables() {
        nAddedEntitiesShouldBeInDrawables(1);
    }
    
    @Test
    public void twoAddedEntitiesShouldBeInDrawables() {
        nAddedEntitiesShouldBeInDrawables(2);
    }
    
    @Test
    public void tenAddedEntitiesShouldBeInDrawables() {
        nAddedEntitiesShouldBeInDrawables(10);
    }
    
    public void nAddedEntitiesShouldBeInDrawables(int numberOfAddedEntites) {
        addDrawablesIntoTestRoom(numberOfAddedEntites);
        
        DrawPanel drawPanel = gameLoop.getDrawPanel();
        ArrayList<Drawable> drawables = drawPanel.getDrawables();
        
        assertEquals(numberOfAddedEntites + 1, drawables.size());
    }
    

    public void addDrawablesIntoTestRoom(int numberOfDrawables) {
        for (int i = 0; i < numberOfDrawables; i++) {
            testRoom.addEntity(new PlayerCharacter(400, 100));
        }
        gameLoop.changeCurrentRoom(testRoom);
        gameLoop.updateDrawables();
    }
    
    @Test
    public void removing1EntityRemoves1Drawable() {
        removing_N_entitiesRemoves_N_Drawables(1);
    }
    
    @Test
    public void removing2EntitiesRemoves2Drawables() {
        removing_N_entitiesRemoves_N_Drawables(2);
    }
    
    @Test
    public void removingAllEntitiesRemovesAllDrawables() {
        removing_N_entitiesRemoves_N_Drawables(100);
    }
    
    public void removing_N_entitiesRemoves_N_Drawables(int toBeRemoved) {
        int startingEntities = 100;
        
        addDrawablesIntoTestRoom(startingEntities);
        ArrayList<Entity> entities = gameLoop.getEntities();
        
        for (int i = 0; i < toBeRemoved; i++) {
            entities.remove(startingEntities-i-1);
        }
        gameLoop.updateDrawables();
        
        DrawPanel drawPanel = gameLoop.getDrawPanel();
        ArrayList<Drawable> drawables = drawPanel.getDrawables();
        
        assertEquals(startingEntities + 1 - toBeRemoved, drawables.size());
    }
    
    
}