package com.example.prettyant.util;

import android.view.View;
import android.view.animation.Animation;
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
    public static AnimationUtil newInstance(){
        if (instance == null) {
            synchronized (AnimationUtil.class) {
                if (instance == null) {
                    instance = new AnimationUtil();
                }
            }
        }
        return instance;
    }
    public void roateAnima(ImageView imageView){
        imageView.setVisibility(View.VISIBLE);
        Animation rotate = new RotateAnimation(0f, 180f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(1000);//设置动画持续周期
        rotate.setFillAfter(false);//动画执行完后是否停留在执行完的状态
        imageView.startAnimation(rotate);
    }
}
