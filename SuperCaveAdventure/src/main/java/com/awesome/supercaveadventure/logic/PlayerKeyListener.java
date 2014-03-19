
package com.awesome.supercaveadventure.logic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Juho
 */
public class PlayerKeyListener implements KeyListener{
    
    private KeyEvent keyEvent;
    private boolean left;
    private boolean right;
    private boolean down;
    private boolean up;

    public PlayerKeyListener() {
        left = false;
        right = false;
        down = false;
        up = false;
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
    
    public KeyEvent getKeyEvent() {
        return keyEvent;
    }
    
    
}
