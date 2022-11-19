package com.example.carroandroidproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class CarroImages extends AppCompatActivity {

    private ImageView imgR35, imgR34, imgRx7, img350Z, imgS15, imgS14, largeImage;
    private Button salvarButton, voltarButton;
    private int imagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carros_images);
        largeImage = findViewById(R.id.largeCarImage);

        imgR35 = findViewById(R.id.imagemR35);
        imgR35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                largeImage.setImageResource(R.drawable._ee03295_2020_nissan_gt_r_19_1160x773);
                imagem = 1;
            }
        });

        imgR34 = findViewById(R.id.imagemR34);
        imgR34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                largeImage.setImageResource(R.drawable._707d9c10e216316150008c9skyline_gt_r_r34);
                imagem = 2;
            }
        });

        imgRx7 = findViewById(R.id.imagemRx7);
        imgRx7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                largeImage.setImageResource(R.drawable.rx7);
                imagem = 3;
            }
        });

        img350Z = findViewById(R.id.imagem350Z);
        img350Z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                largeImage.setImageResource(R.drawable._50z);
                imagem = 4;
            }
        });

        imgS15 = findViewById(R.id.imageS15);
        imgS15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                largeImage.setImageResource(R.drawable.s15);
                imagem = 5;
            }
        });

        imgS14 = findViewById(R.id.imagemS14);
        imgS14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                largeImage.setImageResource(R.drawable.silvia_marcelo);
                imagem = 6;
            }
        });


        salvarButton = findViewById(R.id.salvarImgButton);
        salvarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarroImages.this, CadastroCarro.class);
                intent.putExtra("imagem", imagem);
                CarroImages.this.startActivity(intent);
            }
        });

        voltarButton = findViewById(R.id.voltarCadastroButton);
        voltarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
