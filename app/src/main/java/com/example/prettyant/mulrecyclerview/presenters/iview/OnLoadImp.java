package com.example.prettyant.mulrecyclerview.presenters.iview;

import com.example.prettyant.mulrecyclerview.model.NewsModel;

import java.util.ArrayList;

/**
 * @author ChenYu
 * Author's github https://github.com/PrettyAnt
 * <p>
 * Created on 5:18 PM  2020/5/26
 * PackageName : com.example.prettyant.mulrecyclerview.presenters.iview
 * describle :
 */
public interface OnLoadImp {
    void onReceive(ArrayList<NewsModel> newsModels);
}
