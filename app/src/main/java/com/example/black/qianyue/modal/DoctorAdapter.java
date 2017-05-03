package com.example.black.qianyue.modal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.black.qianyue.R;

import java.util.List;

/**
 * Created by black on 2017/5/3.
 */
public class DoctorAdapter extends BaseAdapter {
    private List<Doctor> mData;
    private Context mContext;
    public DoctorAdapter(List<Doctor> mData, Context mContext) {
        this.mData=mData;
        this.mContext=mContext;
    }


    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(mContext).inflate(R.layout.item_list_doctor,viewGroup,false);
        TextView name=(TextView)view.findViewById(R.id.doctor_item_name);
        name.setText(mData.get(i).getName());
        return view;
    }
}
