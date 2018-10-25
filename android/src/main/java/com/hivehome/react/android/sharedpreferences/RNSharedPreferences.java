package com.hivehome.react.android.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class RNSharedPreferences {

    private SharedPreferences sharedPreferences;

    RNSharedPreferences(Context context, String name) {
        sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    String getItem(String key) {
        return sharedPreferences.getString(key, null);
    }

    List<String> getItems(String[] keys) {
        List<String> results = new ArrayList<>();
        for (String key: keys) {
            results.add(getItem(key));
        }
        return results;
    }

    Set<String> keys() {
        return sharedPreferences.getAll().keySet();
    }

    Map<String, ?> entries() {
        return sharedPreferences.getAll();
    }

    void setItem(String key, Object value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (value instanceof String) {
            editor.putString(key, (String)value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        }
        editor.apply();
    }

    void deleteItem(String key) {
        sharedPreferences.edit().remove(key).apply();
    }

    void clear() {
        sharedPreferences.edit().clear().apply();
    }
}
