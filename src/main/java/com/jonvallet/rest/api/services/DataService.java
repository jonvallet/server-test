package com.jonvallet.rest.api.services;

import com.jonvallet.rest.api.model.DataStore;

import javax.ws.rs.*;
import java.util.Map;

@Path("/data")
public class DataService {

    private DataStore dataStore = new DataStore();


    public DataService(){

    }

    @Path("/{token}/{key}/{value}")
    @PUT
    public void saveData(@PathParam(value = "token") String token,
                         @PathParam(value = "key") String key,
                         @PathParam(value = "value") String value){

        dataStore.storeValue(token, key, value);

    }

    @Path("/{token}/{key}")
    @GET
    @Produces("application/json")
    public String retrieveData(@PathParam(value = "token") String token,
                               @PathParam(value = "key") String key){
        return dataStore.getValue(token, key);
    }

    @Path("/{token}")
    @GET
    @Produces("application/json")
    public Map<String, String> retrieveData(@PathParam(value = "token") String token){

        return dataStore.getValues(token);
    }

}
