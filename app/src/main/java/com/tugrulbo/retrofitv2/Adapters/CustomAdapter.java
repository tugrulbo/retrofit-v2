package com.tugrulbo.retrofitv2.Adapters;

import android.content.Context;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tugrulbo.retrofitv2.Models.Todos;
import com.tugrulbo.retrofitv2.R;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    List<Todos> mList;
    Context context;

    public CustomAdapter(List<Todos> _mList,Context _context){
        this.mList = _mList;
        this.context = _context;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.list_items,parent,false);
        TextView userId = convertView.findViewById(R.id.userId);
        TextView id = convertView.findViewById(R.id.userId);
        TextView title = convertView.findViewById(R.id.title);
        if(mList.get(position).getCompleted()==false){
            convertView.setBackgroundResource(R.color.design_default_color_error);
            userId.setText("User Id:"+mList.get(position).getUserId());
            id.setText("ID:"+mList.get(position).getId());
            title.setText(mList.get(position).getTitle());
        }else if(mList.get(position).getCompleted()==true){
            convertView.setBackgroundResource(R.color.design_default_color_primary_variant);
            userId.setText("User Id:"+mList.get(position).getUserId());
            id.setText("ID:"+mList.get(position).getId());
            title.setText(mList.get(position).getTitle());
        }
        return convertView;
    }
}
