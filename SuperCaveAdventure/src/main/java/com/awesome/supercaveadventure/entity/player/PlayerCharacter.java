package com.awesome.supercaveadventure.entity.player;

import com.awesome.supercaveadventure.entity.abstracts.Entity;
import com.awesome.supercaveadventure.graphics.ImageLoader;
import com.awesome.supercaveadventure.graphics.enums.DrawDepth;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

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
    private BufferedImage upOrientationImage;
    private BufferedImage downOrientationImage;
    private BufferedImage leftOrientationImage;
    private BufferedImage rightOrientationImage;
    private BufferedImage usedImage; //Which image should be drawn
    

    public PlayerCharacter(int x, int y) {
        this.x = x;
        this.y = y;
        width = 50;
        height = 50;
        speed = 4;
        upOrientationImage = ImageLoader.loadImage("resources/dudeUP.png");
        downOrientationImage = ImageLoader.loadImage("resources/dudeDOWN.png");
        rightOrientationImage = ImageLoader.loadImage("resources/dudeRIGHT.png");
        leftOrientationImage = ImageLoader.loadImage("resources/dudeLEFT.png");
        usedImage = rightOrientationImage;
    }
    
    public void loadImage() {
        
    }
    
    
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
        checkBorders();
        changeOrientationImage(dx, dy);
    }
    
    
    
    private void changeOrientationImage(double dx, double dy) {
        if(dx > 0) {
            usedImage = rightOrientationImage;
        } else if(dx < 0) {
            usedImage = leftOrientationImage;
        } else if(dy > 0) {
            usedImage = downOrientationImage;
        } else if(dy < 0) {
            usedImage = upOrientationImage;
        }
    }
    
    private void checkBorders() {
        int maximumX = 790;
        int maximumY = 438;
        int minimumX = 11;
        int minimumY = 11;
        
        if(x + width > maximumX) {
            x = maximumX - width;
        }
        if(y + height > maximumY) {
            y = maximumY - height;
        }
        if(x < minimumX) {
            x = minimumX;
        }
        if(y < minimumY) {
            y = minimumY;
        }
    }
    
    @Override
    public void onOverlap(Entity collidingEntity) {
        
    }
    
    
    @Override
    public void draw(Graphics2D graphics) {
        
        graphics.drawImage(usedImage, x, y, null);
        
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

    public double getSpeed() {
        return speed;
    }
    
    

    @Override
    public DrawDepth getDrawDepth() {
        return DrawDepth.PLAYER;
    }

    

    

}
