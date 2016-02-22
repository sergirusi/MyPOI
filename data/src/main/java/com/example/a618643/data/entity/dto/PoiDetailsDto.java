package com.example.a618643.data.entity.dto;

/**
 * Created by a618643 on 08/02/2016.
 */
public class PoiDetailsDto {

    private String ID;

    private String title;

    private String address;

    private String transport;

    private String email;

    private String geocoordinates;

    private String description;

    private String phone;


    public PoiDetailsDto() {
    }

    public PoiDetailsDto(String ID, String title, String address, String transport, String email, String geocoordinates,
            String description, String phone) {
        this.ID = ID;
        this.title = title;
        this.address = address;
        this.transport = transport;
        this.email = email;
        this.geocoordinates = geocoordinates;
        this.description = description;
        this.phone = phone;
    }

    public String getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public String getTransport() {
        return transport;
    }

    public String getEmail() {
        return email;
    }

    public String getGeocoordinates() {
        return geocoordinates;
    }

    public String getDescription() {
        return description;
    }

    public String getPhone() {
        return phone;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGeocoordinates(String geocoordinates) {
        this.geocoordinates = geocoordinates;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isEmpty() {
        if (ID == null && title == null && address == null && transport == null && email == null && geocoordinates == null
                && description == null && phone == null) {
            return true;
        } else {
            return false;
        }
    }
}
