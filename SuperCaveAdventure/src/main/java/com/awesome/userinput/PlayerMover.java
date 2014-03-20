/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.awesome.userinput;

import com.awesome.supercaveadventure.entity.player.PlayerCharacter;


public class PlayerMover {
    private PlayerCharacter playerCharacter;
    private PlayerKeyListener playerKeyListener;

    public PlayerMover(PlayerCharacter playerCharacter, PlayerKeyListener playerKeyListener) {
        this.playerCharacter = playerCharacter;
        this.playerKeyListener = playerKeyListener;
    }
    
    public void movePlayer(double delta) {
        if(playerKeyListener.isDown()) {
            playerCharacter.move(0, delta * playerCharacter.getSpeed());
        }
        else if(playerKeyListener.isUp()) {
            playerCharacter.move(0, -delta * playerCharacter.getSpeed());
        }
        else if(playerKeyListener.isLeft()) {
            playerCharacter.move(-delta * playerCharacter.getSpeed(), 0);
        }
        else if(playerKeyListener.isRight()) {
            playerCharacter.move(delta * playerCharacter.getSpeed(), 0);
        }
    }
    
}
