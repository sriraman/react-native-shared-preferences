package in.sriraman.sharedpreferences;


import android.widget.Toast;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.common.MapBuilder;
import android.bluetooth.BluetoothAdapter;
import com.facebook.react.bridge.Callback;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import in.sriraman.sharedpreferences.SharedDataProvider;
import in.sriraman.sharedpreferences.SharedHandler;

import android.content.Intent;
import android.content.Context;

import java.util.Map;
import java.util.HashMap;

import android.app.AlertDialog;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;



public class RNSharedPreferencesModule extends ReactContextBaseJavaModule {


    final int BT_ACTION_REQUEST_ENABLE = 1;

    private BluetoothAdapter bt_adapter = null;
    private ListView bt_list_view;
    private ArrayList<BluetoothDevice> bt_device_list = null;
    private boolean bt_scanning = false;
    private boolean is_watch = false;

    private BroadcastReceiver bt_info_receiver = null;




    public void onCreate(Bundle savedInstanceState) {


    }




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
        SharedDataProvider.putSharedValue(key,value);

    }

    @ReactMethod
    public void getItem(String key, Callback successCallback){

      SharedHandler.init(getReactApplicationContext());
      String value = SharedDataProvider.getSharedValue(key);
      successCallback.invoke(value);

    }

/*

	@ReactMethod
	public void multiGet(String[] keys, Callback successCallback){

		SharedHandler.init(getReactApplicationContext());
		String[][] value = SharedDataProvider.getMultiSharedValues(keys);
		successCallback.invoke(value);

	}	

	
	@ReactMethod
	public void getAllKeys(Callback successCallback){

		SharedHandler.init(getReactApplicationContext());
		Object value = SharedDataProvider.getAllKeys();
		successCallback.invoke(value.toString());

	}	

*/

    @ReactMethod
    public void clear(){
      SharedHandler.init(getReactApplicationContext());
      SharedDataProvider.clear();
    }




}
