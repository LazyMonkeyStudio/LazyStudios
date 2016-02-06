package com.lazymonkeystudio.engine;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Will on 11/12/2015.
 * Extends default background
 * Purpose: create a background to a certain size and create a scale factor
 * scale any image to the input size
 */
public class Background_World extends Background {
    private int width;
    private int height;

    public Background_World(GamePanel gp, Bitmap res, int width, int height)
    {
        super(gp, res);
        this.width = width;
        this.height = height;
        //GamePanel.WIDTH = width;
        //GamePanel.HEIGHT = height;
    }

    @Override
    public void update()
    {
        super.update();
        //System.out.println(gamePanel.getHeight() + "/" + gamePanel.HEIGHT);
        //System.out.println(gamePanel.getWidth() + "/" + gamePanel.WIDTH);
    }

    @Override
    public void draw(Canvas canvas)
    {
        //super.draw(canvas);        //1980
        float scaleFactorX = (float)width/gamePanel.getWidth(); //scale X based on input size
        float scaleFactorY = (float)height/gamePanel.getHeight(); //scale Y based on input size
        if(canvas != null) {
            final int savedState = canvas.save();
            canvas.scale(scaleFactorX, scaleFactorY);
            canvas.drawBitmap(image, X, Y, null);
            canvas.restoreToCount(savedState);
        }
    }
}
