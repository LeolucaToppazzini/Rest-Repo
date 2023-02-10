package com.heartwoodlabs.corso.model;

import java.util.ArrayList;
import java.util.List;

public class Docente {
    private Long id;
    private String nome,cognome;
    private List<Materia> listaMaterie = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public List<Materia> getListaMaterie() {
        return listaMaterie;
    }

    public void setListaMaterie(List<Materia> listaMaterie) {
        this.listaMaterie = listaMaterie;
    }
}
