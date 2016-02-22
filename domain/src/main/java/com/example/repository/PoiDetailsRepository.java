package com.example.repository;

import com.example.bo.request.PoiDetailsBoRequest;
import com.example.bo.response.PoiDetailsBoResponse;
import com.example.exception.ErrorBundle;

/**
 * Created by a618643 on 15/02/2016.
 */
public interface PoiDetailsRepository {

    interface PoiDetailsCallback {

        void onPoiDetailsLoaded(PoiDetailsBoResponse poiListBoResponse);

        void onError(ErrorBundle errorBundle);
    }

    void getPoiDetails(PoiDetailsBoRequest poiDetailsBoRequest, PoiDetailsCallback poiDetailsCallback);
}
