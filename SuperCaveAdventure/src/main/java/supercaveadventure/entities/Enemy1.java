

package supercaveadventure.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;
import supercaveadventure.graphics.DrawDepth;
import supercaveadventure.graphics.sprites.Enemy1Sprite;
import supercaveadventure.graphics.sprites.Sprite;
import supercaveadventure.logic.GameLogic;

/**
 * An enemy that dies when a bullet hits it.
 */
public class Enemy1 extends Entity implements MovableEntity, Mortal{
    
    private boolean alive;
    private Direction currentDirection;
    private PlayerCharacter playerCharacter;
    private Sprite enemy1Sprite;

    public Enemy1(double x, double y, GameLogic gameLogic) {
        super(x, y);
        width = 30;
        height = 30;
        currentDirection = Direction.getRandomDirection();
        alive = true;
        playerCharacter = gameLogic.getPlayerCharacter();
        enemy1Sprite = new Enemy1Sprite(this);
    }

    @Override
    public void onOverlap(Entity collidingEntity) {
        killCollidingPlayerCharacter(collidingEntity);
        dieIfBulletHits(collidingEntity);
    }

    protected void dieIfBulletHits(Entity collidingEntity) {
        if(collidingEntity instanceof Bullet) {
            setAlive(false);
        }
    }

    protected void killCollidingPlayerCharacter(Entity collidingEntity) {
        if(collidingEntity instanceof PlayerCharacter) {
            Mortal killedPlayer = (Mortal) collidingEntity;
            killedPlayer.setAlive(false);
        }
    }
    

    @Override
    public void draw(Graphics2D graphics) {
        enemy1Sprite.draw(graphics);
    }

    @Override
    public DrawDepth getDrawDepth() {
        return DrawDepth.ENEMY;
    }
    
    /**
     * Moves the enemy1 randomly.
     * @param delta Time-dependent scalar
     */
    @Override
    public void move(double delta) {
        
        Random r = new Random();
        int movementOrder = r.nextInt(100);
        
        if(movementOrder < 90) {
            moveToCurrentDirection(delta);
        } else {
            setCurrentDirection(getRandomDirectionTowardsPlayer());
            moveToCurrentDirection(delta);
        } 
        changeDirectionIfBorderIsHit();        
        checkBorders();
    }
    
    /**
     * Chooses a random orientation when a border is hit.
     */
    private void changeDirectionIfBorderIsHit() {
        if(overlapsBorder()) {
            setCurrentDirection(Direction.getRandomDirection());
        }
    }
    
    /**
     * Calculates a random direction that gets
     * enemy1 closer to the player.
     * @return A direction towards the player.
     */
    private Direction getRandomDirectionTowardsPlayer() {
        ArrayList<Direction> possibleDirections = getAllDirectionsTowardsPlayer();
        return getRandomDirectionFromList(possibleDirections);
    }
    
    /**
     * Returns all the directions that could be used
     * to get closer to the player.
     * @return The directions.
     */
    public ArrayList<Direction> getAllDirectionsTowardsPlayer() {
        ArrayList<Direction> possibleDirections = new ArrayList<>();
        if(playerCharacter.getX() < this.x) {
            possibleDirections.add(Direction.LEFT);
        } else {
            possibleDirections.add(Direction.RIGHT);
        }
        
        if(playerCharacter.getY() < this.y) {
            possibleDirections.add(Direction.UP);
        } else {
            possibleDirections.add(Direction.DOWN);
        }
        return possibleDirections;
    }
    
    /**
     * Returns a random direction from the given list.
     * @param directions List of directions.
     * @return A random direction.
     */
    private Direction getRandomDirectionFromList(ArrayList<Direction> directions) {
        Random r = new Random();
        int index = r.nextInt(directions.size());
        return directions.get(index);
    }
    
    /**
     * Moves enemy1 to the direction it is currently facing.
     * @param delta Time-dependent scalar.
     */
    public void moveToCurrentDirection(double delta) {
        double speed = 3;
        double distance = speed * delta;
        
        if(currentDirection == Direction.LEFT) {
            x -= distance;
        } else if(currentDirection == Direction.RIGHT) {
            x += distance;
        } else if(currentDirection == Direction.DOWN) {
            y += distance;
        } else {
            y -= distance;
        }
        
    }
    
    @Override
    public boolean isAlive() {
        return alive;
    }

    @Override
    public void setAlive(boolean isAlive) {
        alive = isAlive;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }
    
    

}
