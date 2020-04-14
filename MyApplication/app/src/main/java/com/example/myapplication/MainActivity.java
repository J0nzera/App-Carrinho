package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.myapplication.bd.AppDatabase;
import com.example.myapplication.bd.Produto;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = Room.databaseBuilder(getApplication(),
                AppDatabase.class, "database-name").build();

    }

   public void carregar (View view) {
        new Thread() {

            @Override
                    public void run () {

                List<Produto> produtos = db.produtoDao().getAll();
                TextView textView = findViewById(R.id.ttnome);
                TextView textView1 = findViewById(R.id.ttdesc);
                TextView textView2 = findViewById(R.id.ttvalor);

                Produto produto = produtos.get(0);
                textView.setText(produto.nomeprod);
                textView1.setText(produto.descprod);
                textView2.setText(produto.valorprod);

            }
        }.start();
   }

}
