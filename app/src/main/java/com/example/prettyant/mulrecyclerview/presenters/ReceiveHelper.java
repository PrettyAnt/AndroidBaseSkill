package com.example.prettyant.mulrecyclerview.presenters;

import com.example.prettyant.mulrecyclerview.model.NewsModel;
import com.example.prettyant.mulrecyclerview.presenters.iview.OnLoadImp;

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
    private        ArrayList<NewsModel> currentModels = new ArrayList<>();
    public static final int DEFAULT_SIZA = 16;


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
        onLoad.onReceive(currentModels);
    }

    /**
     * 造数据
     */
    private void initData(int index) {
        if (index == 0) {
            currentModels.clear();
            getCurrentMulDatas();
        } else {
            /**
             * 为了保证拉取的数据在最上面，先倒叙，再插入，最后再倒叙
             */
            Collections.reverse(currentModels);
            historyModels.clear();
            addHistoryModels(index);
            Collections.reverse(historyModels);
            currentModels.addAll(historyModels);
            Collections.reverse(currentModels);
        }
    }


    /**
     * 最新的消息
     * <p>
     * 0--富文本
     * 1--只有文字
     * 2--文字和图片
     * 3--只有图片
     * 4--只有视频
     */
    private void getCurrentMulDatas() {
        NewsModel newsModela = new NewsModel();
        newsModela.setNewsType(1);
        newsModela.setTextSize(DEFAULT_SIZA);
        newsModela.setTextContent("自定义dialog、mvp的简单实例");
        currentModels.add(newsModela);

        NewsModel newsModelb = new NewsModel();
        newsModelb.setNewsType(1);
        newsModelb.setTextSize(DEFAULT_SIZA);
        newsModelb.setTextContent("注解原理");
        currentModels.add(newsModelb);

        NewsModel newsModelc = new NewsModel();
        newsModelc.setNewsType(1);
        newsModelc.setTextSize(DEFAULT_SIZA);
        newsModelc.setTextContent("日历选择器");
        currentModels.add(newsModelc);
        NewsModel newsModeld = new NewsModel();
        newsModeld.setNewsType(1);
        newsModeld.setTextSize(DEFAULT_SIZA);
        newsModeld.setTextContent("自定义textView");
        currentModels.add(newsModeld);
        NewsModel newsModele = new NewsModel();
        newsModele.setNewsType(1);
        newsModele.setTextSize(DEFAULT_SIZA);
        newsModele.setTextContent("音视频");
        currentModels.add(newsModele);


        for (int i = 0; i < 10; i++) {
            switch (i % 5) {
                case 0:
                    NewsModel newsModel = new NewsModel();
                    newsModel.setNewsType(0);//富文本消息，文字、图片、视频都有
                    newsModel.setTextSize(12);
                    newsModel.setTextContent("这是富文本消息，你想要的内容这里都有");
                    newsModel.setImgUrl("http://prettyant.com/images/wife/lp_a.png");
                    newsModel.setVideoUrl("这是视频模块");
                    currentModels.add(newsModel);
                    break;
                case 1:
                    NewsModel newsModel1 = new NewsModel();
                    newsModel1.setNewsType(1);//只有文字
                    newsModel1.setTextSize(12);
                    newsModel1.setTextContent("这是单纯的文字消息，纯文字纯文字纯文字纯文字纯文字");
                    currentModels.add(newsModel1);
                    break;
                case 2:
                    NewsModel newsModel2 = new NewsModel();
                    newsModel2.setNewsType(2);//文字和图片
                    newsModel2.setTextSize(12);
                    newsModel2.setTextContent("文字和图片 文字和图片 文字和图片 文字和图片");
                    newsModel2.setImgUrl("http://prettyant.com/images/wife/a.png");
                    currentModels.add(newsModel2);
                    break;
                case 3:
                    NewsModel newsModel3 = new NewsModel();
                    newsModel3.setNewsType(3);//单纯的图片消息
                    newsModel3.setTextSize(12);
                    newsModel3.setImgUrl("http://prettyant.com/images/wife/a.png");
                    currentModels.add(newsModel3);
                    break;
                case 4:
                    NewsModel newsModel4 = new NewsModel();
                    newsModel4.setNewsType(4);//单纯的图片消息
                    newsModel4.setTextSize(12);
                    newsModel4.setVideoUrl("这是视频模块");
                    currentModels.add(newsModel4);
                    break;
                default:
                    NewsModel newsModel5 = new NewsModel();
                    newsModel5.setNewsType(1);//富文本消息，文字、图片、视频都有
                    newsModel5.setTextSize(12);
                    newsModel5.setTextContent("这是单纯的文字消息，纯文字纯文字纯文字纯文字纯文字 ");
                    currentModels.add(newsModel5);
                    break;
            }
        }
    }

    private ArrayList<NewsModel> historyModels = new ArrayList<>();

    /**
     * 历史消息
     */

    private void addHistoryModels(int index) {
        NewsModel newsModel = new NewsModel();
        newsModel.setNewsType(1);
        newsModel.setTextSize(12);
        newsModel.setTextContent("1、自定义dialog、mvp的简单实例" + index);
        historyModels.add(newsModel);

        NewsModel newsModel1 = new NewsModel();
        newsModel1.setNewsType(2);
        newsModel1.setTextSize(12);
        newsModel1.setTextContent("2、注解原理" + index);
        historyModels.add(newsModel1);

        NewsModel newsModel2 = new NewsModel();
        newsModel2.setNewsType(1);
        newsModel2.setTextSize(12);
        newsModel2.setTextContent("3、打开日历选择器" + index);
        historyModels.add(newsModel2);
    }
}
