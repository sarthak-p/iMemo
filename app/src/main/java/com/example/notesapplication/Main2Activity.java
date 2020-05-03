package com.example.notesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import static com.example.notesapplication.R.layout.activity_main2;


public class Main2Activity extends AppCompatActivity {

    int noteId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main2);

        //shows the text for the note the user clicked on
        EditText text = (EditText) findViewById(R.id.editText3);

        //getting the noteId
        Intent intent = getIntent();
        noteId = intent.getIntExtra("noteId", -1);

        if (noteId != -1) {
            text.setText(MainActivity.setOfNotes.get(noteId));
        } else {
            MainActivity.setOfNotes.add("");
            noteId = MainActivity.setOfNotes.size() - 1;
            MainActivity.adapter.notifyDataSetChanged();
        }

        //
        text.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.setOfNotes.set(noteId, String.valueOf(s));
                MainActivity.adapter.notifyDataSetChanged();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
