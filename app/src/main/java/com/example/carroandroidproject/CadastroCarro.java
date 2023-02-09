package com.example.carroandroidproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CadastroCarro extends AppCompatActivity {

    private Button botaoVoltar, botaoSalvar;
    private Uri imagemCaminho;
    private EditText marcaCarro, modeloCarro, anoCarro;
    private ImageView imagemCarro;
    private Bitmap imagemCarroBitMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carros_cadastro);

        marcaCarro = findViewById(R.id.marcaCarroText);
        modeloCarro = findViewById(R.id.modeloCarroText);
        anoCarro = findViewById(R.id.anoCarroText);
        imagemCarro = findViewById(R.id.imagemCarroGaleria);
        imagemCarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escolheImagemGaleria();
            }
        });

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
                imagem = extras.getInt("imagem");
                Intent intent= new Intent(CadastroCarro.this, MainActivity.class);
                setResult(Activity.RESULT_OK, intent);
                finish();
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

    private void escolheImagemGaleria() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/");
        startActivityForResult(intent, 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0){
            imagemCaminho = data.getData();
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imagemCaminho);
                imagemCarro.setImageBitmap(bitmap);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
