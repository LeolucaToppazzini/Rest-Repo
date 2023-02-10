package com.heartwoodlabs.corso.business;

import com.heartwoodlabs.corso.model.Corso;
import com.heartwoodlabs.corso.model.Esame;
import com.heartwoodlabs.corso.model.Materia;
import com.heartwoodlabs.corso.model.Studente;
import com.heartwoodlabs.corso.rs.StudenteResource;

import java.time.LocalDate;

public class StudenteManager {

    public static Studente build(Long id) {
        Studente s = new Studente();
        s.setId(id);
        s.setNome("nome " + id);
        s.setCognome("cognome " + id);
        s.setMatricola(String.valueOf(1000 + id.intValue()));
        s.setDataDiNascita(LocalDate.now().minusYears(30));

        Materia m = new Materia();
        m.setId(10 + id);
        m.setNome("Java");

        Corso c = new Corso();
        c.setId(20 + id);
        c.setNome("Corso Ecipar 2023");
        c.getListaMaterie().add(m);

        Esame e = new Esame();
        e.setId(30 + id);
        e.setData(LocalDate.now());
        e.setMateriaEsame(m);
        e.setVoto(100);

        s.getListaCorsi().add(c);
        s.getListaEsami().add(e);

        return s;
    }

    /*
    public static String verify(Studente studente) {
        if (studente.getNome() == null || studente.getListaEsami().i == null) {
            return "Manca l'iscritto";
        }

        if (iscrizione.getTorneo() == null || iscrizione.getTorneo().getId() == null) {
            return "Manca il torneo";
        }

        return null;
    }

     */

    public static void updateEsame(Long idStudente, Esame esame){
        Studente studente = build(idStudente);
        studente.getListaEsami().add(esame);
    }

    public static void updateCorso(Long idStudente, Corso corso){
        Studente studente = build(idStudente);
        studente.getListaCorsi().add(corso);
    }

    public static boolean deleteEsame(Long idStudente, Long idEsame) {
        Studente studente= build(idStudente);
        Esame esame= null;
        for (Esame e : studente.getListaEsami()){
            if(e.getId().equals(idEsame)){
                e = esame;
            }
        }
        if(esame != null){
            studente.getListaEsami().remove(esame);
            return true;
        }
        return false;
    }
}
