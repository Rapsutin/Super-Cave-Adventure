package supercaveadventure.entities;

import supercaveadventure.graphics.ImageLoader;
import supercaveadventure.graphics.DrawDepth;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * The character controlled by the player.
 */
public class PlayerCharacter extends Entity implements Mortal{
    
    private double speed;
    private boolean alive;
    private BufferedImage upOrientationImage;
    private BufferedImage downOrientationImage;
    private BufferedImage leftOrientationImage;
    private BufferedImage rightOrientationImage;
    private BufferedImage usedImage; //Which image should be drawn
    

    public PlayerCharacter(int x, int y) {
        super(x, y);
        alive = true;
        width = 50;
        height = 50;
        speed = 4;
        setupSprites();
    }
    
     private void setupSprites() {
        upOrientationImage = ImageLoader.loadImage("resources/dudeUP.png");
        downOrientationImage = ImageLoader.loadImage("resources/dudeDOWN.png");
        rightOrientationImage = ImageLoader.loadImage("resources/dudeRIGHT.png");
        leftOrientationImage = ImageLoader.loadImage("resources/dudeLEFT.png");
        usedImage = rightOrientationImage;
    }
    
    /**
     * Moves the PlayerCharacter-object while checking
     * that it is inside the game borders.
     * @param dx Movement to the right in pixels
     * @param dy Movement down in pixels
     */
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
        
        graphics.drawImage(usedImage, (int)x, (int)y, null);
        
    }

    
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getSpeed() {
        return speed;
    }

    @Override
    public DrawDepth getDrawDepth() {
        return DrawDepth.PLAYER;
    }

    public BufferedImage getUsedImage() {
        return usedImage;
    }

    public BufferedImage getDownOrientationImage() {
        return downOrientationImage;
    }

    public BufferedImage getLeftOrientationImage() {
        return leftOrientationImage;
    }

    public BufferedImage getRightOrientationImage() {
        return rightOrientationImage;
    }

    public BufferedImage getUpOrientationImage() {
        return upOrientationImage;
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    @Override
    public void setAlive(boolean isAlive) {
        alive = isAlive;
    }
    

}