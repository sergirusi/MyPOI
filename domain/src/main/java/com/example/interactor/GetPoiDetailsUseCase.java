package com.example.interactor;

import com.example.bo.request.PoiDetailsBoRequest;
import com.example.bo.response.PoiDetailsBoResponse;
import com.example.exception.ErrorBundle;

/**
 * Created by a618643 on 15/02/2016.
 */
public interface GetPoiDetailsUseCase extends Interactor {

    interface Callback {

        void onPoiDetailsLoaded(PoiDetailsBoResponse poiDetailsBoResponse);

        void onError(ErrorBundle errorBundle);
    }

    void setPoiDetailsBoRequest(PoiDetailsBoRequest poiDetailsBoRequest);

    void execute(Callback callback);
}
