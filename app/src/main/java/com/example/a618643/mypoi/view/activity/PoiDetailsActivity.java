package com.example.a618643.mypoi.view.activity;

import com.example.a618643.mypoi.R;
import com.example.a618643.mypoi.model.PoiDetailsModel;
import com.example.a618643.mypoi.navigation.Navigator;
import com.example.a618643.mypoi.presenter.PoiDetailsPresenter;
import com.example.a618643.mypoi.view.PoiDetailsView;
import com.example.bo.request.PoiDetailsBoRequest;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import retrofit.Callback;

/**
 * Created by a618643 on 15/02/2016.
 */
public class PoiDetailsActivity extends Activity implements PoiDetailsView{

    private PoiDetailsBoRequest poiDetailsBoRequest;

    private PoiDetailsPresenter poiDetailsPresenter;

    private Callback<PoiDetailsModel> callback;

    private Navigator navigator;

    private TextView title;

    private TextView address;

    private TextView transport;

    private TextView email;

    private TextView geocoordinates;

    private TextView description;

    private TextView phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poi_details);
        Bundle extras = getIntent().getExtras();
        String id = extras.getString("id");
        findViews();
        init(id);
        setListeners();
    }

    private void findViews() {
       title = (TextView) findViewById(R.id.titleTV);
       address = (TextView) findViewById(R.id.addressTV);
       transport = (TextView) findViewById(R.id.transportTV);
       email = (TextView) findViewById(R.id.emailTV);
       geocoordinates = (TextView) findViewById(R.id.geocoordinatesTV);
       description = (TextView) findViewById(R.id.descriptionTV);
       phone = (TextView) findViewById(R.id.phoneTV);
    }

    @Override
    public void renderPoiDetails(PoiDetailsModel poiDetailsModel) {
        if(!poiDetailsModel.isEmpty()) {
            title.setText("Title: " + poiDetailsModel.getTitle());
            address.setText("Address: " +poiDetailsModel.getAddress());
            transport.setText("Transport: " +poiDetailsModel.getTransport());
            email.setText("Email: " +poiDetailsModel.getEmail());
            geocoordinates.setText("Geocoordinates: " +poiDetailsModel.getGeocoordinates());
            description.setText("Description: " +poiDetailsModel.getDescription());
            phone.setText("Phone: " +poiDetailsModel.getPhone());
        }
    }

    @Override
    public Context getContext() {
        return this;
    }

    public void init(String id) {
        poiDetailsBoRequest = new PoiDetailsBoRequest(id);
        poiDetailsPresenter = new PoiDetailsPresenter(this, poiDetailsBoRequest);
        poiDetailsPresenter.getPoiDetails();

    }

    private void setListeners() {

    }


}
