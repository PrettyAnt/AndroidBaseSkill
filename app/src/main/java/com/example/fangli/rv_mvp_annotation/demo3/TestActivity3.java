package com.example.fangli.rv_mvp_annotation.demo3;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fangli.rv_mvp_annotation.R;
import com.example.fangli.rv_mvp_annotation.demo3.user.AnnotationTest2;
import com.example.fangli.rv_mvp_annotation.demo3.zhujie.TestB;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestActivity3 extends AppCompatActivity implements View.OnClickListener {

    private Button btn_back, btn_test1, btn_test2, btn_test3, btn_test4;
    private TextView tv_show;
    private final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_test);
        initView();
        initEvent();
    }


    private void initView() {
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_test1 = (Button) findViewById(R.id.btn_test1);
        btn_test2 = (Button) findViewById(R.id.btn_test2);
        btn_test3 = (Button) findViewById(R.id.btn_test3);
        btn_test4 = (Button) findViewById(R.id.btn_test4);
        tv_show = (TextView) findViewById(R.id.tv_show);
    }

    private void initEvent() {
        btn_back.setOnClickListener(this);
        btn_test1.setOnClickListener(this);
        btn_test2.setOnClickListener(this);
        btn_test3.setOnClickListener(this);
        btn_test4.setOnClickListener(this);
    }


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_test1:
                try {
                    parseTypeAnnotation(tv_show);
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.i(TAG, "错误" + e.toString());
                    tv_show.setText("错误日志:" + e.toString());
                }
                break;
            case R.id.btn_test2:
                try {
                    getAnnotation(tv_show);
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.i(TAG, "错误" + e.toString());
                    tv_show.setText("错误日志:" + e.toString());
                }
                break;
            case R.id.btn_test3:
                try {
                    parseMethodAnnotation(tv_show);
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.i(TAG, "错误" + e.toString());
                    tv_show.setText("错误日志:" + e.toString());
                }
                break;
            case R.id.btn_test4:
                try {
                    parseConstructAnnotation(tv_show);
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.i(TAG, "错误" + e.toString());
                    tv_show.setText("错误日志:" + e.toString());
                }
                break;
        }
    }

    /**
     * 测试该方法的注解的某个方法名
     *
     * @param tv_show
     */
    public void getAnnotation(TextView tv_show) {
        StringBuffer sb = new StringBuffer();
        TestB testB = AnnotationTest2.class.getAnnotation(TestB.class);
        sb.append(testB.name()).append(", \n");
        Log.i(TAG, testB.name());
        try {
            Class<AnnotationTest2> annotationTest2Class = AnnotationTest2.class;

            TestB testB1 = AnnotationTest2.class.getDeclaredMethod("a", null).getAnnotation(TestB.class);
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
    public void parseTypeAnnotation(TextView tv) throws ClassNotFoundException {
        Class clazz = Class.forName("com.example.fangli.rv_mvp_annotation.demo3.user.AnnotationTest2");

        StringBuffer sb = new StringBuffer();

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            TestB testB = (TestB) annotation;
            String info = "id= \"" + testB.id() + "\"; \nname= \"" + testB.name() + "\";\n gid = " + testB.gid();
            sb.append(info).append("\n");
            System.out.println(sb.toString());

        }
        tv.setText("打印结果:\n" + sb.toString());
    }

    /**
     * 简单打印出UserAnnotation 类中所使用到的方法注解
     * 该方法只打印了 Method 类型的注解
     *
     * @throws ClassNotFoundException
     */
    public void parseMethodAnnotation(TextView tv) {
        Method[] methods = AnnotationTest2.class.getDeclaredMethods();
        StringBuffer sb = new StringBuffer();
        for (Method method : methods) {
            /*
             * 判断方法中是否有指定注解类型的注解
             */
            boolean hasAnnotation = method.isAnnotationPresent(TestB.class);
            if (hasAnnotation) {
                /*
                 * 根据注解类型返回方法的指定类型注解
                 */
                TestB annotation = method.getAnnotation(TestB.class);
                String info = "method = " + method.getName()
                        + " ;\n id = " + annotation.id() + " ;\n description = "
                        + annotation.name() + ";\n gid= " + annotation.gid();
                sb.append(info).append("\n");
                System.out.println("method = " + method.getName()
                        + " ; id = " + annotation.id() + " ; description = "
                        + annotation.name() + "; gid= " + annotation.gid());

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
        Constructor[] constructors = AnnotationTest2.class.getConstructors();
        StringBuffer sb = new StringBuffer();
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
                System.out.println("constructor = " + constructor.getName()
                        + " ; id = " + annotation.id() + " ; description = "
                        + annotation.name() + "; gid= " + annotation.gid());
            }
        }
        tv.setText("打印结果:\n" + sb.toString());

    }


// 反射的三种方法:
//Class clazz = Class.forName("com.example.fangli.myjavaannotation.user.AnnotationTest2");
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
