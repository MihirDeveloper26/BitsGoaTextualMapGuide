package com.example.admin.bitsgoatextualmapguide;
import android.content.Context;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter{


    Context mContext;
    LayoutInflater inflater;
    List<ColorSpace.Model> modellist;
    ArrayList<ColorSpace.Model> arrayList;


    public ListViewAdapter(Context context, List<ColorSpace.Model> modellist) {
        mContext = context;
        this.modellist = modellist;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<ColorSpace.Model>();
        this.arrayList.addAll(modellist);
    }

    public class ViewHolder{
        TextView mTitleTv, mDescTv;
        ImageView mIconIv;
    }

    @Override
    public int getCount() {
        return modellist.size();
    }

    @Override
    public Object getItem(int i) {
        return modellist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int postition, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view==null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row, null);
            holder.mTitleTv = view.findViewById(R.id.mainTitle);
            holder.mDescTv = view.findViewById(R.id.mainDesc);
            holder.mIconIv = view.findViewById(R.id.mainIcon);

            view.setTag(holder);

        }
        else {
            holder = (ViewHolder)view.getTag();
        }
        holder.mTitleTv.setText(modellist.get(postition).getTitle());
        holder.mDescTv.setText(modellist.get(postition).getDesc());
        holder.mIconIv.setImageResource(modellist.get(postition).getIcon());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (modellist.get(postition).getTitle().equals("Battery")){
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Battery");
                    intent.putExtra("contentTv", "This is Battery detail...");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Cpu")){
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Cpu");
                    intent.putExtra("contentTv", "This is Cpu detail...");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Display")){
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Display");
                    intent.putExtra("contentTv", "This is Display detail...");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Memory")){
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Memory");
                    intent.putExtra("contentTv", "This is Memory detail...");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Sensor")){
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Sensor");
                    intent.putExtra("contentTv", "This is Sensor detail...");
                    mContext.startActivity(intent);
                }
            }
        });


        return view;
    }


    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        modellist.clear();
        if (charText.length()==0){
            modellist.addAll(arrayList);
        }
        else {
            for (Model model : arrayList){
                if (model.getTitle().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    modellist.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }

}

