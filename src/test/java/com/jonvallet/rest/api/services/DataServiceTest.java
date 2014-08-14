package com.jonvallet.rest.api.services;


import org.junit.Assert;
import org.junit.Test;

public class DataServiceTest {

    @Test
    public void IStoreKeyFirstNameWithValueJonWhenIRetrieveTheValuesAreTheSame(){

        String token = "test-token-id";
        String key = "firstName";
        String value = "Jon";

        new DataService().saveData(token, key, value);

        String retrieveValue = new DataService().retrieveData(token, key);

        Assert.assertEquals(value, retrieveValue);

    }

    @Test
    public void IStoreTwoValuesICanRetriveBoth(){

    }


}
