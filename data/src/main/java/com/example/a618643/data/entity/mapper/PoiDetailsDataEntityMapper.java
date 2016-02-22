package com.example.a618643.data.entity.mapper;

import com.example.a618643.data.entity.dto.PoiDetailsDto;
import com.example.bo.response.PoiDetailsBoResponse;

/**
 * Created by a618643 on 15/02/2016.
 */
public class PoiDetailsDataEntityMapper {

    public PoiDetailsDataEntityMapper(){

    }

    public PoiDetailsBoResponse transform(PoiDetailsDto poiDetailsDto) {
        PoiDetailsBoResponse poiDetailsBoResponse = new PoiDetailsBoResponse();
        poiDetailsBoResponse.setId(poiDetailsDto.getID());
        poiDetailsBoResponse.setTitle(poiDetailsDto.getTitle());
        poiDetailsBoResponse.setAddress(poiDetailsDto.getAddress());
        poiDetailsBoResponse.setTransport(poiDetailsDto.getTransport());
        poiDetailsBoResponse.setGeocoordinates(poiDetailsDto.getGeocoordinates());
        poiDetailsBoResponse.setDescription(poiDetailsDto.getDescription());
        poiDetailsBoResponse.setPhone(poiDetailsDto.getPhone());
        return poiDetailsBoResponse;
    }

}
