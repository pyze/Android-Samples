package com.pyze.events.ui;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.pyze.android.collections.Values;
import com.pyze.events.Constants.Extras;
import com.pyze.events.EventsManager;
import com.pyze.events.R;
import com.pyze.events.RandomNumberGenerator;

public class MethodDetailActivity extends AppCompatActivity {
	
	private String[] mArgumentsArray = new String[] {"facebook", "twitter", "pyze rocks", "news", "music", "video",
			"bitcoin", "content", "account", "activate"};
	private TextView mRequiredAttributesTv, mCustomAttributesTv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_method_details);
		getSupportActionBar().setTitle(getString(R.string.title_methods));
		
		mRequiredAttributesTv = (TextView) findViewById(R.id.textview_required_attributes);
		mCustomAttributesTv = (TextView) findViewById(R.id.textview_custom_attributes);
		
		int position = getIntent().getIntExtra(Extras.SELECTED_METHOD_POSITION, 0);
		final Method selectedMethod = EventsManager.getInstance().getMethodList().get(position);
		
		RandomNumberGenerator rGen = new RandomNumberGenerator();
		Class<?>[] parametersTypeArray = selectedMethod.getParameterTypes();
		int parametersCount = parametersTypeArray.length;
		final Object[] arguments = new Object[parametersCount];
		if(parametersCount > 0) {
			for(int index = 0; index < parametersCount; index++) {
				String parameterType = parametersTypeArray[index].getName();
				if(parameterType.equalsIgnoreCase("java.util.HashMap")) {
					mCustomAttributesTv.setVisibility(View.VISIBLE);
					HashMap<Object, Object> map = getCustomAttributesMap();
					Set<Entry<Object, Object>> keyset = map.entrySet();
					Iterator<Entry<Object, Object>> iterator = keyset.iterator();
					while(iterator.hasNext()) {
						Entry<Object, Object> entry = iterator.next();
						mCustomAttributesTv.setText(mCustomAttributesTv.getText() + "\n " 
						+ entry.getKey() + " : " + entry.getValue());
					}				
					arguments[index] = map;
				} else if(parameterType.equalsIgnoreCase("java.lang.String")) {
					mRequiredAttributesTv.setVisibility(View.VISIBLE);
					String attribute = mArgumentsArray[rGen.getNumber()];
					mRequiredAttributesTv.setText(mRequiredAttributesTv.getText() + "\n" + attribute );
					arguments[index] = attribute;
				} else if(parameterType.equalsIgnoreCase("boolean")) {
					mRequiredAttributesTv.setVisibility(View.VISIBLE);
					mRequiredAttributesTv.setText(mRequiredAttributesTv.getText() + "\ntrue");
					arguments[index] = true;
				} else if(parameterType.equalsIgnoreCase("long")) {
					mRequiredAttributesTv.setVisibility(View.VISIBLE);
					mRequiredAttributesTv.setText(mRequiredAttributesTv.getText() + "\n54834211");
					arguments[index] = 54834211;
				} else if(parameterType.equalsIgnoreCase("com.pyze.android.events.dto.PyzeGeoPoint")) {
					mRequiredAttributesTv.setVisibility(View.VISIBLE);
					mRequiredAttributesTv.setText(mRequiredAttributesTv.getText() + "\nLongitude:12, Latitude:24");
					arguments[index] = "12,24";
				} else if(parameterType.equalsIgnoreCase("com.pyze.android.collections.Values")) {
					Values values = new Values();
					values.putValue("key1", "value1");
					values.putValue("key2", "value2");
					values.putValue("key3", "value3");
					values.putValue("key4", "value4");
					Iterator<Entry<Object, Object>> iterator = values.getAttributes().entrySet().iterator();
					while(iterator.hasNext()) {
						Entry<Object, Object> entry = iterator.next();
						mCustomAttributesTv.setText(mCustomAttributesTv.getText() + "\n " 
						+ entry.getKey() + " : " + entry.getValue());
					}	
					arguments[index] = values;
				}
			}
			
		}
		((Button) findViewById(R.id.btn_done)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
					try {
						selectedMethod.invoke(null, arguments);
						Toast.makeText(MethodDetailActivity.this, getString(R.string.event_success), Toast.LENGTH_LONG).show();
					} catch (IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						e.printStackTrace();
					}
				}
		});
		
	}
	

	public HashMap<Object, Object> getCustomAttributesMap() {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		map.put("key4", "value4");
		return map;		
	}

	
}
