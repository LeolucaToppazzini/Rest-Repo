package com.heartwoodlabs.corso.rs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.heartwoodlabs.corso.business.StudenteManager;
import com.heartwoodlabs.corso.model.Corso;
import com.heartwoodlabs.corso.model.Esame;
import com.heartwoodlabs.corso.model.Materia;
import com.heartwoodlabs.corso.model.Studente;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Path("/studenti")
public class StudenteResource {
    @GET  // GET-- lettura di una risorsa--non avendo un DB mi creo una risorsa da reperire tramite Id come se fosse su
                    //un database
    @Path("/{id}")
    public Response getStudente(@PathParam("id") Long idStudente) {



        //creo due materie
        Materia materia = new Materia();
        materia.setId(1L);
        materia.setNome("Matematica");

        Materia materia1 = new Materia();
        materia1.setId(2L);
        materia1.setNome("Elettronica");

        //creo un corso e ci aggiungo le due materie sopra create

        Corso corso= new Corso();
        corso.setId(1L);
        corso.setNome("Informatica");
        corso.getListaMaterie().add( materia);
        corso.getListaMaterie().add( materia1);

        //creo esame, con come materia la prima che ho creato
        Esame esame= new Esame();
        esame.setId(1L);
        esame.setData(LocalDate.of(2023, 01, 01));
        esame.setVoto(100);
        esame.setMateriaEsame(materia);

        //creo studente
        Studente studente= new Studente();
        studente.setNome("Gianfrangiorgio");
        studente.setCognome("soumaouru");
        studente.setMatricola("12R3");
        studente.setId(idStudente);
        studente.setDataDiNascita(LocalDate.of(1991, 05,17));
        studente.getListaCorsi().add(corso);
        studente.getListaEsami().add(esame);




        return Response
                .status(Response.Status.OK)
                .type(MediaType.APPLICATION_JSON)
                .entity(studente)
                .build();

    }
    @GET    //non avendo un DB di studenti--creo una lista di studenti(creo 10 cloni con un ciclo) e poi ne riottengo
            //i dati con una GET
    @Path("/")
    public Response getStudentiDb() {
        List<Studente> studentiDb = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            //creo due materie
            Materia materia = new Materia();
            materia.setId(1L+i);
            materia.setNome("Matematica");

            Materia materia1 = new Materia();
            materia1.setId(2L+i);
            materia1.setNome("Elettronica");

            //creo un corso e ci aggiungo le due materie sopra create

            Corso corso= new Corso();
            corso.setId(1L+i);
            corso.setNome("Informatica");
            corso.getListaMaterie().add( materia);
            corso.getListaMaterie().add( materia1);

            //creo esame, con come materia la prima che ho creato
            Esame esame= new Esame();
            esame.setId(1L+i);
            esame.setData(LocalDate.of(2023, 01, 01));
            esame.setVoto(100);
            esame.setMateriaEsame(materia);

            //creo studente
            Studente studente= new Studente();
            studente.setNome("Gianfrangiorgio");
            studente.setCognome("soumaouru");
            studente.setMatricola("12R3"+ i);
            studente.setId((long) i);
            studente.setDataDiNascita(LocalDate.of(1991, 05,17));
            studente.getListaCorsi().add(corso);
            studente.getListaEsami().add(esame);
            //Iscrizione iscrizione = IscrizioneManager.build(i);
            studentiDb.add(studente);
        }

        return Response
                .status(Response.Status.OK)
                .entity(studentiDb)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    @POST
    @Path("/")
    @Consumes("application/json")
    public Response insertStudente(Studente studente) throws JsonProcessingException {

        //dati gli errori:
        //java.lang.reflect.InaccessibleObjectException: Unable to make field private final int java.time.LocalDate.year
        //accessible: module java.base does not &quot;opens java.time&quot; to unnamed module @644c862
        //si è provato a rifare il modulo per la data ma non è andata ben

        //se faccio qui la serializzazione non funziona, come mai? c'è bisogno di una classe apposita (Jackson Configuration)
        // perchè è il parametro Studente in ingresso che deve essere già serificato
        /*
        ObjectMapper mapper= new ObjectMapper();
        SimpleModule module= new SimpleModule("CustomDate");
        module.addSerializer(LocalDate.class,
                new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        module.addDeserializer(LocalDate.class,
                new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        mapper.registerModule(module);
        */
        ObjectMapper mapper= new ObjectMapper();
        String json = mapper.writeValueAsString(studente);
        System.out.println(json);
        System.out.println("cognome: " + studente.getCognome());
        System.out.println("nome: " + studente.getNome());

        //Long id = StudenteManager

        // INSERT nel DB

        return Response
                .status(Response.Status.OK)
                .entity(12345)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    public Response updateStudente(@PathParam("id") Long id, Studente studente) throws JsonProcessingException {


        //ObjectMapper mapper= new ObjectMapper();
        //String json = mapper.writeValueAsString(studente);
        Studente dbStudente = new Studente();
        //System.out.println(json);


        //dbStudente.getListaEsami().add(Esame esame = new Esame());



        // UPDATE su DB

        dbStudente.setNome(studente.getNome());
        dbStudente.setCognome(studente.getCognome());
        System.out.println("nome e cognome dello studente modificati correttamente ");

        return Utility.buildNoContentResponse();


    }
    //oltre alle CRUD viste i servizi possono essere molti
    //ad esempio potrei voler aggiungere un esame alla lista degli esami dello studente
    //PUT
    //api/studenti/{id}/esami---questo è l'URI del servizio che invochiamo
    //prendimi fra gli studenti quello con questo id, e mi agiisci solo sul parametro che vado ad indicare

    @PUT
    @Path("/{id}/esami")
    @Consumes("application/json")
    public Response updateEsamiStudente(@PathParam("id") Long idStudente, Esame esame)  {


        StudenteManager.updateEsame(idStudente,esame);


        System.out.println("esame aggiunto correttamente correttamente ");

        return Utility.buildNoContentResponse();


    }

    @PUT
    @Path("/{id}/corsi")
    @Consumes("application/json")
    public Response updateCorsiStudente(@PathParam("id") Long idStudente, Corso corso) throws JsonProcessingException {


        StudenteManager.updateCorso(idStudente,corso);


        System.out.println("corso aggiunto  correttamente ");
        ObjectMapper mapper= new ObjectMapper();
        String json = mapper.writeValueAsString(corso);
        System.out.println(json);

        return Utility.buildNoContentResponse();


    }



    @DELETE
    @Path("/{id}")
    public Response deleteStudente(@PathParam("id") Long id) {
        // Verifica dell'esistenza del record
        // DELETE su DB
        System.out.println("lo studente è stato eliminato dal database");
        return Utility.buildNoContentResponse();
    }

    //nel caso io volessi cancellare un determinato esame:
    //api/studenti/{id}/esami/{id}

    @DELETE
    @Path("/{idStudente}/esami/{idEsame}")
    public Response deleteEsameStudente(@PathParam("idStudente") Long idStudente, @PathParam("idEsame") Long idEsame) {

        StudenteManager.deleteEsame(idStudente,idEsame);
        //System.out.println("lo studente è stato eliminato dal database");
        return Utility.buildNoContentResponse();
    }



}
