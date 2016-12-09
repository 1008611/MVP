package com.wildwolf.mvp.presenter;


import com.wildwolf.mvp.data.SplashData;
import com.wildwolf.mvp.model.ISplashModel;
import com.wildwolf.mvp.model.impl.SplashModelImpl;
import com.wildwolf.mvp.rx.RxManager;
import com.wildwolf.mvp.rx.RxSubscriber;
import com.wildwolf.mvp.ui.view.SplashView;

/**
 * Author: Othershe
 * Time:  2016/8/11 11:26
 */
public class SplashPresenter extends BasePresenter<SplashView> {
    private ISplashModel mModel;

    public SplashPresenter() {
        mModel = new SplashModelImpl();
    }

    public void getSplashPic() {
        mSubscription = RxManager.getInstance().doSubscribe(mModel.getSplashPic(), new RxSubscriber<SplashData>(false) {
            @Override
            protected void _onNext(SplashData data) {
                mView.onSuccess(data);
            }

            @Override
            protected void _onError() {
                mView.onError();
            }
        });
    }
}
