package com.wildwolf.mvp.model.impl;


import com.wildwolf.mvp.api.GirlItemService;
import com.wildwolf.mvp.model.IGirlItemModel;
import com.wildwolf.mvp.net.NetManager;

import rx.Observable;

/**
 * Author: Othershe
 * Time: 2016/8/17 14:42
 */
public class GirlItemModelImpl implements IGirlItemModel {
    @Override
    public Observable<String> getGirlItemData(String cid, int page) {
        GirlItemService service = NetManager.getInstance().create1(GirlItemService.class);
        return service.getGirlItemData(cid, page);
    }
}
