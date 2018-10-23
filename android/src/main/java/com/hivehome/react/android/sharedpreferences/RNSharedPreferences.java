package com.hivehome.react.android.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

public class RNSharedPreferences {

    private SharedPreferences mSharedPreferences;

    public SharedHandler(Context context, String name) {
        mSharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    public String getItemString(String key) {
        return mSharedPreferences.getString(key, null);
    }

    public Float getItemFloat(String key) {
        return mSharedPreferences.getFloat(key, 0f);
    }

    public Long getItemLong(String key) {
        return mSharedPreferences.getLong(key, 0);
    }

    public Boolean getItemBoolean(String key) {
        return mSharedPreferences.getBoolean(key, false);
    }

    public Integer getItemInt(String key) {
        return mSharedPreferences.getInt(key, 0);
    }

    public String[][] getItems(String[] keys) {
        String[][] results = new String[keys.length][2];
        for (int i = 0; i < keys.length; i++) {
            results[i][0] = keys[i];
            results[i][1] = String.valueOf(getString(keys[i]));
        }
        return results;
    }

    public String[] keys() {
        Map<String, ?> keyValues = mSharedPreferences.getAll();
        List<String> keys = new ArrayList<>(keyValues.keySet());
        String[] results = new String[keys.size()];
        for (int i = 0; i < keys.size(); i++) {
            results[i] = keys.get(i);
        }
        return results;
    }

    public String[][] entries() {
        Map<String, ?> keyValues = mSharedPreferences.getAll();
        List<String> keys = new ArrayList<>(keyValues.keySet());
        String[][] results = new String[keys.size()][2];
        for (int i = 0; i < keys.size(); i++) {
            results[i][0] = keys.get(i);
            results[i][1] = String.valueOf(keyValues.get(keys.get(i)));
        }
        return results;
    }

    public void setItem(String key, Object value) {
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

    public void deleteItem(String key) {
        mSharedPreferences.edit().remove(key).commit();
    }

    public void clear() {
        mSharedPreferences.edit().clear().commit();
    }

}
