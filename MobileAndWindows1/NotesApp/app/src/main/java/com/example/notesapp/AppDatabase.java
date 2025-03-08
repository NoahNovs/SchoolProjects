//package com.example.notesapp;
//
//import android.content.Context;
//
//import androidx.room.Database;
//import androidx.room.Room;
//import androidx.room.RoomDatabase;
//
//@Database(entities = {newNote.class}, version = 1)
//public abstract class AppDatabase extends RoomDatabase {
//    public abstract newNoteDao noteDao();
//    private static AppDatabase noteDB;
//
//    public static AppDatabase getInstance(Context context) {
//        if (null == noteDB) {
//            noteDB = buildDatabaseInstance(context);
//        }
//        return noteDB;
//    }
//
//    private static AppDatabase buildDatabaseInstance(Context context) {
//        return Room.databaseBuilder(context,
//                        AppDatabase.class,
//                        "Note Database")
//                .allowMainThreadQueries().build();
//    }
//
//    public void cleanUp(){
//        noteDB = null;
//    }
//}
