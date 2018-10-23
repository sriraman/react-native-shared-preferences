# React Native Shared Preferences

Android's Native key value storage system in React Native

## Installation

```bash
npm install @connected-home/react-native-android-shared-preferences--save
```

## Project setup and initialization

- In `android/settings.gradle`

```gradle
...
include ':react-native-android-shared-preferences', ':app'
project(':react-native-android-shared-preferences').projectDir = new File(rootProject.projectDir, '../node_modules/@connected-home/react-native-android-shared-preferences/android')
```

- In `android/app/build.gradle`

```gradle
...
dependencies {
    /* YOUR DEPENDENCIES HERE */
    compile "com.facebook.react:react-native:+"
    compile project(":react-native-android-shared-preferences") // <--- add this
}
```

- Register Module (in MainApplication.java)

```java
import com.hivehome.react.android.sharedpreferences.RNSharedPreferencesReactPackage;

public class MainActivity extends ReactActivity {
  ...

  @Override
  protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          ...
          new RNSharedPreferencesReactPackage()
      );
  }

  ...
}
```

## Usage

#### Import

```javascript
const SharedPreferences = require("react-native-android-shared-preferences");
```

#### Set Item

```javascript
SharedPreferences.setItem("file", "key", "value");
```

#### Get an value

```javascript
SharedPreferences.getItem("file", "key", function(value) {
  console.log(value);
});
```

#### Get multiple items

```javascript
SharedPreferences.getItems("file", ["key1", "key2"], function(values) {
  console.log(values);
});
```

#### Get all keys - returns promise with array of keys

```javascript
SharedPreferences.keys("file", function(keys) {
  console.log(keys);
});
```

#### Get all values

```javascript
SharedPreferences.entries("file", function(values) {
  console.log(values);
});
```

#### Remove Item

```javascript
SharedPreferences.deleteItem("key");
```

#### Clear all values

```javascript
SharedPreferences.clear();
```
