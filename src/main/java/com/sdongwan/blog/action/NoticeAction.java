package com.sdongwan.blog.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sdongwan.blog.bean.NoticeBean;
import com.sdongwan.blog.dao.NoticeDao;
import com.sdongwan.blog.dao.impl.NoticeDaoImpl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/25.
 */
public class NoticeAction extends ActionSupport {
    private NoticeDao noticeDao = new NoticeDaoImpl();
    private List<NoticeBean> noticeBeans;
    private NoticeBean noticeBean;
    private int noticeId;

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public List<NoticeBean> getNoticeBeans() {
        return noticeBeans;
    }

    public void setNoticeBeans(List<NoticeBean> noticeBeans) {
        this.noticeBeans = noticeBeans;
    }

    public NoticeBean getNoticeBean() {
        return noticeBean;
    }

    public void setNoticeBean(NoticeBean noticeBean) {
        this.noticeBean = noticeBean;
    }

    public String addNotice() throws SQLException, ClassNotFoundException {
        int result = -1;
        System.out.println("add " + noticeBean);

        noticeBean.setNoticeTime(new Date(System.currentTimeMillis()));
        result = noticeDao.insert(noticeBean);
        if (result > 0) {
            if (noticeBeans != null) {
                noticeBeans.add(noticeBean);
            } else {
                noticeBeans = new ArrayList<NoticeBean>();
                noticeBeans.add(noticeBean);
            }
            return SUCCESS;
        } else {
            return ERROR;
        }


//        NoticeBean noticeBean1 = noticeDao.selectByName(noticeBean.getNoticeName());
//        if (noticeBean1 != null) {
//            return ERROR;
//        } else {
//            int result = -1;
//            noticeBean.setNoticeTime(new Date(System.currentTimeMillis()));
//            result = noticeDao.insert(noticeBean);
//            if (result > 0) {
//                return SUCCESS;
//            } else {
//                return ERROR;
//            }
//        }
    }

    public String showNotice() throws SQLException, ClassNotFoundException {
        noticeBean = noticeDao.selectById(noticeId);

        if (noticeBean != null) {
            return SUCCESS;
        } else {
            return ERROR;
        }

    }

    public String updateNotice() throws SQLException, ClassNotFoundException {
        int result = -1;
        noticeBean.setNoticeTime(new Date(System.currentTimeMillis()));
        result = noticeDao.update(noticeBean);
        if (result > 0) {
            return SUCCESS;
        } else {
            return ERROR;
        }

//        int result = -1;
//        NoticeBean noticeBean1 = noticeDao.selectByName(noticeBean.getNoticeName());
//        if (noticeBean1 != null) {
//            if (noticeBean1.getNoticeId() != noticeBean.getNoticeId()) {
//                return ERROR;
//            }
//        }
//
//        noticeBean.setNoticeTime(new Date(System.currentTimeMillis()));
//        result = noticeDao.insert(noticeBean);
//        if (result > 0) {
//            return SUCCESS;
//        } else {
//            return ERROR;
//        }
    }

    public String showNotices() throws SQLException, ClassNotFoundException {
        noticeBeans = noticeDao.selectAll();
        if (noticeBeans != null) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }


    public String toUpNotice() throws SQLException, ClassNotFoundException {
        noticeBean = noticeDao.selectById(noticeId);
        if (noticeBean != null) {
            return SUCCESS;
        } else {
            return ERROR;
        }

    }

    public String deleteNotice() throws SQLException, ClassNotFoundException {
        int result = -1;
        result = noticeDao.del(noticeId);
        if (result > 0) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }


}
