package com.wildwolf.mvp.presenter;


import com.wildwolf.mvp.model.IGirlDetailModel;
import com.wildwolf.mvp.model.impl.GirlDetailModelImpl;
import com.wildwolf.mvp.rx.RxManager;
import com.wildwolf.mvp.rx.RxSubscriber;
import com.wildwolf.mvp.ui.view.GirlDetailView;
import com.wildwolf.mvp.utils.JsoupUtil;

/**
 * Author: Othershe
 * Time: 2016/8/12 14:29
 */
public class GirlDetailPresenter extends BasePresenter<GirlDetailView> {
    private IGirlDetailModel mModel;

    public GirlDetailPresenter() {
        mModel = new GirlDetailModelImpl();
    }

    public void getGirlDetailData(String id) {
        mSubscription = RxManager.getInstance().doSubscribe(mModel.getGirlDetailData(id), new RxSubscriber<String>(false) {
            @Override
            protected void _onNext(String s) {
                mView.onSuccess(JsoupUtil.parseGirlDetail(s));
            }

            @Override
            protected void _onError() {
                mView.onError();
            }
        });
    }
}
