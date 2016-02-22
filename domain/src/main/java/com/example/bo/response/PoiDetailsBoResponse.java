package com.example.bo.response;

/**
 * Created by a618643 on 15/02/2016.
 */
public class PoiDetailsBoResponse {

    private String id;

    private String title;

    private String address;

    private String transport;

    private String geocoordinates;

    private String description;

    private String phone;

    public PoiDetailsBoResponse() {

    }

    public PoiDetailsBoResponse(String id, String title, String address, String transport, String geocoordinates,
            String description, String phone) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.transport = transport;
        this.geocoordinates = geocoordinates;
        this.description = description;
        this.phone = phone;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getGeocoordinates() {
        return geocoordinates;
    }

    public void setGeocoordinates(String geocoordinates) {
        this.geocoordinates = geocoordinates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
