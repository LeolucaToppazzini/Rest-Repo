package com.heartwoodlabs.corso.model;

import java.util.ArrayList;
import java.util.List;

public class Corso {
    private String nome;
    private Long id;
    private List<Materia> listaMaterie = new ArrayList<>();



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Materia> getListaMaterie() {
        return listaMaterie;
    }

    public void setListaMaterie(List<Materia> listaMaterie) {
        this.listaMaterie = listaMaterie;
    }
}
