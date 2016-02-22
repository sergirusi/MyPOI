package com.example.exception;

/**
 * Created by a618643 on 05/02/2016.
 */
public class DefaultErrorBundle implements ErrorBundle {

    private final Exception exception;

    public DefaultErrorBundle(Exception exception) {
        this.exception = exception;
    }

    @Override
    public Exception getException() {
        return exception;
    }

    @Override
    public String getErrorMessage() {
        String message = "";
        if(this.exception == null) {
            message = this.exception.getMessage();
        }
        return message;
    }
}
