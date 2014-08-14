package com.jonvallet.rest.api.services;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/data")
public class DataService {

    @Path("/{token}/{key}/{value}")
    @PUT
    public void saveData(@PathParam(value = "token") String token,
                         @PathParam(value = "key") String key,
                         @PathParam(value = "value") String value){

    }

}
