package br.com.escalacao.domain;

import android.view.View;

/**
 * Created by pablo on 12/07/15.
 */
public class Player {

    private int id;
    private String nome;
    private String apelido;
    private String posicao;

    public Player(String nome, String apelido, String posicao) {
        this.nome = nome;
        this.apelido = apelido;
        this.posicao = posicao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }
}
