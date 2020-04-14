package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import com.example.myapplication.bd.AppDatabase;
import com.example.myapplication.bd.Produto;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bancoDb();
    }

    public void bancoDb() {
        new Thread() {

            @Override
            public void run() {

                AppDatabase db = Room.databaseBuilder(getApplication(),
                        AppDatabase.class, "database-name").build();

                Produto produto = new Produto();
                produto.nomeprod = "Playstation";
                produto.descprod = "Descrição do Produto";
                produto.valorprod = "999,999";

                db.produtoDao().insertAll(produto);

                }
        }.start();
    }

}
