package supercaveadventure.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import supercaveadventure.graphics.DrawDepth;
import supercaveadventure.graphics.sprites.BulletSprite;
import supercaveadventure.graphics.sprites.Sprite;

public class Bullet extends Entity implements Mortal, MovableEntity {

    private boolean alive;
    private Direction movementDirection;
    private Sprite bulletSprite;

    public Bullet(double x, double y, Direction movementDirection) {
        super(x, y);
        width = 5;
        height = 5;
        setAlive(true);
        this.movementDirection = movementDirection;
        bulletSprite = new BulletSprite(this);
    }

    @Override
    public void move(double delta) {
        double distance = calculateMovementDistance(delta);
        moveToCurrentDirection(distance);
        killIfHitsBorder();
    }

    /**
     * Calculates the distance the bullet should be moved.
     *
     * @param delta Time-dependent constant.
     * @return Distance in pixels.
     */
    private double calculateMovementDistance(double delta) {
        int speed = 6;
        double distance = speed * delta;
        return distance;
    }
    
    /**
     * Moves the bullet to the direction it is facing.
     * @param distance The distance the bullet will be moved.
     */
    private void moveToCurrentDirection(double distance) {
        if (movementDirection == Direction.DOWN) {
            y += distance;
        } else if (movementDirection == Direction.UP) {
            y -= distance;
        } else if (movementDirection == Direction.LEFT) {
            x -= distance;
        } else if (movementDirection == Direction.RIGHT) {
            x += distance;
        }
    }
    
    /**
     * Checks if the bullet hits a border and 
     * destroys it if it does.
     */
    private void killIfHitsBorder() {
        if (overlapsBorder()) {
            setAlive(false);
        }
    }

    @Override
    public void onOverlap(Entity collidingEntity) {
        if (collidingEntity instanceof Staircase) {
            return;
        }
        setAlive(false);
    }

    @Override
    public void draw(Graphics2D graphics) {
        bulletSprite.draw(graphics);
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

}
