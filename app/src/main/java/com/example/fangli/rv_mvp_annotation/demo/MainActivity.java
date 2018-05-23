package com.example.fangli.rv_mvp_annotation.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fangli.rv_mvp_annotation.R;
import com.example.fangli.rv_mvp_annotation.demo.adapter.DataAdapter;
import com.example.fangli.rv_mvp_annotation.demo1.TestActivity1;
import com.example.fangli.rv_mvp_annotation.demo2.TestActivity2;
import com.example.fangli.rv_mvp_annotation.demo3.TestActivity3;
import com.example.fangli.rv_mvp_annotation.demo4.TestActivity4;
import com.example.fangli.rv_mvp_annotation.util.DialogHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyu.
 * Created on 下午4:01.
 * Author'github https://github.com/PrettyAnt
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ItemOnClickListener {

    private Button btn_load_data;
    private TextView tv_show_msg;
    private RecyclerView rv_recycle;
    private DataAdapter dataAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        initEvent();

    }

    public static int pageIndex = 0;
    private boolean memberPagIsEnd = false,
            isLoading = false,//是否滑到最后一个
            isRefresh = false;//是否正在刷新

    private void initView() {
        btn_load_data = (Button) findViewById(R.id.btn_back);
        tv_show_msg = (TextView) findViewById(R.id.tv_show_msg);
        rv_recycle = (RecyclerView) findViewById(R.id.rv_country_recycle);
        //设置布局管理器
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, LinearLayoutManager.VERTICAL, false);
//        gridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_recycle.setLayoutManager(gridLayoutManager);
        dataAdapter = new DataAdapter(data, this);
        rv_recycle.setAdapter(dataAdapter);
        dataAdapter.setItemOnClickListener(this);
        rv_recycle.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dx > 0) {
                    int lastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
                    if (lastVisibleItemPosition + 1 == dataAdapter.getItemCount() && !isLoading && !isRefresh) {
                        isLoading = true;
                        pageIndex++;
//                        if (pageIndex >= dataTotal.size()) {
//                            Log.v("ttt", "dx>0      bbb" + pageIndex);
//                            pageIndex = dataTotal.size() - 1;
//
//                        }
//                        getData(pageIndex);

                    }


                    Log.i("ttt", "dx>0      " + pageIndex);
                }
                if (dx < 0) {
                    int firstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();
                    if (firstVisibleItemPosition == 0 && !isLoading && !isRefresh) {
//                        isRefresh = true;
//                        pageIndex--;
//                        if (pageIndex <= 0) {
//                            pageIndex = 0;
//                        }
//                        getData(pageIndex);
                    }

                    Log.i("ttt", "dx<0      " + pageIndex);
                }

            }
        });

    }

    private void initEvent() {
        btn_load_data.setOnClickListener(this);
    }

    private List<String> data = new ArrayList<>();
    private List<String> data2 = new ArrayList<>();
    private List<List<String>> dataTotal = new ArrayList<>();

    private void initData() {
        data.clear();
        for (int i = 0; i < 60; i++) {
            if (i <= 25||i>31&&i<=57) {
                data.add("跳转到： Activity " + (char) (65 + i));
            } else  {
                data.add("测试数据" + i);
            }
//            if (i < 4) {
//                data.add("跳转到： Activity " + (char)(65+i));
//            } else {
//                data.add("测试数据" + i);
//            }
        }
//
//        for (int i = 0; i < data.size(); i++) {
//            data2.add(data.get(i));
//            if (i % 8 == 0 && i != 0) {
//                dataTotal.add(data2);
//                data2 = new ArrayList<>();
////                data2.clear();
//
//            }
//        }
    }

    private void getData(int pageIndex) {
        dataTotal.get(pageIndex);
        isLoading = false;
        isRefresh = false;
        dataAdapter.notifyDataSetChanged();
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
        Toast.makeText(MainActivity.this, ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
        switch (position) {
            case 0:
                startActivity(new Intent(this, TestActivity1.class));
                break;
            case 1:
                startActivity(new Intent(this, TestActivity2.class));
                break;
            case 2:
                startActivity(new Intent(this, TestActivity3.class));
                break;
            case 3:
                startActivity(new Intent(this, TestActivity4.class));
                break;
            case 4:
                DialogHelper.getInstance().initDateDialog(this, new DialogHelper.OnDatePickedListener() {
                    @Override
                    public void onDatePicked(DatePicker view, int year, int month, int dayOfMonth) {
                     tv_show_msg.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                    }
                });
                break;
        }
    }
}
