
package supercaveadventure.entities;

/**
 * Entities implementing Mortal can die.
 */
public interface Mortal {
    public boolean isAlive();
    public void setAlive(boolean isAlive);
}
