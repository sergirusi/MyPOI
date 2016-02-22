package com.example.bo.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a618643 on 05/02/2016.
 */
public class PoiListBoResponse {

    private List<PoiBoResponse> poiList;

    public PoiListBoResponse(List<PoiBoResponse> poiList) {
        this.poiList = poiList;
    }

    public PoiListBoResponse() {
    }

    public PoiBoResponse getPoiListItem(int index) {
        return poiList.get(index);
    }

    public List<PoiBoResponse> getPoiList() {
        return poiList;
    }

    public void setPoiList(List<PoiBoResponse> poiList) {
        this.poiList = poiList;
    }
}
