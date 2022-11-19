package com.example.carroandroidproject;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroCarro extends AppCompatActivity {

    private Button botaoEscolherImg, botaoVoltar, botaoSalvar;
    private EditText marcaCarro, modeloCarro, anoCarro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carros_cadastro);

        botaoEscolherImg = findViewById(R.id.escolherImgButton);
        botaoEscolherImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagesCarros();
            }
        });

        marcaCarro = findViewById(R.id.marcaCarroText);
        modeloCarro = findViewById(R.id.modeloCarroText);
        anoCarro = findViewById(R.id.anoCarroText);

        botaoSalvar = findViewById(R.id.salvarButton);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Carro carro = new Carro();
                carro.setMarca(marcaCarro.getText().toString());
                carro.setModelo(modeloCarro.getText().toString());
                carro.setAno(Integer.parseInt(anoCarro.getText().toString()));

                Bundle extras = getIntent().getExtras();
                int imagem = 0;

                if (extras != null) {
                    imagem = extras.getInt("name");
                    // and get whatever type user account id is
                }
                switch (imagem){
                    case 1:
                        carro.setImagem(R.drawable._ee03295_2020_nissan_gt_r_19_1160x773);
                        break;
                    case 2:
                        carro.setImagem(R.drawable._707d9c10e216316150008c9skyline_gt_r_r34);
                        break;
                    case 3:
                        carro.setImagem(R.drawable.rx7);
                        break;
                    case 4:
                        carro.setImagem(R.drawable._50z);
                        break;
                    case 5:
                        carro.setImagem(R.drawable.s15);
                        break;
                    case 6:
                        carro.setImagem(R.drawable.silvia_marcelo);
                        break;
                }
                MainActivity.carros.add(carro);
                Intent intent= new Intent(CadastroCarro.this, MainActivity.class);
                startActivity(intent);
            }
        });

        botaoVoltar = findViewById(R.id.voltarButton);
        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void openImagesCarros(){
        Intent intent= new Intent(this, CarroImages.class);
        startActivity(intent);
    }
}
