# React Native Android Shared Preferences

Android Shared Preferences for React Native

## Installation

```bash
npm install @connected-home/react-native-android-shared-preferences --save
# or...
yarn add @connected-home/react-native-android-shared-preferences
```

## Project setup and initialization

- `android/settings.gradle`

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

### Import

```javascript
const SharedPreferences = require("react-native-android-shared-preferences");
// or...
import SharedPreferences from "react-native-android-shared-preferences";
```

### Get item

```javascript
SharedPreferences.getItem("file", "key", value => {
  ...
});
```

### Get multiple items

```javascript
SharedPreferences.getItems("file", ["key1", "key2"], values => {
  ...
});
```

### Get keys

```javascript
SharedPreferences.keys("file", keys => {
  ...
});
```

### Get entries

```javascript
SharedPreferences.entries("file", entries => {
  console.log(values);
});
```

### Set Item

```javascript
SharedPreferences.setItem("file", "key", "value");
```

### Delete Item

```javascript
SharedPreferences.deleteItem("file", "key");
```

### Clear all items

```javascript
SharedPreferences.clear("file");
```
