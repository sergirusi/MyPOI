package com.example.a618643.data.net.service;

import com.example.a618643.data.entity.dto.PoiDetailsDto;
import com.example.a618643.data.entity.dto.PoiListDto;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by a618643 on 03/02/2016.
 */
public interface PoiService {

    @GET("/points")
    void getPois(Callback<PoiListDto> callback);

    @GET("/points/{id}")
    void getPoiDetails(@Path("id") String id, Callback<PoiDetailsDto> callback);

}
