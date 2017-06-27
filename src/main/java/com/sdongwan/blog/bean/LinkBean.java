package com.sdongwan.blog.bean;

/**
 * Created by Administrator on 2017/6/23.
 */
public class LinkBean {
    private int linkId=-1;
    private String linkUrl=null;
    private String linkName=null;

    public LinkBean() {
    }

    public LinkBean(int linkId, String linkUrl, String linkName) {
        this.linkId = linkId;
        this.linkUrl = linkUrl;
        this.linkName = linkName;
    }

    public int getLinkId() {
        return linkId;
    }

    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    @Override
    public String toString() {
        return "LinkBean{" +
                "linkId=" + linkId +
                ", linkUrl='" + linkUrl + '\'' +
                ", linkName='" + linkName + '\'' +
                '}';
    }
}
