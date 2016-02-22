package com.example.a618643.mypoi.view;

import com.example.a618643.mypoi.model.PoiDetailsModel;

import android.content.Context;

/**
 * Created by a618643 on 15/02/2016.
 */
public interface PoiDetailsView {

    void renderPoiDetails(PoiDetailsModel poiDetailsModel);

    Context getContext();
}
