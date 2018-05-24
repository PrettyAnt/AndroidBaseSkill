package com.example.fangli.rv_mvp_annotation.demo1;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fangli.rv_mvp_annotation.R;
import com.example.fangli.rv_mvp_annotation.demo1.presenter.MyPresenter;
import com.example.fangli.rv_mvp_annotation.demo1.view.IView;
import com.example.fangli.rv_mvp_annotation.util.MyDialogUtils;

import java.util.Map;

public class TestActivity1 extends AppCompatActivity implements IView, View.OnClickListener {

    private Button btn_back, btn_next_act;
    private TextView tv_show_msg;
    private MyPresenter myPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_test);
        initView();
        initEvent();
//        initData();
        myPresenter = new MyPresenter();
    }


    private void initView() {
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_next_act = (Button) findViewById(R.id.btn_test);
        tv_show_msg = (TextView) findViewById(R.id.tv_show_msg);
    }

    private void initEvent() {
        btn_back.setOnClickListener(this);
        btn_next_act.setOnClickListener(this);
    }

    private void initData() {
        myPresenter.loadDatas(this);
    }

    private StringBuffer sb = new StringBuffer();

    @Override
    public void onGetDataList(Map<Integer, String> datas)   {
        for (int i = 0; i < datas.size(); i++) {
            sb.append(datas.get(i));
            Log.i("ttt", datas.get(i));
        }
        tv_show_msg.setText("数据:" + sb.toString());
    }

    @Override
    public void toast(String msg) {
        Toast.makeText(this, "收到：" + msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
//                finish();
                MyDialogUtils.CommDialog(this,
                        "提示",
                        "\"确定\"退出当前界面",
                        "取消",
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
//                                finish();
                                MyDialogUtils.commDialog.dismiss();
                            }
                        }, "确定",
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                finish();
                            }
                        }, new DialogInterface.OnKeyListener() {
                            @Override
                            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                                    Toast.makeText(TestActivity1.this, "退出111111", Toast.LENGTH_SHORT).show();
                                    return true;
                                } else {
                                    Toast.makeText(TestActivity1.this, "没", Toast.LENGTH_SHORT).show();
                                    return false;
                                }
                            }
                        });
                break;
            case R.id.btn_test:
                initData();
                myPresenter.toast(this);
                break;
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Toast.makeText(this, "退出", Toast.LENGTH_SHORT).show();
        return super.onKeyDown(keyCode, event);
    }
}
