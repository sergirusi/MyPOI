package com.example.a618643.mypoi.presenter;

import com.example.a618643.data.entity.mapper.PoiListDataEntityMapper;
import com.example.a618643.data.repository.PoiListDataRepository;
import com.example.a618643.data.repository.datasource.PoiListDataStoreFactory;
import com.example.a618643.mypoi.UIThread;
import com.example.a618643.mypoi.mapper.PoiListModelDataMapper;
import com.example.a618643.mypoi.model.PoiListModel;
import com.example.a618643.mypoi.view.PoiListView;
import com.example.bo.response.PoiListBoResponse;
import com.example.exception.ErrorBundle;
import com.example.executor.JobExecutor;
import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.interactor.GetPoiListUseCase;
import com.example.interactor.GetPoiListUseCaseImpl;
import com.example.repository.PoiListRepository;


/**
 * Created by a618643 on 04/02/2016.
 */
public class PoiListPresenter implements Presenter {

    private PoiListView poiListView;

    private GetPoiListUseCase getPoiListUseCase;

    private PoiListRepository poiListRepository;

    private PoiListModel poiListModel;

    private PoiListDataEntityMapper poiListDataEntityMapper;

    private PoiListModelDataMapper poiListModelDataMapper;

    private ThreadExecutor threadExecutor;

    private PostExecutionThread postExecutionThread;

    public PoiListPresenter(PoiListView poiListView) {
        if (poiListView == null) {
            throw new IllegalArgumentException("Constructor parameters cannot be null");
        }
        this.poiListView = poiListView;
        poiListDataEntityMapper = new PoiListDataEntityMapper();
        poiListModelDataMapper = new PoiListModelDataMapper();
        threadExecutor = JobExecutor.getInstance();
        postExecutionThread = UIThread.getInstance();
        PoiListDataStoreFactory poiListDataStoreFactory = new PoiListDataStoreFactory(this.poiListView.getContext());
        poiListRepository = PoiListDataRepository.getInstance(poiListDataEntityMapper, poiListDataStoreFactory);
        getPoiListUseCase = new GetPoiListUseCaseImpl(poiListRepository, threadExecutor, postExecutionThread);
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    private final GetPoiListUseCase.Callback poiListCallback = new GetPoiListUseCase.Callback() {

        @Override
        public void onPoiListLoaded(PoiListBoResponse poiListBoResponse) {
            poiListModel = poiListModelDataMapper.transformResponseToModel(poiListBoResponse);
            poiListView.renderPoiList(poiListModel);
        }

        public void onError(ErrorBundle errorBundle) {
            //TODO implement error case
        }

    };

    public void getPoiList() {
        getPoiListUseCase.execute(poiListCallback);
    }
}
