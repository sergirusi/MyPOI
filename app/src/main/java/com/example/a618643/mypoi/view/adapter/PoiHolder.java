package com.example.a618643.mypoi.view.adapter;

import com.example.a618643.mypoi.R;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by a618643 on 15/02/2016.
 */
public class PoiHolder extends RecyclerView.ViewHolder {

    private final TextView textView;

    public PoiHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.poiListItemTV);
    }

    public TextView getTextView() {
        return textView;
    }
}
