package com.example.annointroduction.utils;

import android.util.Log;

/**
 * @author ChenYu
 * Author's github https://github.com/PrettyAnt
 * <p>
 * Created on 11:38 AM  2020/5/28
 * PackageName : com.example.annointroduction.utils
 * describle :
 */
public class ReflexUtils {
//    private static ReflexUtils instance;
    private        String      name="wangbei";
//
//    public static ReflexUtils getInstance() {
//        if (instance == null) {
//            synchronized (ReflexUtils.class) {
//                if (instance == null) {
//                    instance = new ReflexUtils();
//                }
//            }
//        }
//        return instance;
//    }

    public ReflexUtils() {
    }

    public ReflexUtils(String name) {
        this.name = name;
    }

    private void setName(String name) {
        this.name = name;
        Log.i("androidbaseskill", "反射----->>>" + name);
    }

    public String getName() {
        return name;
    }

    public String getInformation(){
//        setName("wangbei");
        String info=name+"chenyu";
        return info;
    }

    @Override
    public String toString() {
        return "ReflexUtils{" +
                "name='" + name + '\'' +
                '}';
    }
}
