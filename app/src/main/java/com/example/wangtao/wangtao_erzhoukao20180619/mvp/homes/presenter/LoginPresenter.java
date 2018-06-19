package com.example.wangtao.wangtao_erzhoukao20180619.mvp.homes.presenter;

import android.util.Log;

import com.example.wangtao.wangtao_erzhoukao20180619.base.BasePresenter;
import com.example.wangtao.wangtao_erzhoukao20180619.mvp.homes.model.LoginModel;
import com.example.wangtao.wangtao_erzhoukao20180619.mvp.homes.view.iview.LoginView;

/**
 * Created by wangtao on 2018/6/19.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class LoginPresenter extends BasePresenter<LoginView> {
    private static final String TAG = "LoginPresenter";

    private LoginModel loginModel;

    public LoginPresenter(LoginView iview) {
        super(iview);
    }

    @Override
    protected void InitModel() {
        loginModel = new LoginModel();
    }

    public void logins(String name,String paw,String newPaw){
        Log.d(TAG, "logins:++++++++++++++ "+name+paw);
            loginModel.logins(name, paw, newPaw, new LoginModel.IncanDech() {
                @Override
                public void getDataSuccess(String json) {
                         if (iview != null){
                                iview.getDataSuccess(json);
                         }
                }

                @Override
                public void getDataError(String error) {
                    if (iview != null){
                        iview.getDataError(error);
                    }
                }
            });
    }
}
