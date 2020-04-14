package com.example.myapplication.bd;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Produto.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProdutoDao produtoDao();
}
