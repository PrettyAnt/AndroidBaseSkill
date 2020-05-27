package com.example.prettyant.mulrecyclerview.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.prettyant.R;
import com.example.prettyant.mulrecyclerview.ItemOnClickListener;
import com.example.prettyant.mulrecyclerview.model.NewsModel;
import com.example.prettyant.mulrecyclerview.ui.holder.BaseViewHolder;
import com.example.prettyant.mulrecyclerview.ui.holder.ImgTextViewHolder;
import com.example.prettyant.mulrecyclerview.ui.holder.ImgViewHolder;
import com.example.prettyant.mulrecyclerview.ui.holder.MulViewHolder;
import com.example.prettyant.mulrecyclerview.ui.holder.TextViewHolder;
import com.example.prettyant.mulrecyclerview.ui.holder.VideoViewHolder;

import java.util.List;

/**
 * Created by chenyu.
 * Created on 上午11:46.
 * Author'github https://github.com/PrettyAnt
 */

public class DataAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private              List<NewsModel> newsModels;
    private              Context         mContext;
    private static final int             TYPE_MULTEXT   = 0;//富文本
    private static final int             TYPE_ONLYTEXT  = 1;//只有文字
    private static final int             TYPE_TEXT_PIC  = 2;//文字和图片
    private static final int             TYPE_ONLYPIC   = 3;//只有图片
    private static final int             TYPE_ONLYVIDEO = 4;//只有视频

    public void setItemOnClickListener(ItemOnClickListener itemOnClickListener) {
        this.itemOnClickListener = itemOnClickListener;
    }

    private ItemOnClickListener itemOnClickListener;

    public DataAdapter(List<NewsModel> newsModels, Context mContext) {
        this.newsModels = newsModels;
        this.mContext = mContext;
    }

    @Override
    public int getItemViewType(int position) {

        return newsModels.get(position).getNewsType();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder holder = null;
        switch (viewType) {
            case TYPE_MULTEXT:
                holder = new MulViewHolder(LayoutInflater
                        .from(mContext)
                        .inflate(R.layout.item_mul_view, parent, false),
                        itemOnClickListener);
                break;

            case TYPE_ONLYTEXT:
                holder = new TextViewHolder(LayoutInflater
                        .from(mContext)
                        .inflate(R.layout.item_text_view, parent, false),
                        itemOnClickListener);
                break;
            case TYPE_TEXT_PIC:
                holder = new ImgTextViewHolder(LayoutInflater
                        .from(mContext)
                        .inflate(R.layout.item_img_text_view, parent, false),
                        itemOnClickListener);
                break;
            case TYPE_ONLYPIC:
                holder = new ImgViewHolder(LayoutInflater
                        .from(mContext)
                        .inflate(R.layout.item_img_view, parent, false),
                        itemOnClickListener);
                break;
            case TYPE_ONLYVIDEO:
                holder = new VideoViewHolder(LayoutInflater
                        .from(mContext)
                        .inflate(R.layout.item_video_view, parent, false),
                        itemOnClickListener);
                break;

        }
        ;
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
//        holder.tv_item.setText("$" + (position + 1) + ". " + newsModels.get(position));
        if (holder instanceof MulViewHolder) {
            ((MulViewHolder) holder).tv_item_text.setText(newsModels.get(position).getTextContent());
//            ((MulViewHolder) holder).iv_item_pic.setImageResource(R.drawable.a);
            Glide.with(mContext).load(newsModels.get(position).getImgUrl()).error(R.drawable.a).into(((MulViewHolder) holder).iv_item_pic);
            ((MulViewHolder) holder).tv_item_video.setText(newsModels.get(position).getVideoUrl());
        } else if (holder instanceof ImgTextViewHolder) {
            ((ImgTextViewHolder) holder).tv_item_text.setText(newsModels.get(position).getTextContent());
//            ((ImgTextViewHolder) holder).iv_item_pic.setImageResource(R.drawable.b);
            Glide.with(mContext).load(newsModels.get(position).getImgUrl()).error(R.drawable.b).into(((ImgTextViewHolder) holder).iv_item_pic);
        } else if (holder instanceof TextViewHolder) {
            ((TextViewHolder) holder).tv_item_text.setText(newsModels.get(position).getTextContent());
        } else if (holder instanceof ImgViewHolder) {
//            ((ImgViewHolder) holder).iv_item_pic.setImageResource(R.drawable.c);
            Glide.with(mContext).load(newsModels.get(position).getImgUrl()).error(R.drawable.c).into(((ImgViewHolder) holder).iv_item_pic);
        } else if (holder instanceof VideoViewHolder) {
            ((VideoViewHolder) holder).tv_item_video.setText(newsModels.get(position).getVideoUrl());
        }
    }

    @Override
    public int getItemCount() {
        return newsModels.size();
    }

}
