package com.example.executor;

/**
 * Created by a618643 on 09/02/2016.
 */
public interface ThreadExecutor {

    /**
     * Executes a {@link Runnable}.
     *
     * @param runnable The class that implements {@link Runnable} interface.
     */
    void execute(final Runnable runnable);
}
