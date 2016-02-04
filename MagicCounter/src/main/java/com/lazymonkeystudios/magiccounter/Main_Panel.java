package com.lazymonkeystudios.magiccounter;


import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.widget.Button;

import com.lazymonkeystudio.engine.Background;
//import com.lazymonkeystudio.engine.Background_Scrolling;
import com.lazymonkeystudio.engine.GameObject;
import com.lazymonkeystudio.engine.GamePanel;
import com.lazymonkeystudio.engine.DebugGUI;
import com.lazymonkeystudio.engine.Physics;

/**
 * Created by Mobil HQ on 12/4/2015.
 */
public class Main_Panel extends GamePanel{
    private DebugGUI debug_gui;
    private Physics physics = new Physics(this);
    private GameObject player;
    private PlayerManager playerManager;

    //Panel Specific Buttons
    private Button setPlayersBTN;
    private Button resetGameBTN;
    private Button whoGoesFirstBTN;
    //

    public Main_Panel(Context context, int targetFPS) {
        super(context, targetFPS);
        thread.setGamePanel(this);
        setPlayersBTN = new Button(context);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {
        setPlayersBTN.setText("PLEASE SHOW");
        setPlayersBTN.setTextColor(16714734);
        setPlayersBTN.setBackgroundColor(16714734);
        setPlayersBTN.setMinWidth(10);
        setPlayersBTN.setMinHeight(10);
        debug_gui = new DebugGUI();
        background = new Background(this, BitmapFactory.decodeResource(getResources(), com.lazymonkeystudio.engine.R.drawable.background));
        //player = new GameObject("player", BitmapFactory.decodeResource(getResources(), com.lazymonkeystudio.engine.R.drawable.player), 100, 100, 1, 3);
        //entity_m.addEntity(player);

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
        //background.draw(canvas);

        debug_gui.draw(canvas);
        setPlayersBTN.draw(canvas);
        entity_m.draw(canvas);
    }
}
