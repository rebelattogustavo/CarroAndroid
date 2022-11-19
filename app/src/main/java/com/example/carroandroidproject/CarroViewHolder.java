package com.example.carroandroidproject;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CarroViewHolder extends RecyclerView.ViewHolder{
    TextView marca, modelo, ano;
    ImageView imagem;

    public CarroViewHolder(@NonNull View itemView) {
        super(itemView);
        marca = itemView.findViewById(R.id.marca);
        modelo = itemView.findViewById(R.id.modelo);
        ano = itemView.findViewById(R.id.ano);
        imagem = itemView.findViewById(R.id.imageCarro);
    }
}
