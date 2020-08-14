package com.example.prettyant.mulrecyclerview.ui.widget;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author ChenYu
 * My personal blog  https://prettyant.github.io
 * <p>
 * Created on 2:35 PM  2020/8/14
 * PackageName : com.example.prettyant.mulrecyclerview.ui.widget
 * describle :
 */
public class RecyclerScrollListener extends RecyclerView.OnScrollListener {
    private ScrollListener scrollListener;
    public RecyclerScrollListener() {
        super();
    }

    @Override
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
        scrollListener.onScrollStateChanged(recyclerView,newState);
        super.onScrollStateChanged(recyclerView, newState);
    }

    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        scrollListener.onScrolled(recyclerView,dx,dy);
        super.onScrolled(recyclerView, dx, dy);
    }

    public void setScrollListener(ScrollListener scrollListener) {
        this.scrollListener = scrollListener;
    }

   public interface ScrollListener{
        void onScrollStateChanged(RecyclerView recyclerView, int newState);
        void onScrolled(RecyclerView recyclerView, int dx, int dy);
    }
}
