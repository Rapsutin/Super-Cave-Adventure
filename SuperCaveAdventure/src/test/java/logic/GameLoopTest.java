
package logic;

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
import testobjects.TestRoom;

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
    public void playerCharacter_should_be_in_entities_when_starting() {
        ArrayList<Entity> entities = gameLoop.getEntities();
        PlayerCharacter playerCharacter = gameLoop.getPlayerCharacter();
        assertTrue(entities.contains(playerCharacter));
    }
    
    @Test
    public void playerCharacter_should_be_transported_while_changing_rooms() {
        ArrayList<Entity> entities = gameLoop.getEntities();
        PlayerCharacter playerCharacter = gameLoop.getPlayerCharacter();
        gameLoop.changeCurrentRoom(testRoom);
        assertTrue(entities.contains(playerCharacter));
    }
    
    @Test
    public void changeCurrentRoom_should_change_the_current_room() {
        Room previous = gameLoop.getCurrentRoom();
        gameLoop.changeCurrentRoom(new TestRoom());
        assertNotSame(previous, gameLoop.getCurrentRoom());
    }
    
    @Test
    public void one_added_entity_should_be_in_drawables() {
        n_added_entities_should_be_in_drawables(1);
    }
    
    @Test
    public void two_added_entities_should_be_in_drawables() {
        n_added_entities_should_be_in_drawables(2);
    }
    
    @Test
    public void ten_added_entities_should_be_in_drawables() {
        n_added_entities_should_be_in_drawables(10);
    }
    
    public void n_added_entities_should_be_in_drawables(int numberOfAddedEntites) {
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
    public void removing_1_entity_removes_1_drawable() {
        removing_n_entities_removes_n_drawables(1);
    }
    
    @Test
    public void removing_2_entities_removes_2_drawables() {
        removing_n_entities_removes_n_drawables(2);
    }
    
    @Test
    public void removing_all_entities_removes_all_drawables() {
        removing_n_entities_removes_n_drawables(100);
    }
    
    public void removing_n_entities_removes_n_drawables(int toBeRemoved) {
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