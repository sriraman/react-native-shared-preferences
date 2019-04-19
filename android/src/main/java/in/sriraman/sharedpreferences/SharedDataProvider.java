package in.sriraman.sharedpreferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SharedDataProvider {

    public static String[][] getMultiSharedValues(String[] keys) {
        SharedHandler sharedHandler = SharedHandler.getInstance();
        String[][] results = new String[keys.length][2];
        for (int i = 0; i < keys.length; i++) {
            results[i][0] = keys[i];
            results[i][1] = String.valueOf(sharedHandler.getString(keys[i]));
        }
        return results;
    }

    public static String[][] getAllSharedValues() {
        Map<String, ?> keyValues = SharedHandler.getInstance().getAllSharedData();
        List<String> keys = new ArrayList<>(keyValues.keySet());
        String[][] results = new String[keys.size()][2];
        for (int i = 0; i < keys.size(); i++) {
            results[i][0] = keys.get(i);
            results[i][1] = String.valueOf(keyValues.get(keys.get(i)));
        }
        return results;
    }

    public static String[] getAllKeys() {
        Map<String, ?> keyValues = SharedHandler.getInstance().getAllSharedData();
        List<String> keys = new ArrayList<>(keyValues.keySet());
        String[] results = new String[keys.size()];
        for (int i = 0; i < keys.size(); i++) {
            results[i] = keys.get(i);
        }
        return results;
    }

    public static String getSharedValue(String key) {
        return SharedHandler.getInstance().getString(key);
    }

    public static void putSharedValue(String key, String value) {
        SharedHandler.getInstance().putExtra(key, value);
    }

    public static void clear() {
        SharedHandler.getInstance().clear();
    }

    public static void deleteSharedValue(String key) {
        SharedHandler.getInstance().deleteKey(key);
    }

}
