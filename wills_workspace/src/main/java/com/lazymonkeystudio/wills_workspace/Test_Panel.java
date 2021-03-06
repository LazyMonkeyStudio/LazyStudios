package com.lazymonkeystudio.wills_workspace;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;

import com.lazymonkeystudio.engine.Background_Scrolling;
import com.lazymonkeystudio.engine.Button;
import com.lazymonkeystudio.engine.DebugGUI;
import com.lazymonkeystudio.engine.GameObject;
import com.lazymonkeystudio.engine.GamePanel;
import com.lazymonkeystudio.engine.Physics;

/**
 * Created by Will on 2/5/2016.
 */
public class Test_Panel extends GamePanel {
    private DebugGUI debug_gui;
    private Physics physics = new Physics(this);
    private GameObject player;

    public Test_Panel(Context context, int targetFPS)
    {
        super(context, targetFPS);
        thread.setGamePanel(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {
        debug_gui = new DebugGUI();
        background = new Background_Scrolling(this, BitmapFactory.decodeResource(getResources(), R.drawable.background));
        player = new Button("player", BitmapFactory.decodeResource(getResources(), R.drawable.player), 100, 100, 1, 8);
        entity_m.addEntity(player);

        super.surfaceCreated(holder);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder)
    {
        super.surfaceDestroyed(holder);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        //entity_m.addEntity(player);
        //System.out.println("tapped");
        return super.onTouchEvent(event);
    }

    @Override
    public void  update()
    {
        super.update();
        physics.update();
        background.update();

        debug_gui.update();
        debug_gui.fpsCount = (int) thread.averageFPS;

        entity_m.update();
    }

    @Override
    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        background.draw(canvas);

        debug_gui.draw(canvas);

        entity_m.draw(canvas);
    }
}
