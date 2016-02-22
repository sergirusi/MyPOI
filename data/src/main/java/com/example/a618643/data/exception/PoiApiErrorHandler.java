package com.example.a618643.data.exception;

import com.example.exception.ErrorBundle;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import android.util.Log;

import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by a618643 on 03/02/2016.
 */
public class PoiApiErrorHandler implements retrofit.ErrorHandler,
        ErrorBundle {

    protected final String TAG = getClass().getSimpleName();

    private final Exception exception;

    public PoiApiErrorHandler(Exception exception) {
        this.exception = exception;
    }

    @Override
    public Throwable handleError(RetrofitError cause) {
        Response r = cause.getResponse();
        if (r != null && r.getStatus() == 401) {
            Log.e(TAG, "Error: ", cause);
        }
        return cause;
    }

    @Override
    public Exception getException() {
        return exception;
    }

    @Override
    public String getErrorMessage() {
        String message = "";
        if (this.exception != null) {
            this.exception.getMessage();
        }
        return message;
    }
}
