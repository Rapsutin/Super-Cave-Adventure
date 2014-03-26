/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.awesome.supercaveadventure.rooms;

import com.awesome.supercaveadventure.entity.abstracts.Entity;
import com.awesome.supercaveadventure.graphics.ImageLoader;
import com.awesome.supercaveadventure.graphics.enums.DrawDepth;
import com.awesome.supercaveadventure.rooms.abstracts.Room;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Room01 extends Room{
    
    private ArrayList<Entity> entities;
    private int playerStartXPos;
    private int playerStartYPos;
    private BufferedImage ground;

    public Room01() {
        entities = new ArrayList<>();
        ground = ImageLoader.loadImage("resources/ground.png");
        playerStartXPos = 100;
        playerStartYPos = 180;
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

    @Override
    public void draw(Graphics2D graphics) {
        graphics.drawImage(ground, 0, 0, null);
    }

    @Override
    public DrawDepth getDrawDepth() {
        return DrawDepth.ROOM;
    }

}
