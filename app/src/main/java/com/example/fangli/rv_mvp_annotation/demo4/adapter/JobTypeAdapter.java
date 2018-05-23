package com.example.fangli.rv_mvp_annotation.demo4.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fangli.rv_mvp_annotation.R;
import com.example.fangli.rv_mvp_annotation.demo4.holder.JobTypeViewHolder;
import com.example.fangli.rv_mvp_annotation.demo4.imp.ItemOnClickListener;
import com.example.fangli.rv_mvp_annotation.demo4.model.JobType;

import java.util.List;

/**
 * Created by chenyu.
 * Created on 下午3:20.
 * Author'github https://github.com/PrettyAnt
 */

public class JobTypeAdapter extends RecyclerView.Adapter<JobTypeViewHolder> {
    private Context context;
    private List<JobType> jobTypeList;


    public JobTypeAdapter(Context context, List<JobType> jobTypeList) {
        this.context = context;
        this.jobTypeList = jobTypeList;
    }

    public void setItemOnClickListener(ItemOnClickListener itemOnClickListener) {
        this.itemOnClickListener = itemOnClickListener;
    }

    private ItemOnClickListener itemOnClickListener;

    @Override
    public JobTypeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        JobTypeViewHolder viewHolder = null;
        View inflate = LayoutInflater
                .from(context)
                .inflate(R.layout.item_jobtype, parent, false);
        viewHolder= new JobTypeViewHolder(inflate, itemOnClickListener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(JobTypeViewHolder holder, int position) {
        holder.tv_jobName.setText("工作类型：\n"+jobTypeList.get(position).getJobName());
        holder.tv_salary.setText("平均薪资：\n"+jobTypeList.get(position).getSalary());
//        holder.tv_countryname.setText("国家名称:" + countryBeanList.get(position).getCountryName());
//        holder.tv_countrynum.setText("国家编号:" + countryBeanList.get(position).getCountryNum());
    }

    @Override
    public int getItemCount() {
        return jobTypeList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return jobTypeList.get(position).getViewType();
    }
}
