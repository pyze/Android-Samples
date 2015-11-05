package com.pyze.events.ui;

import com.pyze.events.R;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class AboutActivity extends Activity {
	
	private static final String URL = "http://www.pyze.com";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		((WebView) findViewById(R.id.webview_about)).loadUrl(URL);	
	}
}
