package com.example.myapplication;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.myapplication.bd.AppDatabase;
import com.example.myapplication.bd.Produto;

import java.util.List;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.MyViewHolder> {
    private List<Produto> mList;
    private LayoutInflater mLayoutInflater;

    public ProdutoAdapter(Context c, List<Produto> l) {
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_prod, parent, false);
        MyViewHolder mvh = new MyViewHolder(v);

        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView ttnome;
        public TextView ttdesc;
        public TextView ttvalor;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ttnome = (TextView) itemView.findViewById(R.id.ttnome);
            ttdesc = (TextView) itemView.findViewById(R.id.ttdesc);
            ttvalor = (TextView) itemView.findViewById(R.id.ttvalor);
        }
    }
}
