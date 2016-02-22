package com.example.a618643.data.net.client.base;

import com.example.a618643.data.net.callback.OnResultCallBack;
import com.squareup.okhttp.OkHttpClient;

import org.apache.http.HttpStatus;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;

/**
 * Created by a618643 on 10/02/2016.
 */
public abstract class PoiBaseClient <K> implements Callback<K>, RequestInterceptor, RestAdapter.Log {

    private static final String CLASS_TAG = PoiBaseClient.class.getSimpleName();

    protected Context context;

    protected String id;

    protected final String baseURL;

    protected final String contextURI;

    protected final String apiVersion;

    protected OnResultCallBack<K> onResultCallBack;


    public PoiBaseClient(Context context, String baseURL, String contextURI,
            String apiVersion, String id) {
        this.context = context;
        this.baseURL = baseURL;
        this.contextURI = contextURI;
        this.apiVersion = apiVersion;
        this.id = id;

    }


    protected static OkHttpClient getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain,
                                String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain,
                                String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient okHttpClient = new OkHttpClient();
            okHttpClient.setSslSocketFactory(sslSocketFactory);
            okHttpClient.setHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            okHttpClient.setConnectTimeout(45, TimeUnit.SECONDS);
            okHttpClient.setReadTimeout(45, TimeUnit.SECONDS);

            return okHttpClient;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public final String getBaseURL() {
        return baseURL;
    }

    public final String getApiVersion() {
        return apiVersion;
    }

    public final String getEndpoint() {
        String endpoint = baseURL;
        if (!TextUtils.isEmpty(contextURI)) {
            endpoint += "/";
            endpoint += contextURI;
        }
        return endpoint;
    }

    private RestAdapter createRestAdapter() {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(getEndpoint())
                .setRequestInterceptor(this)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setLog(this)//Workaround for SSL certificate issue
                .setClient(new OkClient(getUnsafeOkHttpClient()))
                .build();

        return restAdapter;
    }

    /**
     * Configure Retrofit request with URL and Converter.
     * Sends {@link RestAdapter} to <b>execute(RestAdapter restAdapter)</b>;
     */
    public void execute() {
        RestAdapter restAdapter = createRestAdapter();
        execute(restAdapter);
    }

    /**
     * Create an implementation of the API defined by the specified service interface.
     *
     * @param restAdapter {@link RestAdapter} Used to create Service that executes request.
     *
     * @see <a href="http://square.github.io/retrofit/#introduction">http://square.github.io/retrofit/#introduction</a>
     */
    public abstract void execute(RestAdapter restAdapter);

    /**
     * Successful HTTP response.
     */
    @Override
    public void success(K k, retrofit.client.Response response) {
        if (HttpStatus.SC_OK == response.getStatus()) {
            onResultCallBack.onResponseOK(response.getStatus(), k);
        } else {
            handleError(response.getStatus(), response.getReason(), null);
        }
    }

    /**
     * Unsuccessful HTTP response due to network failure, non-2XX status code, or unexpected
     * exception.
     */
    @Override
    public void failure(RetrofitError error) {
        if (error.getResponse() != null) {
            handleError(error.getResponse().getStatus(), error.getMessage(), error);
        } else {
            handleError(-1, error.getMessage(), error);
        }
    }

    private void handleError(int code, String message, RetrofitError error) {
        onResultCallBack.onError(code, message, error);
    }

    /**
     * @return {@link OnResultCallBack} Callback sets to
     * retrieve response.
     */
    public OnResultCallBack<K> getOnResultCallBack() {
        return onResultCallBack;
    }

    /**
     * Sets the callback to retrieve the response.
     *
     * @param onResultCallBack {@link OnResultCallBack}
     */
    public void setOnResultCallBack(OnResultCallBack<K> onResultCallBack) {
        this.onResultCallBack = onResultCallBack;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public void intercept(RequestInterceptor.RequestFacade request) {
        //TODO move this strings to constants file
        request.addHeader("Accept", "application/json");
    }

    @Override
    public void log(String message) {
        Log.d(CLASS_TAG, " " + message);
    }

}
