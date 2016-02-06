package com.lazymonkeystudio.engine;

import android.graphics.Bitmap;

/**
 * Created by Will on 11/13/2015.
 * Animation class, this is where animation takes place
 * call setFrames and pass it a bitmap array, it will loop through array
 * call setDelay, this will give your animations a delay
 */
public class Animation {
    private Bitmap[] frames;
    private int currentFrame;
    private long startTime, delay;
    private boolean playedOnce;

    //populates the bitmap array to know what image to loop over
    public void setFrames(Bitmap[] frames)
    {
        this.frames = frames;
        currentFrame = 0;
        startTime = System.nanoTime();
    }

    public Animation()
    {

    }

    //animation update, without this your animations wont update, aka change frames
    //if the elapsed time is greater than the delay it will increment the frame
    //if the current frame is the last one it'll start over from frame 0
    public void update()
    {
        long elapsed = (System.nanoTime()-startTime)/1000000;

        if(elapsed>delay)
        {
            currentFrame++;
            startTime = System.nanoTime();
        }

        if(currentFrame == frames.length)
        {
            currentFrame = 0;
            playedOnce = true;
        }
    }
    public Bitmap getImage()
    {return frames[getFrame()];} //gets the current Image in the loop

    public int getFrame()
    {return currentFrame;} //gets the current Frame number

    public void setDelay(int d)
    {delay = d;} //sets the delay between each frame
    //plan to add onto this to make the delay based on the amount of frames
    //instead of being hardcoded

    public void setFrames(int i)
    {currentFrame = i;}//set the frame to which ever picture in the image
}
