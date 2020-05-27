package com.example.prettyant.mulrecyclerview.ui.holder;

import android.view.View;
import android.widget.ImageView;

import com.example.prettyant.R;
import com.example.prettyant.mulrecyclerview.ItemOnClickListener;

/**
 * Created by chenyu.
 * Created on 上午11:47.
 * Author'github https://github.com/PrettyAnt
 */

public class ImgViewHolder extends BaseViewHolder {

    public  ImageView           iv_item_pic;
    public ImgViewHolder(View itemView, ItemOnClickListener itemOnClickListener) {
        super(itemView,itemOnClickListener);
        iv_item_pic = itemView.findViewById(R.id.iv_item_pic);
    }


}
