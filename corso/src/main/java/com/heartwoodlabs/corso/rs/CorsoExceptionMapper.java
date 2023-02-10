package com.heartwoodlabs.corso.rs;



import com.heartwoodlabs.corso.business.CorsoException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CorsoExceptionMapper implements ExceptionMapper<CorsoException> {
    @Override
    public Response toResponse(CorsoException e) {
        return Utility.buildServerError(e.getMessage());
    }
}
