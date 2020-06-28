package com.example.customizetextview;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customizetextview.widget.ExplandableTextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomizeTextActivity extends AppCompatActivity implements View.OnClickListener {

    private String testText = "点击我我会展开的，但是小于3行是不会展开的，设置方法为ExplandableTextView中的MAX_LINES参数，，建议问/相关问显示区域、④有用/无用选项区域，其中回复内容区域、" +
            "建议问/相关问提示话术区域和建议问/相关问显示区域需要根据内容的多少调整模板区域大小①回复内容区" +
            "域的内容，需判断内容的行数是否大于3行，若大于3行，则显示3.5行内容以及“展开”按钮，第4行以外部分全部隐藏，②、③、④区域内容展现不变，效果图如下图，当点击“展开”按钮后则显示全部内容，并不再收起。";

    private ExplandableTextView etv;
    private TextView            tv_show;
    private LinearLayout        ll_loadmore;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customizetext);
        initView();
        initEvent();
        initData();
    }

//        private String link = "好的，下回见，请<a href=\"http://172.29.32.128:9001/IM/myd/reqAdapterMyd.do?sid=101521B57B99578F0DA481699084BA25EDD3zxkfappct10100001592458668069&useno=gTm2YE/oogN84fk7a4VSoz94/r1aGJEHL0di6HeAf5eSL4XsCCnIPJ73ViLg6pRRHNh0RVzoIkbNsiaY83NLAySMKFPjllmiCSuRoA0ZSQFl9RmteLx6D6uDWrIqOgWlx43wsahd/9e/584lNQ5V19wBssOopX7OD7Syt0JRQ34=&userId=21B57B99578F0DA481699084BA25EDD3&certType=01&workNo=992701&cardNo=ptChSCtUE2ISveTZ759L9ftE0C3VAXhhhwzxgyOreeffdc0nXiEOPF/iOqFRvoAYQrKm0l4Ox76Ph3at2SARZB53ttzl1YOZ4e5sXD95q69uMldhs989+SSwcKKDn6vqDV/olexGslhl5c6OpGbeq1NhYb0FdN/OF0NUZ9QCffg=&sendAccount=zxkf_appct\">点击这里</a>进行满意度评价。测试1";
//    private String link = "好的，下回见,请<font color='#FF0000'><a href='http:www.baidu.com'>点击这里</a></font>评价";
    private String link = "<a href='http://prettyant.com/'>点击这里</a>试一下,SpannableString效果";
//    private String link = "好的 <font color='#FF00ff'>点击这里</font>";
    private void initView() {
        etv = (ExplandableTextView) findViewById(R.id.etv);
        tv_show = (TextView) findViewById(R.id.tv_half_show);
    }

    private void initEvent() {
        tv_show.setOnClickListener(this);
        ll_loadmore = etv.getLl_loadmore();
        ll_loadmore.setOnClickListener(this);
    }

    private void initData() {
//        testText = "你好点击我我会展开的点niimiohhm8很纠结哦我我我我就跑回货乙uoiji UI加啤酒PHP h8upihhftuyiviuv好看不要提芙蓉大道待修复好击我我会展开的";
        etv.setHalfText(testText);
        tv_show.setText(getSpannStr(link));
    }

    private SpannableString getSpannStr(String totalSource) {
        String          totalStringWithoutUrl               = Html.fromHtml(totalSource).toString();//点击这里试一下,SpannableString效果
        String valueString = getValue(totalSource);//"点击这里"
        int    start = totalStringWithoutUrl.indexOf(valueString);
        int end = start + valueString.length();
        SpannableString spannableString = new SpannableString(totalStringWithoutUrl);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#ff0000")),start,end,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);//设置颜色
        spannableString.setSpan(new UnderlineSpan(), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);//设置下划线
        return spannableString;
    }


    /**
     * 正则匹配A标签中的 href地址
     * @param url
     * @return
     */
    public static String getMatcher(String url) {
        String result = "";
        try {
            String regex = "['\"](.*?)['\"]";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(url);
            while (matcher.find()) {
                result = matcher.group();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.replaceAll("\"", "");
    }

    /**
     * 正则匹配A标签中的文字
     * @param source
     * @return
     */
    private String getValue(String source){

//        Pattern compile = Pattern.compile("<a[^>]*>([^<]*)</a>");
        Pattern compile = Pattern.compile("<a.*?>([\\s\\S]*?)</a>");
        Matcher matcher = compile.matcher(source);
        while (matcher.find()) {
            Log.i("prettyants", "getContent: "+matcher.group(1));
            return matcher.group(1);
        }
        return source;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ll_loadmore) {
            etv.setText(testText);
        } else if (v.getId() == R.id.tv_half_show) {
            String urlString = getMatcher(link);
            Intent intent = new Intent(this, WebActivity.class);
            intent.putExtra("url", urlString);
            startActivity(intent);
        }
    }
}
