package supercaveadventure.graphics;

import supercaveadventure.userinput.PlayerKeyListener;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * The window that contains DrawPanel.
 */
public class GameFrame implements Runnable {

    private JFrame frame;
    private DrawPanel drawPanel;
    private PlayerKeyListener playerKeyListener;

    public GameFrame(DrawPanel drawPanel) {
        this.drawPanel = drawPanel;
        this.drawPanel.setDoubleBuffered(true);
        playerKeyListener = new PlayerKeyListener();
    }
    
    
    @Override
    public void run() {

        frame = new JFrame("Super Cave Adventure");
        frame.setMinimumSize(new Dimension(806, 486));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);


    }

    public DrawPanel getDrawPanel() {
        return drawPanel;
    }

    public PlayerKeyListener getPlayerKeyListener() {
        return playerKeyListener;
    }

    private void createComponents(Container container) {
        container.add(drawPanel);
        frame.addKeyListener(playerKeyListener);

    }
}
