package com.example.repository;

import com.example.bo.response.PoiListBoResponse;
import com.example.exception.ErrorBundle;

/**
 * Created by a618643 on 08/02/2016.
 */
public interface PoiListRepository {

    interface PoiListCallback {

        void onPoiListLoaded(PoiListBoResponse poiListBoResponse);

        void onError(ErrorBundle errorBundle);
    }

    void getPoiList(PoiListCallback poiListCallback);

}
