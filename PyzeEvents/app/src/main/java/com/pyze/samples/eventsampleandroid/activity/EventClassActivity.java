package com.pyze.samples.eventsampleandroid.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pyze.android.Pyze;
import com.pyze.samples.eventsampleandroid.R;
import com.pyze.samples.eventsampleandroid.pyzeutil.PyzeEventClass;
import com.pyze.samples.eventsampleandroid.adapter.EventClassAdapter;

public class EventClassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.events_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        Pyze.getTimerReference();
        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        PyzeEventClass[] pyzeEventClasses = PyzeEventClass.values();
        String[] mDataSet = new String[pyzeEventClasses.length];
        for (int classIndex = 0; classIndex<pyzeEventClasses.length;classIndex++){
            mDataSet[classIndex] = pyzeEventClasses[classIndex].name();
        }

        RecyclerView.Adapter mAdapter = new EventClassAdapter(mDataSet);
        mRecyclerView.setAdapter(mAdapter);
    }
}

