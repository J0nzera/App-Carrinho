package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import com.example.myapplication.bd.AppDatabase;
import com.example.myapplication.bd.Produto;

import java.util.List;

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

                List<Produto> produtos = db.produtoDao().getAll();
                Produto produto = produtos.get(0);
                System.out.println(produto.nomeprod);
                System.out.println(produto.descprod);
                System.out.println(produto.valorprod);

                }
        }.start();
    }

}
