package supercaveadventure.entities;

import supercaveadventure.graphics.DrawDepth;
import supercaveadventure.logic.GameLogic;
import java.awt.Graphics2D;
import supercaveadventure.graphics.sprites.PlayerCharacterSprite;

/**
 * The character controlled by the player.
 */
public class PlayerCharacter extends Entity implements Mortal{
    
    private double lastShotTime;
    private double speed;
    private boolean alive;
    private Direction orientation;
    private PlayerCharacterSprite sprite;
    private GameLogic gameLogic;
    

    public PlayerCharacter(int x, int y, GameLogic gameLogic) {
        super(x, y);
        lastShotTime = 0;
        alive = true;
        width = 50;
        height = 50;
        speed = 4;
        orientation = Direction.RIGHT;
        sprite = new PlayerCharacterSprite(this);
        this.gameLogic = gameLogic;
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
        changeOrientation(dx, dy);
       
    }
    
    private void changeOrientation(double dx, double dy) {
        if(dx > 0) {
            orientation = Direction.RIGHT;
        } else if(dx < 0) {
            orientation = Direction.LEFT;
        } else if(dy > 0) {
            orientation = Direction.DOWN;
        } else if(dy < 0) {
            orientation = Direction.UP;
        }
    }
    
    public void shoot() {
        double shotAttemptTime = System.currentTimeMillis();
        
        if(shotAttemptTime - lastShotTime < 750) {
            return;
        }
        
        lastShotTime = shotAttemptTime;
        
        if(orientation == Direction.RIGHT) {
            
            gameLogic.addEntity(new Bullet(x+50, y+45, orientation));
            
        } else if(orientation == Direction.LEFT){
            
            gameLogic.addEntity(new Bullet(x-7, y, orientation));
            
        } else if(orientation == Direction.DOWN) {
            
            gameLogic.addEntity(new Bullet(x+3, y+50, orientation));
            
        } else {
            
            gameLogic.addEntity(new Bullet(x+45, y-5, orientation));
            
        }
        
        
    }
    
    public double getRotatedVectorX(double vectorX, double vectorY, double rotation) {
        return Math.cos(rotation)*vectorX - Math.sin(rotation)*vectorY;
    }
    public double getRotatedVectorY(double vectorX, double vectorY, double rotation) {
        return Math.sin(rotation)*vectorX + Math.cos(rotation)*vectorY;
    }
    
   
    @Override
    public void onOverlap(Entity collidingEntity) {
        
    }
    
    @Override
    public void draw(Graphics2D graphics) {
        sprite.draw(graphics);
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

    public Direction getOrientation() {
        return orientation;
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
