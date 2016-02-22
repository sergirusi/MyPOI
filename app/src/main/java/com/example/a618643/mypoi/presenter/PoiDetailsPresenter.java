package com.example.a618643.mypoi.presenter;

import com.example.a618643.data.entity.mapper.PoiDetailsDataEntityMapper;
import com.example.a618643.data.repository.PoiDetailsDataRepository;
import com.example.a618643.data.repository.datasource.PoiDetailsDataStoreFactory;
import com.example.a618643.mypoi.UIThread;
import com.example.a618643.mypoi.mapper.PoiDetailsModelDataMapper;
import com.example.a618643.mypoi.model.PoiDetailsModel;
import com.example.a618643.mypoi.view.PoiDetailsView;
import com.example.bo.request.PoiDetailsBoRequest;
import com.example.bo.response.PoiDetailsBoResponse;
import com.example.exception.ErrorBundle;
import com.example.executor.JobExecutor;
import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.interactor.GetPoiDetailsUseCase;
import com.example.interactor.GetPoiDetailsUseCaseImpl;
import com.example.repository.PoiDetailsRepository;

/**
 * Created by a618643 on 15/02/2016.
 */
public class PoiDetailsPresenter implements Presenter {

    private PoiDetailsView poiDetailsView;

    private GetPoiDetailsUseCase getPoiDetailsUseCase;

    private PoiDetailsRepository poiDetailsRepository;

    private PoiDetailsModel poiDetailsModel;

    private PoiDetailsDataEntityMapper poiDetailsDataEntityMapper;

    private PoiDetailsModelDataMapper poiDetailsModelDataMapper;

    private ThreadExecutor threadExecutor;

    private PostExecutionThread postExecutionThread;

    private PoiDetailsBoRequest poiDetailsBoRequest;

    public PoiDetailsPresenter(PoiDetailsView poiDetailsView, PoiDetailsBoRequest poiDetailsBoRequest) {
        if (poiDetailsView == null) {
            throw new IllegalArgumentException("Constructor parameters cannot be null");
        }
        this.poiDetailsView = poiDetailsView;
        poiDetailsDataEntityMapper = new PoiDetailsDataEntityMapper();
        poiDetailsModelDataMapper = new PoiDetailsModelDataMapper();
        threadExecutor = JobExecutor.getInstance();
        postExecutionThread = UIThread.getInstance();
        PoiDetailsDataStoreFactory poiDetailsDataStoreFactory = new PoiDetailsDataStoreFactory(this.poiDetailsView.getContext());
        poiDetailsRepository = PoiDetailsDataRepository.getInstance(poiDetailsDataEntityMapper, poiDetailsDataStoreFactory);
        getPoiDetailsUseCase = new GetPoiDetailsUseCaseImpl(poiDetailsRepository, threadExecutor, postExecutionThread);
        this.poiDetailsBoRequest = poiDetailsBoRequest;
    }


    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    private final GetPoiDetailsUseCase.Callback poiDetailsCallback = new GetPoiDetailsUseCase.Callback() {

        @Override
        public void onPoiDetailsLoaded(PoiDetailsBoResponse poiDetailsBoResponse) {
            poiDetailsModel = poiDetailsModelDataMapper.transformResponseToModel(poiDetailsBoResponse);
            poiDetailsView.renderPoiDetails(poiDetailsModel);
        }

        public void onError(ErrorBundle errorBundle) {
            //TODO implement error case
        }

    };

    public void getPoiDetails() {
        getPoiDetailsUseCase.setPoiDetailsBoRequest(poiDetailsBoRequest);
        getPoiDetailsUseCase.execute(poiDetailsCallback);
    }
}
