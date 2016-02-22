package com.example.a618643.data.repository;

import com.example.a618643.data.entity.dto.PoiDetailsDto;
import com.example.a618643.data.entity.mapper.PoiDetailsDataEntityMapper;
import com.example.a618643.data.exception.PoiApiErrorHandler;
import com.example.a618643.data.repository.datasource.PoiDetailsDataStore;
import com.example.a618643.data.repository.datasource.PoiDetailsDataStoreFactory;
import com.example.bo.request.PoiDetailsBoRequest;
import com.example.repository.PoiDetailsRepository;

/**
 * Created by a618643 on 16/02/2016.
 */
public class PoiDetailsDataRepository implements PoiDetailsRepository {

    private final PoiDetailsDataStoreFactory poiDetailsDataStoreFactory;

    private final PoiDetailsDataEntityMapper poiDetailsDataEntityMapper;

    private static PoiDetailsDataRepository ourInstance;

    public static PoiDetailsDataRepository getInstance(PoiDetailsDataEntityMapper poiDetailsDataEntityMapper, PoiDetailsDataStoreFactory poiDetailsDataStoreFactory) {
        if(ourInstance == null) {
            ourInstance = new PoiDetailsDataRepository(poiDetailsDataEntityMapper, poiDetailsDataStoreFactory);
        }
        return ourInstance;
    }

    public PoiDetailsDataRepository(PoiDetailsDataEntityMapper poiDetailsDataEntityMapper, PoiDetailsDataStoreFactory poiDetailsDataStoreFactory) {
        this.poiDetailsDataEntityMapper = poiDetailsDataEntityMapper;
        this.poiDetailsDataStoreFactory = poiDetailsDataStoreFactory;
    }

    public void getPoiDetails(PoiDetailsBoRequest poiDetailsBoRequest, final PoiDetailsCallback poiDetailsCallback) {

        final PoiDetailsDataStore poiDetailsDataStore = poiDetailsDataStoreFactory.create();

        poiDetailsDataStore.getPoiDetails(poiDetailsBoRequest.getId(), new PoiDetailsDataStore.PoiDetailsCallback() {

            @Override
            public void onPoiDetailsCallback(PoiDetailsDto poiDetailsDto) {
                poiDetailsCallback.onPoiDetailsLoaded(poiDetailsDataEntityMapper.transform(poiDetailsDto));
            }

            @Override
            public void onError(Exception exception) {
                poiDetailsCallback.onError(new PoiApiErrorHandler(exception));
            }
        });
    }
}
