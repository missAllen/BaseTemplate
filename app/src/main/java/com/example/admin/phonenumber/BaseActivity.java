package com.example.admin.phonenumber;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by admin on 2017/3/30.
 */

public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener{

    private SparseArray<View> mViews;

    public abstract  int getLayoutId();
    public abstract void initViews();
    public abstract void initListener();
    public abstract void initData();
    public abstract void processClick(View view);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViews = new SparseArray<View>();
        setContentView(getLayoutId());
        initViews();
        initListener();
        initData();
    }

    /**
     * 通过id找到view
     * @param
     */
    public <E extends View> E F(int viewId){
        E view = (E) mViews.get(viewId);
        if(view==null){
            view = (E)F(viewId);
            mViews.put(viewId,view);
        }
        return view;
    }
    /**
     * view设置Onclick事件
     */
    public <E extends View>void C(E View){
        View.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        processClick(v);
    }
}
