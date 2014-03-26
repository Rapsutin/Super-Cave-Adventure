/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.awesome.supercaveadventure.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


public class ImageLoader {

    private ImageLoader() {
    }
    
    public static BufferedImage loadImage(String imagePath) {
        try {
            return ImageIO.read(new File(imagePath));
        } catch(Exception e) {
        }
        return null;
        
    }
    
}
