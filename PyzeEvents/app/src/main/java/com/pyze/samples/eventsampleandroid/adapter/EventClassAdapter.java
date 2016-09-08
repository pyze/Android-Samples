package com.pyze.samples.eventsampleandroid.adapter;

import android.content.Context;
import android.content.Intent;

import com.pyze.samples.eventsampleandroid.activity.EventMethodActivity;
import com.pyze.samples.eventsampleandroid.pyzeutil.PyzeEventClass;
import com.pyze.samples.eventsampleandroid.pyzeutil.PyzeUtil;

/**
 * Created by jesudas on 01/09/16.
 */
public class EventClassAdapter extends PyzeBaseAdapter {

    public EventClassAdapter(String[] dataSet) {
        super(dataSet);
    }

    @Override
    protected void onItemClick(Context context, String itemName) {
        PyzeUtil.SelectedEventClass = PyzeUtil.getClassOfType(PyzeEventClass.valueOf(itemName));
        Intent showMethodsIntent = new Intent(context, EventMethodActivity.class);
        context.startActivity(showMethodsIntent);
    }
}
