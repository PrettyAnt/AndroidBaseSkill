package com.example.annointroduction.user;



import com.example.annointroduction.zhujie.TestA;

import java.util.HashMap;

/**
 * Created by chenyu.
 * Created on 下午2:44.
 * <p>
 * 这个类专门用来测试注解使用
 */
@TestA
public class AnnotationTestA {
    @TestA//成员变量注解
    private Integer age;

    @TestA//构造方法注解
    public AnnotationTestA() {

    }

    @TestA//方法注解
    public void a() {
        @TestA//局部变量注解
                HashMap<Object, Object> m = new HashMap<>();
    }

    public void b(@TestA Integer age) {//方法参数注解

    }
}
