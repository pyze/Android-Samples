package com.pyze.events.ui.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.pyze.events.R;

public class EventsListAdapter extends ArrayAdapter<String>{
	
	private LayoutInflater mInflater;

	public EventsListAdapter(Context context, List<String> eventsList) {
		super(context, 0, eventsList);
		mInflater = LayoutInflater.from(context);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.list_item_events, parent, false);
			holder.eventNameTextView = (TextView) convertView.findViewById(R.id.txt_eventName);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		String fullClassName = getItem(position);
		int start = fullClassName.lastIndexOf('$') + 1, end = fullClassName.length();
		holder.eventNameTextView.setText(fullClassName.substring(start, end));
		return convertView;
	}
	
	private static class ViewHolder {
		TextView eventNameTextView;
	}
	


}
