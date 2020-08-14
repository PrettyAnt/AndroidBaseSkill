package com.example.raudiomodule;

import android.content.Context;
import android.media.AudioManager;

/**
 * @author ChenYu
 * My personal blog  https://prettyant.github.io
 * <p>
 * Created on 3:35 PM  2020/8/5
 * PackageName : com.example.spdbsoappandroid.util
 * describle :
 */
public class DmAudioHelper {
    private static DmAudioHelper instance;
    private        AudioManager  audioManager;

    public static DmAudioHelper getInstance() {
        if (instance == null) {
            synchronized (DmAudioHelper.class) {
                if (instance == null) {
                    instance = new DmAudioHelper();
                }
            }
        }
        return instance;
    }

    private  boolean isRequested = false;

    /**
     * @param context
     * @param flag    0，1   0暂停外部音乐 1 表示降低外部音量
     */
    public  void requestAudioFocus(Context context, int flag) {
        LogUtil.warnLog(LogUtil.logStaus, "------------------->>>  外部音乐 "+flag);
        if (audioManager == null) {
            audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        }
        if (audioManager != null) {
            int durationHint = AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK;
            if (flag == 0) {
                durationHint = AudioManager.AUDIOFOCUS_GAIN_TRANSIENT;
            }
            audioManager.requestAudioFocus(onAudioFocusChangeListener, AudioManager.STREAM_MUSIC, durationHint);
            isRequested = true;
        }
    }

    /**
     * 取消状态
     */
    public  void abandonAudioFocus() {
        LogUtil.warnLog(LogUtil.logStaus, "------------------->>>  外部音乐恢复");
        if (audioManager != null && isRequested) {
            isRequested = false;
            audioManager.abandonAudioFocus(onAudioFocusChangeListener);
        }
    }

    protected static AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            switch (focusChange) {
                case AudioManager.AUDIOFOCUS_GAIN:
                    // do nothingø
                    LogUtil.warnLog(LogUtil.logStaus, "-------------------结束------------------AUDIOFOCUS_GAIN");
                    break;
                case AudioManager.AUDIOFOCUS_LOSS:
//                    Pause();
                    LogUtil.warnLog(LogUtil.logStaus, "-------------------结束------------------AUDIOFOCUS_LOSS");
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                    LogUtil.warnLog(LogUtil.logStaus, "-------------------结束------------------AUDIOFOCUS_LOSS_TRANSIENT");
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                    LogUtil.warnLog(LogUtil.logStaus, "-------------------结束------------------AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
                    //do nothing
                    break;
            }
        }
    };


}
