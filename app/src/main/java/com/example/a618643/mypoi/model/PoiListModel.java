package com.example.a618643.mypoi.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a618643 on 04/02/2016.
 */
public class PoiListModel {

    protected List<PoiModel> poiList;

    public PoiListModel() {
        poiList = new ArrayList<>();
    }

    public int size() {
        return poiList.size();
    }

    public PoiModel getPoiListItem(int index) {
        return poiList.get(index);
    }

    public List<PoiModel> getPoiList() {
        return poiList;
    }

    public void setPoiList(List<PoiModel> listModel) {
        poiList = listModel;
    }
}