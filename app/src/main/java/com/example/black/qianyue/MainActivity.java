package com.example.black.qianyue;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //UI Object
    private TextView txt_topbar;
    private TextView tab_main;
    private TextView tab_doctor;
    private TextView tab_user;
    private FrameLayout ly_content;

    //Fragment Object
    private MainFragment fg1,fg2,fg4;
    private UserFragment fg3;
    private FragmentManager fManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        fManager = getFragmentManager();
        bindViews();
        tab_main.performClick();   //模拟一次点击，既进去后选择第一项
    }

    //UI组件初始化与事件绑定
    private void bindViews() {
        txt_topbar = (TextView) findViewById(R.id.txt_topbar);
        tab_main = (TextView) findViewById(R.id.tab_main);
        tab_doctor = (TextView) findViewById(R.id.tab_doctor);
        tab_user = (TextView) findViewById(R.id.tab_user);
        ly_content = (FrameLayout) findViewById(R.id.ly_content);
        txt_topbar.setOnClickListener(this);
        tab_main.setOnClickListener(this);
        tab_doctor.setOnClickListener(this);
        tab_user.setOnClickListener(this);
    }

    //重置所有文本的选中状态
    private void setSelected(){
        tab_main.setSelected(false);
        tab_doctor.setSelected(false);
        tab_user.setSelected(false);
    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fg1 != null)fragmentTransaction.hide(fg1);
        if(fg2 != null)fragmentTransaction.hide(fg2);
        if(fg3 != null)fragmentTransaction.hide(fg3);
        if(fg4 != null)fragmentTransaction.hide(fg4);
    }


    @Override
    public void onClick(View v) {
        FragmentTransaction fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);
        switch (v.getId()){
            case R.id.tab_main:
                setSelected();
                tab_main.setSelected(true);
                if(fg1 == null){
                    fg1 = MainFragment.newInstance("第一个Fragment");
                    fTransaction.add(R.id.ly_content,fg1);
                }else{
                    fTransaction.show(fg1);
                }
                break;
            case R.id.tab_doctor:
                setSelected();
                tab_doctor.setSelected(true);
                if(fg2 == null){
                    fg2 =MainFragment.newInstance("第二个Fragment");
                    fTransaction.add(R.id.ly_content,fg2);
                }else{
                    fTransaction.show(fg2);
                }
                break;
            case R.id.tab_user:
                setSelected();
                tab_user.setSelected(true);
                if(fg3 == null){
                    fg3 = new UserFragment();
                    fTransaction.add(R.id.ly_content,fg3);
                }else{
                    fTransaction.show(fg3);
                }
                break;

        }
        fTransaction.commit();
    }
}
