package com.example.myapplication.bd;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Produto.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProdutoDao produtoDao();


    public static AppDatabase getConnection(Context appContext) {
        return Room.databaseBuilder(appContext,
                AppDatabase.class, "database-name").build();
    }
}

