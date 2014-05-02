/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package supercaveadventure.graphics.sprites;

import java.awt.Font;
import java.awt.Graphics2D;
import supercaveadventure.rooms.Room;


public class Room03Sprite extends Sprite{
    
    private Room room03;
    
    public Room03Sprite(Room room03) {
        this.room03 = room03;
    }
    
    @Override
    public void draw(Graphics2D graphics) {
        if(room03.getWinConditionMet()) {
            graphics.setFont(new Font("Arial", Font.BOLD, 30));
            graphics.drawString("YOU WON! Now grade my work 5/5 :)", 35, 60);
            graphics.drawString("Menu", 460, 335);
        }
    }
    
}
