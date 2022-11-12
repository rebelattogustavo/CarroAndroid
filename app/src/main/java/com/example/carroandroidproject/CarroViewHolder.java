package com.example.carroandroidproject;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CarroViewHolder extends RecyclerView.ViewHolder{
    TextView modelo, ano;
    ImageView imagem;

    public CarroViewHolder(@NonNull View itemView) {
        super(itemView);
        modelo.findViewById(R.id.modelo);
        ano.findViewById(R.id.ano);
        imagem.findViewById(R.id.imageCarro);
    }
}
