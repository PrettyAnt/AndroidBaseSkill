package com.example.fangli.rv_mvp_annotation.util;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.DatePicker;

import com.example.fangli.rv_mvp_annotation.R;

import java.util.Calendar;

/**
 * Created by chenyu.
 * Created on 下午2:18 2017/12/29.
 * Author'github https://github.com/PrettyAnt
 */

public class DialogHelper {

    /**
     * 单例类
     */
    private static DialogHelper sDialogHelper = new DialogHelper();

    private DialogHelper() {
    }

    public static DialogHelper getInstance() {
        return sDialogHelper;
    }
    /**
     * 创建一个选择日期的对话框
     *
     * @param context
     */
    public void initDateDialog(Context context, final OnDatePickedListener listener) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                listener.onDatePicked(view, year, monthOfYear, dayOfMonth);
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.setCancelable(true);
        datePickerDialog.setCanceledOnTouchOutside(true);
        datePickerDialog.show();

        Window window = datePickerDialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.BOTTOM;

        window.setAttributes(params);
        window.setDimAmount(0.7f);
        window.setWindowAnimations(R.style.BottomDialogWindowAnim);
    }
    /**
     * 日期选择对话框的监听器
     */
    public interface OnDatePickedListener {
        void onDatePicked(DatePicker view, int year, int month, int dayOfMonth);
    }
}
