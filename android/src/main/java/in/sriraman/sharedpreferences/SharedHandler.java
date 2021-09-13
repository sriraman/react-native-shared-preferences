package in.sriraman.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

public class SharedHandler {

    private SharedPreferences mSharedPreferences;

    private String mName;

    private static SharedHandler sSharedHandler;

    public SharedHandler(Context context, String name) {
        mName = name;
        mSharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    public static SharedHandler getInstance() {
        return sSharedHandler;
    }

    public static void init(Context context, String name) {
        if (sSharedHandler == null || !name.equals(sSharedHandler.getName())) {
            sSharedHandler = new SharedHandler(context, name);
        }
    }

    public String getName() {
        return mName;
    }

    public void putExtra(String key, Object value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        if (value instanceof String) {
            editor.putString(key, (String) value).commit();
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value).commit();
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value).commit();
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value).commit();
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value).commit();
        }
    }

    public String getString(String key) {
        return mSharedPreferences.getString(key, null);
    }

    public Float getFloat(String key) {
        return mSharedPreferences.getFloat(key, 0f);
    }

    public Long getLong(String key) {
        return mSharedPreferences.getLong(key, 0);
    }

    public Boolean getBoolean(String key) {
        return mSharedPreferences.getBoolean(key, false);
    }

    public Integer getInt(String key) {
        return mSharedPreferences.getInt(key, 0);
    }

    public void clear() {
        mSharedPreferences.edit().clear().commit();
    }

    public Map<String, ?> getAllSharedData(){
        return mSharedPreferences.getAll();
    }

    public void deleteKey(String key) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.remove(key);
        editor.commit();
    }

}
