package com.wildwolf.mvp.ui.activity;


import android.content.Intent;
import android.os.Handler;
import android.widget.ImageView;

import com.wildwolf.mvp.R;
import com.wildwolf.mvp.data.SplashData;
import com.wildwolf.mvp.presenter.SplashPresenter;
import com.wildwolf.mvp.ui.fragemnt.SetFragment;
import com.wildwolf.mvp.ui.view.SplashView;
import com.wildwolf.mvp.utils.DateUtil;
import com.wildwolf.mvp.utils.ImageLoader;
import com.wildwolf.mvp.utils.NetUtil;
import com.wildwolf.mvp.utils.SPUtil;

import butterknife.BindView;

/**
 * Author: Othershe
 * Time:  2016/8/11 11:22
 */
public class SplashActivity extends BaseMvpActivity<SplashView, SplashPresenter> implements SplashView {
    private String mTimeLine;

    @BindView(R.id.splash_iv)
    ImageView mSplashIv;

    @Override
    protected SplashPresenter initPresenter() {
        return new SplashPresenter();
    }

    @Override
    protected void fetchData() {
        if (!DateUtil.formatDate().equals(mTimeLine)) {
            mPresenter.getSplashPic();
        }
    }

    @Override
    protected int initLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
//        if (!(Boolean) SPUtil.get(SetFragment.SPLASH, false) || !NetUtil.isConnected(mContext)) {
            ImageLoader.load(mContext, R.drawable.original_splash, mSplashIv);
//        } else {
//            ImageLoader.load(mContext, (String) SPUtil.get("splash_url", ""), mSplashIv);
//        }

        startDelay();
    }

    @Override
    protected void initData() {
        mTimeLine = (String) SPUtil.get("splash_time", "");
    }

    @Override
    public void onSuccess(SplashData data) {
        SPUtil.save("splash_time", DateUtil.formatDate());
        SPUtil.save("splash_url", data.getUrl());
    }

    @Override
    public void onError() {

    }

    private void startDelay() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(mContext, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}
