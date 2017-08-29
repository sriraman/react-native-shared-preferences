package in.sriraman.sharedpreferences;

import com.facebook.react.ReactPackage;
import in.sriraman.sharedpreferences.RNSharedPreferencesModule;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewManager;

/**
 *  allows JS to show an Android Toast.
 */
public class RNSharedPreferencesReactPackage implements ReactPackage {



  @Override
  public List<NativeModule> createNativeModules(
                              ReactApplicationContext reactContext) {
    List<NativeModule> modules = new ArrayList<>();

    modules.add(new RNSharedPreferencesModule(reactContext));

    return modules;
  }


  @Override
  public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
      List<ViewManager> result = new ArrayList<ViewManager>();
      return result;
  }

}
