package com.example.prettyant.util;

import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

/**
 * @author ChenYu
 * Author's github https://github.com/PrettyAnt
 * <p>
 * Created on 11:57 PM  2020/5/11
 * PackageName : com.example.spdbsoappandroid.textonline.util
 * describle :
 */
public class AnimationUtil {
    private static AnimationUtil instance;
    private        Animation     rotate;

    public static AnimationUtil newInstance() {
        if (instance == null) {
            synchronized (AnimationUtil.class) {
                if (instance == null) {
                    instance = new AnimationUtil();
                }
            }
        }
        return instance;
    }

    public void startAnima(ImageView imageView) {
        rotate = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(1000);//设置动画持续周期
//        rotate.setFillAfter(false);//动画执行完后是否停留在执行完的状态
        rotate.setRepeatCount(Animation.INFINITE);
        rotate.setRepeatMode(Animation.RESTART);
        rotate.setInterpolator(new LinearInterpolator());
        imageView.startAnimation(rotate);

    }

    public void stopAnima() {
        if (rotate == null) {
            return;
        }
        rotate.cancel();
    }
}
