
package supercaveadventure.entities;

/**
 * A non-PlayerCharacter entity that
 * can move.
 */
public interface MovableEntity {
    
    /**
     * Moves the entity.
     * @param delta Time-dependent scalar.
     */
    public void move(double delta);
}
