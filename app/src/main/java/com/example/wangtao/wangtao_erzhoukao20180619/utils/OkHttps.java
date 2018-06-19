package com.example.wangtao.wangtao_erzhoukao20180619.utils;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by wangtao on 2018/6/19.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class OkHttps {
        private static OkHttps  okHttps=new OkHttps();
        private OkHttpClient okHttpClient;
        private Handler handler;

        public OkHttps() {
                handler =new Handler(Looper.myLooper());
                okHttpClient =new OkHttpClient.Builder()
                        .connectTimeout(2000, TimeUnit.MILLISECONDS)
                        .readTimeout(2000, TimeUnit.MILLISECONDS)
                        .writeTimeout(2000, TimeUnit.MILLISECONDS)
                        .build();
        }

        public static OkHttps getOkHttps() {
                if (okHttps == null){
                         synchronized (OkHttps.class){
                                  if (okHttps== null){
                                    okHttps =new OkHttps();
                                  }
                         }
                }
                return okHttps;
        }

        //封装post
        public void post(String url, Map<String,String> map, final IncanOkHttp incanOkHttp){
                FormBody.Builder formBody=new FormBody.Builder();
                for (String key:map.keySet()) {
                         formBody.add(key,map.get(key));
                }
                FormBody build = formBody.build();

                Request request=new Request.Builder()
                        .post(build)
                        .url(url)
                        .build();
                Call call=okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, final IOException e) {
                                  if (incanOkHttp != null){
                                           handler.post(new Runnable() {
                                                   @Override
                                                   public void run() {
                                                      incanOkHttp.getDataError(e);
                                                   }
                                           });
                                  }
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                                if (incanOkHttp != null){
                                        if (response != null && response.isSuccessful()){
                                                final String json = response.body().string();
                                                handler.post(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                           incanOkHttp.getDataSuccess(json);
                                                        }
                                                });

                                        }
                                }
                        }
                });
        }
      public interface   IncanOkHttp{
                void getDataSuccess(String json);
                void getDataError(IOException  error);
      }
}
