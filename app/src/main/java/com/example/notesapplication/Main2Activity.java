package com.example.notesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //shows the text for the note the user clicked on
        EditText text = (EditText) findViewById(R.id.editText3);

        //getting the noteId
        Intent intent = getIntent();
        int noteId = intent.getIntExtra("noteId", -1);

        if (noteId != -1) {
            text.setText(MainActivity.setOfNotes.get(noteId));
        }
    }
}
