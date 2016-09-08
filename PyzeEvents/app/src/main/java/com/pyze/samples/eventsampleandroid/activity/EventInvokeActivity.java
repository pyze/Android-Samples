package com.pyze.samples.eventsampleandroid.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.pyze.android.events.dto.PyzeGeoPoint;
import com.pyze.samples.eventsampleandroid.R;
import com.pyze.samples.eventsampleandroid.adapter.EventParametersAdapter;
import com.pyze.samples.eventsampleandroid.pyzeutil.PyzeUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Random;

public class EventInvokeActivity extends AppCompatActivity {

    Object[] parameterValues;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_invoke);
        final Class[] parameters = PyzeUtil.SelectedEventMethod.getParameterTypes();


        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.events_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        String[] mDataSet = new String[parameters.length];
        parameterValues = new Object[parameters.length];
        for(int parameterIndex = 0; parameterIndex<parameters.length ;parameterIndex ++) {
            switch (parameters[parameterIndex].getSimpleName()){
                case "int"      : parameterValues[parameterIndex]   = new Random().nextInt();
                    break;
                case "long"     : parameterValues[parameterIndex]   = new Random().nextLong();
                    break;
                case "String"   : parameterValues[parameterIndex]   = PyzeUtil.getRandomString(4);
                    break;
                case "boolean"  : parameterValues[parameterIndex]   = (new Random().nextInt() % 2) == 0;
                    break;
                case "double"   : parameterValues[parameterIndex]   = new Random().nextDouble();
                    break;
                case "HashMap"  :
                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put("attr1",PyzeUtil.getRandomString(4));
                    parameterValues[parameterIndex]  = hashMap;
                    break;
                case "PyzeGeoPoint"   :
                    PyzeGeoPoint pyzeGeoPoint = new PyzeGeoPoint();
                    pyzeGeoPoint.mLatitude  = new Random().nextFloat();
                    pyzeGeoPoint.mLongitude = new Random().nextFloat();
                    parameterValues[parameterIndex]   = pyzeGeoPoint;
                    break;
            }
            mDataSet[parameterIndex] = parameters[parameterIndex].getSimpleName() + " " + parameterValues[parameterIndex];
        }

        RecyclerView.Adapter mAdapter = new EventParametersAdapter(mDataSet);
        mRecyclerView.setAdapter(mAdapter);

        (findViewById(R.id.invoke_method)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    PyzeUtil.SelectedEventMethod.invoke(PyzeUtil.SelectedEventClass,parameterValues);
                    Toast.makeText(EventInvokeActivity.this, "Method Invoked!", Toast.LENGTH_SHORT).show();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
