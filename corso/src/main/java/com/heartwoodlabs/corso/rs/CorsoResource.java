package com.heartwoodlabs.corso.rs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heartwoodlabs.corso.business.CorsoManager;
import com.heartwoodlabs.corso.business.MateriaManager;
import com.heartwoodlabs.corso.business.StudenteManager;
import com.heartwoodlabs.corso.model.Corso;
import com.heartwoodlabs.corso.model.Esame;
import com.heartwoodlabs.corso.model.Materia;
import com.heartwoodlabs.corso.model.Studente;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Path("/corsi")
public class CorsoResource {
    @GET  // GET-- lettura di una risorsa--non avendo un DB mi creo una risorsa da reperire tramite Id come se fosse su
    //un database
    @Path("/{id}")
    public Response getCorso(@PathParam("id") Long idCorso) {



        //creo due materie
        Materia materia = new Materia();
        materia.setId(1L);
        materia.setNome("Matematica");

        Materia materia1 = new Materia();
        materia1.setId(2L);
        materia1.setNome("Elettronica");

        //creo un corso e ci aggiungo le due materie sopra create

        Corso corso= new Corso();
        corso.setId(idCorso);
        corso.setNome("Informatica");
        corso.getListaMaterie().add( materia);
        corso.getListaMaterie().add( materia1);


        return Response
                .status(Response.Status.OK)
                .type(MediaType.APPLICATION_JSON)
                .entity(corso)
                .build();

    }

    @GET    //non avendo un DB di studenti--creo una lista di studenti(creo 10 cloni con un ciclo) e poi ne riottengo
    //i dati con una GET
    @Path("/")
    public Response getStudentiDb() {
        List<Corso> corsiDb = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Corso corso = CorsoManager.build((long) i);



            corsiDb.add(corso);
        }

        return Response
                .status(Response.Status.OK)
                .entity(corsiDb)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    @PUT
    @Path("/{id}/")
    @Consumes("application/json")
    public Response updateCorso(@PathParam("id") Long id, Corso corso) throws JsonProcessingException {


        CorsoManager.verifyExp(corso);
        CorsoManager.update(corso);

        return Utility.buildNoContentResponse();


    }
    @DELETE
    @Path("/{id}")
    public Response deleteCorso(@PathParam("id") Long id) {
        //boolean res = CorsoManager.delete(id);
        //if (res) {
       //     return Utility.buildNoContentResponse();
     //   }

        return Utility.buildNoContentResponse();
    }

    @PUT
    @Path("/{id}/materie")
    @Consumes("application/json")
    public Response addMaterieCorso(@PathParam("id") Long id, Materia materia) throws JsonProcessingException {

        //utilizzando in questo modo l'eccezzione, abbiamo la sicurezza che se le condizioni non vengono verificate, l'ec
        //cezzione verrà lanciata e di conseguenza le righe che la seguono non verranno eseguite e viceversa.
        MateriaManager.verifyExp(materia);
        CorsoManager.updateMateria(id,materia);


        return Utility.buildNoContentResponse();


    }
}
