package com.jonvallet.rest.api.services;

import com.jonvallet.rest.api.model.DataStore;

import javax.ws.rs.*;
import java.util.Map;

@Path("/data")
public class DataService {

    private DataStore dataStore = new DataStore();


    public DataService() {

    }

    @GET
    @Produces("text/html;charset=utf-8")
    public String retrieveData(){

        String string = "<p>\n" +
                "    For saving an entry, use PUT method an adding the following path parameters:\n" +
                "    \"rest/data/{token}/{key}/{value}\"\n" +
                "</p>\n" +
                "\n" +
                "<p>\n" +
                "    For retrieving an entry, use GET method an adding the following path parameters:\n" +
                "    \"rest/data/{token}/{key}\"\n" +
                "</p>\n" +
                "\n" +
                "<p>\n" +
                "    For retrieving all entries for a given token, use GET method an adding the following path parameters:\n" +
                "    \"rest/data/{token}\"\n" +
                "</p>";

        return string;
    }

    @Path("/{token}/{key}")
    @PUT
    @Consumes("text/plain;charset=utf-8")
    public void saveData(@PathParam(value = "token") String token,
                         @PathParam(value = "key") String key,
                         String value) {

        dataStore.storeValue(token, key, value);

    }

    @Path("/{token}/{key}")
    @GET
    @Produces("text/plain;charset=utf-8")
    public String retrieveData(@PathParam(value = "token") String token,
                               @PathParam(value = "key") String key) {
        return dataStore.getValue(token, key);
    }

    @Path("/{token}")
    @GET
    @Produces("application/json;charset=utf-8")
    public Map<String, String> retrieveData(@PathParam(value = "token") String token) {

        return dataStore.getValues(token);
    }

}
