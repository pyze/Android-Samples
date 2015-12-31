package com.pyze.events.ui;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.pyze.events.Constants.Extras;
import com.pyze.events.R;
import com.pyze.events.ui.adapters.EventsListAdapter;

public class EventsListingActivity extends AppCompatActivity implements OnItemClickListener{

	private List<String> mEventsList = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_events);
		getSupportActionBar().setTitle(getString(R.string.title_events));
		getClasses();
		ListView listview = (ListView) findViewById(R.id.listview_events);
		listview.setOnItemClickListener(this);
		listview.setAdapter(new EventsListAdapter(this, mEventsList));
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position,
			long arg3) {

		Intent methodsIntent = new Intent(this, MethodListingActivity.class);
		methodsIntent
				.putExtra(Extras.SELECTED_CLASS_NAME, mEventsList.get(position));
		startActivity(methodsIntent);

	}
	
	private void getClasses() {
		try {
			Class<?> PyzeEventsClass = Class
					.forName("com.pyze.android.PyzeEvents");
			Class<?>[] classes = PyzeEventsClass.getClasses();
			Toast.makeText(this, "Total class: " + classes.length, Toast.LENGTH_LONG).show();
			for(Class<?> eventClass : classes) {
				mEventsList.add(eventClass.getName());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
