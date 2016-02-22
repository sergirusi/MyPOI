package com.example.interactor;

/**
 * Created by a618643 on 09/02/2016.
 */
public interface Interactor extends Runnable{

    /**
     * Everything inside this method will be executed asynchronously.
     */
    void run();
}
