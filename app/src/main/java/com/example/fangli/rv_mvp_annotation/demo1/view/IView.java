package com.example.fangli.rv_mvp_annotation.demo1.view;

import java.util.Map;

/**
 * Created by chenyu.
 * Created on 下午3:18.
 * Author'github https://github.com/PrettyAnt
 */

public interface IView {
    void onGetDataList(Map<Integer,String> datas);
    void toast(String msg);
}
