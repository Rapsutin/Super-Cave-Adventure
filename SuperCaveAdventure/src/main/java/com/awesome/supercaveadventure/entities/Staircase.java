
package com.awesome.supercaveadventure.entities;

import com.awesome.supercaveadventure.entities.Entity;
import com.awesome.supercaveadventure.entities.PlayerCharacter;
import com.awesome.supercaveadventure.graphics.ImageLoader;
import com.awesome.supercaveadventure.graphics.DrawDepth;
import com.awesome.supercaveadventure.logic.GameLogic;
import com.awesome.supercaveadventure.rooms.Room;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * When the PlayerCharacter walks into this, 
 * the current room is changed to another.
 */
public class Staircase extends Entity {

    private int x;
    private int y;
    private int height;
    private int width;
    private Room nextRoom;
    private GameLogic gameLogic;
    private BufferedImage img;
    

    public Staircase(int x, int y, Room nextRoom, GameLogic gameLogic) {
        this.x = x;
        this.y = y;
        this.height = 50;
        this.width = 50;
        this.nextRoom = nextRoom;
        this.gameLogic = gameLogic;
        img = ImageLoader.loadImage("resources/staircaseDoor.png");
    }

    @Override
    public void onOverlap(Entity collidingEntity) {
        
        if(collidingEntity.getClass() == PlayerCharacter.class) {
            gameLogic.changeCurrentRoom(nextRoom);
        }
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.drawImage(img, x, y, null);
    }

    @Override
    public DrawDepth getDrawDepth() {
        return DrawDepth.DOOR;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    
}
