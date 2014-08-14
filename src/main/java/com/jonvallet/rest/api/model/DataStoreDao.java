package com.jonvallet.rest.api.model;

import java.util.Map;

public interface DataStoreDao {

    public void persist (Map<String,Map<String,String>> data );
    public Map<String,Map<String,String>> retrieve();
}
