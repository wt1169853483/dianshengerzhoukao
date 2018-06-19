package com.example.wangtao.wangtao_erzhoukao20180619.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by wangtao on 2018/6/19.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public abstract class BaseActivity <P extends BasePresenter> extends AppCompatActivity {
       protected  P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         presenter =prolidID();
         setContentView(prolidPresenter());
         InitView();
         initListener();
         initData();
    }

    protected abstract void initData();

    protected abstract void initListener();

    protected abstract void InitView();

    protected abstract int prolidPresenter();

    protected abstract P prolidID();

    //处理内存泄漏

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.getDestroy();
    }
}
