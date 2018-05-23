package com.example.fangli.rv_mvp_annotation.demo4.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fangli.rv_mvp_annotation.R;
import com.example.fangli.rv_mvp_annotation.demo4.imp.ItemOnClickListener;

/**
 * Created by chenyu.
 * Created on 下午3:22.
 * Author'github https://github.com/PrettyAnt
 */

public class CountryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private ItemOnClickListener itemOnClickListener;
    public LinearLayout ll_country;
    public TextView tv_countryname;
    public TextView tv_countrynum;
    public RecyclerView rv_jobtype_recycle;

    public CountryViewHolder(View itemView, ItemOnClickListener itemOnClickListener) {
        super(itemView);
        this.itemOnClickListener = itemOnClickListener;
        ll_country = itemView.findViewById(R.id.ll_country);
        tv_countryname = itemView.findViewById(R.id.tv_countryname);
        tv_countrynum = itemView.findViewById(R.id.tv_countrynum);
        rv_jobtype_recycle = itemView.findViewById(R.id.rv_jobtype_recycle);
        ll_country.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (itemOnClickListener != null) {
            itemOnClickListener.onItemClickListener(ll_country,getAdapterPosition());
        }
    }
}
