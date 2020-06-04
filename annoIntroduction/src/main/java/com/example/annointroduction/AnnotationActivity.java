package com.example.annointroduction;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.annointroduction.user.AnnotationTestB;
import com.example.annointroduction.utils.ReflexUtils;
import com.example.annointroduction.zhujie.TestB;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_back, btn_test1, btn_test2, btn_test3, btn_test4, btn_test5, btn_test6, btn_test7;
    private       TextView tv_show;
    private final String   TAG = "AndroidBaseSkill";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annotation);
        initView();
        initEvent();
    }


    private void initView() {
        btn_back = findViewById(R.id.btn_back);
        btn_test1 = findViewById(R.id.btn_test1);
        btn_test2 = findViewById(R.id.btn_test2);
        btn_test3 = findViewById(R.id.btn_test3);
        btn_test4 = findViewById(R.id.btn_test4);
        btn_test5 = findViewById(R.id.btn_test5);
        btn_test6 = findViewById(R.id.btn_test6);
        btn_test7 = findViewById(R.id.btn_test7);
        tv_show = findViewById(R.id.tv_show);
    }

    private void initEvent() {
        btn_back.setOnClickListener(this);
        btn_test1.setOnClickListener(this);
        btn_test2.setOnClickListener(this);
        btn_test3.setOnClickListener(this);
        btn_test4.setOnClickListener(this);
        btn_test5.setOnClickListener(this);
        btn_test6.setOnClickListener(this);
        btn_test7.setOnClickListener(this);
    }


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();
        try {
            if (id == R.id.btn_back) {
                finish();
            } else if (id == R.id.btn_test1) {
                parseTypeAnnotation(tv_show);
            } else if (id == R.id.btn_test2) {
                getAnnotation(tv_show);
            } else if (id == R.id.btn_test3) {
                parseMethodAnnotation(tv_show);
            } else if (id == R.id.btn_test4) {
                parseConstructAnnotation(tv_show);
            } else if (id == R.id.btn_test5) {//反射测试
                Class c = Class.forName("com.example.annointroduction.utils.ReflexUtils");
                Constructor con = c.getConstructor();
                Object o = con.newInstance();

                Field name = c.getDeclaredField("name");
                name.setAccessible(true);
                name.set(o,"wangbei love ");

                Log.i(TAG, "========="+o.toString());


            } else if (id == R.id.btn_test6) {

            } else if (id == R.id.btn_test7) {

            }
        } catch (Exception e) {
            Log.i(TAG, "错误" + e.toString());
            tv_show.setText("错误日志:" + e.toString());
        }

    }

    /**
     * 测试该方法的注解的某个方法名
     *
     * @param tv_show
     */
    public void getAnnotation(TextView tv_show) {
        StringBuffer sb    = new StringBuffer();
        TestB        testB = AnnotationTestB.class.getAnnotation(TestB.class);
        sb.append(testB.name()).append(", \n");
        Log.i(TAG, testB.name());
        try {
            Class<AnnotationTestB> annotationTest2Class = AnnotationTestB.class;
            TestB                  testB1               = annotationTest2Class.getDeclaredMethod("a", null).getAnnotation(TestB.class);
            sb.append(testB1.name());
            Log.i(TAG, testB1.name());
            tv_show.setText("getAnnotation: " + sb.toString());
        } catch (Exception e) {

        }
    }

    /**
     * 简单打印出UserAnnotation 类中所使用到的类注解
     * 该方法只打印了 Type 类型的注解
     *
     * @throws ClassNotFoundException
     */
    public void parseTypeAnnotation(TextView tv) {
        Class clazz = null;
        try {
            clazz = Class.forName("com.example.annointroduction.user.AnnotationTestB");
            StringBuffer sb = new StringBuffer();

            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation annotation : annotations) {
                TestB  testB = (TestB) annotation;
                String info  = "id= \"" + testB.id() + "\"; \nname= \"" + testB.name() + "\";\n gid = " + testB.gid();
                sb.append(info).append("\n");
                Log.i(TAG, "parseTypeAnnotation-->> " + sb.toString());

            }
            tv.setText("打印结果:\n" + sb.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 简单打印出UserAnnotation 类中所使用到的方法注解
     * 该方法只打印了 Method 类型的注解
     *
     * @throws ClassNotFoundException
     */
    public void parseMethodAnnotation(TextView tv) {
        Method[]     methods = AnnotationTestB.class.getDeclaredMethods();
        StringBuffer sb      = new StringBuffer();
        for (Method method : methods) {
            /*
             * 判断方法中是否有指定注解类型的注解
             */
            boolean hasAnnotation = method.isAnnotationPresent(TestB.class);
            if (hasAnnotation) {
                /*
                 * 根据注解类型返回方法的指定类型注解
                 */
                TestB  annotation = method.getAnnotation(TestB.class);
                String info       = "method = " + method.getName() + " ;\n id = " + annotation.id() + " ;\n description = " + annotation.name() + ";\n gid= " + annotation.gid();
                sb.append(info).append("\n");
                Log.i(TAG, "parseMethodAnnotation-->>  method = " + method.getName() + " ; id = " + annotation.id() + " ; description = " + annotation.name() + "; gid= " + annotation.gid());

            }
        }
        tv.setText("打印结果:\n" + sb.toString());
    }

    /**
     * 简单打印出UserAnnotation 类中所使用到构造方法的注解
     * 该方法只打印了 Method 类型的注解
     *
     * @throws ClassNotFoundException
     */
    public void parseConstructAnnotation(TextView tv) {
        Constructor[] constructors = AnnotationTestB.class.getConstructors();
        StringBuffer  sb           = new StringBuffer();
        for (Constructor constructor : constructors) {
            /*
             * 判断构造方法中是否有指定注解类型的注解
             */
            boolean hasAnnotation = constructor.isAnnotationPresent(TestB.class);
            if (hasAnnotation) {
                /*
                 * 根据注解类型返回方法的指定类型注解
                 */
                TestB annotation = (TestB) constructor.getAnnotation(TestB.class);
                String info = "constructor = " + constructor.getName()
                        + " ;\n id = " + annotation.id() + " ;\n description = "
                        + annotation.name() + ";\n gid= " + annotation.gid();
                sb.append(info).append("\n");
                Log.i(TAG, "parseConstructAnnotation-->>  constructor = " + constructor.getName()
                        + " ; id = " + annotation.id() + " ; description = "
                        + annotation.name() + "; gid= " + annotation.gid());
            }
        }
        tv.setText("打印结果:\n" + sb.toString());

    }

// 反射的三种方法:
//Class clazz = Class.forName("com.example.annointroduction.user.AnnotationTestB.java");
//        Class clazz1 = TestB.class;
//        TestB testB1 = new TestB() {
//            @Override
//            public Class<? extends Annotation> annotationType() {
//                return null;
//            }
//
//            @Override
//            public String name() {
//                return null;
//            }
//
//            @Override
//            public int id() {
//                return 0;
//            }
//
//            @Override
//            public Class<Long> gid() {
//                return null;
//            }
//        };
//        Class<? extends TestB> clazz = testB1.getClass();

}
