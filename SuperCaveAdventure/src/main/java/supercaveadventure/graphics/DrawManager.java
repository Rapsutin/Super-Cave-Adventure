

package supercaveadventure.graphics;

import supercaveadventure.entities.Entity;
import supercaveadventure.rooms.Room;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.SwingUtilities;



/**
 * Controls what is drawn to the DrawPanel.
 */
public class DrawManager {
    private DrawPanel drawPanel;
    private GameFrame gameFrame;
    private ArrayList<Drawable> drawables;

    public DrawManager() {
        
        
        gameFrame = new GameFrame();
        drawPanel = gameFrame.getDrawPanel();
        drawables = drawPanel.getDrawables();
        
        SwingUtilities.invokeLater(gameFrame);
        
    }
    
    

    /**
     * Updates the list of things to draw.
     */
    public void updateDrawables(ArrayList<Entity> entities, Room currentRoom) {
        drawables = new ArrayList<>(entities.size());
        drawables.addAll(entities);
        drawables.add(currentRoom);
        Collections.sort(drawables, new DrawDepthComparator());
        drawPanel.setDrawables(drawables);
    }
    
    
    public void updateDrawPanel() {
        drawPanel.repaint();
    }

    public DrawPanel getDrawPanel() {
        return drawPanel;
    }

    public GameFrame getGameFrame() {
        return gameFrame;
    }

    
    
    
    

}
