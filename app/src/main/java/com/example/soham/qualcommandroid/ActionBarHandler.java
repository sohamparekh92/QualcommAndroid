package com.example.soham.qualcommandroid;

import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by Soham on 10/5/2016.
 */

public class ActionBarHandler {

    private boolean celsius_scale;
    private MainActivity context_;

    public ActionBarHandler(MainActivity context){
        this.celsius_scale = true;
        this.context_ = context;
    }

    private void toggleScale(){
        celsius_scale = !celsius_scale;
    }

    public void setActionBar(boolean c_scale){
        toggleScale();
        if(c_scale){
            context_.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    context_.scaleDisplay.setText("°C");
                }
            });
        }
        else{
            context_.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    context_.scaleDisplay.setText("°F");
                }
            });

        }
    }
}
