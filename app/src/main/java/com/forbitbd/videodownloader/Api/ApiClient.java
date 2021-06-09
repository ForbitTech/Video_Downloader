package com.forbitbd.videodownloader.Api;

import com.forbitbd.videodownloader.utils.VideoRequest;
import com.forbitbd.videodownloader.models.VideoData;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiClient {

    @GET("/downloader")
    Call<ResponseBody> getVideo();

    @POST("/youtube/downloader")
    Call<VideoData> getVideoFromData(@Body VideoRequest videoRequest);

    @POST("/youtube/filegetter")
    Call<ResponseBody> downloadFile(@Body VideoData data);

//    @POST("/downloader")
//    Call<VideoData> getVideoFromData(@Body VideoRequest videoRequest);
//
//    @POST("/filegetter")
//    Call<ResponseBody> downloadFile(@Body VideoData data);
}
