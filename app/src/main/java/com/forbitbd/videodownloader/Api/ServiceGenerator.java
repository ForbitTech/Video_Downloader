package com.forbitbd.videodownloader.Api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static final String BASE_URL = "https://karnaphuli.sultantracker.com";
//    private static final String BASE_URL = "http://mongo2.sultantracker.com:6601";
//    private static final String BASE_URL = "http://103.144.201.119:4000";
//    private static final String BASE_URL = "http://167.71.227.221:2255";
//    private static final String BASE_URL = "http://10.0.2.2:2255/";

    private static final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .readTimeout(3600, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient);

    private static Retrofit retrofit = builder.build();

    public static <S> S createService(
            Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
