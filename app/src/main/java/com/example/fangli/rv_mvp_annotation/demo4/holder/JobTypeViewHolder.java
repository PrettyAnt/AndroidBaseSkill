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

public class JobTypeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private ItemOnClickListener itemOnClickListener;
    public LinearLayout ll_jobtype;
    public TextView tv_jobName;
    public TextView tv_salary;

    public JobTypeViewHolder(View itemView, ItemOnClickListener itemOnClickListener) {
        super(itemView);
        this.itemOnClickListener = itemOnClickListener;
        ll_jobtype = itemView.findViewById(R.id.ll_jobtype);
        tv_jobName = itemView.findViewById(R.id.tv_jobName);
        tv_salary = itemView.findViewById(R.id.tv_salary);
        ll_jobtype.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (itemOnClickListener != null) {
            itemOnClickListener.onItemClickListener(ll_jobtype,getAdapterPosition());
        }
    }
}
