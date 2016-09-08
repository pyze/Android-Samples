package com.pyze.samples.eventsampleandroid.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.pyze.samples.eventsampleandroid.R;
import com.pyze.samples.eventsampleandroid.pyzeutil.PyzeUtil;
import com.pyze.samples.eventsampleandroid.adapter.EventMethodAdapter;

import java.lang.reflect.Method;

public class EventMethodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_method);
        Method[] methods = PyzeUtil.SelectedEventClass.getDeclaredMethods();

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.events_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        String[] mDataSet;
        if(TextUtils.equals(PyzeUtil.SelectedEventClass.getSimpleName(),"PyzeEvents")) {
            mDataSet = new String[4];
            for (int methodIndex = 3; methodIndex < 7; methodIndex++) {
                mDataSet[methodIndex-3] = methods[methodIndex].getName();
            }
        }else {
            mDataSet = new String[methods.length];
            for (int methodIndex = 0; methodIndex < methods.length; methodIndex++) {
                mDataSet[methodIndex] = methods[methodIndex].getName();
            }
        }

        RecyclerView.Adapter mAdapter = new EventMethodAdapter(mDataSet);
        mRecyclerView.setAdapter(mAdapter);

    }
}
