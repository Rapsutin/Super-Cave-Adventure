package supercaveadventure;


import javax.swing.SwingUtilities;
import supercaveadventure.graphics.GameFrame;
import supercaveadventure.logic.GameLoop;


/**
 * Starts the game.
 */
public class SuperCaveAdventure {
    public static void main( String[] args ) {
 
        new GameLoop().run();
    }
}
