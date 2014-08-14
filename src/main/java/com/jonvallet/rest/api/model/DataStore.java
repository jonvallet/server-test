package com.jonvallet.rest.api.model;

import com.jonvallet.rest.api.services.TokenNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class DataStore {

    public DataStoreDao dataStoreDao = new FileDataStoreDaoImpl();

    public void storeValue(String token, String key, String value){


        Map<String,Map<String,String>> data = dataStoreDao.retrieve();

        Map<String, String> entry = data.get(token);

        entry = createOrRetrive(token, entry, data);

        entry.put(key, value);

        dataStoreDao.persist(data);

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
