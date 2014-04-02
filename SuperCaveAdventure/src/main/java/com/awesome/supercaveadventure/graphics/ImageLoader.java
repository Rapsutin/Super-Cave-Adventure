

package com.awesome.supercaveadventure.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * This utility class makes loading sprites
 * slightly cleaner looking and removes 
 * duplication.
 */
public class ImageLoader {

    private ImageLoader() {
    }
    
    /**
     * Creates a BufferedImage-object from
     * the specified image file.
     * @param imagePath The Path to the image file.
     * @return The image as a BufferedImage-object.
     */
    public static BufferedImage loadImage(String imagePath) {
        try {
            return ImageIO.read(new File(imagePath));
        } catch(Exception e) {
        }
        return null;
        
    }
    
}
