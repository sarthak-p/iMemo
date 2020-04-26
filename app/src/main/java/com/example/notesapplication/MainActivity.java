package com.example.notesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //creating an arrayList that links to listView
    ArrayList<String> setOfNotes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //links to the list_view
        ListView list = (ListView) findViewById(R.id.list_view);

        //first note
        setOfNotes.add("firstNote");

        //arrayAdapter holds on to the set of notes, without this the list_view is useless
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, setOfNotes);

        list.setAdapter(adapter);



    }
}
