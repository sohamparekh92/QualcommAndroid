package com.example.soham.qualcommandroid;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.provider.CalendarContract;
import android.provider.Settings;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private SensorManager mSensorManager;
    private Sensor mAmbientTemperature;
    private Sensor mAccelerometer;
    private long LAST_UPDATE_TIME;
    private long UPDATE_THRESHOLD;
    private TextView sensorDataView;
    private ListView tempDataView;
    private TempDataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAmbientTemperature = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        LAST_UPDATE_TIME = 0;
        UPDATE_THRESHOLD = 1000;
        tempDataView = (ListView)findViewById(R.id.tempDataList);
        adapter = new TempDataAdapter(getApplicationContext(),R.layout.row_layout);
        ;

        if(mAmbientTemperature!=null){
            Log.i("Ambient Sensor Check", "Affirmative");
        }
        else {
            Log.i("Ambient Sensor Check", "Negative");
        }

        //TextView tv = (TextView) findViewById(R.id.sample_text);
        sensorDataView = (TextView) findViewById(R.id.sensorDataView);
        int temperatureArray[] = new int[]{75,73,54,65,67};
        String days[] = new String[]{"Mon","Tue","Wed","Thu","Fri"};
        int i=0;
        for (String day: days){
            TempData tempData = new TempData(day,temperatureArray[i]);
            adapter.add(tempData);
            i++;
        }

        tempDataView.setAdapter(adapter);

        //tv.setText(getTempJNI(temperatureArray));
    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        /*if(event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE){
            long CURR_TIME = System.currentTimeMillis();
            // if(CURR_TIME - LAST_UPDATE_TIME > UPDATE_THRESHOLD){
            sensorDataView.setText(event.values[0]+"");
            //}
        }*/
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            sensorDataView.setText(""+event.values[0]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


    //Native method implemented by native-lib library
    public native String getTempJNI(int [] temp_far);

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

}
