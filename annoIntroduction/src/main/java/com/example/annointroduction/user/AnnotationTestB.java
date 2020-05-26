
package com.example.annointroduction.user;



import com.example.annointroduction.zhujie.TestB;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenyu.
 * Created on 下午2:44.
 * <p>
 * 这个类专门用来测试注解使用
 */
@TestB(name = "type", gid = Long.class)//类成员注解
public class AnnotationTestB {
    @TestB(name = "param", id = 1, gid = Long.class)
    private Integer age;

    @TestB(name = "param", id = 2, gid = Long.class)
    public AnnotationTestB() {
    }

    @TestB(name = "public method", id = 3, gid = Long.class) //类方法注解
    public void a() {
        Map<String, String> m = new HashMap<String, String>(0);
    }

    @TestB(name = "protected method", id = 4, gid = Long.class) //类方法注解
    protected void b() {
        Map<String, String> m = new HashMap<String, String>(0);
    }

    @TestB(name = "private method", id = 5, gid = Long.class) //类方法注解
    private void c() {
        Map<String, String> m = new HashMap<String, String>(0);
    }

    public void b(Integer a) {

    }
}
