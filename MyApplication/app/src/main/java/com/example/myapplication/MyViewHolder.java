package com.example.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView ttnome;
    TextView ttdesc;
    TextView ttvalor;

    MyViewHolder(@NonNull View itemView) {
        super(itemView);

        ttnome = itemView.findViewById(R.id.ttnome);
        ttdesc = itemView.findViewById(R.id.ttdesc);
        ttvalor = itemView.findViewById(R.id.ttvalor);
    }
}