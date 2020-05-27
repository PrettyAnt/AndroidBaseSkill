package com.example.prettyant.mulrecyclerview.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.annointroduction.AnnotationActivity;
import com.example.mvpstrategy.MvpStrategyActivity;
import com.example.prettyant.R;
import com.example.prettyant.mulrecyclerview.ItemOnClickListener;
import com.example.prettyant.mulrecyclerview.model.NewsModel;
import com.example.prettyant.mulrecyclerview.presenters.ReceiveHelper;
import com.example.prettyant.mulrecyclerview.presenters.iview.OnLoadImp;
import com.example.prettyant.mulrecyclerview.ui.adapter.DataAdapter;
import com.example.prettyant.util.DialogHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyu.
 * Created on 下午4:01.
 * Author'github https://github.com/PrettyAnt
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ItemOnClickListener, OnLoadImp {

    private Button       btn_load_data;
    private TextView     tv_show_msg;
    private RecyclerView rv_recycle;
    private DataAdapter  dataAdapter;
    private List<NewsModel> newsModels=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
        initData();
    }

    private void initView() {
        btn_load_data = findViewById(R.id.btn_back);
        tv_show_msg = findViewById(R.id.tv_show_msg);
        rv_recycle = findViewById(R.id.rv_country_recycle);


    }

    private void initEvent() {
        btn_load_data.setOnClickListener(this);
        //设置布局管理器  spanCount==1时，GridLayoutManager布局管理器就类似于LinearLayoutManager
        GridLayoutManager manager = new GridLayoutManager(this, 1, LinearLayoutManager.VERTICAL, false);
//        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL); //流布局
        rv_recycle.setLayoutManager(manager);
        dataAdapter = new DataAdapter(newsModels, this);
        rv_recycle.setAdapter(dataAdapter);
        dataAdapter.setItemOnClickListener(this);
        rv_recycle.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    private void initData() {
        ReceiveHelper.getInstance().loading(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                finish();
                break;
        }
    }

    @Override
    public void onItemClickListener(View view, int position) {
        Toast.makeText(MainActivity.this,newsModels.get(position).getTextContent()+"--->>"+position , Toast.LENGTH_SHORT).show();
        switch (position) {
            case 0:
                startActivity(new Intent(this, MvpStrategyActivity.class));//跳转到 自定义dialog、mvp的简单实例
                break;
            case 1:
                startActivity(new Intent(this, AnnotationActivity.class));//注解原理
                break;
            case 2:
                DialogHelper.getInstance().initDateDialog(this, new DialogHelper.OnDatePickedListener() {
                    @Override
                    public void onDatePicked(DatePicker view, int year, int month, int dayOfMonth) {
                        tv_show_msg.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                    }
                });
                break;
            case 3:

                break;
            case 4:

                break;
        }
    }

    @Override
    public void onReceive(ArrayList<NewsModel> newsModels) {
        this.newsModels.clear();
        this.newsModels.addAll(newsModels);
        dataAdapter.notifyDataSetChanged();
    }
}
