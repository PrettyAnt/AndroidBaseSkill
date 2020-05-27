package com.example.prettyant.mulrecyclerview.ui.holder;

import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.example.prettyant.mulrecyclerview.ItemOnClickListener;

/**
 * Created by chenyu.
 * Created on 上午11:47.
 * Author'github https://github.com/PrettyAnt
 */

public class BaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ItemOnClickListener itemOnClickListener;

    public BaseViewHolder(View itemViewr, ItemOnClickListener itemOnClickListener) {
        super(itemViewr);
        this.itemOnClickListener = itemOnClickListener;
        itemViewr.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (itemOnClickListener != null) {
            itemOnClickListener.onItemClickListener(v, getLayoutPosition());
        }
    }
}
