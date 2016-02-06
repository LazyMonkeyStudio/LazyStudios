package com.lazymonkeystudio.wills_workspace;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //below is all you need to create a new project
        requestWindowFeature(Window.FEATURE_NO_TITLE); //turn off title
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); //lock as landscape
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //set screen full screen


        //Goal here is to create a game panel manager
        //this will allow easability when trying to swtich game panels
        //theory would be that you switch the panel in the manager and it draws the new panel
        setContentView(new Test_Panel(this, 30)); //new GamePanel, set your game panel here
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.lazymonkeystudio.engine.R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == com.lazymonkeystudio.engine.R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
