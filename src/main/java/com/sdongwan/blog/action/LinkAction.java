package com.sdongwan.blog.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sdongwan.blog.bean.LinkBean;
import com.sdongwan.blog.dao.LinkDao;
import com.sdongwan.blog.dao.impl.LinkDaoImpl;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/6/25.
 */
public class LinkAction extends ActionSupport {
    private LinkDao linkDao = new LinkDaoImpl();
    private LinkBean linkBean;
    private List<LinkBean> linkBeans;
    private int linkId;

    public List<LinkBean> getLinkBeans() {
        return linkBeans;
    }

    public void setLinkBeans(List<LinkBean> linkBeans) {
        this.linkBeans = linkBeans;
    }

    public int getLinkId() {
        return linkId;
    }

    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }

    public LinkBean getLinkBean() {
        return linkBean;
    }

    public void setLinkBean(LinkBean linkBean) {
        this.linkBean = linkBean;
    }

    public String addLink() throws SQLException, ClassNotFoundException {
        int result = -1;
        result = linkDao.insert(linkBean);
        if (result > 0) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String deleteLink() throws SQLException, ClassNotFoundException {
        int result = -1;
        result = linkDao.del(linkId);
        if (result > 0) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String updateLink() throws SQLException, ClassNotFoundException {
        int result = -1;
        result = linkDao.update(linkBean);
        if (result > 0) {
            return SUCCESS;
        } else {
            return ERROR;
        }

    }

    public String showLink() throws SQLException, ClassNotFoundException {
        int result = -1;
        linkBean = linkDao.selectById(linkId);
        if (linkBean != null) {
            return SUCCESS;
        } else {
            return ERROR;
        }

    }

    public String showLinks() throws SQLException, ClassNotFoundException {
        linkBeans = linkDao.showLink();
        if (linkBeans != null) {
            return SUCCESS;
        } else {
            return ERROR;
        }

    }

}


