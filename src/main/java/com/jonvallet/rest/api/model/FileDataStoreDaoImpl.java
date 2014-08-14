package com.jonvallet.rest.api.model;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileDataStoreDaoImpl implements DataStoreDao {

    public static final String DATA_STORE_DATA_FILE = "data-store.data";

    @Override
    public void persist(Map<String, Map<String, String>> data) {
        try {
            FileOutputStream fos = new FileOutputStream(DATA_STORE_DATA_FILE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(data);

            oos.close();
        } catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Map<String, Map<String, String>> retrieve() {

        Map<String, Map<String, String>> data;

        if (fileExist()) {
            data = readFromFile();
        }else {
            data = new HashMap<>();
        }

        return data;
    }

    private Map<String, Map<String, String>> readFromFile() {
        Map<String, Map<String, String>> data;
        try {
            FileInputStream fis = new FileInputStream(DATA_STORE_DATA_FILE);
            ObjectInputStream ois = new ObjectInputStream(fis);

            data = (Map<String, Map<String, String>>) ois.readObject();

            ois.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return data;
    }

    private boolean fileExist() {
        File f = new File(DATA_STORE_DATA_FILE);
        return (f.exists() && !f.isDirectory());
    }
}
