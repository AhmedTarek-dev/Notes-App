package com.example.notes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.notes.databinding.FragmentHomeBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements NotesClickListener {

    RecyclerView recyclerView;
    NoteListAdapter notesListAdapter;
    List<Notes> notes = new ArrayList<>();
    RoomDB database;
    FloatingActionButton note_add;
    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragView = inflater.inflate(R.layout.fragment_home, container, false);
        binding = FragmentHomeBinding.bind(fragView);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = binding.recycleviewHome;///////
        note_add = binding.addnote;//////////

        binding.addnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), NotesTaker.class));
                //startActivityForResult(new Intent(getActivity(),NotesTaker.class, 101);
                Intent intebt = new Intent(getActivity(), NotesTaker.class);
                //startActivityForResult(intebt,101);     //send data
                //////////////////////////////

            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                RoomDB builder = RoomDB.getInstance(getContext());
                List<Notes> list = builder.noteDAO().getAll();
                NoteListAdapter adapter = new NoteListAdapter(getActivity(), list,HomeFragment.this);


                // to access views in main thread from background thread we need to this function
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        binding.recycleviewHome.setLayoutManager(new LinearLayoutManager(getActivity()));
                        binding.recycleviewHome.setAdapter(adapter);
                    }
                });
            }
        }).start();


    }

  


    private void updateRecycler(List<Notes> notes) {/////delete it


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        notesListAdapter = new NoteListAdapter(getActivity(), notes, notesClickListener);
        recyclerView.setAdapter(notesListAdapter);
    }

    private final NotesClickListener notesClickListener = new NotesClickListener() {
        @Override
        public void onClick(Notes notes) {

        }

        @Override
        public void onLongClick(Notes notes, CardView cardview) {

        }
    };

    @Override
    public void onClick(Notes notes) {

    }

    @Override
    public void onLongClick(Notes notes, CardView cardview) {

    }
}