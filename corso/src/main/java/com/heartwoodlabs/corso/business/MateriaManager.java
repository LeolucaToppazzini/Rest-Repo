package com.heartwoodlabs.corso.business;

import com.heartwoodlabs.corso.model.Corso;
import com.heartwoodlabs.corso.model.Materia;

public class MateriaManager {
    public static Materia build(Long id) {
        //creo due materie
        Materia materia = new Materia();
        materia.setId(id);
        materia.setNome("Matematica");

        return materia;
    }

    public static void verifyExp(Materia materia) throws MateriaException{
        if (materia.getNome() == null || materia.getNome().isBlank()) {
            throw new MateriaException("Nome non valido");
        }

    }
}
