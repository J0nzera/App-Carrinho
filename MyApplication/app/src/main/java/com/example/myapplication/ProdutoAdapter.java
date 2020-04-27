package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.myapplication.bd.AppDatabase;
import com.example.myapplication.bd.Produto;

import java.util.List;

public class ProdutoAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<Produto> mList;

    void setProdutos(List<Produto> produtos) {
        this.mList = produtos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_prod, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.ttnome.setText(mList.get(position).nomeprod);
        holder.ttdesc.setText(mList.get(position).descprod);
        holder.ttvalor.setText(mList.get(position).valorprod);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

}
