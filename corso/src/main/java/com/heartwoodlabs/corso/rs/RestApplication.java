package com.heartwoodlabs.corso.rs;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class RestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classi = new HashSet<>();
        classi.add(StudenteResource.class);
        classi.add(DocenteResource.class);
        //classi.add(LibroResource.class);
        classi.add(JacksonConfiguration.class);
        classi.add(CorsoExceptionMapper.class);
        classi.add(CorsoResource.class);
        classi.add(MateriaExceptionMapper.class);

        return classi;
    }
}
