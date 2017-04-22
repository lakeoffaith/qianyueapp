package com.example.black.qianyue;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class UserFragment extends Fragment {

    private static final String TAB_ID="contentId";
    private Context context;
    public static final UserFragment newInstance(String content)
    {
        UserFragment f = new UserFragment();
        Bundle bdl = new Bundle(2);
        bdl.putString(TAB_ID, content);
        f.setArguments(bdl);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context=getActivity().getApplicationContext();
       View view= inflater.inflate(R.layout.fragment_user, container, false);
        Map<String ,Object> data=initLogin();
        String username=data.get("username")!=null?data.get("username").toString():"";

        Button userNameBtn = (Button) view.findViewById(R.id.userNameBtn);
        if(username.length()>0){
            userNameBtn.setText(username);
        }else {
            userNameBtn.setOnClickListener(new Button.OnClickListener(){
                @Override
                public void onClick(View view) {
                    goLogin();
                }
            });
        }


        return view;


    }
    //从sharedpreferences 读取用户名
    private Map<String, Object> initLogin(){
        Map<String,Object> data=new HashMap<>();
        SharedPreferences sp=context.getSharedPreferences("user",Context.MODE_PRIVATE);
        data.put("username",sp.getString("username",""));
        data.put("token",sp.getString("token",""));
        return data;

    }

    private void goLogin(){
        Intent intent=new Intent();
        intent.setClass(getActivity(),LoginActivity.class);
        startActivity(intent);
    }




}
