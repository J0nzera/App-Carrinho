package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.myapplication.bd.AppDatabase;
import com.example.myapplication.bd.Produto;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.rView);
        mRecyclerView.setHasFixedSize(true); //Tamanho do Recycler não vai mudar

        //Inicio Linear Layout
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        AppDatabase db = Room.databaseBuilder(getApplication(),
                AppDatabase.class, "database-name")
                .allowMainThreadQueries()
                .build();

        List<Produto> produtos = db.produtoDao().getAll();

        }

}
