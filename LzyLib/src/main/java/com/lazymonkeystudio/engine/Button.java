package com.lazymonkeystudio.engine;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Mobil HQ on 2/5/2016.
 */
public class Button extends GameObject {

    public Button(String tag, Bitmap res, int x, int y, int columns, int rows) {
        super(tag, res, x, y, columns, rows);

    }
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        return super.onTouchEvent(event);
    }

    @Override
    public void update()
    {
        /*this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });*/
        //System.out.println(WIDTH + "," + HEIGHT);
        //System.out.println(GamePanel.WIDTH + "," + GamePanel.HEIGHT);
    }
    @Override
    public void draw(Canvas canvas)
    {
        super.draw(canvas);

    }
}
