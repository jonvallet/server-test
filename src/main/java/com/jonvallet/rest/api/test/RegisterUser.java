package com.jonvallet.rest.api.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/register")
public class RegisterUser {

    @GET
    public String register(){
        return "920423409u0";
    }

}
