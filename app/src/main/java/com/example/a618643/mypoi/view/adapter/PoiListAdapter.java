package com.example.a618643.mypoi.view.adapter;

import com.example.a618643.mypoi.R;
import com.example.a618643.mypoi.model.PoiListModel;
import com.example.a618643.mypoi.model.PoiModel;
import com.example.a618643.mypoi.view.activity.PoiListActivity;

import org.w3c.dom.Text;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a618643 on 04/02/2016.
 */
public class PoiListAdapter extends RecyclerView.Adapter<PoiHolder> {

    private ArrayList<String> listItem;

    private PoiListModel poiList;

    public PoiListAdapter() {
        listItem = new ArrayList<>();
    }

    public interface ViewOnClickedListener {

        void onItemDetailsClicked(int position);

    }

    private ViewOnClickedListener viewOnClickedListener;

    public void setViewOnClickedListener(ViewOnClickedListener viewOnClickedListener) {
        this.viewOnClickedListener = viewOnClickedListener;
    }

    public void addList(PoiListModel list) {
        poiList = list;
        if(listItem.isEmpty()) {
            for(int i = 0; i < list.size(); i++) {
                String addItem = list.getPoiListItem(i).getTitle();
                listItem.add(addItem);
            }
        } else {
            int listItemSize = listItem.size();
            int limit = listItemSize+list.size();
            for(int i = listItemSize; i < limit; i++) {
                String addItem = list.getPoiListItem(i).getTitle();
                listItem.add(addItem);
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public PoiHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.poi_list_items, parent, false);
        return new PoiHolder(v);
    }

    @Override
    public void onBindViewHolder(PoiHolder holder, final int position) {
        holder.getTextView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewOnClickedListener.onItemDetailsClicked(position);
            }
        });
        String title = listItem.get(position);
        holder.getTextView().setText(title);
    }

    @Override
    public int getItemCount() {
        if(listItem == null) {
            return 0;
        }
        else {
            return listItem.size();
        }
    }
}
