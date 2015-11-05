package com.pyze.events;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class EventsManager {
	
	private List<Method> mMethodList = new ArrayList<>();
	private static EventsManager sInstance;
	
	private EventsManager() {
		
	}
	
	public static EventsManager getInstance() {
		if(sInstance == null)
			sInstance = new EventsManager();
		return sInstance;
	}
	
	public void setMethodList(List<Method> methodList) {
		mMethodList = methodList;
	}

	public List<Method> getMethodList() {
		return mMethodList;
	}
	
	public static void clearInstance() {
		sInstance = null;
	}
}
