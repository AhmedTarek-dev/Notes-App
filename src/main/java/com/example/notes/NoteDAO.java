package com.example.notes;


import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NoteDAO  {

    @Insert(onConflict = REPLACE)
    void insert(Notes notes);


    @Query("SELECT * FROM notes")
    List<Notes> getAll();

    @Query("UPDATE notes SET title= :title, notes= :notes WHERE ID= :id")
    void update(int id, String title,String notes);

    @Delete
    void delete(Notes notes);

}
