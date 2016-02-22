package com.example.a618643.data.net.client;

import com.example.a618643.data.entity.dto.PoiListDto;
import com.example.a618643.data.net.client.base.PoiBaseClient;
import com.example.a618643.data.net.service.PoiService;

import android.content.Context;

import retrofit.RestAdapter;


/**
 * Created by a618643 on 03/02/2016.
 */
public class PoiListClient extends PoiBaseClient<PoiListDto> {

    protected final String TAG = getClass().getSimpleName();

    public PoiListClient(Context context, String baseURL, String contextURI, String apiVersion, String id) {
        super(context, baseURL, contextURI,apiVersion, id);
    }

    @Override
    public void execute(RestAdapter restAdapter) {
        PoiService poiService = restAdapter.create(PoiService.class);
        poiService.getPois(this);
    }
}
