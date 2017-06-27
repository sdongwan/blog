package com.sdongwan.blog.bean;

import java.sql.Date;

/**
 * Created by Administrator on 2017/6/23.
 */
public class ArticleBean {
    private int articleId = -1;
    private int artTypeId = -1;
    private String articleName = null;
    private String article = null;//文章内容
    private Date articleTime = null;
    private int articleTop = -1;
    private int articleCount = -1;

    public ArticleBean() {
    }

    public ArticleBean(int articleId, int artTypeId, String articleName, String article, Date articleTime, int articleTop, int articleCount) {
        this.articleId = articleId;
        this.artTypeId = artTypeId;
        this.articleName = articleName;
        this.article = article;
        this.articleTime = articleTime;
        this.articleTop = articleTop;
        this.articleCount = articleCount;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getArtTypeId() {
        return artTypeId;
    }

    public void setArtTypeId(int artTypeId) {
        this.artTypeId = artTypeId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public Date getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Date articleTime) {
        this.articleTime = articleTime;
    }

    public int getArticleTop() {
        return articleTop;
    }

    public void setArticleTop(int articleTop) {
        this.articleTop = articleTop;
    }

    public int getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }

    @Override
    public String toString() {
        return "ArticleBean{" +
                "articleId=" + articleId +
                ", artTypeId=" + artTypeId +
                ", articleName='" + articleName + '\'' +
                ", article='" + article + '\'' +
                ", articleTime=" + articleTime +
                ", articleTop=" + articleTop +
                ", articleCount=" + articleCount +
                '}';
    }
}
