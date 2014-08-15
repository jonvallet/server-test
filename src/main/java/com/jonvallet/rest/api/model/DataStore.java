package com.jonvallet.rest.api.model;

import com.jonvallet.rest.api.services.TokenNotFoundException;
import com.jonvallet.rest.api.services.ValidationException;

import java.util.HashMap;
import java.util.Map;

public class DataStore {

    public static final int MAX_VALUE_SIZE = 100;
    public static final int MIN_VALUE_SIZE = 1;
    public static final int MIN_KEY_SIZE = 1;
    public static final int MAX_KEY_SIZE = 20;
    public DataStoreDao dataStoreDao = new FileDataStoreDaoImpl();

    public void storeValue(String token, String key, String value){

        validateKey(key);
        validateValue(value);

        Map<String,Map<String,String>> data = dataStoreDao.retrieve();

        Map<String, String> entry = data.get(token);

        entry = createOrRetrive(token, entry, data);

        entry.put(key, value);

        dataStoreDao.persist(data);

    }

    private void validateValue(String value) {
        if (value == null || value.length() < MIN_VALUE_SIZE || value.length() > MAX_VALUE_SIZE){
            throw new ValidationException("key", "Key has to be a non null string between "+MIN_VALUE_SIZE+
                    " and "+MAX_VALUE_SIZE+" characters long. ");
        }
    }

    private void validateKey(String key) {
        if (key == null || key.length() < MIN_KEY_SIZE || key.length() > MAX_KEY_SIZE){
            throw new ValidationException("key", "Key has to be a non null string between "+MIN_KEY_SIZE+
                    " and "+MAX_KEY_SIZE+" characters long. ");
        }
    }


    private Map<String, String> createOrRetrive(String token, Map<String, String> entry, Map<String, Map<String, String>> data) {
        if (entry == null){
            entry = new HashMap<>();
            data.put(token,entry);
        }
        return entry;
    }

    public String getValue(String token, String key) {

        Map<String,Map<String,String>> data = dataStoreDao.retrieve();

        if (data.get(token) == null) {
            throw new TokenNotFoundException(token);
        }

        return data.get(token).get(key);
    }

    public Map<String,String> getValues(String token) {

        Map<String,Map<String,String>> data = dataStoreDao.retrieve();

        return data.get(token);
    }

}
