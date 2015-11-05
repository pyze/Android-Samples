package com.pyze.events.ui;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.pyze.events.Constants.Extras;
import com.pyze.events.EventsManager;
import com.pyze.events.R;
import com.pyze.events.ui.adapters.MethodListingAdapter;

public class MethodListingActivity extends AppCompatActivity implements OnItemClickListener{

	private List<Method> mMethodList = new ArrayList<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_events);
		getSupportActionBar().setTitle(getString(R.string.title_methods));
		extractDataFromIntent();
		ListView listview = (ListView) findViewById(R.id.listview_events);
		listview.setOnItemClickListener(this);
		listview.setAdapter(new MethodListingAdapter(this, mMethodList));
	}

	private void extractDataFromIntent() {
		String selectedClassName = getIntent().getStringExtra(Extras.SELECTED_CLASS_NAME);
		Class<?> PyzeEventsClass;
		try {
			PyzeEventsClass = Class
					.forName(selectedClassName);
			Method[] methods = PyzeEventsClass.getDeclaredMethods();
			for(Method method : methods) {
				mMethodList.add(method);
			}
			EventsManager.getInstance().setMethodList(mMethodList);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		Intent intent = new Intent(MethodListingActivity.this, MethodDetailActivity.class);
		intent.putExtra(Extras.SELECTED_METHOD_POSITION, position);
		startActivity(intent);
		
	}
	
}
