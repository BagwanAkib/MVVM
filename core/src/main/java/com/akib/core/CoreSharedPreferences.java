package com.akib.core;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Bagwan Akib on 5/17/2020. for com.akibbagwan.h_helper
 */
public class CoreSharedPreferences {

    private static CoreSharedPreferences instance;
    private SharedPreferences sharedPreferences;

    public CoreSharedPreferences(Context context) {
        instance = this;
        sharedPreferences = context.getSharedPreferences(Const.NAME, Context.MODE_PRIVATE);
    }

    public static CoreSharedPreferences getInstance() {
        if (instance == null) {
            throw new NullPointerException("CoreSharedHelper was not initialized!");
        }
        return instance;
    }

    private void savePref(String key, Object value) {
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        // delete(key);

        if (value instanceof Boolean) {
            sharedPreferencesEditor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Integer) {
            sharedPreferencesEditor.putInt(key, (Integer) value);
        } else if (value instanceof Float) {
            sharedPreferencesEditor.putFloat(key, (Float) value);
        } else if (value instanceof Long) {
            sharedPreferencesEditor.putLong(key, (Long) value);
        } else if (value instanceof String) {
            sharedPreferencesEditor.putString(key, (String) value);
        } else if (value instanceof Enum) {
            sharedPreferencesEditor.putString(key, value.toString());
        } else if (value != null) {
            throw new RuntimeException("Attempting to save non-primitive preference");
        }

        sharedPreferencesEditor.apply();
    }

    private <T> T getPref(String key, T defValue) {
        T returnValue = (T) sharedPreferences.getAll().get(key);
        return returnValue == null ? defValue : returnValue;
    }

    public String getString(String Key, String defaultString) {
        return getPref(Key, defaultString);
    }

    public void saveString(String Key, String value) {
        savePref(Key, value);
    }
}
