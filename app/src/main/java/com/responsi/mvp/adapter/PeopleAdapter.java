package com.responsi.mvp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.responsi.mvp.DetailActivity;
import com.responsi.mvp.R;
import com.responsi.mvp.model.ResultData;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder> {

    Context mContext;
    List<ResultData> resultDataList;

    public PeopleAdapter(Context mContext, List<ResultData> resultDataList) {
        this.mContext = mContext;
        this.resultDataList = resultDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_people, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        ResultData data = resultDataList.get(i);

        Log.i("xxxx", "Here " + resultDataList.size());

        Glide.with(mContext)
                .load(data.getPicture().getThumbnail())
                .into(holder.mImagePeople);

        holder.name = data.getName().getTitle() + " " + data.getName().getFirst() + " " + data.getName().getLast();

        holder.mTextName.setText(holder.name);
        holder.mTextGender.setText(data.getGender());
        holder.mTextState.setText(data.getLocation().getState());
    }

    @Override
    public int getItemCount() {
        return resultDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout mLayoutPeople;
        CircleImageView mImagePeople;
        TextView mTextName;
        TextView mTextGender;
        TextView mTextState;

        String name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mLayoutPeople = itemView.findViewById(R.id.layout_people);
            mImagePeople = itemView.findViewById(R.id.iv_people);
            mTextName = itemView.findViewById(R.id.tv_name);
            mTextGender = itemView.findViewById(R.id.tv_gender);
            mTextState = itemView.findViewById(R.id.tv_state);

            mLayoutPeople.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ResultData data = resultDataList.get(getAdapterPosition());

                    Intent intent = new Intent(mContext, DetailActivity.class);
                    intent.putExtra("image", data.getPicture().getLarge());
                    intent.putExtra("name", name);
                    intent.putExtra("email", data.getEmail());
                    intent.putExtra("phone", data.getPhone());
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
