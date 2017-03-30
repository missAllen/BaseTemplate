package com.example.admin.phonenumber;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by admin on 2017/3/30.
 */

public abstract class BaseFragment extends Fragment implements View.OnClickListener {
    private boolean isVisible = false;
    private boolean isInitView = false;
    private boolean isFirstLoad = true;

    public View convertView;
    private SparseArray<View> mViews;

    public abstract int getLayoutId();

    public abstract void initViews();

    public abstract void initListener();

    public abstract void initData();

    public abstract void processClick(View v);


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            isVisible = true;
            lazyLoad();
        } else {
            //设置已经不是可见的
            isVisible = false;
        }
    }

    /**
     * 懒加载
     */
    private void lazyLoad() {
        if (!isFirstLoad || !isVisible || !isInitView) {
            //如果不是第一次加载、不是可见的、不是初始化View，则不加载数据
            return;
        }
        //加载数据
        initListener();
        initData();
        //设置已经不是第一次加载
        isFirstLoad = false;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViews = new SparseArray<View>();
        convertView = inflater.inflate(getLayoutId(), container, false);
        initViews();

        isInitView = true;
        lazyLoad();
        return convertView;

    }

    //设置缓存页面
//    viewPager.setOffscreenPageLimit(5);
    @Override
    public void onClick(View v) {
        processClick(v);
    }
}
