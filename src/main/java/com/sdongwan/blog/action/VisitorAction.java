package com.sdongwan.blog.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sdongwan.blog.bean.VisitorBean;
import com.sdongwan.blog.dao.VisitorDao;
import com.sdongwan.blog.dao.impl.VisitorDaoImpl;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/6/25.
 */
public class VisitorAction extends ActionSupport {
    private VisitorDao visitorDao = new VisitorDaoImpl();
    private List<VisitorBean> visitorBeans;
    private VisitorBean visitorBean;
    private int visitorId;


    public int getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(int visitorId) {
        this.visitorId = visitorId;
    }

    public List<VisitorBean> getVisitorBeans() {
        return visitorBeans;
    }

    public void setVisitorBeans(List<VisitorBean> visitorBeans) {
        this.visitorBeans = visitorBeans;
    }

    public VisitorBean getVisitorBean() {
        return visitorBean;
    }

    public void setVisitorBean(VisitorBean visitorBean) {
        this.visitorBean = visitorBean;
    }

    public String showVisitors() throws SQLException, ClassNotFoundException {
        visitorBeans = visitorDao.selectAll();
        System.out.println("visitorBeans " + visitorBeans);
        if (visitorBeans != null) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String showVisitorById() throws SQLException, ClassNotFoundException {
        visitorBean = visitorDao.selectById(visitorId);
        if (visitorBean != null) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String addVisitor() throws SQLException, ClassNotFoundException {
        int result = -1;
        result = visitorDao.insert(visitorBean);
        if (result > 0) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String updateVisitor() throws SQLException, ClassNotFoundException {
        int result = -1;
        result = visitorDao.update(visitorBean);
        if (result > 0) {
            return SUCCESS;
        } else {
            return ERROR;
        }

    }

    public String showVisitor() throws SQLException, ClassNotFoundException {
        visitorBean = visitorDao.selectById(visitorId);
        if (visitorBean != null) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String deleteVisitor() throws SQLException, ClassNotFoundException {
        int result = -1;
        result = visitorDao.del(visitorId);
        if (result > 0) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

}
