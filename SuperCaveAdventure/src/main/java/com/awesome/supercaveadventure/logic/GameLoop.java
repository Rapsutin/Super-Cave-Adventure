
package com.awesome.supercaveadventure.logic;


import com.awesome.supercaveadventure.graphics.DrawManager;


/**
 * Updates the game periodically and is also used to 
 * start the game.
 */
public class GameLoop {
    

    private DrawManager drawManager;
    private GameLogic gameLogic;
    
    
    public GameLoop() {
        drawManager = new DrawManager();
        gameLogic = new GameLogic(drawManager.getGameFrame());
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
            
            gameLogic.updateGame(delta);
            drawManager.updateDrawables(gameLogic.getEntities(), gameLogic.getCurrentRoom());
            drawManager.updateDrawPanel();
            
            wait(lastLoopTime, OPTIMAL_TIME);
        }
    }
    
    private void wait(long lastLoopTime, final long OPTIMAL_TIME) {
        try {
            Thread.sleep( (lastLoopTime - System.nanoTime() + OPTIMAL_TIME)/1000000);
        } catch (Exception e) {}
    }

    public DrawManager getDrawManager() {
        return drawManager;
    }

    public GameLogic getGameLogic() {
        return gameLogic;
    }

    
    

    

    
    
}
