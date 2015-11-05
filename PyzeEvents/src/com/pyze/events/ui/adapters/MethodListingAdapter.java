package com.pyze.events.ui.adapters;

import java.lang.reflect.Method;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.pyze.events.R;

public class MethodListingAdapter extends ArrayAdapter<Method>{
	
	private LayoutInflater mInflater;

	public MethodListingAdapter(Context context, List<Method> methodsList) {
		super(context, 0, methodsList);
		mInflater = LayoutInflater.from(context);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.list_item_events, parent, false);
			holder.methodNameTextView = (TextView) convertView.findViewById(R.id.txt_eventName);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.methodNameTextView.setText(getItem(position).getName());
		return convertView;
	}
	
	private static class ViewHolder {
		TextView methodNameTextView;
	}

}
