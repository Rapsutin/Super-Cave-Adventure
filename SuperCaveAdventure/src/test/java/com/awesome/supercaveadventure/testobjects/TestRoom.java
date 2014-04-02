
package com.awesome.supercaveadventure.testobjects;

import com.awesome.supercaveadventure.entities.Entity;
import com.awesome.supercaveadventure.graphics.DrawDepth;
import com.awesome.supercaveadventure.rooms.Room;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author Juho
 */
public class TestRoom extends Room{
    private ArrayList<Entity> entities;
    private int playerStartXPos;
    private int playerStartYPos;

    public TestRoom() {
        entities = new ArrayList<>();
        playerStartXPos = 40;
        playerStartYPos = 40;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    @Override
    public void draw(Graphics2D graphics) {
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
    public DrawDepth getDrawDepth() {
        return DrawDepth.ROOM;
    }
}
