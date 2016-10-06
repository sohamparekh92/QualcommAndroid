package com.example.soham.qualcommandroid;

import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by Soham on 10/5/2016.
 */

public class ScaleDisplayHandler {

    private MainActivity context;

    public ScaleDisplayHandler(MainActivity context){
        this.context = context;
    }

    //Changes Scale displays according to scale
    public void setScaleDisplays(boolean c_scale){

        if(c_scale){
            context.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    context.scaleDisplay.setText("Temperatures in °C");
                }
            });
        }
        else{
            context.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    context.scaleDisplay.setText("Temperatures in °F");
                }
            });

        }
    }
}
