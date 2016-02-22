package com.example.a618643.mypoi.model;

/**
 * Created by a618643 on 09/02/2016.
 */
public class PoiModel {

    protected String title;

    protected String id;

    protected String geocoordinates;

    public PoiModel() {
    }

    public PoiModel(String title, String id, String geocoordinates) {
        this.title = title;
        this.id = id;
        this.geocoordinates = geocoordinates;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGeocoordinates() {
        return geocoordinates;
    }

    public void setGeocoordinates(String geocoordinates) {
        this.geocoordinates = geocoordinates;
    }
}
