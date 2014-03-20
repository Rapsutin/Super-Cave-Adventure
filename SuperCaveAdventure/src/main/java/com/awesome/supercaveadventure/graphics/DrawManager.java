/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.awesome.supercaveadventure.graphics;

import com.awesome.supercaveadventure.entity.abstracts.Entity;
import com.awesome.supercaveadventure.graphics.interfaces.Drawable;
import java.util.ArrayList;
import javax.swing.SwingUtilities;




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
    public void updateDrawables(ArrayList<Entity> entities) {
        drawables = new ArrayList<>(entities.size());
        for (Entity e : entities) {
            drawables.add(e);
        }
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
