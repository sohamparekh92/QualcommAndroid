package com.example.soham.qualcommandroid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Soham on 10/4/2016.
 */

public class TempDataAdapter extends ArrayAdapter {

    private List list = new ArrayList();
    private boolean scale_celsius = true;

    public void toggleScale() { scale_celsius = !scale_celsius; }

    public TempDataAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    class TemperatureData{
        TextView day;
        TextView temp;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        TemperatureData t_data;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.row_layout,parent,false);
            t_data = new TemperatureData();
            t_data.day = (TextView) row.findViewById(R.id.dayView);
            t_data.temp = (TextView) row.findViewById(R.id.temperatureView);
            row.setTag(t_data);
        }
        else{
            t_data = (TemperatureData) row.getTag();
        }

        TempData tempData = (TempData) this.list.get(position);

        t_data.day.setText(tempData.getDay());
        if(scale_celsius) {
            t_data.temp.setText(tempData.getCelsius() + "");
        }
        else {
            t_data.temp.setText(tempData.getFahrenheit() + "");
        }
        return row;
    }
}
