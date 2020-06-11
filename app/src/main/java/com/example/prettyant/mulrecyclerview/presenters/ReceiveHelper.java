package com.example.prettyant.mulrecyclerview.presenters;

import com.example.prettyant.mulrecyclerview.model.NewsModel;
import com.example.prettyant.mulrecyclerview.presenters.iview.OnLoadImp;
import com.example.prettyant.mulrecyclerview.ui.MainActivity;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author ChenYu
 * Author's github https://github.com/PrettyAnt
 * <p>
 * Created on 5:16 PM  2020/5/26
 * PackageName : com.example.prettyant.mulrecyclerview.presenters
 * describle :
 */
public class ReceiveHelper {
    private static ReceiveHelper        instant;
    private        ArrayList<NewsModel> newsModels = new ArrayList<>();

    public static ReceiveHelper getInstance() {
        if (instant == null) {
            synchronized (ReceiveHelper.class) {
                if (instant == null) {
                    instant = new ReceiveHelper();
                }
            }
        }
        return instant;
    }

    public void loading(OnLoadImp onLoad, int index) {
        initData(index);
        onLoad.onReceive(newsModels);
    }

    /**
     * 造数据
     */
    private void initData(int index) {
        if (index == 0) {
            newsModels.clear();
            addDatas();
            getMulDatas();
        } else {
            /**
             * 为了保证拉取的数据在最上面，先倒叙，再插入，最后再倒叙
             */
            Collections.reverse(newsModels);
            newsModels2.clear();
            addDatas1(index);
            Collections.reverse(newsModels2);
            newsModels.addAll(newsModels2);
            Collections.reverse(newsModels);
        }
    }


    /**
     * 0--富文本
     * 1--只有文字
     * 2--文字和图片
     * 3--只有图片
     * 4--只有视频
     */
    private void getMulDatas() {
        for (int i = 0; i < 10; i++) {
            switch (i % 5) {
                case 0:
                    NewsModel newsModel = new NewsModel();
                    newsModel.setNewsType(0);//富文本消息，文字、图片、视频都有
                    newsModel.setTextContent("这是富文本消息，你想要的内容这里都有");
                    newsModel.setImgUrl("http://prettyant.com/images/wife/lp_a.png");
                    newsModel.setVideoUrl("这是视频模块");
                    newsModels.add(newsModel);
                    break;
                case 1:
                    NewsModel newsModel1 = new NewsModel();
                    newsModel1.setNewsType(1);//只有文字
                    newsModel1.setTextContent("这是单纯的文字消息，纯文字纯文字纯文字纯文字纯文字");
                    newsModels.add(newsModel1);
                    break;
                case 2:
                    NewsModel newsModel2 = new NewsModel();
                    newsModel2.setNewsType(2);//文字和图片
                    newsModel2.setTextContent("文字和图片 文字和图片 文字和图片 文字和图片");
                    newsModel2.setImgUrl("http://prettyant.com/images/wife/a.png");
                    newsModels.add(newsModel2);
                    break;
                case 3:
                    NewsModel newsModel3 = new NewsModel();
                    newsModel3.setNewsType(3);//单纯的图片消息
                    newsModel3.setImgUrl("http://prettyant.com/images/wife/a.png");
                    newsModels.add(newsModel3);
                    break;
                case 4:
                    NewsModel newsModel4 = new NewsModel();
                    newsModel4.setNewsType(4);//单纯的图片消息
                    newsModel4.setVideoUrl("这是视频模块");
                    newsModels.add(newsModel4);
                    break;
                default:
                    NewsModel newsModel5 = new NewsModel();
                    newsModel5.setNewsType(1);//富文本消息，文字、图片、视频都有
                    newsModel5.setTextContent("这是单纯的文字消息，纯文字纯文字纯文字纯文字纯文字 ");
                    newsModels.add(newsModel5);
                    break;
            }
        }
    }

    private ArrayList<NewsModel> newsModels2 = new ArrayList<>();

    /**
     * 造假数据
     */

    private void addDatas() {
        NewsModel newsModel = new NewsModel();
        newsModel.setNewsType(1);
        newsModel.setTextContent("点击 -->>跳转到 自定义dialog、mvp的简单实例");
        newsModels.add(newsModel);

        NewsModel newsModel1 = new NewsModel();
        newsModel1.setNewsType(1);
        newsModel1.setTextContent("点击打开 -->>注解原理");
        newsModels.add(newsModel1);

        NewsModel newsModel2 = new NewsModel();
        newsModel2.setNewsType(1);
        newsModel2.setTextContent("点击 -->>打开日历选择器");
        newsModels.add(newsModel2);
        NewsModel newsModel3 = new NewsModel();
        newsModel3.setNewsType(1);
        newsModel3.setTextContent("点击 -->>自定义textView");
        newsModels.add(newsModel3);
    }

    /**
     * 造假数据
     */

    private void addDatas1(int index) {
        NewsModel newsModel = new NewsModel();
        newsModel.setNewsType(1);
        newsModel.setTextContent("1、点击 -->>跳转到 自定义dialog、mvp的简单实例"+index);
        newsModels2.add(newsModel);

        NewsModel newsModel1 = new NewsModel();
        newsModel1.setNewsType(2);
        newsModel1.setTextContent("2、点击打开 -->>注解原理"+index);
        newsModels2.add(newsModel1);

        NewsModel newsModel2 = new NewsModel();
        newsModel2.setNewsType(1);
        newsModel2.setTextContent("3、点击 -->>打开日历选择器"+index);
        newsModels2.add(newsModel2);
    }
}
