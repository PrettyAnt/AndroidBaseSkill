package com.example.fangli.rv_mvp_annotation.demo4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.fangli.rv_mvp_annotation.R;
import com.example.fangli.rv_mvp_annotation.demo4.adapter.CountryAdapter;
import com.example.fangli.rv_mvp_annotation.demo4.imp.ItemOnClickListener;
import com.example.fangli.rv_mvp_annotation.demo4.model.CountryBean;
import com.example.fangli.rv_mvp_annotation.demo4.model.JobType;
import com.example.fangli.rv_mvp_annotation.demo4.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by chenyu.
 * Created on 下午2:21.
 * Author'github https://github.com/PrettyAnt
 */

public class TestActivity4 extends AppCompatActivity implements View.OnClickListener, ItemOnClickListener {

    private RecyclerView rv_recycle;
    private Button btn_back;
    private CountryAdapter countryAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4_test);
        initView();
//        initData();
    }

    private void initView() {
        rv_recycle = (RecyclerView) findViewById(R.id.rv_country_recycle);
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv_recycle.setLayoutManager(linearLayoutManager);
        countryAdapter = new CountryAdapter(this, countryBeanList);
        rv_recycle.setAdapter(countryAdapter);
        countryAdapter.setItemOnClickListener(this);
    }


    private List<CountryBean> countryBeanList = new ArrayList<>();
    private String[] jobName = {"老师", "公务员", "会计", "程序员"};
    private String[] countryName = {"中国", "美国", "俄罗斯", "英国", "德国", "日本"};

    /**
     * 数据源
     */
    private void initData() {
        countryBeanList.clear();
        Random random = new Random();
        for (int k = 0; k < 3; k++) {
            CountryBean countryBean = new CountryBean();
            List<JobType> jobTypeList = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                JobType jobType = new JobType();
                List<Person> personList = new ArrayList<>();
                for (int i = 0; i < 2; i++) {
                    Person person = new Person();
                    person.setPersonName("姓名：" + (char) (i + 65));
                    int age = 20 + random.nextInt(10);
                    person.setAge(age);
                    int weight = 10 + random.nextInt(50);
                    person.setWeight(weight);
                    personList.add(person);
                }
                int job = random.nextInt(4);
                jobType.setJobName(jobName[job]);
                jobType.setSalary(3000 + 1220 * job);
                jobType.setPersonList(personList);
                jobTypeList.add(jobType);
            }
            countryBean.setCountryName(countryName[random.nextInt(5)]);
            countryBean.setCountryNum(10 + random.nextInt(20));
            countryBean.setJobTypeList(jobTypeList);
            countryBeanList.add(countryBean);
        }
        Log.i("ttt", "得到的数据为： " + countryBeanList.toString());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                initData();
                countryAdapter.notifyDataSetChanged();
                break;
        }
    }

    @Override
    public void onItemClickListener(View view, int position) {
        switch (view.getId()) {

        }
    }
}
