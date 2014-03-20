
package com.awesome.supercaveadventure.rooms;

import com.awesome.supercaveadventure.entity.abstracts.Entity;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * This is here for testing purposes only. Will be removed in the final release.
 */
public class StartRoom extends Room{
    private ArrayList<Entity> entities;
    private int playerStartXPos;
    private int playerStartYPos;

    public StartRoom() {
        entities = new ArrayList<>();
        playerStartXPos = 40;
        playerStartYPos = 40;
    }
    
    @Override
    public void draw(Graphics graphics) {
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
