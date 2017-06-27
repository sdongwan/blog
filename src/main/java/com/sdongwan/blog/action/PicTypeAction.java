package com.sdongwan.blog.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sdongwan.blog.bean.PicTypeBean;
import com.sdongwan.blog.dao.PicTypeDao;
import com.sdongwan.blog.dao.impl.PicTypeDaoImpl;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/6/25.
 */
public class PicTypeAction extends ActionSupport {
    private PicTypeDao picTypeDao = new PicTypeDaoImpl();
    private List<PicTypeBean> picTypeBeans;
    private PicTypeBean picTypeBean = null;
    private int picTypeId;

    public int getPicTypeId() {
        return picTypeId;
    }

    public void setPicTypeId(int picTypeId) {
        this.picTypeId = picTypeId;
    }

    public List<PicTypeBean> getPicTypeBeans() {
        return picTypeBeans;
    }

    public void setPicTypeBeans(List<PicTypeBean> picTypeBeans) {
        this.picTypeBeans = picTypeBeans;
    }

    public PicTypeBean getPicTypeBean() {
        return picTypeBean;
    }

    public void setPicTypeBean(PicTypeBean picTypeBean) {
        this.picTypeBean = picTypeBean;
    }

    public String showPicTypes() throws SQLException, ClassNotFoundException {
        picTypeBeans = picTypeDao.selectAll();
        if (picTypeBeans != null) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }


    public String updatePicType() throws SQLException, ClassNotFoundException {
        int result = -1;
        result = picTypeDao.update(picTypeBean);

        if (result > 0) {
            return SUCCESS;
        } else {
            return ERROR;
        }

//        int result = -1;
//        PicTypeBean picTypeBean1 = picTypeDao.selectByName(picTypeBean.getPicTypeName());
//        if (picTypeBean != null) {
//            if (picTypeBean1.getPicTypeId() != picTypeBean.getPicTypeId()) {
//                return ERROR;
//            }
//        }
//        result = picTypeDao.update(picTypeBean);
//
//        if (result > 0) {
//            return SUCCESS;
//        } else {
//            return ERROR;
//        }

    }

    public String addPicType() throws SQLException, ClassNotFoundException {
        int result = -1;

        result = picTypeDao.insert(picTypeBean);
        if (result > 0) {
            return SUCCESS;
        } else {
            return ERROR;
        }


//        PicTypeBean picTypeBean1 = picTypeDao.selectByName(picTypeBean.getPicTypeName());
//        if (picTypeBean1 != null) {
//            return ERROR;
//        }
//        result = picTypeDao.insert(picTypeBean);
//        if (result > 0) {
//            return SUCCESS;
//        } else {
//            return ERROR;
//        }

    }

    public String showPicType() throws SQLException, ClassNotFoundException {

        picTypeBean = picTypeDao.selectById(picTypeId);
        if (picTypeBean != null) {
            return SUCCESS;
        } else {
            return ERROR;
        }

    }

    public String deletePicType() throws SQLException, ClassNotFoundException {
        int result = -1;
        result = picTypeDao.del(picTypeId);
        if (result > 0) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }


}
