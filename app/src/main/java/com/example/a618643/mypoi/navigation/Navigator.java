package com.example.a618643.mypoi.navigation;

import com.example.a618643.mypoi.view.activity.PoiDetailsActivity;
import com.example.a618643.mypoi.view.activity.PoiListActivity;

import android.content.Context;
import android.content.Intent;

/**
 * Created by a618643 on 02/02/2016.
 */
public class Navigator {

    private Context context;

    public Navigator(Context context) {
        this.context = context;
    }

    public void PoiListNavigate(Context context) {
        if (context != null) {
            Intent nextClass = new Intent(context, PoiListActivity.class);
            context.startActivity(nextClass);
        }
    }

    public void PoiDetailsNavigate(Context context, int position) {
        if (context != null) {
            Intent nextClass = new Intent(context, PoiDetailsActivity.class);
            String id = String.valueOf(position);
            nextClass.putExtra("id", id);
            context.startActivity(nextClass);
        }
    }
}
