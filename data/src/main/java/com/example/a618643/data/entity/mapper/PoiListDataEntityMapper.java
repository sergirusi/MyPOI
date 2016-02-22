package com.example.a618643.data.entity.mapper;

import com.example.a618643.data.entity.dto.PoiDto;
import com.example.a618643.data.entity.dto.PoiListDto;
import com.example.bo.response.PoiBoResponse;
import com.example.bo.response.PoiListBoResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a618643 on 08/02/2016.
 */
public class PoiListDataEntityMapper {

    public PoiListDataEntityMapper(){

    }

    public PoiListBoResponse transform(PoiListDto poiListDto) {
        PoiListBoResponse poiListBoResponse = new PoiListBoResponse();
        List<PoiBoResponse> poiList = new ArrayList<>();
        if(poiListDto != null) {
            for(int i = 0; i < poiListDto.getList().size(); i++) {
                PoiDto poiDto = poiListDto.getPoiFromList(i);
                String id = poiDto.getId();
                String title = poiDto.getTitle();
                String geocoordinates = poiDto.getGeocoordinates();
                poiList.add(new PoiBoResponse(id, title, geocoordinates));
            }
            poiListBoResponse.setPoiList(poiList);
        }
        return poiListBoResponse;
    }
}
