package com.heartwoodlabs.corso.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Studente {
    private String nome, cognome ;
    private Long id;
    private LocalDate dataDiNascita;
    private String matricola;

    private List<Corso> listaCorsi = new ArrayList<>();
    private List<Esame> listaEsami = new ArrayList<>();

    public Studente() {
    }

    public Studente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public List<Esame> getListaEsami() {
        return listaEsami;
    }

    public void setListaEsami(List<Esame> listaEsami) {
        this.listaEsami = listaEsami;
    }

    public List<Corso> getListaCorsi() {
        return listaCorsi;
    }

    public void setListaCorsi(List<Corso> listaCorsi) {
        this.listaCorsi = listaCorsi;
    }



}
