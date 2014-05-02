/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package supercaveadventure.entities;

/**
 *
 * @author Juho
 */
public interface MovableEntity {
    
    /**
     * Moves the entity.
     * @param delta Time-dependent scalar.
     */
    public void move(double delta);
}
