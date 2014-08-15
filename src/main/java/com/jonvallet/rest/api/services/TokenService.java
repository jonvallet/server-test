package com.jonvallet.rest.api.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.UUID;

@Path("/token")
public class TokenService {

    @GET
    @Produces("text/plain;charset=utf-8")
    public String requestToken(){
        return UUID.randomUUID().toString();
    }

}
