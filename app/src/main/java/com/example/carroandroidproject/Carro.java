package com.example.carroandroidproject;

import android.graphics.Bitmap;

public class Carro {
    private String marca, modelo;
    private int ano;
    private Bitmap imagem;

    public Carro(String marca, String modelo, int ano, Bitmap imagem) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.imagem = imagem;
    }

    public Carro() {
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Bitmap getImagem() {
        return imagem;
    }

    public void setImagem(Bitmap imagem) {
        this.imagem = imagem;
    }
}
