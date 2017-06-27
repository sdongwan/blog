package com.sdongwan.blog.dao;

import com.sdongwan.blog.bean.NoticeBean;

import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
public interface NoticeDao {
    List<NoticeBean> selectAll() throws SQLException, ClassNotFoundException;

    NoticeBean selectById(int noticeId) throws SQLException, ClassNotFoundException;

    NoticeBean selectByName(String noticeName) throws SQLException, ClassNotFoundException;

    NoticeBean selectNew() throws SQLException, ClassNotFoundException;

    List<NoticeBean> selectByTime(Date noticeTime) throws SQLException, ClassNotFoundException;//根据欢迎度查询

    int insert(NoticeBean noticeBean) throws SQLException, ClassNotFoundException;

    int del(int noticeId) throws SQLException, ClassNotFoundException;

    int update(NoticeBean noticeBean) throws SQLException, ClassNotFoundException;


}
