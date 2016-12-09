package com.wildwolf.mvp.presenter;


import com.wildwolf.mvp.model.IGirlItemModel;
import com.wildwolf.mvp.model.impl.GirlItemModelImpl;
import com.wildwolf.mvp.rx.RxManager;
import com.wildwolf.mvp.rx.RxSubscriber;
import com.wildwolf.mvp.ui.view.GirlItemView;
import com.wildwolf.mvp.utils.JsoupUtil;

/**
 * Author: Othershe
 * Time: 2016/8/12 14:29
 */
public class GirlItemPresenter extends BasePresenter<GirlItemView> {
    private IGirlItemModel mModel;

    public GirlItemPresenter() {
        mModel = new GirlItemModelImpl();
    }

    public void getGirlItemData(String cid, int page) {
        mSubscription = RxManager.getInstance().doSubscribe(mModel.getGirlItemData(cid, page), new RxSubscriber<String>(false) {
            @Override
            protected void _onNext(String s) {
                mView.onSuccess(JsoupUtil.parseGirls(s));
            }

            @Override
            protected void _onError() {
                mView.onError();
            }
        });
    }
}
