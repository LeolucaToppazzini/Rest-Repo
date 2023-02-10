package com.heartwoodlabs.corso.business;

import com.heartwoodlabs.corso.model.Corso;
import com.heartwoodlabs.corso.model.Esame;
import com.heartwoodlabs.corso.model.Materia;
import com.heartwoodlabs.corso.model.Studente;

import java.time.LocalDate;

public class CorsoManager {
    public static Corso build(Long id) {

        //creo due materie
        Materia materia = MateriaManager.build(id);


        Materia materia1 = new Materia();
        materia1.setId(2L);
        materia1.setNome("Elettronica");

        //creo un corso e ci aggiungo le due materie sopra create

        Corso corso= new Corso();
        corso.setId(id);
        corso.setNome("Informatica");
        corso.getListaMaterie().add( materia);
        corso.getListaMaterie().add( materia1);

        return corso;
    }
    public static void verifyExp(Corso corso) throws CorsoException{
        if (corso.getNome() == null || corso.getNome().isBlank()) {
            throw new CorsoException("nome non valido");
        }

    }

    public static Long insert(Corso corso) {
        // TODO insert
        return 5768L;
    }

    public static void update(Corso corso) {
        // TODO update

    }

    public static void updateMateria(Long id, Materia materia){
        Corso corso = CorsoManager.build(id);
        corso.getListaMaterie().add(materia);


    }
}
