/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.awesome.supercaveadventure.rooms;

import com.awesome.supercaveadventure.entity.abstracts.Entity;
import com.awesome.supercaveadventure.entity.player.PlayerCharacter;
import java.awt.Graphics;
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
        entities.add(new PlayerCharacter(200, 200));
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
