package com.jonvallet.rest.api.services;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class ValidationException extends WebApplicationException {
    public ValidationException(String field, String message) {
        super(Response.status(Response.Status.NOT_ACCEPTABLE).entity("Field: "+field+" has to be a value: "+ message).build());
    }
}
