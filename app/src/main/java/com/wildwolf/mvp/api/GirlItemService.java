package com.wildwolf.mvp.api;


import com.wildwolf.mvp.constant.Api;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Author: Othershe
 * Time: 2016/8/17 11:49
 */
public interface GirlItemService {
    String BASE_URL = Api.URL_GET_GIRL;

    @GET("show.htm")
    Observable<String> getGirlItemData(@Query("cid") String cid, @Query("pager_offset") int pager_offset);
}
