package com.example.a618643.mypoi;

import com.example.executor.PostExecutionThread;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by a618643 on 09/02/2016.
 */
public class UIThread implements PostExecutionThread {

    private static UIThread ourInstance = new UIThread();

    public static UIThread getInstance() {
        return ourInstance;
    }

    private final Handler handler;

    private UIThread() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    /**
     * Causes the Runnable r to be added to the message queue.
     * The runnable will be run on the main thread.
     *
     * @param runnable {@link Runnable} to be executed.
     */
    @Override
    public void post(Runnable runnable) {
        handler.post(runnable);
    }
}
