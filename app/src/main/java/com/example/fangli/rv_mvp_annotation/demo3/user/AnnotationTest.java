package com.example.fangli.rv_mvp_annotation.demo3.user;


import com.example.fangli.rv_mvp_annotation.demo3.zhujie.TestA;

import java.util.HashMap;

/**
 * Created by chenyu.
 * Created on 下午2:44.
 * <p>
 * 这个类专门用来测试注解使用
 */
@TestA
public class AnnotationTest {
    @TestA//成员变量注解
    private Integer age;

    @TestA//构造方法注解
    public AnnotationTest() {

    }

    @TestA//方法注解
    public void a() {
        @TestA//局部变量注解
                HashMap<Object, Object> m = new HashMap<>();
    }

    public void b(@TestA Integer age) {//方法参数注解

    }
}
