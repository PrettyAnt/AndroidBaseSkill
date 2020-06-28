package com.example.customizetextview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
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
public class ExplandableTextView2 extends RelativeLayout implements View.OnClickListener {
    private Context        context;
    private String         text;
    private TextView       tv_show;
    private RelativeLayout rl_loadmore, rl_item;
    private int height;

    /**
     * default text show max lines
     */
    private static final int DEFAULT_MAX_LINE_COUNT = 4;

    private static final int COLLAPSIBLE_STATE_NONE     = 0;
    private static final int COLLAPSIBLE_STATE_SHRINKUP = 1;
    private static final int COLLAPSIBLE_STATE_SPREAD   = 2;

    private int     mState;
    private boolean flag;

    public ExplandableTextView2(Context context) {
        this(context, null);
        this.context = context;
    }

    public ExplandableTextView2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        this.context = context;
    }

    public ExplandableTextView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        View inflate = LayoutInflater
                .from(context)
                .inflate(R.layout.widget_explandabletext, this);
        tv_show = inflate.findViewById(R.id.tv_half_show);
        rl_item = inflate.findViewById(R.id.rl_item);
        rl_loadmore = inflate.findViewById(R.id.ll_loadmore);
        rl_loadmore.setOnClickListener(this);
    }

    public void setHalfText(String text) {
        this.text = text;
        tv_show.setText(text);
        mState = COLLAPSIBLE_STATE_SPREAD;
        requestLayout();
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ll_loadmore) {
            flag = false;
            requestLayout();
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (!flag) {
            flag = true;
            if (tv_show.getLineCount() <= DEFAULT_MAX_LINE_COUNT) {
                mState = COLLAPSIBLE_STATE_NONE;
                rl_loadmore.setVisibility(View.GONE);
                tv_show.setMaxLines(DEFAULT_MAX_LINE_COUNT + 1);
            } else {
                post(runnable);
            }
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (mState == COLLAPSIBLE_STATE_SPREAD) {//查看更多
                tv_show.setMaxLines(DEFAULT_MAX_LINE_COUNT);
                rl_loadmore.setVisibility(View.VISIBLE);
                mState = COLLAPSIBLE_STATE_SHRINKUP;
            } else if (mState == COLLAPSIBLE_STATE_SHRINKUP) {//收起
                tv_show.setMaxLines(Integer.MAX_VALUE);
                rl_loadmore.setVisibility(View.GONE);
                mState = COLLAPSIBLE_STATE_SPREAD;
            }

        }
    };




}
