package com.example.wangtao.wangtao_erzhoukao20180619.mvp.homes.model;

import android.util.Log;

import com.example.wangtao.wangtao_erzhoukao20180619.mvp.homes.model.bean.BeanUtil;
import com.example.wangtao.wangtao_erzhoukao20180619.utils.OkHttps;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;

/**
 * Created by wangtao on 2018/6/19.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class LoginModel {
    private static final String TAG = "LoginModel";
           public void logins(String name, String paw, String newPaw, final IncanDech incanDech){
               Log.d(TAG, "logins: "+name+paw);
               //调用工具类
               OkHttps okHttps = OkHttps.getOkHttps();
               //创创建一个map集合
               Map<String,String> map=new HashMap<>();
               map.put("name",name);
               map.put("paw",paw);
              // map.put("newPaw",newPaw);
               String url="https://www.zhaoapi.cn/user/reg";
               //调用post请求
               okHttps.post(url, map, new OkHttps.IncanOkHttp() {
                   @Override
                   public void getDataSuccess(String json) {
                          incanDech.getDataSuccess(json);
                          Log.d(TAG, "getDataSuccess: "+json);
                          Gson gson=new Gson();
                       BeanUtil beanUtil = gson.fromJson(json, BeanUtil.class);
                       String code = beanUtil.getCode();
                       String msg = beanUtil.getMsg();
                       if ("0".equalsIgnoreCase(code)){
                             incanDech.getDataSuccess(msg);
                       }else{
                           incanDech.getDataError(msg);
                       }
                   }

                   @Override
                   public void getDataError(IOException error) {

                   }
               });
           }
           public  interface  IncanDech{
                void getDataSuccess(String json);
                void getDataError(String error);
           }
}
