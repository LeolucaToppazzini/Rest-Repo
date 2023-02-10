package com.heartwoodlabs.corso.model;

import java.time.LocalDate;

public class Esame {
    private Long id;
    private LocalDate data;
    private Integer voto;
    private Materia materiaEsame;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getVoto() {
        return voto;
    }

    public void setVoto(Integer voto) {
        this.voto = voto;
    }

    public Materia getMateriaEsame() {
        return materiaEsame;
    }

    public void setMateriaEsame(Materia materiaEsame) {
        this.materiaEsame = materiaEsame;
    }
}
