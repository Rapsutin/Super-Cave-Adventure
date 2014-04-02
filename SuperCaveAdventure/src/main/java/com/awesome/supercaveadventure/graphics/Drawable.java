
package com.awesome.supercaveadventure.graphics;

import java.awt.Graphics2D;

/**
 * Any object that can be drawn on DrawPanel.
 */
public interface Drawable {

    /**
     * Draws the object onto the
     * screen.
     * @param graphics The object will be drawn on this.
     */
    public void draw(Graphics2D graphics);
    public DrawDepth getDrawDepth();
    
    
    
}
