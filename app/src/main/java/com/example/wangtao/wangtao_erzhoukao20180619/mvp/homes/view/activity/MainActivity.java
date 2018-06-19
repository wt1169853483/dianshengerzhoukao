package com.example.wangtao.wangtao_erzhoukao20180619.mvp.homes.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wangtao.wangtao_erzhoukao20180619.R;
import com.example.wangtao.wangtao_erzhoukao20180619.base.BaseActivity;
import com.example.wangtao.wangtao_erzhoukao20180619.mvp.homes.presenter.LoginPresenter;
import com.example.wangtao.wangtao_erzhoukao20180619.mvp.homes.view.iview.LoginView;

public class MainActivity extends BaseActivity<LoginPresenter> implements View.OnClickListener,LoginView {
    private static final String TAG = "MainActivity";
    private EditText editText;
    private EditText editText1;
    private EditText editText2;

    @Override
    protected int prolidPresenter() {
        return R.layout.activity_main;
    }
    @Override
    protected LoginPresenter prolidID() {
        return new LoginPresenter(this);
    }

    @Override
    protected void InitView() {
        //获取组件
        editText = findViewById(R.id.main_editName);
        editText1 = findViewById(R.id.main_editPaw);
        editText2 = findViewById(R.id.main_editNewPaw);
        Button btn=findViewById(R.id.main_regBtn);
        btn.setOnClickListener(this);
    }
    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        String name = editText.getText().toString();
        String pwd = editText1.getText().toString();
        String newPwd = editText2.getText().toString();
        Log.d(TAG, "onClick: "+name+"  "+pwd);
        presenter.logins(name,pwd,newPwd);
    }

    @Override
    public void getDataSuccess(String data) {
        Intent intent=new Intent(MainActivity.this,ShouActivity.class);

        Toast.makeText(MainActivity.this,data,Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    @Override
    public void getDataError(String error) {
        Toast.makeText(MainActivity.this,error,Toast.LENGTH_SHORT).show();
    }
}
