package com.example.a618643.data.net.client;

import com.example.a618643.data.entity.dto.PoiDetailsDto;
import com.example.a618643.data.net.client.base.PoiBaseClient;
import com.example.a618643.data.net.service.PoiService;

import android.content.Context;

import retrofit.RestAdapter;

/**
 * Created by a618643 on 15/02/2016.
 */
public class PoiDetailsClient extends PoiBaseClient<PoiDetailsDto> {

    protected final String TAG = getClass().getSimpleName();

    private String id;

    public PoiDetailsClient(Context context, String baseURL, String contextURI, String apiVersion, String id) {
        super(context, baseURL, contextURI,apiVersion, id);
        this.id = id;
    }

    @Override
    public void execute(RestAdapter restAdapter) {
        PoiService poiService = restAdapter.create(PoiService.class);
        poiService.getPoiDetails(id, this);
    }
}
