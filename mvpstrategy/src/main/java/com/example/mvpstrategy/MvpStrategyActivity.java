package com.example.mvpstrategy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvpstrategy.imp.OnClickListenerImp;
import com.example.mvpstrategy.presenter.MyPresenter;
import com.example.mvpstrategy.utils.MyDialogUtils;
import com.example.mvpstrategy.view.IView;

import java.util.Map;

public class MvpStrategyActivity extends AppCompatActivity implements IView, View.OnClickListener {

    private Button btn_back, btn_next_act;
    private TextView tv_show_msg;
    private String   content = "其实对于TextView，如果固定了高度，超bai出部分自动在末尾显示省略号，但是如果高度是自适应则会完全显示，除非屏幕空间不不够了。ellipsize这个属性设置的是当内容显示不下是在什么地方显示省略号，还支持在开头和中间显示省略号。";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvpstrategy);
        initView();
        initEvent();
    }


    private void initView() {
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_next_act = (Button) findViewById(R.id.btn_test);
        tv_show_msg = (TextView) findViewById(R.id.tv_show_msg);
    }

    private void initEvent() {
        btn_back.setOnClickListener(this);
        btn_next_act.setOnClickListener(this);
        tv_show_msg.setOnClickListener(this);

    }


    private StringBuffer sb = new StringBuffer();

    @Override
    public void onGetDataList(Map<Integer, String> datas) {
        for (int i = 0; i < datas.size(); i++) {
            sb.append(datas.get(i));
            Log.i("ttt", datas.get(i));
        }
        tv_show_msg.setText("收到了消息-->>  " + sb.toString());
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_back) {
            MyDialogUtils.getInstance().commDialog(this,
                    "提示",
                    "\"确定\"退出当前界面",
                    "取消",
                    new OnClickListenerImp() {
                        @Override
                        public void onClickListener(AlertDialog dialog, View view) {
                            dialog.dismiss();
                        }
                    }, "确定",
                    new OnClickListenerImp() {
                        @Override
                        public void onClickListener(AlertDialog dialog, View view) {
                            dialog.dismiss();
                            finish();
                        }
                    }, new DialogInterface.OnKeyListener() {
                        @Override
                        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                            if (event.getAction() == KeyEvent.ACTION_DOWN) {
                                Toast.makeText(MvpStrategyActivity.this, "退出111111", Toast.LENGTH_SHORT).show();
                                return true;
                            } else {
                                Toast.makeText(MvpStrategyActivity.this, "没", Toast.LENGTH_SHORT).show();
                                return false;
                            }
                        }
                    });
        } else if (id == R.id.btn_test) {
            MyPresenter.getInstance().loadDatas(this);
//            String subString = getSubString(tv_show_msg, content, 3);
//            tv_show_msg.setText(subString);
//            float lineSpacingExtra = tv_show_msg.getLineSpacingExtra();
//            float lineSpacingMultiplier = tv_show_msg.getLineSpacingMultiplier();
//            double   singleLineHeigh = tv_show_msg.getHeight() / tv_show_msg.getLineCount();
//            tv_show_msg.setHeight((int) (singleLineHeigh*3.5));
//            tv_show_msg.setHeight(100);

        } else if (id == R.id.tv_show_msg) {
//            tv_show_msg.setText(content);
        }
    }


    public String getSubString(TextView tv, String content, float maxLine) {
        float width = tv.getPaint().measureText(content);//字符串总长度
        //这里只是为了方便，用屏幕宽度代替了textview控件宽度，如果需要精准控制，可以换成控件宽度
//        float tvWidth =getWindowManager().getDefaultDisplay().getWidth();
        float tvWidth = tv.getWidth();
//        if(width / tvWidth > (maxLine + 0.5)){
//            return content.substring(0,(int)(content.length()/(width/tvWidth)/(maxLine + 0.5))) + "...";
//        }


        if (width / tvWidth > maxLine) {
//            return content.substring(0,)
            return content.substring(0, (int) (content.length() * maxLine / (width / tvWidth)));
        }
        Log.i("perttyant", "line: " + width / tvWidth);
        return content;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Toast.makeText(this, "退出", Toast.LENGTH_SHORT).show();
        return super.onKeyDown(keyCode, event);
    }
}
