package com.example.fangli.rv_mvp_annotation.demo1.presenter;

import com.example.fangli.rv_mvp_annotation.demo1.view.IView;

/**
 * Created by chenyu.
 * Created on 下午3:20.
 * Author'github https://github.com/PrettyAnt
 */

public interface IPresenter {
    void loadDatas(IView iView);

    void toast(IView iView);
}
