package com.example.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by a618643 on 09/02/2016.
 */
public class JobExecutor implements ThreadExecutor {

    private static final int INITIAL_POOL_SIZE = 3;

    private static final int MAX_POOL_SIZE = 5;

    // Sets the amount of time an idle thread waits before terminating
    private static final int KEEP_ALIVE_TIME = 10;

    // Sets the Time Unit to seconds
    private static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;

    private final BlockingQueue<Runnable> workQueue;

    private final ThreadPoolExecutor threadPoolExecutor;

    private static JobExecutor ourInstance = new JobExecutor();

    public static JobExecutor getInstance() {
        return ourInstance;
    }

    private JobExecutor() {
        this.workQueue = new LinkedBlockingQueue<Runnable>();
        this.threadPoolExecutor = new ThreadPoolExecutor(INITIAL_POOL_SIZE, MAX_POOL_SIZE,
                KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT, this.workQueue);
    }

    @Override
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new IllegalArgumentException("Runnable to execute cannot be null");
        }
        this.threadPoolExecutor.execute(runnable);
    }
}
