package com.example.a618643.data.repository;

import com.example.a618643.data.entity.dto.PoiListDto;
import com.example.a618643.data.entity.mapper.PoiListDataEntityMapper;
import com.example.a618643.data.exception.PoiApiErrorHandler;
import com.example.a618643.data.repository.datasource.PoiListDataStore;
import com.example.a618643.data.repository.datasource.PoiListDataStoreFactory;
import com.example.repository.PoiListRepository;

/**
 * Created by a618643 on 08/02/2016.
 */
public class PoiListDataRepository implements PoiListRepository {

    private final PoiListDataStoreFactory poiListDataStoreFactory;

    private final PoiListDataEntityMapper poiListDataEntityMapper;

    private static PoiListDataRepository ourInstance;

    public static PoiListDataRepository getInstance(PoiListDataEntityMapper poiListDataEntityMapper, PoiListDataStoreFactory poiListDataStoreFactory) {
        if(ourInstance == null) {
            ourInstance = new PoiListDataRepository(poiListDataEntityMapper, poiListDataStoreFactory);
        }
        return ourInstance;
    }

    public PoiListDataRepository(PoiListDataEntityMapper poiListDataEntityMapper, PoiListDataStoreFactory poiListDataStoreFactory) {
        this.poiListDataEntityMapper = poiListDataEntityMapper;
        this.poiListDataStoreFactory = poiListDataStoreFactory;
    }

    public void getPoiList(final PoiListCallback poiListCallback) {

        final PoiListDataStore poiListDataStore = poiListDataStoreFactory.create();

        poiListDataStore.getPoiList(new PoiListDataStore.PoiListCallback() {

            @Override
            public void onPoiListCallback(PoiListDto poiListDto) {
                poiListCallback.onPoiListLoaded(poiListDataEntityMapper.transform(poiListDto));
            }

            @Override
            public void onError(Exception exception) {
                poiListCallback.onError(new PoiApiErrorHandler(exception));
            }
        });
    }


}
