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

    public CarroAdapter(Context context, ArrayList<Carro> carros) {
        this.context = context;
        this.carros = carros;
    }

    @NonNull
    @Override
    public CarroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.carros_list_layout, parent, false);
        CarroViewHolder atletaViewHolder = new CarroViewHolder(view);
        return atletaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CarroViewHolder carroViewHolder, int position) {
        Carro carro = carros.get(position);
        carroViewHolder.modelo.setText(carro.getModelo());
        carroViewHolder.ano.setText(carro.getAno());
        carroViewHolder.imagem.setImageResource(carro.getImagem());
//        carroViewHolder.modelo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "Clicou em: " + atleta.getNome(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
