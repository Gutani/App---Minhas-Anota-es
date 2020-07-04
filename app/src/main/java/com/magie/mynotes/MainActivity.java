package com.magie.mynotes;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editNote;
    private SharedPreferences preferential;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNote = findViewById(R.id.editNote);
        preferential = new SharedPreferences(getApplicationContext());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(editNote.getText().toString().equals("")){
                    Snackbar.make(view, "Digite alguma coisa...", Snackbar.LENGTH_LONG).show();
                }else{
                    preferential.SaveNotes(editNote.getText().toString());
                    Snackbar.make(view, "Notas salvas com sucesso!", Snackbar.LENGTH_LONG).show();
                }

            }
        });
        if(!preferential.RecoverSavedNotes().equals("")){
            editNote.setText(preferential.RecoverSavedNotes());
        }


    }

}