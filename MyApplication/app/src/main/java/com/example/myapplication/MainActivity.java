package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.myapplication.bd.AppDatabase;
import com.example.myapplication.bd.Produto;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rView);

        ProdutoAdapter adapter = new ProdutoAdapter();
        recyclerView.setAdapter(adapter);

        AppDatabase db = Room.databaseBuilder(getApplication(),
                AppDatabase.class, "database-name")
                .allowMainThreadQueries()
                .build();

        List<Produto> produtos = db.produtoDao().getAll();

        adapter.setProdutos(produtos);

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

                AppDatabase.getConnection(getApplicationContext()).produtoDao().insertAll(produto);

                produto = new Produto();
                produto.nomeprod = "Xbox";
                produto.descprod = "Descrição do Produto";
                produto.valorprod = "999,999";

                AppDatabase.getConnection(getApplicationContext()).produtoDao().insertAll(produto);

                produto = new Produto();
                produto.nomeprod = "Computador";
                produto.descprod = "Descrição do Produto";
                produto.valorprod = "999,999";

                AppDatabase.getConnection(getApplicationContext()).produtoDao().insertAll(produto);

                produto = new Produto();
                produto.nomeprod = "Notebook";
                produto.descprod = "Descrição do Produto";
                produto.valorprod = "999,999";

                AppDatabase.getConnection(getApplicationContext()).produtoDao().insertAll(produto);

            }
        }.start();
    }


}
