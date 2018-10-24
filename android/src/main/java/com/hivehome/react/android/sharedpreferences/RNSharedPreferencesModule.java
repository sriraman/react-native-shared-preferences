package com.hivehome.react.android.sharedpreferences;

import com.hivehome.react.android.sharedpreferences.RNSharedPreferences;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.Callback;
import java.util.HashMap;

public class RNSharedPreferencesModule extends ReactContextBaseJavaModule {

	private HashMap<String, RNSharedPreferences> preferences = new HashMap<String, RNSharedPreferences>();

	public RNSharedPreferencesModule(ReactApplicationContext reactContext) {
		super(reactContext);
	}

	@Override
	public String getName() {
		return "AndroidSharedPreferences";
	}

	private RNSharedPreferences getPreferenceStore(String name) {
		if (!preferences.containsKey(name)) {
			RNSharedPreferences prefs = new RNSharedPreferences(getReactApplicationContext(), name);
			preferences.put(name, prefs);
			return prefs;
		}

		return preferences.get(name);
	}

	@ReactMethod
	public void getItem(String prefName, String key, Callback successCallback) {
		String value = getPreferenceStore(prefName).getItem(key);
		successCallback.invoke(value);
	}

	@ReactMethod
	public void getItems(String prefName, ReadableArray keys, Callback successCallback) {
		String[] keysArray = new String[keys.size()];
		for (int i = 0; i < keys.size(); i++) {
			keysArray[i] = keys.getString(i);
		}

		String[][] values = getPreferenceStore(prefName).getItems(keysArray);
		WritableNativeArray data = new WritableNativeArray();
		for (int i = 0; i < keys.size(); i++) {
			data.pushString(values[i][1]);
		}

		successCallback.invoke(data);
	}

	@ReactMethod
	public void keys(String prefName, Callback successCallback) {
		String[] keys = getPreferenceStore(prefName).keys();

		WritableNativeArray data = new WritableNativeArray();
		for (int i = 0; i < keys.length; i++) {
			data.pushString(keys[i]);
		}

		successCallback.invoke(data);
	}

	@ReactMethod
	public void entries(String prefName, Callback successCallback) {
		String[][] values = getPreferenceStore(prefName).entries();

		WritableNativeArray data = new WritableNativeArray();
		for (int i = 0; i < values.length; i++) {
			WritableArray arr = new WritableNativeArray();
			arr.pushString(values[i][0]);
			arr.pushString(values[i][1]);
			data.pushArray(arr);
		}

		successCallback.invoke(data);
	}

	@ReactMethod
	public void setItem(String prefName, String key, String value) {
		getPreferenceStore(prefName).setItem(key, value);
	}

	@ReactMethod
	public void deleteItem(String prefName, String key) {
		getPreferenceStore(prefName).deleteItem(key);
	}

	@ReactMethod
	public void clear(String prefName) {
		getPreferenceStore(prefName).clear();
	}
}