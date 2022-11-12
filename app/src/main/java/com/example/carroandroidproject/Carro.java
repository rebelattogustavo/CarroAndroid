package com.example.carroandroidproject;

public class Carro {
    private String modelo, ano;
    private int imagem;

    public Carro(String modelo, String ano, int imagem) {
        this.modelo = modelo;
        this.ano = ano;
        this.imagem = imagem;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
