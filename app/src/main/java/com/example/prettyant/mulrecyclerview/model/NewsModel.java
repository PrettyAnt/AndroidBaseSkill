package com.example.prettyant.mulrecyclerview.model;

/**
 * @author ChenYu
 * Author's github https://github.com/PrettyAnt
 * <p>
 * Created on 5:04 PM  2020/5/26
 * PackageName : com.example.prettyant.mulrecyclerview.model
 * describle :
 */
public class NewsModel {
    /**
     * 0 富文本消息，文字图片，视频都有;
     * 1 只有文字
     * 2 只有文字和图片
     * 3 只有视频
     */
    private int newsType;
    private String textContent;//消息内容
    private String imgUrl;//图片链接
    private String videoUrl;//视频链接

    public int getNewsType() {
        return newsType;
    }

    public void setNewsType(int newsType) {
        this.newsType = newsType;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
