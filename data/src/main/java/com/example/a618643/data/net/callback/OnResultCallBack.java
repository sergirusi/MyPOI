package com.example.a618643.data.net.callback;

import retrofit.RetrofitError;

/**
 * Created by a618643 on 10/02/2016.
 */
public interface OnResultCallBack<K> {

    /**
     * Used on everything in request works ok.
     *
     * @param code HTTP code of request
     * @param t    Object from api, in specified by extends type.
     */
    void onResponseOK(int code, K t);

    /**
     * Used on custom error should be delivered.
     *
     * @param code         HTTP code of response.
     * @param errorMessage Message of error from http request
     * @param error        The body of the response
     */
    void onError(int code, String errorMessage, RetrofitError error);

}
