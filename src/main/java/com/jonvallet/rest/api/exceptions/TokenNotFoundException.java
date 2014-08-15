package com.jonvallet.rest.api.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class TokenNotFoundException extends WebApplicationException {
    public TokenNotFoundException(String token) {
        super(Response.status(Response.Status.NOT_FOUND).entity("Token wiht id: ["+token+"] not found.").build());
    }
}
