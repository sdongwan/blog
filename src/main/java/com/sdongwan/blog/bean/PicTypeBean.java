package com.sdongwan.blog.bean;

/**
 * Created by Administrator on 2017/6/23.
 */
public class PicTypeBean {
    private int picTypeId = -1;
    private String picTypeName = null;

    public PicTypeBean() {
    }

    public PicTypeBean(int picTypeId, String picTypeName) {
        this.picTypeId = picTypeId;
        this.picTypeName = picTypeName;
    }

    public int getPicTypeId() {
        return picTypeId;
    }

    public void setPicTypeId(int picTypeId) {
        this.picTypeId = picTypeId;
    }

    public String getPicTypeName() {
        return picTypeName;
    }

    public void setPicTypeName(String picTypeName) {
        this.picTypeName = picTypeName;
    }

    @Override
    public String toString() {
        return "PicTypeBean{" +
                "picTypeId=" + picTypeId +
                ", picTypeName='" + picTypeName + '\'' +
                '}';
    }
}
