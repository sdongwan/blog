package com.sdongwan.blog.bean;

/**
 * Created by Administrator on 2017/6/23.
 */
public class BlogAdminBean {
    private int adminId = 1;
    private String loginName = null;
    private String loginPwd = null;
    private String adminName = null;

    public BlogAdminBean() {
    }

    public BlogAdminBean(int adminId, String loginName, String loginPwd, String adminName) {
        this.adminId = adminId;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.adminName = adminName;
    }


    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    @Override
    public String toString() {
        return "BlogAdminBean{" +
                "adminId=" + adminId +
                ", loginName='" + loginName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", adminName='" + adminName + '\'' +
                '}';
    }
}
