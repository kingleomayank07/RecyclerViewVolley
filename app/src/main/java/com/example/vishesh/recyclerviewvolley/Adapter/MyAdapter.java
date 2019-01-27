package com.example.vishesh.recyclerviewvolley.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.vishesh.recyclerviewvolley.Model.List1;
import com.example.vishesh.recyclerviewvolley.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>  {
    private Context context;
    private List<List1> list1s;
    RequestOptions option;

    public MyAdapter(Context context, List<List1> list1s) {
        this.context = context;
        this.list1s = list1s;
        option = new RequestOptions().centerCrop().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_foreground);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.list_row,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.tv_id.setText(list1s.get(i).getId());
        myViewHolder.tv_name.setText(list1s.get(i).getName());
        myViewHolder.tv_studio.setText(list1s.get(i).getId());
        myViewHolder.tv_categories.setText(list1s.get(i).getName());
        Glide.with(context).load(list1s.get(i).getImg()).apply(option).into(myViewHolder.img);

    }

    @Override
    public int getItemCount() {
        return list1s.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_id;
        TextView tv_name;
        TextView tv_studio;
        TextView tv_categories;
        ImageView img;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_id = itemView.findViewById(R.id.tv1);
            tv_name = itemView.findViewById(R.id.tv2);
            img = itemView.findViewById(R.id.thumbnail);
            tv_studio = itemView.findViewById(R.id.tv3);
            tv_categories=itemView.findViewById(R.id.tv4);
                }
    }

}
