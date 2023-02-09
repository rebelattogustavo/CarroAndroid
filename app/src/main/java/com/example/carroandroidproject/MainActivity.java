package com.example.carroandroidproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton botaoCadastro;
    private CarroAdapter carroAdapter;
    private RecyclerView recycler;
    public static ArrayList<Carro> carros;
    private Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.recyclerView);

        carros = new ArrayList<Carro>();

        carroAdapter = new CarroAdapter(MainActivity.this, carros, (view, item, pos) -> {
            carros.remove(pos);
            carroAdapter.notifyDataSetChanged();
        }, (view, item, pos) -> {
            Intent intent = new Intent(getApplicationContext(), TelaCarro.class);
            intent.putExtra("position", pos);
            startActivity(intent);
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(layoutManager);
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setAdapter(carroAdapter);

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            carroAdapter.notifyItemChanged(carros.size() + 1);
        }
    }


}