package com.wildwolf.mvp.model.impl;


import com.wildwolf.mvp.api.GirlDetailService;
import com.wildwolf.mvp.model.IGirlDetailModel;
import com.wildwolf.mvp.net.NetManager;

import rx.Observable;

/**
 * Author: Othershe
 * Time: 2016/8/17 14:42
 */
public class GirlDetailModelImpl implements IGirlDetailModel {

    @Override
    public Observable<String> getGirlDetailData(String id) {
        GirlDetailService service = NetManager.getInstance().create1(GirlDetailService.class);
        return service.getGirlDetailData(id);
    }
}
