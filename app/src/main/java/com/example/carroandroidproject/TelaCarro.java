package com.example.carroandroidproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mikhaellopez.circularimageview.CircularImageView;

public class TelaCarro extends AppCompatActivity {
    TextView marcaCarroClica, modeloCarroClica, anoCarroClica;
    Button voltarButtonCarro;
    CircularImageView imagemCarroClica;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_carro);

        Intent intent = getIntent();
        Integer pos = intent.getIntExtra("position", 0);

        imagemCarroClica = findViewById(R.id.imagemCarroClica);
        marcaCarroClica = findViewById(R.id.marcaCarroClica);
        modeloCarroClica = findViewById(R.id.modeloCarroClica);
        anoCarroClica = findViewById(R.id.anoCarroClica);
        voltarButtonCarro = findViewById(R.id.voltarButtonCarro);

        imagemCarroClica.setImageBitmap(MainActivity.carros.get(pos).getImagem());
        marcaCarroClica.setText(MainActivity.carros.get(pos).getMarca());
        modeloCarroClica.setText(MainActivity.carros.get(pos).getModelo());
        anoCarroClica.setText(String.valueOf(MainActivity.carros.get(pos).getAno()));

        voltarButtonCarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
