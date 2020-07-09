package com.example.customizetextview.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.customizetextview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChenYu
 * My personal blog  https://prettyant.github.io
 * <p>
 * Created on 1:42 PM  2020/6/14
 * PackageName : com.example.spdbsoappandroid.View.pop
 * describle :
 */
public class QueuePopWindow  {
    private static QueuePopWindow                    INSTANCE;
    private        PopupWindow                          popupWindow;
    private        Activity                             activity;

    public static QueuePopWindow getInstance() {
        if (INSTANCE == null) {
            synchronized (QueuePopWindow.class) {
                if (INSTANCE == null) {
                    INSTANCE = new QueuePopWindow();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * pop是否显示
     *
     * @return
     */
    public boolean isShow() {
        if (popupWindow == null) {
            return false;
        } else {
            return popupWindow.isShowing();
        }
    }

    /**
     *      * 创建popupWindow
     * <p>
     *      *popupWindow 是全局定义的，根W据自己需要定义
     *      * @param view View 比如：btn_ok的点击后触发popupWindow，则view就是id为btn_ok对应的view
     *      
     */
    @SuppressLint("WrongConstant")
    public PopupWindow showBottomPop(View view, Activity activity) {
        this.activity = activity;
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
            popupWindow = null;
        }
        LayoutInflater inflater    = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View           contentView = inflater.inflate(R.layout.pop_queue, null);
        initView(activity, contentView);
        initEvent();
        popupWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        //点击空白处时，隐藏掉pop窗口
        popupWindow.setFocusable(false);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchable(false);
        setBackgroundAlpha(0.4f);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        //添加弹出、弹入的动画
//        popupWindow.setAnimationStyle(R.style.bottom_popwindow);
//        popupWindow.showAtLocation(view, Gravity.LEFT | Gravity.BOTTOM, 0, 0);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
        //添加按键事件监听
//        setButtonListeners(layout);
        //添加pop窗口关闭事件，主要是实现关闭时改变背景的透明度
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                setBackgroundAlpha(1.0f);

            }
        });
        return popupWindow;
    }


    /**
     * 初始化pop页面的数据
     *
     * @param activity
     * @param inflate
     */
    private void initView(Activity activity, View inflate) {
    }

    private void initEvent() {
    }

    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha 屏幕透明度0.0-1.0 1表示完全不透明
     */
    private void setBackgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = activity.getWindow()
                .getAttributes();
        lp.alpha = bgAlpha;
        activity.getWindow().setAttributes(lp);
    }

    /**
     * 隐藏popupWindow
     */
    public void hideBottomPop() {
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

}
