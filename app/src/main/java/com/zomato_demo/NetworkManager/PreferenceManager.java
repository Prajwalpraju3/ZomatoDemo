package com.zomato_demo.NetworkManager;

import android.content.Context;
import android.content.SharedPreferences;

import com.zomato_demo.common.Const;


public class PreferenceManager {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public PreferenceManager(Context context) {
        if (context != null) {
            preferences = context.getSharedPreferences(Const.SHARED_PREF, Context.MODE_PRIVATE);
            editor = preferences.edit();
        }
    }

    public void clearAllPrefData() {
        editor.clear().apply();
    }

}
