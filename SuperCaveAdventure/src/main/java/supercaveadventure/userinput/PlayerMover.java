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
    public void controlPlayerCharacter(double delta) {
        movePlayerCharacter(delta);
        makePlayerCharacterShoot();
    }

    public void movePlayerCharacter(double delta) {
        double movementDistance = delta * playerCharacter.getSpeed();
        
        if (playerKeyListener.isDown()) {
            playerCharacter.move(0, movementDistance);
        } else if (playerKeyListener.isUp()) {
            playerCharacter.move(0, -movementDistance);
        } else if (playerKeyListener.isLeft()) {
            playerCharacter.move(-movementDistance, 0);
        } else if (playerKeyListener.isRight()) {
            playerCharacter.move(movementDistance, 0);
        }
    }
    
    public void makePlayerCharacterShoot() {
        if(playerKeyListener.isSpacebar()) {
            playerCharacter.shoot();
        }
    }
}
