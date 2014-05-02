/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package supercaveadventure.graphics.sprites;

import java.awt.Font;
import java.awt.Graphics2D;
import supercaveadventure.rooms.Room;


public class Room00Sprite extends Sprite{
    
    private Room room00;
    
    public Room00Sprite(Room room00) {
        this.room00 = room00;
    }
    
    @Override
    public void draw(Graphics2D graphics) {
        graphics.setFont(new Font("Arial", Font.BOLD, 30));
        
        graphics.drawString("Use the arrow keys to move and spacebar to shoot.", 35, 60);
        
        graphics.drawString("Start", 360, 215);
        graphics.drawString("Exit", 360, 315);
    }
    
}
