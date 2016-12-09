package com.wildwolf.mvp.ui.adapter;

import android.content.Context;

import com.wildwolf.mvp.App;
import com.wildwolf.mvp.R;
import com.wildwolf.mvp.data.GirlItemData;
import com.wildwolf.mvp.ui.adapter.baseadapter.BaseAdapter;
import com.wildwolf.mvp.ui.adapter.baseadapter.ViewHolder;
import com.wildwolf.mvp.ui.weiget.ScaleImageView;
import com.wildwolf.mvp.utils.ImageLoader;

import java.util.List;


/**
 * Author: Othershe
 * Time: 2016/8/18 21:59
 */
public class GirlItemAdapter extends BaseAdapter<GirlItemData> {

    public GirlItemAdapter(Context context, List<GirlItemData> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }

    @Override
    protected void convert(ViewHolder holder, GirlItemData girlItemData) {
        ScaleImageView imageView = holder.getView(R.id.girl_item_iv);
        imageView.setInitSize(girlItemData.getWidth(), girlItemData.getHeight());
        ImageLoader.load(App.getContext(),
                girlItemData.getUrl(), imageView);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_girl_layout;
    }
}
