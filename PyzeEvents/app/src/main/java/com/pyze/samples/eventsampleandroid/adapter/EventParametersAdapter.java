package com.pyze.samples.eventsampleandroid.adapter;

import android.content.Context;

/**
 * Created by jesudas on 06/09/16.
 */
public class EventParametersAdapter extends PyzeBaseAdapter {
    public EventParametersAdapter(String[] dataSet) {
        super(dataSet);
    }

    @Override
    protected void onItemClick(Context context, String itemName) {
        //ignore
    }
}
