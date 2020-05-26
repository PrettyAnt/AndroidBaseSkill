package com.example.mvpstrategy.presenter;

import android.os.Handler;

import com.example.mvpstrategy.view.IView;

import java.util.HashMap;

/**
 * Created by chenyu.
 * Created on 下午3:24.
 * Author'github https://github.com/PrettyAnt
 */

public class MyPresenter  {
    private static MyPresenter instance;

    public static MyPresenter getInstance() {
        if (instance == null) {
            synchronized (MyPresenter.class) {
                if (instance == null) {
                    instance = new MyPresenter();
                }
            }
        }
        return instance;
    }
    private MyPresenter() {
    }

    private HashMap<Integer, String> data = new HashMap<>();
    private Handler handler = new Handler();
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

}
