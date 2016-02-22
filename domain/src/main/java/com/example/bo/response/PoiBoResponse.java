package com.example.bo.response;

/**
 * Created by a618643 on 08/02/2016.
 */
public class PoiBoResponse {

    private String id;
    private String title;
    private String geocoordinates;
    
    public PoiBoResponse() {

    }

    public PoiBoResponse(String id, String title, String geocoordinates) {
        this.id = id;
        this.title = title;
        this.geocoordinates = geocoordinates;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGeocoordinates() {
        return geocoordinates;
    }

    public void setGeocoordinates(String geocoordinates) {
        this.geocoordinates = geocoordinates;
    }
}
