/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.awesome.graphics;

import com.awesome.supercaveadventure.entity.abstracts.Entity;
import com.awesome.supercaveadventure.entity.player.PlayerCharacter;
import com.awesome.supercaveadventure.graphics.DrawManager;
import com.awesome.supercaveadventure.graphics.DrawPanel;
import com.awesome.supercaveadventure.graphics.interfaces.Drawable;
import com.awesome.supercaveadventure.logic.GameLogic;
import com.awesome.supercaveadventure.logic.GameLoop;
import com.awesome.testobjects.TestRoom;
import java.util.ArrayList;
import org.junit.Before;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juho
 */
public class DrawManagerTest {
    
    private DrawManager drawManager; 
    private GameLogic gameLogic;
    private TestRoom testRoom;
    
    @Before
    public void setUp() {
        GameLoop gameLoop = new GameLoop();
        drawManager = gameLoop.getDrawManager();
        gameLogic = gameLoop.getGameLogic();
        testRoom = new TestRoom();
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
        
        DrawPanel drawPanel = drawManager.getDrawPanel();
        ArrayList<Drawable> drawables = drawPanel.getDrawables();
        
        assertEquals(numberOfAddedEntites + 1, drawables.size());
    }
    

    public void addDrawablesIntoTestRoom(int numberOfDrawables) {
        for (int i = 0; i < numberOfDrawables; i++) {
            testRoom.addEntity(new PlayerCharacter(400, 100));
        }
        gameLogic.changeCurrentRoom(testRoom);
        drawManager.updateDrawables(gameLogic.getEntities());
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
        ArrayList<Entity> entities = gameLogic.getEntities();
        
        for (int i = 0; i < toBeRemoved; i++) {
            int lastEntityIndexInList = entities.size() - 1;
            Entity lastEntityInList = entities.get(lastEntityIndexInList);
            gameLogic.removeEntity(lastEntityInList);
        }
        drawManager.updateDrawables(entities);
        
        DrawPanel drawPanel = drawManager.getDrawPanel();
        ArrayList<Drawable> drawables = drawPanel.getDrawables();
        
        assertEquals(startingEntities + 1 - toBeRemoved, drawables.size());
    }
}