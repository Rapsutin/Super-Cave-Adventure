

package supercaveadventure.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import supercaveadventure.graphics.DrawDepth;


public class Bullet extends Entity implements Mortal, MovableEntity{
    private boolean alive;
    private Direction movementDirection;

    public Bullet(double x, double y, Direction movementDirection) {
        super(x, y);
        width = 5;
        height = 5;
        setAlive(true);
        this.movementDirection = movementDirection;
    }
    
    

    @Override
    public void onOverlap(Entity collidingEntity) {
        if(collidingEntity instanceof Staircase) {
            return;
        }
        setAlive(false);
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setPaint(Color.BLACK);
        graphics.fillOval((int)x, (int)y, width, height);
    }

    @Override
    public DrawDepth getDrawDepth() {
        return DrawDepth.BULLET;
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    @Override
    public void setAlive(boolean isAlive) {
        alive = isAlive;
    }

    @Override
    public void move(double delta) {
        int speed = 6;
        double distance = speed * delta;
        if(movementDirection == Direction.DOWN) {
            y += distance;
        } else if(movementDirection == Direction.UP) { 
            y -= distance;
        } else if(movementDirection == Direction.LEFT) {
            x -= distance;
        } else if(movementDirection == Direction.RIGHT) {
            x += distance;
        }
        
        if(overlapsBorder()) {
            setAlive(false);
        }
    }
    
}
