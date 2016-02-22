package com.example.a618643.data.repository;

import com.example.a618643.data.net.client.PoiListClient;
import com.example.a618643.data.repository.datasource.PoiListDataStore;
import com.example.a618643.data.repository.datasource.PoiListDataStoreApiConnectionCallback;
import com.example.a618643.data.util.Constants;
import com.example.bo.request.PoiListBoRequest;

import android.content.Context;

/**
 * Created by a618643 on 09/02/2016.
 */
public class CloudPoiListDataStore implements PoiListDataStore {

    private Context context;

    private PoiListClient poiListClient;

    public CloudPoiListDataStore(Context context) {
        this.context = context;
    }

    @Override
    public void getPoiList(PoiListCallback poiListCallback) {
        poiListClient = new PoiListClient(context, Constants.BASE_URL, Constants.URI_POI_LIST, Constants.VERSION, null);
        poiListClient.setOnResultCallBack(new PoiListDataStoreApiConnectionCallback(context, this, poiListCallback));
        poiListClient.execute();
    }
}
