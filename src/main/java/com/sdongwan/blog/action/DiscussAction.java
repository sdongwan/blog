package com.sdongwan.blog.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sdongwan.blog.bean.DiscussBean;
import com.sdongwan.blog.bean.VisitorBean;
import com.sdongwan.blog.dao.DiscussDao;
import com.sdongwan.blog.dao.VisitorDao;
import com.sdongwan.blog.dao.impl.DiscussDaoImpl;
import com.sdongwan.blog.dao.impl.VisitorDaoImpl;
import com.sdongwan.blog.util.MethodUtil;

import java.sql.SQLException;

/**
 * Created by Administrator on 2017/6/25.
 */
public class DiscussAction extends ActionSupport {
    private DiscussDao discussDao = new DiscussDaoImpl();
    private VisitorDao visitorDao = new VisitorDaoImpl();
    private DiscussBean discussBean;
    private VisitorBean visitorBean;
    private int discussId;


    public int getDiscussId() {
        return discussId;
    }

    public void setDiscussId(int discussId) {
        this.discussId = discussId;
    }

    public VisitorBean getVisitorBean() {
        return visitorBean;
    }

    public void setVisitorBean(VisitorBean visitorBean) {
        this.visitorBean = visitorBean;
    }


    public DiscussBean getDiscussBean() {
        return discussBean;
    }

    public void setDiscussBean(DiscussBean discussBean) {
        this.discussBean = discussBean;
    }

    public String addDiscuss() {









        return null;
    }


    public String deleteDiscuss() throws SQLException, ClassNotFoundException {
        int result = -1;
        result = discussDao.del(discussId);
        if (result > 0) {
            return SUCCESS;
        } else {
            return ERROR;
        }

    }

    public String updateDiscuss() throws SQLException, ClassNotFoundException {
        discussBean.setDiscussTime(MethodUtil.getDate());
        int result = -1;
        result = discussDao.update(discussBean);
        if (result > 0) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }


    public String showDiscuss() {

        return SUCCESS;
    }

    public String listDiscuss() {
        return SUCCESS;
    }


}
