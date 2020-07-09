package com.example.prettyant.mulrecyclerview.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.prettyant.R;
import com.example.prettyant.mulrecyclerview.ItemOnClickListener;
import com.example.prettyant.mulrecyclerview.model.NewsModel;
import com.example.prettyant.mulrecyclerview.presenters.ReceiveHelper;
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
        if (newsModels.size() > 0) {
            return newsModels.get(position).getNewsType();
        }
        return super.getItemViewType(position);
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
        NewsModel newsModel = newsModels.get(position);
        int       textSize  = newsModel.getTextSize();
        if (holder instanceof MulViewHolder) {
            TextView  tv_item_text  = ((MulViewHolder) holder).tv_item_text;
            ImageView iv_item_pic   = ((MulViewHolder) holder).iv_item_pic;
            TextView  tv_item_video = ((MulViewHolder) holder).tv_item_video;

            if (newsModel.getTextSize() == ReceiveHelper.DEFAULT_SIZA) {
                tv_item_text.setTextColor(Color.parseColor("#206cce"));
                tv_item_text.getPaint().setFakeBoldText(true);
            } else {
                tv_item_text.setTextColor(Color.parseColor("#777777"));
                tv_item_text.getPaint().setFakeBoldText(false);
            }
            tv_item_text.setText(newsModel.getTextContent());
            tv_item_text.setTextSize(TypedValue.COMPLEX_UNIT_SP,textSize);
            Glide.with(mContext).load(newsModel.getImgUrl()).error(R.drawable.a).into(iv_item_pic);
            tv_item_video.setText(newsModel.getVideoUrl());
        } else if (holder instanceof ImgTextViewHolder) {
            TextView  tv_item_text = ((ImgTextViewHolder) holder).tv_item_text;
            ImageView iv_item_pic  = ((ImgTextViewHolder) holder).iv_item_pic;

            if (newsModel.getTextSize() == ReceiveHelper.DEFAULT_SIZA) {
                tv_item_text.setTextColor(Color.parseColor("#206cce"));
                tv_item_text.getPaint().setFakeBoldText(true);
            } else {
                tv_item_text.setTextColor(Color.parseColor("#777777"));
                tv_item_text.getPaint().setFakeBoldText(false);
            }
            tv_item_text.setText(newsModel.getTextContent());
            tv_item_text.setTextSize(TypedValue.COMPLEX_UNIT_SP,textSize);
            Glide.with(mContext).load(newsModel.getImgUrl()).error(R.drawable.b).into(iv_item_pic);
        } else if (holder instanceof TextViewHolder) {
            TextView tv_item_text = ((TextViewHolder) holder).tv_item_text;

            if (newsModel.getTextSize() == ReceiveHelper.DEFAULT_SIZA) {
                tv_item_text.setTextColor(Color.parseColor("#206cce"));
                tv_item_text.getPaint().setFakeBoldText(true);
            } else {
                tv_item_text.setTextColor(Color.parseColor("#777777"));
                tv_item_text.getPaint().setFakeBoldText(false);
            }
            tv_item_text.setText(newsModel.getTextContent());
        } else if (holder instanceof ImgViewHolder) {
            ImageView iv_item_pic = ((ImgViewHolder) holder).iv_item_pic;

            Glide.with(mContext).load(newsModel.getImgUrl()).error(R.drawable.c).into(iv_item_pic);
        } else if (holder instanceof VideoViewHolder) {
            TextView tv_item_video = ((VideoViewHolder) holder).tv_item_video;

            tv_item_video.setText(newsModel.getVideoUrl());
        }
    }

    @Override
    public int getItemCount() {
        return newsModels.size();
    }

}
