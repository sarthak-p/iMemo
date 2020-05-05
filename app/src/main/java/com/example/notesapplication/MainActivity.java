package com.example.notesapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //creating an arrayList that links to listView
    static ArrayList<String> setOfNotes = new ArrayList<>();
    static ArrayAdapter adapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_notes, menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem i) {
        super.onOptionsItemSelected(i);
        if (i.getItemId() == R.id.new_note) {
            Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
            startActivity(intent);
            return true;
        }
        return false;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //links to the list_view
        ListView list = (ListView) findViewById(R.id.list_view);

        //arrayAdapter holds on to the set of notes, calls on toString() to display each note
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, setOfNotes);
        //set the adapter to our list view
        list.setAdapter(adapter);

        //when each note is clicked, it takes it to a new activity where the user can edit it
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent main2Act = new Intent(getApplicationContext(), Main2Activity.class);
                main2Act.putExtra("noteId", position);
                startActivity(main2Act);
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int i = position;
                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(android.R.drawable.ic_delete)
                        .setTitle("This cannot be reverted")
                        .setMessage("Are you sure?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                setOfNotes.remove(i);
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                return true;
            }
        });



        /* new ItemTouchHelper(new ItemTouchHelper.SimpleCallback()) {
            @Override
            public boolean onMove(RecyclerView.ViewHolder vi);
        } */

    }
}
