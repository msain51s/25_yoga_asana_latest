package com.yoga_asana.adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yoga_asana.R;
import com.yoga_asana.YogaDetatailActivity;
import com.yoga_asana.model.YogaDetailModel;
import com.yoga_asana.utility.Application;
import com.yoga_asana.utility.FontType;
import com.yoga_asana.utility.Utils;

import java.util.List;

/**
 * Created by Administrator on 8/30/2017.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> implements View.OnClickListener {

    private List<YogaDetailModel> list;
    private Activity mContext;
    int[] images;
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        ImageView thumb_img;

        public MyViewHolder(View view) {
            super(view);
            Typeface roboto_regular= Utils.getCustomFont(Application.mContext, FontType.ROBOTO_REGULAR);

            title = (TextView) view.findViewById(R.id.list_title);
            thumb_img= (ImageView) view.findViewById(R.id.img_view_thumb);

            title.setTypeface(roboto_regular);
        }
    }
    public ListAdapter(List<YogaDetailModel> list,Activity mContext,int[] images) {
        this.list = list;
        this.mContext=mContext;
        this.images=images;
    }
    @Override
    public ListAdapter.MyViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        itemView.setOnClickListener(this);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListAdapter.MyViewHolder holder, final int position) {
        YogaDetailModel model = list.get(position);
        holder.title.setText(model.getYogaTitle());
    //    holder.thumb_img.setImageResource(images[position]);
        Glide.with(mContext)
                .load(images[position])
                .into(holder.thumb_img);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(mContext, YogaDetatailActivity.class);
        intent.putExtra("model",list.get((Integer) view.getTag()));
        intent.putExtra("image",images[(int) view.getTag()]);
        mContext.startActivity(intent);
    }
}

