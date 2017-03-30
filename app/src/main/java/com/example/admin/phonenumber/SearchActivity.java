package com.example.admin.phonenumber;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by admin on 2017/3/30.
 */

public class SearchActivity extends BaseActivity {

    private TextView tv;
    private Button btn;
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews() {
        tv =  F(R.id.txt);
        btn = F(R.id.btn);
    }

    @Override
    public void initListener() {
        C(tv);
        C(btn);
    }

    @Override
    public void initData() {

    }

    @Override
    public void processClick(View view) {
        switch (view.getId()){
            case R.id.txt:
                break;
            case R.id.btn:
                break;
        }
    }
}
