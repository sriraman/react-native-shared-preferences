package com.hivehome.react.android.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

public class RNSharedPreferences {

    private SharedPreferences sharedPreferences;

    public SharedHandler(Context context, String name) {
        sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    public String getItem(String key) {
        return sharedPreferences.getItem(key, null);
    }

    public String[] getItems(String[] keys) {
        String[] results = new String[keys.length];
        for (int i = 0; i < keys.length; i++) {
            results[i] = getItem(keys[i]);
        }
        return results;
    }

    public String[] keys() {
        Map<String, ?> all = sharedPreferences.getAll();
        Set<String> keySet = all.keySet();
        String[] keys = keySet.toArray(new String[keySet.size()]);
        return keys;
    }

    public String[][] entries() {
        Map<String, ?> all = sharedPreferences.getAll();
        Set<Entry<String, ?>> entrySet = all.entrySet();

        String[][] entries = new String[entrySet.size()][2];
        for (int i = 0; i < entrySet.size(); i++) {
            entries[i][0] = entrySet[i].getKey();
            entries[i][1] = String.valueOf(entrySet[i].getValue());
        }

        return entries;
    }

    public void setItem(String key, Object value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
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
        sharedPreferences.edit().remove(key).commit();
    }

    public void clear() {
        sharedPreferences.edit().clear().commit();
    }

}
