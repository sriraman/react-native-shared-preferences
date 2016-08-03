# React Native Shared Preferences

Android's Native key value storage system in React Native

## Installation

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
    compile "com.facebook.react:react-native:0.18.+"
    compile project(":react-native-shared-preferences") // <--- add this
}

```

* Register Module (in MainActivity.java)

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

#### Clear all values

```javascript
SharedPreferences.clear();
```


## Credits

[Sujith Niraikulathan](http://bit.ly/sujithkanna "Sujith").
