package com.awesome.supercaveadventure.entity.player;

import com.awesome.supercaveadventure.entity.abstracts.Entity;
import com.awesome.supercaveadventure.graphics.enums.DrawDepth;
import com.awesome.userinput.PlayerKeyListener;
import java.awt.Graphics;

/**
 *
 * 
 */
public class PlayerCharacter extends Entity{
    private int x;
    private int y;
    private int width;
    private int height;
    private double speed;
    

    public PlayerCharacter(int x, int y) {
        this.x = x;
        this.y = y;
        width = 40;
        height = 40;
        speed = 4;
    }
    
    //THIS IS NOT FINAL
    public void move(double delta, PlayerKeyListener keyListener) {
        if(keyListener.isDown()) {
            y += delta * speed;
        }
        else if(keyListener.isUp()) {
            y -= delta * speed;
        }
        else if(keyListener.isLeft()) {
            x -= delta * speed;
        }
        else if(keyListener.isRight()) {
            x += delta * speed;
        }
    }
    
    //I will most likely create a Sprite-class to handle this.
    @Override
    public void draw(Graphics graphics) {
        graphics.fillRect(x, y, width, height);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
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

    @Override
    public DrawDepth getDrawDepth() {
        return null;
    }
}
