package com.example.a618643.data.repository.datasource;

import com.example.a618643.data.repository.CloudPoiDetailsDataStore;

import android.content.Context;

/**
 * Created by a618643 on 15/02/2016.
 */
public class PoiDetailsDataStoreFactory {

    private final Context context;

    public PoiDetailsDataStoreFactory(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Constructor parameters cannot be null");
        }
        this.context = context;
    }

    public PoiDetailsDataStore create() {
        PoiDetailsDataStore poiDetailsDataStore = new CloudPoiDetailsDataStore(context);
        return poiDetailsDataStore;
    }
}
