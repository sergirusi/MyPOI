package com.example.a618643.data.repository.datasource;

import com.example.a618643.data.entity.dto.PoiDetailsDto;

/**
 * Created by a618643 on 15/02/2016.
 */
public interface PoiDetailsDataStore {

    interface PoiDetailsCallback {

        void onPoiDetailsCallback(PoiDetailsDto poiDetailsDto);

        void onError(Exception exception);
    }

    void getPoiDetails(String id, PoiDetailsCallback poiDetailsCallback);
}
