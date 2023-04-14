package com.example.notes;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "notes")
public class Notes implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int ID;

    @ColumnInfo(name="title")
    String title;

    @ColumnInfo(name="notes")
    String notes;
    @ColumnInfo(name="image")
    int image;

    @ColumnInfo(name="pin")
    boolean pin=false;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setPin(boolean pin) {
        this.pin = pin;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }

    public String getNotes() {
        return notes;
    }

}
