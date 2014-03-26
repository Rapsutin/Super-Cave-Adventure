
package com.awesome.supercaveadventure.rooms;

import com.awesome.supercaveadventure.rooms.abstracts.Room;
import com.awesome.supercaveadventure.entity.abstracts.Entity;
import com.awesome.supercaveadventure.entity.roomentities.Door;
import com.awesome.supercaveadventure.graphics.ImageLoader;
import com.awesome.supercaveadventure.graphics.enums.DrawDepth;
import com.awesome.supercaveadventure.logic.GameLogic;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * This is here for testing purposes only. Will be removed in the final release.
 */
public class Room00 extends Room{
    private ArrayList<Entity> entities;
    private int playerStartXPos;
    private int playerStartYPos;
    private BufferedImage ground;

    public Room00(GameLogic gameLogic) {
        
        entities = new ArrayList<>();
        playerStartXPos = 100;
        playerStartYPos = 180;
        ground = ImageLoader.loadImage("resources/ground.png");
        entities.add(new Door(300, 180, 100, 70, new Room01(), gameLogic));
    }
    
    
    
    @Override
    public void draw(Graphics2D graphics) {
        graphics.drawImage(ground, 0, 0, null);
        
    }

    @Override
    public DrawDepth getDrawDepth() {
        return DrawDepth.ROOM;
    }

    @Override
    public ArrayList<Entity> getEntities() {
        return entities;
    }

    @Override
    public int getPlayerStartXPos() {
        return playerStartXPos;
    }

    @Override
    public int getPlayerStartYPos() {
        return playerStartYPos;
    }
    
}
