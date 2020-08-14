package com.example.raudiomodule;

import android.util.Log;


/**
 * Created by chenyu.
 * Created on 上午4:57.
 * Author'github https://github.com/PrettyAnt
 */

public class LogUtil {
    public static boolean logIsOpen = true;//日志开关

    public static String logStaus = "ttt";//日志key

    /**
     *  verbose级别
     * @param tag 日志标签
     * @param info 日志内容
     */
    public static void verboseLog(String tag, String info){
        if (logIsOpen) {
            Log.v(tag,info);
        }
    }
    /**
     * debug级别
     * @param tag 日志标签
     * @param info 日志内容
     */
    public static void debugLog(String tag, String info){
        if (logIsOpen) {
            Log.d(tag, info);
        }
    }
    /**
     * info级别
     * @param tag 日志标签
     * @param info 日志内容
     */
    public static void infoLog(String tag, String info){
        if (logIsOpen) {
            Log.i(tag,info);
        }
    }
    /**
     * warn级别
     * @param tag 日志标签
     * @param info 日志内容
     */
    public static void warnLog(String tag, String info){
        if (logIsOpen) {
            if (info.length() < 4000) {
                Log.w(tag,info);
            } else if (info.length() >= 4000 && info.length() < 8000) {
                Log.w(tag,info+"\t");
                Log.w(tag,info.substring(4000));
            } else if (info.length() >= 8000 && info.length() < 12000) {
                Log.w(tag,info+"\t");
                Log.w(tag,info.substring(4000)+"\t");
                Log.w(tag,info.substring(8000));
            } else {
                Log.w(tag,info+"\t");
                Log.w(tag,info.substring(4000)+"\t");
                Log.w(tag,info.substring(8000)+"\t");
                Log.w(tag,info.substring(12000));
            }


        }
    }

    /**
     *  error级别
     * @param tag 日志标签
     * @param info 日志内容
     */
    public static void errorLog(String tag, String info){
        if (logIsOpen) {
            Log.e(tag,info);
        }
    }

}
