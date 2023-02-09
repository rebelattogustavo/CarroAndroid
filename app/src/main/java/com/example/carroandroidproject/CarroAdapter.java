package com.example.carroandroidproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarroAdapter extends RecyclerView.Adapter<CarroViewHolder> {

    private Context context;
    private ArrayList<Carro> carros;
    private MyClick deleteClick;
    private MyClick openClick;

    public CarroAdapter(Context context, ArrayList<Carro> carros, MyClick deleteClick, MyClick openClick) {
        this.context = context;
        this.carros = carros;
        this.deleteClick = deleteClick;
        this.openClick = openClick;
    }

    @NonNull
    @Override
    public CarroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.carros_list_layout, parent, false);
        CarroViewHolder carroViewHolder = new CarroViewHolder(view);
        return carroViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CarroViewHolder carroViewHolder, int position) {
        Carro carro = carros.get(position);
        carroViewHolder.marca.setText(carro.getMarca());
        carroViewHolder.modelo.setText(carro.getModelo());
        carroViewHolder.ano.setText(Integer.toString(carro.getAno()));
        carroViewHolder.imagem.setImageBitmap(carro.getImagem());
        carroViewHolder.delete.setOnClickListener(view -> deleteClick.click(view, carros.get(position), position));
        carroViewHolder.cardView.setOnClickListener(view -> openClick.click(view, carros.get(position), position));
    }

    @Override
    public int getItemCount() {
        return carros.size();
    }
}
