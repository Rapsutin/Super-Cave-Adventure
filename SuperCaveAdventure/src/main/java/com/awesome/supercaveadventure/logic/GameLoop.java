
package com.awesome.supercaveadventure.logic;

import com.awesome.supercaveadventure.entity.abstracts.Entity;
import com.awesome.supercaveadventure.entity.player.PlayerCharacter;
import com.awesome.supercaveadventure.graphics.DrawPanel;
import com.awesome.supercaveadventure.graphics.GameFrame;
import com.awesome.supercaveadventure.graphics.interfaces.Drawable;
import com.awesome.supercaveadventure.rooms.Room;
import com.awesome.supercaveadventure.rooms.StartRoom;
import java.util.ArrayList;
import javax.swing.SwingUtilities;




public class GameLoop {
    
    private GameFrame gameFrame;
    private DrawPanel drawPanel;
    private Room currentRoom;
    private ArrayList<Entity> entities;
    private PlayerCharacter playerCharacter;
    
    
    /**
     * Initializes the game & the game loop. Use run() to start the game loop
     */
    public GameLoop() {
        
        playerCharacter = new PlayerCharacter(0, 0);
        createGameUI();
        changeCurrentRoom(new StartRoom());
    }
    
    public void changeCurrentRoom(Room newRoom) {
        currentRoom = newRoom;
        this.entities = currentRoom.getEntities(); 
        entities.add(playerCharacter); 
        playerCharacter.setX(currentRoom.getPlayerStartXPos());
        playerCharacter.setY(currentRoom.getPlayerStartYPos());
    }
    
    private void createGameUI() {
        ArrayList<Drawable> drawables = new ArrayList<>();
        this.drawPanel = new DrawPanel(drawables);
        this.gameFrame = new GameFrame(drawPanel);
        SwingUtilities.invokeLater(gameFrame);
    }
    
    /**
     * Updates the list of things to draw.
     * @return 
     */
    public void updateDrawables() {
        ArrayList<Drawable> drawables = new ArrayList<>(entities.size());
        for (Entity e : entities) {
            drawables.add(e);
        }
        drawPanel.setDrawables(drawables);
    }
    
    /**
     * This runs the game once it has been initialized.
     */
    public void run() {
        long lastLoopTime = System.nanoTime();
        final int TARGET_FPS = 60;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
        loop(lastLoopTime, OPTIMAL_TIME);
    }
    
    /**
     * This is the game loop, which updates 
     * the game optimally 60 times a second.
     */
    private void loop(long lastLoopTime, final long OPTIMAL_TIME) {
        while(true) {
            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;
            double delta = updateLength / (double) OPTIMAL_TIME;
            
            updateGame(delta);
            updateDrawables();
            drawPanel.repaint();
            wait(lastLoopTime, OPTIMAL_TIME);
                        
        }
    }
    
    private void updateGame(double delta) {
        PlayerKeyListener playerKeyListener = gameFrame.getPlayerKeyListener();
        playerCharacter.move(delta, playerKeyListener);
    }
    
    private void wait(long lastLoopTime, final long OPTIMAL_TIME) {
        try {
            Thread.sleep( (lastLoopTime - System.nanoTime() + OPTIMAL_TIME)/1000000);
        } catch (Exception e) {}
    }

    public GameFrame getGameFrame() {
        return gameFrame;
    }

    public DrawPanel getDrawPanel() {
        return drawPanel;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public PlayerCharacter getPlayerCharacter() {
        return playerCharacter;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }
    
    

    

    
    
}
