# React Native Shared Preferences

Android's Native key value storage system in React Native

## Installation

### < RN 0.47
```bash
npm install react-native-shared-preferences@0.0.8 --save
```

### >= RN 0.47
```bash
npm install react-native-shared-preferences --save
```

## Project setup and initialization


* In `android/settings.gradle`

```gradle
...
include ':react-native-shared-preferences', ':app'
project(':react-native-shared-preferences').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-shared-preferences/android')
```

* In `android/app/build.gradle`

```gradle
...
dependencies {
    /* YOUR DEPENDENCIES HERE */
    compile "com.facebook.react:react-native:+"
    compile project(":react-native-shared-preferences") // <--- add this
}

```

* Register Module (in MainApplication.java)

```java
import in.sriraman.sharedpreferences.RNSharedPreferencesReactPackage;  // <--- import

public class MainActivity extends ReactActivity {
  ......

  @Override
  protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
          new RNSharedPreferencesReactPackage() // <--- Add this
      );
  }

  ......

}
```


## Usage

#### Import

```javascript
var SharedPreferences = require('react-native-shared-preferences');
```

#### Set Item

```javascript
SharedPreferences.setItem("key","value");
```

#### Get an value

```javascript
SharedPreferences.getItem("key", function(value){
  console.log(value);
});
```

#### Get multiple items

```javascript
SharedPreferences.getItems(["key1","key2"], function(values){
  console.log(values)
});
```

#### Get all values

```javascript
SharedPreferences.getAll(function(values){
  console.log(values);
});
```

#### Clear all values

```javascript
SharedPreferences.clear();
```

#### Get all keys - returns promise with array of keys
```javascript
SharedPreferences.getAllKeys(function(keys){
  console.log(keys);
});
```

#### Remove Item

```javascript
SharedPreferences.removeItem("key");
```

## Credits

[Sujith Niraikulathan](http://bit.ly/sujithkanna "Sujith").
