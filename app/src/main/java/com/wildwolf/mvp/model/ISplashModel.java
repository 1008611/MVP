package com.wildwolf.mvp.model;


import com.wildwolf.mvp.data.SplashData;

import rx.Observable;

/**
 * Author: Othershe
 * Time:  2016/8/11 15:17
 */
public interface ISplashModel {
    Observable<SplashData> getSplashPic();
}
