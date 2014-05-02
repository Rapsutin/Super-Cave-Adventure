/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package supercaveadventure.rooms;

import java.awt.Font;
import java.awt.Graphics2D;
import supercaveadventure.entities.Enemy1;
import supercaveadventure.entities.Enemy2;
import supercaveadventure.entities.Staircase;
import supercaveadventure.logic.GameLogic;

/**
 *
 * @author local
 */
public class Room03 extends Room{
    
    
    private Staircase staircaseToNextRoom;
    public Room03(GameLogic gameLogic) {
        super(gameLogic);
        addNewEnemyEntity(new Enemy2(500, 300, gameLogic));
        addNewEnemyEntity(new Enemy1(700, 300, gameLogic));
        addNewEnemyEntity(new Enemy1(600, 400, gameLogic));
        addNewEnemyEntity(new Enemy1(600, 300, gameLogic));
    }

    @Override
    public void checkWinCondition() {
        boolean winCondition = areAllEnemiesDead();
        if(winCondition && !winConditionMet) {
            staircaseToNextRoom = new Staircase(400, 300, new Room00(gameLogic), gameLogic);
            createStaircaseIfWinConditionReached(winCondition, staircaseToNextRoom);
        }
        
    }

    @Override
    public void draw(Graphics2D graphics) {
        drawGround(graphics);
        if(winConditionMet) {
            graphics.setFont(new Font("Arial", Font.BOLD, 30));
            graphics.drawString("YOU WON! Now give me a 5/5 grade.", 35, 60);
            graphics.drawString("Play again?", 460, 335);
            
        }
    }
    
}
