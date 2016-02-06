package com.lazymonkeystudio.engine;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Will on 11/11/2015.
 * Default background class
 * Currently handles drawing a background image on the screen
 * then scales it to properly fit the screen
 * this will take any size image and scale it to screen size
 */
public class Background {
    public GamePanel gamePanel;
    public Bitmap image;
    public int X;
    public int Y;

    //on construction of class, pass it the game panel so it knows where to draw the image
    //also pass it a bitmap which is the image itself
    public Background(GamePanel gp, Bitmap res)
    {
        gamePanel = gp;
        image = res;
        //GamePanel.WIDTH = image.getWidth(); //sets gamepanel witdth to the images width
        //GamePanel.HEIGHT = image.getHeight(); //sets gamepanel height to the images height
    }

    public void update()
    {
    }

    public void draw(Canvas canvas)
    {
        //float scaleFactorY = (float)gamePanel.getHeight()/gamePanel.HEIGHT;
        //float scaleFactorX = (float)gamePanel.getWidth()/gamePanel.WIDTH;
        float scaleFactorX = (float)gamePanel.getWidth()/image.getWidth(); //gets the X scale factor
        float scaleFactorY = (float)gamePanel.getHeight()/image.getHeight(); //gets the Y scale factor
        //goal here is to make a global scale factor so everything scales to one size
        //in theory this will make the app look the same on all screens

        //draws image to the canvas, to be seen onscreen
        if(canvas != null) {
            final int savedState = canvas.save();
            canvas.scale(scaleFactorX, scaleFactorY);
            canvas.drawBitmap(image, X, Y, null);
            canvas.restoreToCount(savedState);
        }
    }
}
