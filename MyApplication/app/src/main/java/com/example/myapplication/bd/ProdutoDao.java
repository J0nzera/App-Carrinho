package com.example.myapplication.bd;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProdutoDao {

    @Insert
    void insertAll(Produto produto);

    @Query("SELECT * FROM Produto")
    List<Produto> getAll();
}