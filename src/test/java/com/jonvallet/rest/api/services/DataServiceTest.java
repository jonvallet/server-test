package com.jonvallet.rest.api.services;


import org.junit.Assert;
import org.junit.Test;

public class DataServiceTest {

    @Test
    public void IStoreKeyFirstNameWithValueJonWhenIRetrieveTheValuesAreTheSame(){

        String token = new TokenService().requestToken();
        String key = "firstName";
        String value = "Jon";

        new DataService().saveData(token, key, value);

        String retrieveValue = new DataService().retrieveData(token, key);

        Assert.assertEquals(value, retrieveValue);

    }

    @Test
         public void IStoreTwoValuesICanRetriveBoth(){

        String token = new TokenService().requestToken();
        String key = "firstName";
        String value = "Jon";

        String token2 = new TokenService().requestToken();
        String key2 = "firstName";
        String value2 = "Laura";

        new DataService().saveData(token, key, value);
        new DataService().saveData(token2, key2, value2);

        String retrieveValue = new DataService().retrieveData(token, key);

        Assert.assertEquals(value, retrieveValue);

        String retrieveValue2 = new DataService().retrieveData(token2, key2);

        Assert.assertEquals(value2, retrieveValue2);

    }

    @Test
    public void IStoreTwoValuesWithSameTokenAndDifferentKeysICanRetrieveBoth(){

        String token = new TokenService().requestToken();
        String key = "firstName";
        String value = "Jon";

        String key2 = "lastName";
        String value2 = "Vallet";

        new DataService().saveData(token, key, value);
        new DataService().saveData(token, key2, value2);

        String retrieveValue = new DataService().retrieveData(token, key);

        Assert.assertEquals(value, retrieveValue);

        String retrieveValue2 = new DataService().retrieveData(token, key2);

        Assert.assertEquals(value2, retrieveValue2);

    }


}
