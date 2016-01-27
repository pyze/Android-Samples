package com.pyze.events.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

import com.pyze.android.Pyze;
import com.pyze.android.constants.Constants.LogLevel;
import com.pyze.events.EventsManager;
import com.pyze.events.R;

public class HomeActivity extends AppCompatActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		Pyze.initialize(getApplication(), LogLevel.DEBUG);
		Pyze.initializeEvents(getApplication());
		initViews();
	}

	private void initViews() {
		findViewById(R.id.btn_about).setOnClickListener(this);
		findViewById(R.id.btn_events).setOnClickListener(this);
		findViewById(R.id.btn_request).setOnClickListener(this);
		findViewById(R.id.txt_website).setOnClickListener(this);		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_about:
			Intent aboutIntent = new Intent(this, AboutActivity.class);
			startActivity(aboutIntent);
			break;

		case R.id.btn_events:
			Intent eventsIntent = new Intent(this, EventsListingActivity.class);
			startActivity(eventsIntent);
			break;

		case R.id.btn_request:

			break;

		case R.id.txt_website:
			Intent websiteIntent = new Intent(this, AboutActivity.class);
			startActivity(websiteIntent);
			break;

		default:
			break;
		}

	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		EventsManager.clearInstance();
	}
}
