package com.example.wangtao.wangtao_erzhoukao20180619.base;

/**
 * Created by wangtao on 2018/6/19.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public abstract class BasePresenter <V extends IView> {
        protected V iview;

    public BasePresenter(V iview) {
        this.iview = iview;
        InitModel();
    }

    protected abstract void InitModel();

    //处理内存外漏
    void getDestroy(){
         iview =null;
    }
}
