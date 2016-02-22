package com.example.a618643.data.repository.datasource;

import com.example.a618643.data.entity.dto.PoiDetailsDto;
import com.example.a618643.data.net.callback.ApiConnectionCallBack;

import android.content.Context;

import retrofit.RetrofitError;

/**
 * Created by a618643 on 16/02/2016.
 */
public class PoiDetailsDataStoreApiConnectionCallback extends ApiConnectionCallBack<PoiDetailsDto, PoiDetailsDataStore> {

    private final PoiDetailsDataStore.PoiDetailsCallback callback;

    public PoiDetailsDataStoreApiConnectionCallback(Context context, PoiDetailsDataStore poiDetailsDataStore,
            PoiDetailsDataStore.PoiDetailsCallback callback) {
        super(context, poiDetailsDataStore);
        this.callback = callback;
    }

    @Override
    public void onResponseOK(int code, PoiDetailsDto t) {
        if (!t.isEmpty()) {
            callback.onPoiDetailsCallback(t);
        } else {
            callback.onPoiDetailsCallback(new PoiDetailsDto());
        }
    }

    @Override
    public void onError(int code, String errorMessage, RetrofitError error) {
        callback.onError(error);
    }
}
