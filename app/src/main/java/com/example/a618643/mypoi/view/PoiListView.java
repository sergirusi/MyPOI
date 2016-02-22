package com.example.a618643.mypoi.view;

import com.example.a618643.mypoi.model.PoiListModel;

import android.content.Context;

import java.util.Collection;

/**
 * Created by a618643 on 04/02/2016.
 */
public interface PoiListView {

    void renderPoiList(PoiListModel poiList);

    Context getContext();

}
