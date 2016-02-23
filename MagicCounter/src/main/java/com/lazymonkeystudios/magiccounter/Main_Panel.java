package com.lazymonkeystudios.magiccounter;


import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

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
    private com.lazymonkeystudio.engine.Button setPlayersBTN;
    private static Button resetGameBTN;
    private Button whoGoesFirstBTN;
    //
    static Activity nContext;
    public Main_Panel(Context context, int targetFPS) {
        super(context, targetFPS);
        nContext = (Activity)context;
        thread.setGamePanel(this);
    }
    public static void onCreate()
    {
        //attempt1-http://stackoverflow.com/questions/11402418/adding-a-button-to-activity-without-any-layout

        //System.out.println("PANEL onCREATE");
        resetGameBTN = new Button (nContext);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        params.topMargin = 10;
        params.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;

        resetGameBTN.setText("Players");
        nContext.addContentView(resetGameBTN,params);
        // setContentView(tv);
        resetGameBTN.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                nContext.setContentView(new PlayerList_Panel(nContext, 30));
                PlayerList_Panel.onCreate();

            }
        });

        //atempt 2
/*
        LinearLayout ll = new LinearLayout(nContext);
        Button b = new Button(nContext);
        b.setText("hello world");
        ll.addView(b);
        ll.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        nContext.addContentView(ll,
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));*/

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {

        debug_gui = new DebugGUI();
        background = new Background(this, BitmapFactory.decodeResource(getResources(), com.lazymonkeystudio.engine.R.drawable.background));
        //player = new GameObject("player", BitmapFactory.decodeResource(getResources(), com.lazymonkeystudio.engine.R.drawable.player), 100, 100, 1, 3);
        //entity_m.addEntity(player);
        //setPlayersBTN = new com.lazymonkeystudio.engine.Button("New Player",BitmapFactory.decodeResource(getResources(), com.lazymonkeystudios.magiccounter.R.drawable.button),100,100,1,1);
        //entity_m.addEntity(setPlayersBTN);
        super.surfaceCreated(holder);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder)
    {
        super.surfaceDestroyed(holder);
    }

   // @Override
    //public boolean onTouchEvent(MotionEvent event){return super.onTouchEvent(event); }

    @Override
    public void  update()
    {
        super.update();
        physics.update();
        background.update();
        /*setPlayersBTN.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    System.out.println("BUTTON PRESSED!!!!!!!!!!!!!!!!!!!");
                    nContext.setContentView(new PlayerList_Panel(nContext, 30));

                    return true;
                }
                return false;
            }
        });*/
        debug_gui.update();
        debug_gui.fpsCount = (int) thread.averageFPS;

        entity_m.update();
    }

    @Override
    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        background.draw(canvas);
        //resetGameBTN.draw(canvas);
        debug_gui.draw(canvas);
        //setPlayersBTN.draw(canvas);
        entity_m.draw(canvas);

    }
}
