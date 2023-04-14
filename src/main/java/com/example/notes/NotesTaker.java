package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NotesTaker extends AppCompatActivity {
    Notes notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_taker);
        Button button;
           EditText edt_title=findViewById(R.id.edt_title);
           EditText edt_note=findViewById(R.id.edt_note);
           //Notes notes;
           button=findViewById(R.id.button);
           button.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   String title=edt_title.getText().toString() ;
                   String note=edt_note.getText().toString();
                   if(title.isEmpty()||note.isEmpty()){

                       Toast.makeText(NotesTaker.this, "wrong input", Toast.LENGTH_SHORT).show();
                   }
                   else {               //add notes




                       // add to room
                       new Thread(new Runnable() {
                           @Override
                           public void run() {
                               notes =new Notes();
                               notes.setTitle(title);
                               notes.setNotes(note);
                               RoomDB Builder = RoomDB.getInstance(getApplication());
Builder.noteDAO().insert(notes);
                           }
                       }).start();
                       /////////////////////////
startActivity(new Intent(NotesTaker.this,MainScreen.class));


                   }


               }
           });

    }
}