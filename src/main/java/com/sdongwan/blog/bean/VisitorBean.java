package com.sdongwan.blog.bean;

/**
 * Created by Administrator on 2017/6/23.
 */
public class VisitorBean {
    private int visitorId=-1;
    private String visitorName=null;
    private String visitorIp=null;
    private String visitorEmail=null;

    public VisitorBean() {
    }

    public VisitorBean(int visitorId, String visitorName, String visitorIp, String visitorEmail) {
        this.visitorId = visitorId;
        this.visitorName = visitorName;
        this.visitorIp = visitorIp;
        this.visitorEmail = visitorEmail;
    }

    public int getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(int visitorId) {
        this.visitorId = visitorId;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getVisitorIp() {
        return visitorIp;
    }

    public void setVisitorIp(String visitorIp) {
        this.visitorIp = visitorIp;
    }

    public String getVisitorEmail() {
        return visitorEmail;
    }

    public void setVisitorEmail(String visitorEmail) {
        this.visitorEmail = visitorEmail;
    }

    @Override
    public String toString() {
        return "VisitorBean{" +
                "visitorId=" + visitorId +
                ", visitorName='" + visitorName + '\'' +
                ", visitorIp='" + visitorIp + '\'' +
                ", visitorEmail='" + visitorEmail + '\'' +
                '}';
    }
}
