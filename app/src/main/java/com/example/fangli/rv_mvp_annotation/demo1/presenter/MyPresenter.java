package com.example.fangli.rv_mvp_annotation.demo1.presenter;

import android.os.Handler;

import com.example.fangli.rv_mvp_annotation.demo1.view.IView;

import java.util.HashMap;

/**
 * Created by chenyu.
 * Created on 下午3:24.
 * Author'github https://github.com/PrettyAnt
 */

public class MyPresenter implements IPresenter {

    public MyPresenter() {

    }

    private HashMap<Integer, String> data = new HashMap<>();
    private Handler handler = new Handler();
    @Override
    public void loadDatas(final IView iView) {
//        mView.onGetDataList(data);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    data.put(i, "这是测试数据" + i);
                }
                iView.onGetDataList(data);
            }
        }, 5000l);
    }

    @Override
    public void toast(IView iView) {
        iView.toast("发送了消息");
    }

}
