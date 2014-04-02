package supercaveadventure.userinput;

import supercaveadventure.entities.PlayerCharacter;

/**
 * Takes the player input and translates it into
 * movement.
 */
public class PlayerMover {

    private PlayerCharacter playerCharacter;
    private PlayerKeyListener playerKeyListener;
  
    public PlayerMover(PlayerCharacter playerCharacter, PlayerKeyListener playerKeyListener) {
        this.playerCharacter = playerCharacter;
        this.playerKeyListener = playerKeyListener;
        
    }
    
    /**
     * Translates key presses
     * into movement.
     * @param delta A time-dependent scalar
     * that is used to calculate how much
     * the player should be moved to fight
     * against inconsistent fps-rates.
     */
    public void movePlayer(double delta) {

        if (playerKeyListener.isDown()) {
            playerCharacter.move(0, delta * playerCharacter.getSpeed());
        } else if (playerKeyListener.isUp()) {
            playerCharacter.move(0, -delta * playerCharacter.getSpeed());
        } else if (playerKeyListener.isLeft()) {
            playerCharacter.move(-delta * playerCharacter.getSpeed(), 0);
        } else if (playerKeyListener.isRight()) {
            playerCharacter.move(delta * playerCharacter.getSpeed(), 0);
        }
    }
}
