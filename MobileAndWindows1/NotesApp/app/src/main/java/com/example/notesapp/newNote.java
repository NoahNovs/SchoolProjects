package com.example.notesapp;

import java.sql.Timestamp;

public class newNote {

    private String noteTitle;
    private String noteContent;

    public newNote(String noteTitle, String noteContent)
    {
        this.noteContent = noteContent;
        this.noteTitle = noteTitle;
    }

    public newNote(){

    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }
}

