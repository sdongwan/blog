package com.sdongwan.blog.bean;

/**
 * Created by Administrator on 2017/6/23.
 */
public class DiscussBean {
    private int discussId = -1;
    private int articleId = -1;
    private int visitorId = -1;
    private String discuss = null;
    private String discussR = null;
    private String discussTime = null;
    private String discussTimeR = null;

    public DiscussBean() {
    }

    public DiscussBean(int discussId, int articleId, int visitorId, String discuss, String discussR, String discussTime, String discussTimeR) {
        this.discussId = discussId;
        this.articleId = articleId;
        this.visitorId = visitorId;
        this.discuss = discuss;
        this.discussR = discussR;
        this.discussTime = discussTime;
        this.discussTimeR = discussTimeR;
    }

    public int getDiscussId() {
        return discussId;
    }

    public void setDiscussId(int discussId) {
        this.discussId = discussId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(int visitorId) {
        this.visitorId = visitorId;
    }

    public String getDiscuss() {
        return discuss;
    }

    public void setDiscuss(String discuss) {
        this.discuss = discuss;
    }

    public String getDiscussR() {
        return discussR;
    }

    public void setDiscussR(String discussR) {
        this.discussR = discussR;
    }

    public String getDiscussTime() {
        return discussTime;
    }

    public void setDiscussTime(String discussTime) {
        this.discussTime = discussTime;
    }

    public String getDiscussTimeR() {
        return discussTimeR;
    }

    public void setDiscussTimeR(String discussTimeR) {
        this.discussTimeR = discussTimeR;
    }

    @Override
    public String toString() {
        return "DiscussBean{" +
                "discussId=" + discussId +
                ", articleId=" + articleId +
                ", visitorId=" + visitorId +
                ", discuss='" + discuss + '\'' +
                ", discussR='" + discussR + '\'' +
                ", discussTime='" + discussTime + '\'' +
                ", discussTimeR='" + discussTimeR + '\'' +
                '}';
    }
}
