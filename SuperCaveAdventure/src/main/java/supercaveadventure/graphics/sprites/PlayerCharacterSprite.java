package supercaveadventure.graphics.sprites;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import supercaveadventure.entities.Direction;
import supercaveadventure.entities.PlayerCharacter;
import supercaveadventure.graphics.Drawable;
import supercaveadventure.graphics.ImageLoader;


public class PlayerCharacterSprite extends Sprite{
    

    private PlayerCharacter playerCharacter;
    private BufferedImage upOrientationImage;
    private BufferedImage downOrientationImage;
    private BufferedImage leftOrientationImage;
    private BufferedImage rightOrientationImage;

    public PlayerCharacterSprite(PlayerCharacter playerCharacter) {
        super((Drawable) playerCharacter);
        this.playerCharacter = playerCharacter;
        loadImages();
    }
    
    /**
     * Loads the used images into memory.
     */
    private void loadImages() {
        upOrientationImage = ImageLoader.loadImage("resources/dudeUP.png");
        downOrientationImage = ImageLoader.loadImage("resources/dudeDOWN.png");
        rightOrientationImage = ImageLoader.loadImage("resources/dudeRIGHT.png");
        leftOrientationImage = ImageLoader.loadImage("resources/dudeLEFT.png");
    }
    
    @Override
    public void draw(Graphics2D graphics) {
        BufferedImage usedImage = selectOrientationImage();
        int playerXPos = (int) playerCharacter.getX();
        int playerYPos = (int) playerCharacter.getY();
        graphics.drawImage(usedImage, playerXPos, playerYPos, null);
    }
    
    /**
     * Selects the correct image according to the orientation
     * of PlayerCharacter
     * @return The correct image.
     */
    public BufferedImage selectOrientationImage() {
        Direction playerCharacterOrientation = playerCharacter.getOrientation();
        
        if(playerCharacterOrientation == Direction.RIGHT) {
            return rightOrientationImage;
        }else if(playerCharacterOrientation == Direction.LEFT) {
            return leftOrientationImage;
        }else if(playerCharacterOrientation == Direction.UP) {
            return upOrientationImage;
        }else {
            return downOrientationImage;
        }
    }

    public BufferedImage getDownOrientationImage() {
        return downOrientationImage;
    }

    public BufferedImage getLeftOrientationImage() {
        return leftOrientationImage;
    }

    public BufferedImage getRightOrientationImage() {
        return rightOrientationImage;
    }

    public BufferedImage getUpOrientationImage() {
        return upOrientationImage;
    }
    
}
