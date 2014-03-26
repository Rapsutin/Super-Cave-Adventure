
package com.awesome.supercaveadventure.graphics;

import com.awesome.supercaveadventure.graphics.interfaces.Drawable;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;



/**
 *
 * @author Juho
 */
public class DrawPanel extends JPanel{
    private ArrayList<Drawable> drawables;
    
    
    public DrawPanel(ArrayList<Drawable> drawables) {
        this.drawables = drawables;
        super.setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        drawAll(graphics);
    }
    
    public void drawAll(Graphics graphics) {
        for(Drawable d : drawables) {
            d.draw((Graphics2D)graphics);
        }
    }
    
    public ArrayList<Drawable> getDrawables() {
        return drawables;
    }

    public void setDrawables(ArrayList<Drawable> drawables) {
        this.drawables = drawables;
    }
    
    
    
}
