package com.example.mvpstrategy.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.mvpstrategy.R;
import com.example.mvpstrategy.imp.OnClickListenerImp;


/**
 * Create by ChenYu
 * Create Time 2017/7/18 16:23
 * Author's GitHub  https://github.com/PrettyAnt
 * Description :
 */

public class MyDialogUtils {
    private  AlertDialog         dialog = null;
    private static MyDialogUtils instance;
    private OnClickListenerImp mCancleClickListener;
    private OnClickListenerImp mSureClickListener;

    public static MyDialogUtils getInstance() {
        if (instance == null) {
            synchronized (MyDialogUtils.class) {
                if (instance == null) {
                    instance = new MyDialogUtils();
                }
            }
        }
        return instance;
    }


    /**
     * @param context
     * @param titleMsg            提示的信息
     * @param cancleStr           取消按钮的显示文字，null 时默认为取消
     * @param cancleClickListener 取消按钮的点击事件
     * @param sureStr             确定按钮的显示文字，null时默认显示确定
     * @param sureClickListener   确定按钮的点击事件
     */
    public  void commDialog(final Context context,
                            String title,
                            String titleMsg,
                            String cancleStr,
                            OnClickListenerImp cancleClickListener,
                            String sureStr,
                            OnClickListenerImp sureClickListener,
                            DialogInterface.OnKeyListener onBackClickListener
    ) {
        this.mCancleClickListener = cancleClickListener;
        this.mSureClickListener = sureClickListener;
        //白名单开启了，但是没有白名单权限，弹出对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.Theme_Transparent);
//                            LayoutInflater layoutInflater = mContext.getLayoutInflater();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View           inflate        = layoutInflater.inflate(R.layout.dialog_whiteuser, null);
        builder.setView(inflate);
        TextView tv_msg_suggest = (TextView) inflate.findViewById(R.id.tv_msg_suggest);
        TextView tv_msg_tip     = (TextView) inflate.findViewById(R.id.tv_msg_detial);
        TextView bt_show_cancle = (TextView) inflate.findViewById(R.id.bt_show_cancle);
        TextView bt_show_sure   = (TextView) inflate.findViewById(R.id.bt_show_sure);
        View     line1          = inflate.findViewById(R.id.v_line1);
        tv_msg_suggest.setText(title);
        tv_msg_tip.setText(titleMsg);
        if (!TextUtils.isEmpty(cancleStr)) {//设置取消按钮显示的文字,cancleStr==null默认为取消
            bt_show_cancle.setText(cancleStr);
        }
        if (!TextUtils.isEmpty(sureStr)) {//设置确定按钮显示的文字,sureStr为null是默认为确定
            bt_show_sure.setText(sureStr);
        }

        if (mCancleClickListener == null) {
            bt_show_cancle.setVisibility(View.GONE);
            line1.setVisibility(View.GONE);
        }
        if (sureClickListener == null) {
            bt_show_sure.setVisibility(View.GONE);
            line1.setVisibility(View.GONE);
        }

        dialog = builder.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setOnKeyListener(onBackClickListener);
        if (mCancleClickListener != null) {
            bt_show_cancle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCancleClickListener.onClickListener(dialog,v);
                }
            });
        }
        if (sureClickListener != null) {
            bt_show_sure.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mSureClickListener.onClickListener(dialog,v);
                }
            });
        }
    }

}
