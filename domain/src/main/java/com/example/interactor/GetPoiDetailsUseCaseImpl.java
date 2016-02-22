package com.example.interactor;

import com.example.bo.request.PoiDetailsBoRequest;
import com.example.bo.response.PoiDetailsBoResponse;
import com.example.exception.ErrorBundle;
import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.repository.PoiDetailsRepository;

/**
 * Created by a618643 on 16/02/2016.
 */
public class GetPoiDetailsUseCaseImpl implements GetPoiDetailsUseCase {

    private Callback callback;

    private PoiDetailsBoRequest poiDetailsBoRequest;

    private PoiDetailsRepository poiDetailsRepository;

    private ThreadExecutor threadExecutor;

    private PostExecutionThread postExecutionThread;

    public GetPoiDetailsUseCaseImpl(PoiDetailsRepository poiDetailsRepository, ThreadExecutor threadExecutor,
            PostExecutionThread postExecutionThread) {
        this.poiDetailsRepository = poiDetailsRepository;
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    @Override
    public void setPoiDetailsBoRequest(PoiDetailsBoRequest poiDetailsBoRequest) {
        this.poiDetailsBoRequest = poiDetailsBoRequest;
    }

    @Override
    public void execute(Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Interactor callback cannot be null!");
        } else {
            this.callback = callback;
            threadExecutor.execute(this);
        }
    }

    private final PoiDetailsRepository.PoiDetailsCallback poiDetailsCallback = new PoiDetailsRepository.PoiDetailsCallback() {
        @Override
        public void onPoiDetailsLoaded(final PoiDetailsBoResponse poiDetailsBoResponse) {
            notifyGetCouponDetailsSuccessfully(poiDetailsBoResponse);
        }

        @Override
        public void onError(final ErrorBundle errorBundle) {
            postExecutionThread.post(new Runnable() {
                @Override
                public void run() {
                    callback.onError(errorBundle);
                }
            });
        }
    };

    @Override
    public void run() {
        poiDetailsRepository.getPoiDetails(poiDetailsBoRequest, poiDetailsCallback);
    }

    private void notifyGetCouponDetailsSuccessfully(final PoiDetailsBoResponse poiDetailsBoResponse) {
        postExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onPoiDetailsLoaded(poiDetailsBoResponse);
            }
        });
    }
}
