package com.jonvallet.rest.api.services;

public class TokenNotFoundException extends RuntimeException {
    public TokenNotFoundException(String token) {
        super("Token id :["+token+"] not found");
    }
}
