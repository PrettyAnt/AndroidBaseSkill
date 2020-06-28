package com.example.customizetextview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.customizetextview.R;


/**
 * @author ChenYu
 * My personal blog  https://prettyant.github.io
 * <p>
 * Created on 2:12 PM  2020/6/11
 * PackageName : com.example.customizetextview.widget
 * describle :
 */
public class ExplandableTextView extends RelativeLayout {
    private              Context        context;
    private              TextView       tv_show;
    private              RelativeLayout rl_item;
    private              LinearLayout   ll_loadmore;
    private static final float          MAX_LINES = 4f;
    private              int            height;
    private              TextView       tv_total_show;

    public ExplandableTextView(Context context) {
        this(context, null);
        this.context = context;
    }

    public ExplandableTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        this.context = context;
    }

    public LinearLayout getLl_loadmore() {
        return ll_loadmore;
    }

    public ExplandableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        View inflate = LayoutInflater
                .from(context)
                .inflate(R.layout.widget_explandabletext, this);
        tv_show = inflate.findViewById(R.id.tv_half_show);
        tv_total_show = inflate.findViewById(R.id.tv_total_show);
        rl_item = inflate.findViewById(R.id.rl_item);
        ll_loadmore = inflate.findViewById(R.id.ll_loadmore);
    }

    /**
     * 设置只显示3.5行
     *
     * @param text
     */
    public void setHalfText(String text) {
        tv_show.setText(text);
        tv_show.post(runnable);
    }


    /**
     * 设置显示全部
     *
     * @param text
     */
    public void setText(String text) {
        tv_show.setText(text);
//        tv_show.setMaxLines(Integer.MAX_VALUE);
        if (height >= 0) {
            tv_show.setHeight(height);
        }
        ll_loadmore.setVisibility(GONE);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            height = tv_show.getHeight();
            int   lineCount     = tv_show.getLineCount();//行数
            int   lineHeight    = tv_show.getLineHeight();//行高
            float textSize      = tv_show.getPaint().getTextSize();//字体的高度
            int distance = (int) ((lineHeight - textSize) / 2 + textSize);//向上平移的距离
            float maxHeigh      = lineHeight * MAX_LINES;
            if (lineCount < MAX_LINES) {
                ll_loadmore.setVisibility(GONE);
            } else {
                ll_loadmore.setVisibility(VISIBLE);
                //每一行的高度
                tv_show.setHeight(Math.round(maxHeigh));
                LayoutParams layoutParams = (LayoutParams) ll_loadmore.getLayoutParams();
                layoutParams.setMargins(0, -distance, 0, 0);
            }
        }
    };

}
