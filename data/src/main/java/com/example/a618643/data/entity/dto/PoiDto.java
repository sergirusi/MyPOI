package com.example.a618643.data.entity.dto;

import com.google.gson.annotations.Expose;

/**
 * Created by a618643 on 08/02/2016.
 */
public class PoiDto {

    @Expose
    private String id;

    @Expose
    private String title;

    @Expose
    private String geocoordinates;

    public PoiDto() {
    }

    public PoiDto(String id, String title, String geocoordinates) {
        this.id = id;
        this.title = title;
        this.geocoordinates = geocoordinates;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGeocoordinates() {
        return geocoordinates;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGeocoordinates(String geocoordinates) {
        this.geocoordinates = geocoordinates;
    }
}
