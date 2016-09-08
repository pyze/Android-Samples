package com.pyze.samples.eventsampleandroid.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.pyze.samples.eventsampleandroid.activity.EventInvokeActivity;
import com.pyze.samples.eventsampleandroid.pyzeutil.PyzeUtil;

/**
 * Created by jesudas on 06/09/16.
 */
public class EventMethodAdapter extends PyzeBaseAdapter {

    public EventMethodAdapter(String[] dataSet) {
        super(dataSet);
    }

    @Override
    protected void onItemClick(Context context, String itemName) {
        int i =0;
        while(!TextUtils.equals(itemName,mDataSet[i]))
            i++;
        if(TextUtils.equals(PyzeUtil.SelectedEventClass.getSimpleName(),"PyzeEvents")) {
            i += 3; //Escape above three unwanted methods
        }
        PyzeUtil.SelectedEventMethod = PyzeUtil.SelectedEventClass.getDeclaredMethods()[i];
        Intent showMethodsIntent = new Intent(context, EventInvokeActivity.class);
        context.startActivity(showMethodsIntent);
    }
}
