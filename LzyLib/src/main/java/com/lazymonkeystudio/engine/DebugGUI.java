package com.lazymonkeystudio.engine;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by Will on 11/6/2015.
 * Debug GUI
 * this will be a class that handles some Debug objects for in game debugging
 */
public class DebugGUI {
    //private TextView fpsCount;
    private Rect bounds;
    public int fpsCount;

    public DebugGUI()
    {
        bounds = new Rect(0, 0, 100, 150);
    }

    public void update()
    {

    }
    public void draw(Canvas canvas)
    {
        draw_fps(canvas);
        //System.out.println("text prinited");
    }

    //draws the current fps to the screen as text Example: 30
    private void draw_fps(Canvas canvas) {
        Paint paint = new Paint();
        paint.setTextSize(100);
        paint.setColor(Color.BLACK);
        canvas.drawText(String.valueOf(fpsCount), 90, 120, paint);
    }

    private void destroy()
    {

    }
}
