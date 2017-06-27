package com.sdongwan.blog.bean;

/**
 * Created by Administrator on 2017/6/23.
 */
public class ArticleTypeBean {
    private int artTypeId=-1;
    private String artTypeName=null;

    public ArticleTypeBean() {
    }

    public ArticleTypeBean(int artTypeId, String artTypeName) {
        this.artTypeId = artTypeId;
        this.artTypeName = artTypeName;
    }

    public int getArtTypeId() {
        return artTypeId;
    }

    public void setArtTypeId(int artTypeId) {
        this.artTypeId = artTypeId;
    }

    public String getArtTypeName() {
        return artTypeName;
    }

    public void setArtTypeName(String artTypeName) {
        this.artTypeName = artTypeName;
    }

    @Override
    public String toString() {
        return "ArticleTypeBean{" +
                "artTypeId=" + artTypeId +
                ", artTypeName='" + artTypeName + '\'' +
                '}';
    }
}
