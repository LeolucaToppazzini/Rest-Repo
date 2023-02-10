package com.heartwoodlabs.corso.rs;



import com.heartwoodlabs.corso.business.CorsoException;
import com.heartwoodlabs.corso.business.MateriaException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MateriaExceptionMapper implements ExceptionMapper<MateriaException> {
    @Override
    public Response toResponse(MateriaException e) {
        return Utility.buildServerError(e.getMessage());
    }
}
