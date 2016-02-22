package com.example.a618643.mypoi.mapper;


import com.example.a618643.mypoi.model.PoiListModel;
import com.example.a618643.mypoi.model.PoiModel;
import com.example.bo.response.PoiBoResponse;
import com.example.bo.response.PoiListBoResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a618643 on 04/02/2016.
 */
public class PoiListModelDataMapper {

    public PoiListModelDataMapper() {

    }

    public PoiListModel transformResponseToModel(PoiListBoResponse poiListBoResponse) {
        PoiListModel poiListModel = new PoiListModel();
        PoiBoResponse poiBoResponse = new PoiBoResponse();
        List<PoiModel> listModel = new ArrayList<>();
        for (int i = 0; i < poiListBoResponse.getPoiList().size(); i++) {
            poiBoResponse = poiListBoResponse.getPoiListItem(i);
            PoiModel poiModel = new PoiModel();
            poiModel.setId(poiBoResponse.getId());
            poiModel.setTitle(poiBoResponse.getTitle());
            poiModel.setGeocoordinates(poiBoResponse.getGeocoordinates());
            listModel.add(poiModel);
        }
        poiListModel.setPoiList(listModel);
        return poiListModel;
    }
}
