package com.example.black.qianyue;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        context=getApplicationContext();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login=(Button)findViewById(R.id.loginBtn);
        login.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
               saveLogin();
            }
        });
    }

    private void saveLogin(){
        SharedPreferences sp=context.getSharedPreferences("user",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sp.edit();
        editor.putString("username","李振纲");
        editor.putString("token","123456234");
        editor.commit();

    }

}
