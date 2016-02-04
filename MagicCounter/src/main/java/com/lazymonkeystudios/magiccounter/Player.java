package com.lazymonkeystudios.magiccounter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.widget.Button;

import com.lazymonkeystudio.engine.GameObject;

/**
 * Created by Mobil HQ on 12/15/2015.
 */
public class Player {
    private int lifeTotal = 20;
    String playerName;
    int x;
    int y;
    Button minusBtn;
    Button plusBtn;
    Button btn;
    int damage;
    public Player (String tag, int nX, int nY)
    {

        playerName = tag;
        x = nX;
        y = nY;
        //minusBtn = new GameObject("minus",,x,y,1,1);
        //plusBtn = new GameObject("plus",,x,y,1,1);

    }

    public int minusHP()
    {
        lifeTotal = lifeTotal - damage;
        return lifeTotal;
    }

    public int plusHP(int heal)
    {
        lifeTotal = lifeTotal + heal;
        return lifeTotal;
    }

    public void setPos(int nX,int nY)
    {
        x = nX;
        y = nY;
    }

    //idea--- each new player created will actually be two buttons in a list
    //not sure how positioning would work though, might be able to make a parent object that they fill to

    // public void draw(Canvas canvas){super.draw(canvas);}

}
