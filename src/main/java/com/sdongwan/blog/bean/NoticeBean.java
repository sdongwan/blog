package com.sdongwan.blog.bean;

import java.sql.Date;

/**
 * Created by Administrator on 2017/6/23.
 */
public class NoticeBean {
    private int noticeId=-1;
    private String notice=null;
    private String noticeName=null;
    private Date noticeTime=null;

    public NoticeBean() {
    }

    public NoticeBean(int noticeId, String notice, String noticeName, Date noticeTime) {
        this.noticeId = noticeId;
        this.notice = notice;
        this.noticeName = noticeName;
        this.noticeTime = noticeTime;
    }

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }

    public Date getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(Date noticeTime) {
        this.noticeTime = noticeTime;
    }

    @Override
    public String toString() {
        return "NoticeBean{" +
                "noticeId=" + noticeId +
                ", notice='" + notice + '\'' +
                ", noticeName='" + noticeName + '\'' +
                ", noticeTime=" + noticeTime +
                '}';
    }
}
