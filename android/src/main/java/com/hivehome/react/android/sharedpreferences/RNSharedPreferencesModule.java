package com.hivehome.react.android.sharedpreferences;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.Callback;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

		List<String> values = getPreferenceStore(prefName).getItems(keysArray);
		WritableNativeArray data = new WritableNativeArray();

		for (String value: values) {
			data.pushString(value);
		}

		successCallback.invoke(data);
	}

	@ReactMethod
	public void keys(String prefName, Callback successCallback) {
		Set<String> keys = getPreferenceStore(prefName).keys();

		WritableNativeArray data = new WritableNativeArray();

		for (String key: keys) {
			data.pushString(key);
		}

		successCallback.invoke(data);
	}

	@ReactMethod
	public void entries(String prefName, Callback successCallback) {
		Map<String, ?> values = getPreferenceStore(prefName).entries();

		WritableNativeArray data = new WritableNativeArray();
		for (Map.Entry<String, ?> entry: values.entrySet()) {
			WritableArray arr = new WritableNativeArray();
			arr.pushString(entry.getKey());
			arr.pushString(entry.getValue().toString());
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