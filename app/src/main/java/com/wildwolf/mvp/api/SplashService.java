package com.wildwolf.mvp.api;

import com.wildwolf.mvp.constant.Api;
import com.wildwolf.mvp.data.SplashData;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Author: Othershe
 * Time:  2016/8/11 12:30
 */
public interface SplashService {
    String BASE_URL = Api.URL_GET_SPLASH_PIC;

    @GET("1080*1920")
    Observable<SplashData> getSplashPic();
}
