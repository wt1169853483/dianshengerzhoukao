package com.example.wangtao.wangtao_erzhoukao20180619.mvp.homes.view.iview;

import com.example.wangtao.wangtao_erzhoukao20180619.base.IView;

/**
 * Created by wangtao on 2018/6/19.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public interface LoginView extends IView {
    void getDataSuccess(String data);
    void getDataError(String error);
}
