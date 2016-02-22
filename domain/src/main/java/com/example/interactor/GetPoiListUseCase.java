package com.example.interactor;

import com.example.bo.response.PoiListBoResponse;
import com.example.exception.ErrorBundle;

/**
 * Created by a618643 on 04/02/2016.
 */
public interface GetPoiListUseCase extends Interactor {

    interface Callback {

        void onPoiListLoaded(PoiListBoResponse poiListBoResponse);

        void onError(ErrorBundle errorBundle);

    }

    void execute(Callback callback);
}
