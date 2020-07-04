package com.magie.mynotes;

import android.annotation.SuppressLint;
import android.content.Context;

public class SharedPreferences{
    private final String KEY = "Key_Name" ;
    private android.content.SharedPreferences.Editor editor;
    private android.content.SharedPreferences preferences;

    @SuppressLint("CommitPrefEdits")
    public SharedPreferences(Context context) {
        String NAME_ARCHIVE = "Notes_Preferences";
        preferences = (android.content.SharedPreferences) context.getSharedPreferences(NAME_ARCHIVE, 0);
        editor = preferences.edit();
    }

    public void SaveNotes(String notes){
        editor.putString( KEY, notes);
        editor.apply();
    }
    public String RecoverSavedNotes(){
        return preferences.getString(KEY, "");
    }

}
