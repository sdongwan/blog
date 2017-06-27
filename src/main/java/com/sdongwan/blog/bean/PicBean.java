package com.sdongwan.blog.bean;

import java.sql.Date;

/**
 * Created by Administrator on 2017/6/23.
 */
public class PicBean {
    private int picId=-1;
    private int picTypeId=-1;
    private String picName=null;
    private String picPath=null;
    private Date picTime=null;
    private String picDes=null;
    private int picCount=-1;

    public PicBean() {
    }

    public PicBean(int picId, int picTypeId, String picName, String picPath, Date picTime, String picDes, int picCount) {
        this.picId = picId;
        this.picTypeId = picTypeId;
        this.picName = picName;
        this.picPath = picPath;
        this.picTime = picTime;
        this.picDes = picDes;
        this.picCount = picCount;
    }

    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }

    public int getPicTypeId() {
        return picTypeId;
    }

    public void setPicTypeId(int picTypeId) {
        this.picTypeId = picTypeId;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public Date getPicTime() {
        return picTime;
    }

    public void setPicTime(Date picTime) {
        this.picTime = picTime;
    }

    public String getPicDes() {
        return picDes;
    }

    public void setPicDes(String picDes) {
        this.picDes = picDes;
    }

    public int getPicCount() {
        return picCount;
    }

    public void setPicCount(int picCount) {
        this.picCount = picCount;
    }

    @Override
    public String toString() {
        return "PicBean{" +
                "picId=" + picId +
                ", picTypeId=" + picTypeId +
                ", picName='" + picName + '\'' +
                ", picPath='" + picPath + '\'' +
                ", picTime=" + picTime +
                ", picDes='" + picDes + '\'' +
                ", picCount=" + picCount +
                '}';
    }
}
