package com.jonvallet.rest.api.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.UUID;

@Path("/token")
public class TokenService {

    @GET
    public String requestToken(){
        return UUID.randomUUID().toString();
    }

}
