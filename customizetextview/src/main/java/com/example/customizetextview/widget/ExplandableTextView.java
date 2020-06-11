package com.example.customizetextview.widget;

import android.content.Context;
import android.content.res.TypedArray;
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
public class ExplandableTextView extends RelativeLayout implements View.OnClickListener {
    private Context        context;
    private String         text;
    private TextView       tv_show;
    private RelativeLayout rl_loadmore, rl_item;
    private              int   height;
    private static final float MAX_LINES = 3.5f;

    public ExplandableTextView(Context context) {
        this(context, null);
        this.context = context;
    }

    public ExplandableTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        this.context = context;
    }


    public ExplandableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        View inflate = LayoutInflater
                .from(context)
                .inflate(R.layout.widget_explandabletext, this);
        tv_show = inflate.findViewById(R.id.tv_show);
        rl_item = inflate.findViewById(R.id.rl_item);
        rl_loadmore = inflate.findViewById(R.id.rl_loadmore);
        rl_loadmore.setOnClickListener(this);
        //加载自定义属性配置
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ExplandableText);
        if (typedArray != null) {
            int          width        = typedArray.getDimensionPixelSize(R.styleable.ExplandableText_prettyant_backgroud_width, 0);
            LayoutParams layoutParams = (LayoutParams) rl_item.getLayoutParams();
            layoutParams.width = width;
            rl_item.setLayoutParams(layoutParams);
            typedArray.recycle();
        }
    }

    public void setHalfText(String text) {
        this.text = text;
        tv_show.setText(text);
        tv_show.post(new Runnable() {
            @Override
            public void run() {
                height = tv_show.getHeight();
                int lineCount = tv_show.getLineCount();
                if (lineCount <= 3) {
                    rl_loadmore.setVisibility(GONE);
                } else {
                    rl_loadmore.setVisibility(VISIBLE);
                    int singleHeigh = height / lineCount;//每一行的高度
                    tv_show.setHeight((int) (singleHeigh * MAX_LINES));
                    LayoutParams layoutParams = (LayoutParams) rl_loadmore.getLayoutParams();
                    layoutParams.setMargins(0, -singleHeigh / 2, 0, 0);
                }

            }
        });
    }

    private void setExplandText(String text) {
        tv_show.setText(text);
        tv_show.setHeight(height);
        rl_loadmore.setVisibility(GONE);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.rl_loadmore) {
            setExplandText(text);
        }
    }
}
