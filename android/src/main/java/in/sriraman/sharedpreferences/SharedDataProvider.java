package in.sriraman.sharedpreferences;

public class SharedDataProvider {

    private static final String TAG = "SharedDataProvider";


    public static String[] getMultiSharedValues(String[] keys) {
        SharedHandler sharedHandler = SharedHandler.getInstance();
        String[] results = new String[keys.length];
        for (int i = 0; i < keys.length; i++) {
            results[i] = sharedHandler.getString(keys[i]);
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

}
