package com.example.carroandroidproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton botaoCadastro;
    private CarroAdapter adapter;
    private RecyclerView recycler;
    public static ArrayList<Carro> carros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.recyclerView);

        carros = new ArrayList<Carro>();
        carros.add(new Carro("nissan", "350z", 2004, R.drawable._50z));
        carros.add(new Carro("nissan", "r34", 1996, R.drawable._707d9c10e216316150008c9skyline_gt_r_r34));

        adapter = new CarroAdapter(MainActivity.this, carros);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(layoutManager);
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setAdapter(adapter);

        botaoCadastro = findViewById(R.id.botaoCadastro);
        botaoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCadastroCarro();
            }
        });
    }

    public void openCadastroCarro(){
        Intent intent= new Intent(this, CadastroCarro.class);
        startActivityForResult(intent, 1);
    }


}