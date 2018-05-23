package com.example.fangli.rv_mvp_annotation.demo4.model;

import java.util.List;

/**
 * Created by chenyu.
 * Created on 下午2:32.
 * Author'github https://github.com/PrettyAnt
 */

public class CountryBean {
    private String countryName;//国家名称
    private int countryNum;//国家编号
    private int viewType=0;
    private List<JobType> jobTypeList;//工作类型

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getCountryNum() {
        return countryNum;
    }

    public void setCountryNum(int countryNum) {
        this.countryNum = countryNum;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public List<JobType> getJobTypeList() {
        return jobTypeList;
    }

    public void setJobTypeList(List<JobType> jobTypeList) {
        this.jobTypeList = jobTypeList;
    }

    @Override
    public String toString() {
        return "CountryBean{" +
                "countryName:'" + countryName + '\'' +
                ", countryNum:" + countryNum +
                ", viewType:" + viewType +
                ", jobTypeList:" + jobTypeList +
                '}';
    }
}
