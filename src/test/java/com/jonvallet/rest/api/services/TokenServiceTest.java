package com.jonvallet.rest.api.services;

import org.junit.Assert;
import org.junit.Test;

public class TokenServiceTest {

    @Test
    public void testIGenerateTwoTokensAndTheyAreNotEqual(){

        TokenService tokenService = new TokenService();

        String firstToken = tokenService.requestToken();
        String secondToken = tokenService.requestToken();

        Assert.assertNotEquals(firstToken, secondToken);

    }

}
