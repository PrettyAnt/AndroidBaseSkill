package com.example.prettyant.mulrecyclerview.ui.holder;

import android.view.View;
import android.widget.TextView;

import com.example.prettyant.R;
import com.example.prettyant.mulrecyclerview.ItemOnClickListener;

/**
 * Created by chenyu.
 * Created on 上午11:47.
 * Author'github https://github.com/PrettyAnt
 */

public class VideoViewHolder extends BaseViewHolder {

    public   TextView tv_item_video;
    public VideoViewHolder(View itemView, ItemOnClickListener itemOnClickListener) {
        super(itemView,itemOnClickListener);
        tv_item_video = itemView.findViewById(R.id.tv_item_video);
    }

}
