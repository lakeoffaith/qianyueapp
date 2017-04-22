package com.example.black.qianyue;

import android.app.Fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MainFragment extends Fragment {
    private static final String TAB_ID="contentId";


    private String content;

    public static final MainFragment newInstance(String content)
    {
        MainFragment f = new MainFragment();
        Bundle bdl = new Bundle(2);
        bdl.putString(TAB_ID, content);
        f.setArguments(bdl);
        return f;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.content=getArguments().getString(TAB_ID);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_main, container, false);
        TextView txt_content = (TextView) view.findViewById(R.id.txt_content);
        txt_content.setText(content);

        Typeface font=Typeface.createFromAsset(getActivity().getAssets(),"MaterialIcons.ttf");

        TextView textIcon=(TextView)view.findViewById(R.id.cropFreeIcon);
        textIcon.setTypeface(font);


        return view;
    }




}
