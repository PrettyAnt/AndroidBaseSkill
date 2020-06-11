package com.example.customizetextview;

import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customizetextview.widget.ExplandableTextView;

public class CustomizeTextActivity extends AppCompatActivity {

    private String              testText = "点击我我会展开的，但是小于3行是不会展开的，设置方法为ExplandableTextView中的MAX_LINES参数，，建议问/相关问显示区域、④有用/无用选项区域，其中回复内容区域、" +
            "建议问/相关问提示话术区域和建议问/相关问显示区域需要根据内容的多少调整模板区域大小①回复内容区" +
            "域的内容，需判断内容的行数是否大于3行，若大于3行，则显示3.5行内容以及“展开”按钮，第4行以外部分全部隐藏，②、③、④区域内容展现不变，效果图如下图，当点击“展开”按钮后则显示全部内容，并不再收起。";
    private ExplandableTextView etv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customizetext);
        initView();
        initEvent();
        initData();
    }

    private void initView() {
        etv = (ExplandableTextView) findViewById(R.id.etv);
    }

    private void initEvent() {
    }

    private void initData() {
        etv.setHalfText(testText);
    }

}
