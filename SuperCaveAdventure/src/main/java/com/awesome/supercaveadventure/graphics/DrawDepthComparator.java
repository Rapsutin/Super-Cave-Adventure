
package com.awesome.supercaveadventure.graphics;

import java.util.Comparator;

/**
 * A utility class that is used to compare
 * DrawDepth-enums so that Collections.sort() can
 * be used to sort them.
 */
public class DrawDepthComparator implements Comparator<Drawable>{

    
    @Override
    public int compare(Drawable o1, Drawable o2) {
        return o1.getDrawDepth().getDepth() - o2.getDrawDepth().getDepth();
    }

}
