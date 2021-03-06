
package supercaveadventure.userinput;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Tells which keys are pressed right now and which aren't.
 */
public class PlayerKeyListener implements KeyListener{
    
    private KeyEvent keyEvent;
    private boolean left;
    private boolean right;
    private boolean down;
    private boolean up;
    private boolean spacebar;

    public PlayerKeyListener() {
        left = false;
        right = false;
        down = false;
        up = false;
        spacebar = false;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        updateKey(e, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        updateKey(e, false);
    }
    
    
    private void updateKey(KeyEvent e, boolean wasItPressed) {
        Integer keyCode = e.getKeyCode();
        switch(keyCode) {
            case KeyEvent.VK_LEFT:
                left = wasItPressed;
                break;
            case KeyEvent.VK_RIGHT:
                right = wasItPressed;
                break;
            case KeyEvent.VK_DOWN:
                down = wasItPressed;
                break;
            case KeyEvent.VK_UP:
                up = wasItPressed;
                break;
            case KeyEvent.VK_SPACE:
                spacebar = wasItPressed;
                break;
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    public boolean isDown() {
        return down;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isUp() {
        return up;
    }

    public boolean isSpacebar() {
        return spacebar;
    }
    
    
    
    public KeyEvent getKeyEvent() {
        return keyEvent;
    }
    
    
}
