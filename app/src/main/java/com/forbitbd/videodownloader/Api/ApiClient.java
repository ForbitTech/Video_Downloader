package com.forbitbd.videodownloader.Api;

import com.forbitbd.videodownloader.VideoRequest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiClient {

    @GET("/downloader")
    Call<ResponseBody> getVideo();

    @POST("/downloader")
    Call<ResponseBody> getVideoFromUrl(@Body VideoRequest videoRequest);
}
