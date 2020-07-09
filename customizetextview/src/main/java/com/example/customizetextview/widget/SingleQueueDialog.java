package com.example.customizetextview.widget;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.customizetextview.R;

/**
 * @author ChenYu
 * My personal blog  https://prettyant.github.io
 * <p>
 * Created on 3:50 PM  2020/6/29
 * PackageName : com.example.customizetextview.widget
 * describle :
 */
public class SingleQueueDialog {
    private static SingleQueueDialog instance;
    private AlertDialog alertDialog;

    public static SingleQueueDialog getInstance() {
        if (instance == null) {
            synchronized (SingleQueueDialog.class) {
                if (instance == null) {
                    instance = new SingleQueueDialog();
                }
            }
        }
        return instance;
    }

    public void showQueueDialog(Activity activity) {
        //设置主题样式
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.Theme_Transparent);
        //布局文件
        View inflate = LayoutInflater.from(activity).inflate(R.layout.pop_queue, null);
        initQueueView(inflate);
        builder.setView(inflate);
        //创建dialog
        alertDialog = builder.create();
        //显示dialog
        alertDialog.show();
        //获取dialog窗口对象
        Window window = alertDialog.getWindow();
        assert window != null;
        window.setGravity(Gravity.BOTTOM);
        //获取dialog窗口的参数
        WindowManager.LayoutParams params = window.getAttributes();
        //获取activity窗口管理器
        WindowManager windowManager = activity.getWindowManager();
        //获取activity的参数
        Display d = windowManager.getDefaultDisplay();
//        params.height = (int) (d.getHeight() * 0.5);
        //给dialog设置属性
        params.width = d.getWidth();
        //让属性生效
        window.setAttributes(params);
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(false);
    }

    private void initQueueView(View inflate) {
        TextView  tv_queue_title   = inflate.findViewById(R.id.tv_queue_title);
        TextView  tv_queue_content = inflate.findViewById(R.id.tv_queue_content);
        ImageView iv_queue_exit    = inflate.findViewById(R.id.iv_queue_exit);
        TextView  tv_queue_tip     = inflate.findViewById(R.id.tv_queue_tip);
        ImageView iv_queue_icon    = inflate.findViewById(R.id.iv_queue_icon);
        iv_queue_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }
}
