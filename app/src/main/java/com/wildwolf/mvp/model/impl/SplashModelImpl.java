package com.wildwolf.mvp.model.impl;


import com.wildwolf.mvp.api.SplashService;
import com.wildwolf.mvp.data.SplashData;
import com.wildwolf.mvp.model.ISplashModel;
import com.wildwolf.mvp.net.NetManager;

import rx.Observable;

/**
 * Author: Othershe
 * Time:  2016/8/11 12:22
 */
public class SplashModelImpl implements ISplashModel {

    @Override
    public Observable<SplashData> getSplashPic() {
        SplashService service = NetManager.getInstance().create(SplashService.class);
        return service.getSplashPic();
    }
}
