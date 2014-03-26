/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.awesome.supercaveadventure.entity.roomentities;

import com.awesome.supercaveadventure.entity.abstracts.Entity;
import com.awesome.supercaveadventure.entity.player.PlayerCharacter;
import com.awesome.supercaveadventure.graphics.enums.DrawDepth;
import com.awesome.supercaveadventure.logic.GameLogic;
import com.awesome.supercaveadventure.rooms.abstracts.Room;
import java.awt.Graphics2D;


public class Door extends Entity {

    private int x;
    private int y;
    private int height;
    private int width;
    private Room nextRoom;
    private GameLogic gameLogic;

    public Door(int x, int y, int height, int width, Room nextRoom, GameLogic gameLogic) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.nextRoom = nextRoom;
        this.gameLogic = gameLogic;
    }

    @Override
    public void onOverlap(Entity collidingEntity) {
        if(collidingEntity.getClass() == PlayerCharacter.class) {
            gameLogic.changeCurrentRoom(nextRoom);
        }
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.fillRect(x, y, width, height);
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
