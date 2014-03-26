
package com.awesome.supercaveadventure.graphics.interfaces;

import com.awesome.supercaveadventure.graphics.enums.DrawDepth;
import java.awt.Graphics2D;

/**
 *
 * @author Juho
 */
public interface Drawable {

    
    public void draw(Graphics2D graphics);
    public DrawDepth getDrawDepth();
    
    
    
}
