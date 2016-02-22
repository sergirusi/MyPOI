package com.example.a618643.data.repository.datasource;

import com.example.a618643.data.entity.dto.PoiDto;
import com.example.a618643.data.entity.dto.PoiListDto;
import com.example.a618643.data.net.callback.ApiConnectionCallBack;
import com.example.bo.response.PoiListBoResponse;

import android.content.Context;

import java.util.List;

import retrofit.RetrofitError;

/**
 * Created by a618643 on 10/02/2016.
 */
public class PoiListDataStoreApiConnectionCallback extends ApiConnectionCallBack<PoiListDto, PoiListDataStore> {

    private final PoiListDataStore.PoiListCallback callback;

    public PoiListDataStoreApiConnectionCallback(Context context, PoiListDataStore poiListDataStore,
            PoiListDataStore.PoiListCallback callback) {
        super(context, poiListDataStore);
        this.callback = callback;
    }

    @Override
    public void onResponseOK(int code, PoiListDto t) {
        if (t.getList() != null) {
            callback.onPoiListCallback(t);
        } else {
            callback.onPoiListCallback(new PoiListDto());
        }
    }

    @Override
    public void onError(int code, String errorMessage, RetrofitError error) {
        callback.onError(error);
    }
}
