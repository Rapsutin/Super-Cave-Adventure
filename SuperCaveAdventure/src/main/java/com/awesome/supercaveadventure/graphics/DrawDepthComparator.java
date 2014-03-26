/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.awesome.supercaveadventure.graphics;

import com.awesome.supercaveadventure.graphics.interfaces.Drawable;
import java.util.Comparator;


public class DrawDepthComparator implements Comparator<Drawable>{

    @Override
    public int compare(Drawable o1, Drawable o2) {
        return o1.getDrawDepth().getDepth() - o2.getDrawDepth().getDepth();
    }

}
