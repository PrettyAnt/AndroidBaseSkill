package com.example.fangli.rv_mvp_annotation.demo4.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fangli.rv_mvp_annotation.R;
import com.example.fangli.rv_mvp_annotation.demo4.holder.CountryViewHolder;
import com.example.fangli.rv_mvp_annotation.demo4.imp.ItemOnClickListener;
import com.example.fangli.rv_mvp_annotation.demo4.model.CountryBean;

import java.util.List;

/**
 * Created by chenyu.
 * Created on 下午3:20.
 * Author'github https://github.com/PrettyAnt
 */

public class CountryAdapter extends RecyclerView.Adapter<CountryViewHolder> implements ItemOnClickListener {
    private Context context;
    private List<CountryBean> countryBeanList;
    CountryViewHolder viewHolder = null;

    public CountryAdapter(Context context, List<CountryBean> countryBeanList) {
        this.context = context;
        this.countryBeanList = countryBeanList;
    }

    public void setItemOnClickListener(ItemOnClickListener itemOnClickListener) {
        this.itemOnClickListener = itemOnClickListener;
    }

    private ItemOnClickListener itemOnClickListener;

    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater
                .from(context)
                .inflate(R.layout.item_country, parent, false);
        viewHolder = new CountryViewHolder(inflate, this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CountryViewHolder holder, int position) {
        holder.tv_countryname.setText("国家名称:" + countryBeanList.get(position).getCountryName());
        countryBeanList.get(position).setCountryNum(position);
        holder.tv_countrynum.setText("国家编号:" + countryBeanList.get(position).getCountryNum());
//        JobTypeAdapter jobTypeAdapter = new JobTypeAdapter(context, countryBeanList.get(position).getJobTypeList());
//        holder.rv_jobtype_recycle.setLayoutManager(new LinearLayoutManager(context));
//        holder.rv_jobtype_recycle.setAdapter(jobTypeAdapter);
    }

    @Override
    public int getItemCount() {
        return countryBeanList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return countryBeanList.get(position).getViewType();
    }

    @Override
    public void onItemClickListener(View view, int position) {
        Toast.makeText(context, "测试---" + position, Toast.LENGTH_SHORT).show();
        if (viewHolder != null) {
            int visibility = viewHolder.rv_jobtype_recycle.getVisibility();
            if (visibility == View.GONE || visibility == view.INVISIBLE) {
                viewHolder.rv_jobtype_recycle.setVisibility(View.VISIBLE);
            } else {
                viewHolder.rv_jobtype_recycle.setVisibility(View.GONE);
            }
            notifyItemChanged(position);
        }

    }
}
