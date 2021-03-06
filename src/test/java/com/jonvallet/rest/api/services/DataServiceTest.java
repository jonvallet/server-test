package com.jonvallet.rest.api.services;


import com.jonvallet.rest.api.exceptions.TokenNotFoundException;
import com.jonvallet.rest.api.exceptions.ValidationException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class DataServiceTest {

    @Test
    public void IStoreKeyFirstNameWithValueJonWhenIRetrieveTheValuesAreTheSame() {

        String token = new TokenService().requestToken();
        String key = "firstName";
        String value = "Jon";

        new DataService().saveData(token, key, value);

        String retrieveValue = new DataService().retrieveData(token, key);

        Assert.assertEquals(value, retrieveValue);

    }

    @Test(expected = TokenNotFoundException.class)
    public void IRetrieveAnonExistentTokenIGetATokenNotFoundException() {

        String token = new TokenService().requestToken();
        String key = "firstName";

        Assert.assertNull(new DataService().retrieveData(token, key));
    }

    @Test
    public void IRetrieveANonExistentKeyIGetNullValue() {

        String token = new TokenService().requestToken();
        String key = "firstName";
        String value = "Jon";

        new DataService().saveData(token, key, value);

        String retrieveValue = new DataService().retrieveData(token, "surname");

        Assert.assertNull(retrieveValue);

    }

    @Test
    public void IStoreTwoValuesICanRetriveBoth() {

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
    public void IStoreTwoValuesWithSameTokenAndDifferentKeysICanRetrieveBoth() {

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

    @Test
    public void IStoreTwoValuesWithSameTokenICanRetriveAList() {

        String token = new TokenService().requestToken();
        String key = "firstName";
        String value = "Jon";

        String key2 = "lastName";
        String value2 = "Vallet";

        new DataService().saveData(token, key, value);
        new DataService().saveData(token, key2, value2);

        Map<String, String> values = new DataService().retrieveData(token);

        Assert.assertEquals(value, values.get(key));

        Assert.assertEquals(value2, values.get(key2));

    }

    @Test(expected = ValidationException.class)
    public void IStoreWithAnEmptyKeyAnIllegalValidationExceptionIsThrown(){

        String token = new TokenService().requestToken();
        String key = null;
        String value = "Jon";

        new DataService().saveData(token, key, value);

        new DataService().retrieveData(token, key);


    }

    @Test(expected = ValidationException.class)
    public void IStoreWithAnEmptyValueAnIllegalValidationExceptionIsThrown(){

        String token = new TokenService().requestToken();
        String key = "firstName";
        String value = null;

        new DataService().saveData(token, key, value);

        new DataService().retrieveData(token, key);

    }

    @Test(expected = ValidationException.class)
    public void IStoreAToLongValueAnIllegalValidationExceptionIsThrown(){

        String token = new TokenService().requestToken();
        String key = "firstName";
        String value = "01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";

        new DataService().saveData(token, key, value);

        new DataService().retrieveData(token, key);

    }

    @Test(expected = ValidationException.class)
    public void IStoreAToLongKeyAnIllegalValidationExceptionIsThrown(){

        String token = new TokenService().requestToken();
        String key = "012345678901234567890";
        String value = "Jon";

        new DataService().saveData(token, key, value);

        new DataService().retrieveData(token, key);

    }

}
