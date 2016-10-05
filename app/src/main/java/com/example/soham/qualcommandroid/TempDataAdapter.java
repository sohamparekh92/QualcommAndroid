package com.example.soham.qualcommandroid;

import android.content.Context;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

/**
 * Created by Soham on 10/4/2016.
 */

public class TempDataAdapter extends ArrayAdapter {

    public TempDataAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(Object object) {
        super.add(object);
    }
}
