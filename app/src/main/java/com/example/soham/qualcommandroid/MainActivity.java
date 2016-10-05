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
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private SensorManager mSensorManager;
    private Sensor mAmbientTemperature;
    private ToggleButton toggleScaleButton;
    private TextView sensorDataView;
    private ListView tempDataView;
    private TempDataAdapter adapter;
    private boolean scale_celsius = true;
    private boolean isSensorPresent = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAmbientTemperature = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);

        tempDataView = (ListView)findViewById(R.id.tempDataList);
        adapter = new TempDataAdapter(getApplicationContext(),R.layout.row_layout);

        //Configuring Toggle Button
        toggleScaleButton = (ToggleButton) findViewById(R.id.toggleButton);
        toggleScaleButton.setChecked(true);
        toggleScaleButton.setText("°C");
        toggleScaleButton.setTextOn("°C");
        toggleScaleButton.setTextOff("°F");

        toggleScaleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    MainActivity.this.toggleScale();
            }
        });

        //Looks for Ambient temperature sensor
        sensorDataView = (TextView) findViewById(R.id.sensorDataView);
        if(mAmbientTemperature!=null){
            isSensorPresent = true;
        }
        else{
            sensorDataView.setText("Sensor Not Available.");
        }

        int temperatureArrayCel[] = new int[]{22,13,11,25,33};
        //TODO: Make a random number generator for Celsius temperatures
        String days[] = new String[]{"Mon","Tue","Wed","Thu","Fri"};
        int i=0;
        TempData tempData[] = new TempData[days.length];
        for (String day: days){
            tempData[i] = new TempData(day,temperatureArrayCel[i]);
            adapter.add(tempData[i]);
            i++;
        }

        String [] tempFarString = getTempJNI(temperatureArrayCel).split(" ");
        for(i=0; i<tempFarString.length; i++ ) {
            //temperaTureArrayFar[i] = Integer.parseInt(tempFarString[i]);
            tempData[i].setFahrenheit(Integer.parseInt(tempFarString[i]));
            Log.i("Temp in Far", ""+tempData[i].getFahrenheit());
        }

        tempDataView.setAdapter(adapter);
    }


    public void toggleScale(){
        adapter.toggleScale();
        adapter.notifyDataSetChanged();
        scale_celsius = !scale_celsius;
    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAmbientTemperature, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE ) {//&& isSensorPresent){
            if(scale_celsius) {
                sensorDataView.setText(event.values[0] + "");
            }
            else{
                int result = getTempSingleJNI((int)event.values[0]);
                sensorDataView.setText(result+"");
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    //Native methods implemented by native-lib library
    public native String getTempJNI(int [] temp_c);
    public native int getTempSingleJNI(int temp_c);

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

}
