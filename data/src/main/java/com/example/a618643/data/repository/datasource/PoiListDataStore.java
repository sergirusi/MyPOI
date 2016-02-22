package com.example.a618643.data.repository.datasource;

import com.example.a618643.data.entity.dto.PoiListDto;
import com.example.bo.request.PoiListBoRequest;

/**
 * Created by a618643 on 08/02/2016.
 */
public interface PoiListDataStore {

    interface PoiListCallback {

        void onPoiListCallback(PoiListDto poiListDto);

        void onError(Exception exception);
    }

    void getPoiList(PoiListCallback poiListCallback);
}
