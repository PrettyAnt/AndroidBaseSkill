package com.example.fangli.rv_mvp_annotation.demo2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fangli.rv_mvp_annotation.R;

import java.util.List;

/**
 * Created by chenyu.
 * Created on 下午4:01.
 * Author'github https://github.com/PrettyAnt
 */

public class TestActivity2 extends AppCompatActivity implements View.OnClickListener, IView2 {

    private Button btn_back, btn_test;
    private TextView tv_show_msg;
    private MyIPresent2 myIPresent2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_test);
        initView();
        initEvent();
        initData();
        myIPresent2 = new MyIPresent2();

    }

    private void initView() {
        btn_back = (Button) findViewById(R.id.btn_back);
        tv_show_msg = (TextView) findViewById(R.id.tv_show_msg);
        btn_test = (Button) findViewById(R.id.btn_test);
    }

    private void initEvent() {
        btn_test.setOnClickListener(this);
        btn_back.setOnClickListener(this);
    }

    private void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_test:
                myIPresent2.getData(this);
                break;
        }
    }

    private StringBuffer sb = new StringBuffer();

    @Override
    public void onGetData(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            Log.i("ttt", list.get(i));
            sb.append(list.get(i));
        }
        tv_show_msg.setText(sb.toString());
    }
}
