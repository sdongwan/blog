package com.sdongwan.blog.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sdongwan.blog.bean.PicBean;
import com.sdongwan.blog.dao.PicDao;
import com.sdongwan.blog.dao.impl.PicDaoImpl;
import com.sdongwan.blog.util.MethodUtil;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Administrator on 2017/6/25.
 */
public class PicAction extends ActionSupport {
    private PicDao picDao = new PicDaoImpl();
    private List<PicBean> picBeans;
    private PicBean picBean;
    private File photo;
    private String photoFileName;
    private int picTypeId;
    private int picId;

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
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

    public List<PicBean> getPicBeans() {
        return picBeans;
    }

    public void setPicBeans(List<PicBean> picBeans) {
        this.picBeans = picBeans;
    }

    public PicBean getPicBean() {
        return picBean;
    }

    public void setPicBean(PicBean picBean) {
        this.picBean = picBean;
    }


    public String addPic() throws SQLException, ClassNotFoundException {
        String uploadPath = ServletActionContext.getServletContext().getRealPath("/upload");
        System.out.println("uploadPath" + uploadPath);
        String saveName = "";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmssSSS");
        String msg = simpleDateFormat.format(new Date(System.currentTimeMillis()));
        if (photo == null || photoFileName == null) {
            System.out.println("file=null----------------------");
            picBean.setPicName("default.jpg");
        } else {
            System.out.println("filename " + photoFileName);
            System.out.println("filesize " + photo.getName());

            String param = photoFileName.substring(photoFileName.lastIndexOf("."));
            saveName = msg + param;
            MethodUtil.upload(uploadPath, saveName, photo);
            picBean.setPicName(saveName);
        }
        picBean.setPicPath(uploadPath + saveName);
        picBean.setPicTime(new Date(System.currentTimeMillis()));
        picBean.setPicCount(0);
        int result = -1;
        result = picDao.insert(picBean);
        if (result > 0) {
            return SUCCESS;
        } else {
            return ERROR;
        }

    }

    public String showPic() throws SQLException, ClassNotFoundException {
        picBean = picDao.selectById(picId);
        if (picBean != null) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String showPics() throws SQLException, ClassNotFoundException {
        picBeans = picDao.selectAll();
        if (picBeans != null) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String showPicByType() throws SQLException, ClassNotFoundException {
        picBeans = picDao.selectByTypeId(picTypeId);
        if (picBeans != null) {
            return SUCCESS;
        } else {
            return ERROR;
        }

    }

    public String showPicById() throws SQLException, ClassNotFoundException {
        picBean = picDao.selectById(picTypeId);
        if (picBean != null) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String updatePic() throws SQLException, ClassNotFoundException {

        picBean.setPicTime(new Date(System.currentTimeMillis()));
        int result = picDao.update(picBean);
        if (result > 0) {
            return SUCCESS;
        } else {
            return ERROR;
        }

//        PicBean picBean1 = picDao.selectByName(picBean.getPicName());
//        if (picBean1 != null) {
//            if (picBean1.getPicId() != picBean.getPicId()) {
//                return ERROR;
//            }
//        }
//        picBean.setPicTime(new Date(System.currentTimeMillis()));
//        int result = picDao.update(picBean);
//        if (result > 0) {
//            return SUCCESS;
//        } else {
//            return ERROR;
//        }
    }

    public String addPicCount() throws SQLException, ClassNotFoundException {
        int count = picBean.getPicCount() + 1;
        int result = -1;
        picBean.setPicCount(count);
        result = picDao.update(picBean);

        if (result > 0) {
            return SUCCESS;
        } else {
            return ERROR;
        }

    }


    public String deletePic() throws SQLException, ClassNotFoundException {
        int result = -1;
        result = picDao.del(picId);
        if (result > 0) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }


}
