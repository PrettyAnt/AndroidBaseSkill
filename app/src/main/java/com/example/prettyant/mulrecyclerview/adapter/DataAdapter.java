package com.example.prettyant.mulrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.prettyant.R;
import com.example.prettyant.mulrecyclerview.ItemOnClickListener;
import com.example.prettyant.mulrecyclerview.holder.DataViewHolder;

import java.util.List;

/**
 * Created by chenyu.
 * Created on 上午11:46.
 * Author'github https://github.com/PrettyAnt
 */

public class DataAdapter extends RecyclerView.Adapter<DataViewHolder> {
    private List<String> mdata;
    private Context mContext;

    public void setItemOnClickListener(ItemOnClickListener itemOnClickListener) {
        this.itemOnClickListener = itemOnClickListener;
    }

    private ItemOnClickListener itemOnClickListener;

    public DataAdapter(List<String> mdata, Context mContext) {
        this.mdata = mdata;
        this.mContext = mContext;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        DataViewHolder holder = new DataViewHolder(LayoutInflater
                .from(mContext)
                .inflate(R.layout.item_info, parent, false),
                itemOnClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        holder.tv_item.setText("$"+(position+1)+". "+mdata.get(position));
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

}
