package in.sriraman.sharedpreferences;


import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.*;
import com.facebook.react.bridge.Callback;


public class RNSharedPreferencesModule extends ReactContextBaseJavaModule {


    public RNSharedPreferencesModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "SharedPreferences";
    }


    @ReactMethod
    public void setItem(String key, String value) {

        SharedHandler.init(getReactApplicationContext());
        SharedDataProvider.putSharedValue(key, value);

    }

    @ReactMethod
    public void getItem(String key, Callback successCallback) {

        SharedHandler.init(getReactApplicationContext());
        String value = SharedDataProvider.getSharedValue(key);
        successCallback.invoke(value);

    }

    @ReactMethod
    public void getItems(ReadableArray keys, Callback successCallback) {
        SharedHandler.init(getReactApplicationContext());
        String[] keysArray = new String[keys.size()];
        for (int i = 0; i < keys.size(); i++) {
            keysArray[i] = keys.getString(i);
        }
        String[][] values = SharedDataProvider.getMultiSharedValues(keysArray);
        WritableNativeArray data = new WritableNativeArray();
        for (int i = 0; i < keys.size(); i++) {
            data.pushString(values[i][1]);
        }
        successCallback.invoke(data);
    }

    @ReactMethod
    public void getAll(Callback successCallback) {
        SharedHandler.init(getReactApplicationContext());
        String[][] values = SharedDataProvider.getAllSharedValues();
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
    public void getAllKeys(Callback successCallback) {
        SharedHandler.init(getReactApplicationContext());
        String[] keys = SharedDataProvider.getAllKeys();
        WritableNativeArray data = new WritableNativeArray();
        for (int i = 0; i < keys.length; i++) {
            data.pushString(keys[i]);
        }
        successCallback.invoke(data);
    }


    @ReactMethod
    public void clear() {
        SharedHandler.init(getReactApplicationContext());
        SharedDataProvider.clear();
    }


    @ReactMethod
    public void removeItem(String key) {
        SharedHandler.init(getReactApplicationContext());
        SharedDataProvider.deleteSharedValue(key);
    }


}
