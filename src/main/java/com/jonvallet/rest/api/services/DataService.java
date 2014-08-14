package com.jonvallet.rest.api.services;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Path("/data")
public class DataService {

    @Path("/{token}/{key}/{value}")
    @PUT
    public void saveData(@PathParam(value = "token") String token,
                         @PathParam(value = "key") String key,
                         @PathParam(value = "value") String value){

    }

    @Path("/{token}/{key}")
    @GET
    @Produces("application/json")
    public String retrieveData(@PathParam(value = "token") String token,
                               @PathParam(value = "key") String key){
        return "Test";
    }

    @Path("/{token}")
    @GET
    @Produces("application/json")
    public List<String> retrieveData(@PathParam(value = "token") String token){

        List<String> strings = new ArrayList<>();
        strings.add("Test");

        return strings;
    }

}
