/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package supercaveadventure.graphics;

import supercaveadventure.graphics.Drawable;
import supercaveadventure.entities.Entity;
import supercaveadventure.entities.PlayerCharacter;
import supercaveadventure.graphics.DrawManager;
import supercaveadventure.graphics.DrawPanel;
import supercaveadventure.logic.GameLogic;
import supercaveadventure.logic.GameLoop;
import supercaveadventure.testobjects.TestRoom;
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
        
        assertEquals(numberOfAddedEntites + 2, drawables.size());
    }
    

    public void addDrawablesIntoTestRoom(int numberOfDrawables) {
        for (int i = 0; i < numberOfDrawables; i++) {
            testRoom.addEntity(new PlayerCharacter(400, 100, gameLogic));
        }
        gameLogic.changeCurrentRoom(testRoom);
        drawManager.updateDrawables(gameLogic.getEntities(), gameLogic.getCurrentRoom());
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
        drawManager.updateDrawables(entities, gameLogic.getCurrentRoom());
        
        DrawPanel drawPanel = drawManager.getDrawPanel();
        ArrayList<Drawable> drawables = drawPanel.getDrawables();
        
        assertEquals(startingEntities + 2 - toBeRemoved, drawables.size());
    }
}