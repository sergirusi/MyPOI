package com.example.a618643.data.net.callback;

import android.content.Context;

/**
 * Created by a618643 on 10/02/2016.
 */
public abstract class ApiConnectionCallBack<Response, DataStore> implements OnResultCallBack<Response> {

    private Context context;

    private DataStore dataStore;

    public ApiConnectionCallBack(Context context, DataStore dataStore) {
        this.context = context;
        this.dataStore = dataStore;
    }
}
