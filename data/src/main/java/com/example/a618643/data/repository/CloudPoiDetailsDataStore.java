package com.example.a618643.data.repository;

import com.example.a618643.data.net.client.PoiDetailsClient;
import com.example.a618643.data.repository.datasource.PoiDetailsDataStore;
import com.example.a618643.data.repository.datasource.PoiDetailsDataStoreApiConnectionCallback;
import com.example.a618643.data.util.Constants;
import com.example.bo.request.PoiDetailsBoRequest;

import android.content.Context;

/**
 * Created by a618643 on 15/02/2016.
 */
public class CloudPoiDetailsDataStore implements PoiDetailsDataStore {

    private Context context;

    private PoiDetailsClient poiDetailsClient;

    public CloudPoiDetailsDataStore(Context context) {
        this.context = context;
    }

    @Override
    public void getPoiDetails(String id, PoiDetailsCallback poiDetailsCallback) { //TODO Ask for id usage
        poiDetailsClient = new PoiDetailsClient(context, Constants.BASE_URL, Constants.URI_POI_LIST, Constants.VERSION, id);
        poiDetailsClient.setOnResultCallBack(new PoiDetailsDataStoreApiConnectionCallback(context, this, poiDetailsCallback));
        poiDetailsClient.execute();
    }
}
