package com.example.a618643.mypoi.mapper;

import com.example.a618643.mypoi.model.PoiDetailsModel;
import com.example.bo.response.PoiDetailsBoResponse;

/**
 * Created by a618643 on 15/02/2016.
 */
public class PoiDetailsModelDataMapper {

    public PoiDetailsModelDataMapper() {

    }

    public PoiDetailsModel transformResponseToModel(PoiDetailsBoResponse poiDetailsBoResponse) {
        PoiDetailsModel poiDetailsModel = new PoiDetailsModel();
        poiDetailsModel.setId(poiDetailsBoResponse.getId());
        poiDetailsModel.setTitle(poiDetailsBoResponse.getTitle());
        poiDetailsModel.setAddress(poiDetailsBoResponse.getAddress());
        poiDetailsModel.setTransport(poiDetailsBoResponse.getTransport());
        poiDetailsModel.setGeocoordinates(poiDetailsBoResponse.getGeocoordinates());
        poiDetailsModel.setDescription(poiDetailsBoResponse.getDescription());
        poiDetailsModel.setPhone(poiDetailsBoResponse.getPhone());
        return poiDetailsModel;
    }
}
