package com.example.fangli.rv_mvp_annotation.demo2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyu.
 * Created on 下午4:28.
 * Author'github https://github.com/PrettyAnt
 */

public class MyIPresent2 implements IPresent2 {
    List<String> list = new ArrayList<>();
    @Override
    public void getData(IView2 iView2) {
        for (int i = 0; i < 10; i++) {
            list.add("添加了" + i);
        }
        iView2.onGetData(list);
    }
}
