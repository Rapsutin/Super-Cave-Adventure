/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package supercaveadventure.graphics.sprites;

import java.awt.Graphics2D;
import supercaveadventure.graphics.Drawable;

public abstract class Sprite {
    
    private Drawable drawableObject;

    public Sprite(Drawable drawableObject) {
        this.drawableObject = drawableObject;
    }
    
    public abstract void draw(Graphics2D graphics);
}
