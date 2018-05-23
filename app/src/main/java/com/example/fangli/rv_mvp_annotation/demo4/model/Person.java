package com.example.fangli.rv_mvp_annotation.demo4.model;

/**
 * Created by chenyu.
 * Created on 下午2:38.
 * Author'github https://github.com/PrettyAnt
 */

public class Person {
    private String personName;
    private int age;
    private int weight;
    private int viewType=2;

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personName:'" + personName + '\'' +
                ", age:" + age +
                ", weight:" + weight +
                ", viewType:" + viewType +
                '}';
    }
}
