

package com.awesome.supercaveadventure.graphics;

import com.awesome.supercaveadventure.entity.abstracts.Entity;
import com.awesome.supercaveadventure.graphics.interfaces.Drawable;
import com.awesome.supercaveadventure.rooms.abstracts.Room;
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
        drawables = new ArrayList<>();
        drawPanel = new DrawPanel(drawables);
        gameFrame = new GameFrame(drawPanel);
        SwingUtilities.invokeLater(gameFrame);
    }

    /**
     * Updates the list of things to draw.
     */
    public void updateDrawables(ArrayList<Entity> entities, Room currentRoom) {
        drawables = new ArrayList<>(entities.size());
        for (Entity e : entities) {
            drawables.add(e);
        }
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
