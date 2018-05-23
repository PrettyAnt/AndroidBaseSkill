package com.example.fangli.rv_mvp_annotation.demo4.model;

import java.util.List;

/**
 * Created by chenyu.
 * Created on 下午2:35.
 * Author'github https://github.com/PrettyAnt
 */

public class JobType {

    private String jobName;//人物工作的名称
    private int salary;//平均薪资
    private List<Person> personList;//人物列表
    private int viewType=1;
    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    @Override
    public String toString() {
        return "JobType{" +
                "jobName:'" + jobName + '\'' +
                ", salary:" + salary +
                ", personList:" + personList +
                ", viewType:" + viewType +
                '}';
    }
}
