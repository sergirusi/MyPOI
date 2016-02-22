package com.example.a618643.mypoi.view.activity;

import com.example.a618643.mypoi.R;
import com.example.a618643.mypoi.model.PoiListModel;
import com.example.a618643.mypoi.navigation.Navigator;
import com.example.a618643.mypoi.presenter.PoiListPresenter;
import com.example.a618643.mypoi.view.PoiListView;
import com.example.a618643.mypoi.view.adapter.ItemDecoration.DividerItemDecoration;
import com.example.a618643.mypoi.view.adapter.PoiListAdapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import retrofit.Callback;

/**
 * Created by a618643 on 02/02/2016.
 */
public class PoiListActivity extends Activity implements PoiListView, PoiListAdapter.ViewOnClickedListener {

    private RecyclerView poiListRecyclerView;

    private PoiListPresenter poiListPresenter;

    private PoiListAdapter poiListAdapter;

    private Callback<PoiListModel> callback;

    private Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poi_list);
        findViews();
        init();
        setListeners();
    }

    private void setListeners() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        poiListPresenter.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        poiListPresenter.pause();
    }

    private void init() {
        poiListPresenter = new PoiListPresenter(this);
        poiListPresenter.getPoiList();
        poiListAdapter = new PoiListAdapter();
        poiListAdapter.setViewOnClickedListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        poiListRecyclerView.setLayoutManager(linearLayoutManager);
        poiListRecyclerView.setAdapter(poiListAdapter);
        poiListRecyclerView.addItemDecoration(new DividerItemDecoration(this));
        poiListRecyclerView.setItemAnimator(new DefaultItemAnimator());
        navigator = new Navigator(this);
    }

    private void findViews() {
        poiListRecyclerView = (RecyclerView) findViewById(R.id.poilist);
    }

    @Override
    public void renderPoiList(PoiListModel poiList) {
        if (poiList != null && poiList.size() > 0) {
            poiListAdapter.addList(poiList);
        }
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void onItemDetailsClicked(int position) {
        navigator.PoiDetailsNavigate(this, position+1);
    }
}
