package com.example.myapplication.bd;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Produto {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String nomeprod;
    public String descprod;
    public String valorprod;
}
