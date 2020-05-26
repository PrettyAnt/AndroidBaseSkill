package com.example.prettyant.mulrecyclerview.holder;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.prettyant.R;
import com.example.prettyant.mulrecyclerview.ItemOnClickListener;

/**
 * Created by chenyu.
 * Created on 上午11:47.
 * Author'github https://github.com/PrettyAnt
 */

public class DataViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ItemOnClickListener itemOnClickListener;
    public  TextView            tv_item;

    public DataViewHolder(View itemView, ItemOnClickListener itemOnClickListener) {
        super(itemView);
        this.itemOnClickListener = itemOnClickListener;
        tv_item = itemView.findViewById(R.id.tv_item);
        tv_item.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (itemOnClickListener != null) {
            itemOnClickListener.onItemClickListener(tv_item,getLayoutPosition());
        }
        Log.i("ttt", "当前点击的为： "+((TextView) v).getText().toString());
    }
}
