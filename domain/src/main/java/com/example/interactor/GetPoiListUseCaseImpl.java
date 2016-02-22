package com.example.interactor;

import com.example.bo.response.PoiListBoResponse;
import com.example.exception.ErrorBundle;
import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.repository.PoiListRepository;

/**
 * Created by a618643 on 04/02/2016.
 */
public class GetPoiListUseCaseImpl implements GetPoiListUseCase {

    private Callback callback;

    private PoiListRepository poiListRepository;

    private ThreadExecutor threadExecutor;

    private PostExecutionThread postExecutionThread;

    public GetPoiListUseCaseImpl(PoiListRepository poiListRepository, ThreadExecutor threadExecutor,
            PostExecutionThread postExecutionThread) {
        this.poiListRepository = poiListRepository;
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
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

    private final PoiListRepository.PoiListCallback poiListCallback = new PoiListRepository.PoiListCallback() {
        @Override
        public void onPoiListLoaded(final PoiListBoResponse poiListBoResponse) {
            notifyGetCouponListSuccessfully(poiListBoResponse);
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
        poiListRepository.getPoiList(poiListCallback);
    }

    private void notifyGetCouponListSuccessfully(final PoiListBoResponse poiListBoResponse) {
        postExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onPoiListLoaded(poiListBoResponse);
            }
        });
    }

}
