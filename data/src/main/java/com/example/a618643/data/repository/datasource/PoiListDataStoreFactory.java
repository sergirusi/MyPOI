package com.example.a618643.data.repository.datasource;

import com.example.a618643.data.repository.CloudPoiListDataStore;

import android.content.Context;

/**
 * Created by a618643 on 11/02/2016.
 */
public class PoiListDataStoreFactory {

    private final Context context;

    public PoiListDataStoreFactory(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Constructor parameters cannot be null");
        }
        this.context = context;
    }

    public PoiListDataStore create() {
        PoiListDataStore poiListDataStore = new CloudPoiListDataStore(context);
        return poiListDataStore;
    }

}
