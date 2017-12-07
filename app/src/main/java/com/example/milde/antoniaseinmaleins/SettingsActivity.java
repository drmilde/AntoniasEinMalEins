package com.example.milde.antoniaseinmaleins;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.util.Log;

import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;

public class SettingsActivity extends PreferenceActivity implements PreferenceChangeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }

    // KLAPPT NICHT ... muss nachgucken
    @Override
    public void preferenceChange(PreferenceChangeEvent preferenceChangeEvent) {
        Log.d("Jan", "Preferences modified");
    }
}
