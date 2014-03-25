/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.awesome.testobjects;

import com.awesome.supercaveadventure.entity.abstracts.Entity;
import com.awesome.supercaveadventure.graphics.enums.DrawDepth;
import java.awt.Graphics;


public class TestEntity extends Entity{
    
    private double x;
    private double y;
    private int height;
    private int width;

    public TestEntity(double x, double y, int width, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
    
    
    
    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public DrawDepth getDrawDepth() {
        return null;
    }

    @Override
    public void onOverlap(Entity collidingEntity) {
    }

    @Override
    public void draw(Graphics graphics) {
    }

}
