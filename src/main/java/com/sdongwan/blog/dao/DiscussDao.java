package com.sdongwan.blog.dao;

import com.sdongwan.blog.bean.DiscussBean;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
public interface DiscussDao {
    List<DiscussBean> selectAll() throws SQLException, ClassNotFoundException;

    DiscussBean selectById(int discussId) throws SQLException, ClassNotFoundException;

    List<DiscussBean> selectByArtId(int articleId) throws SQLException, ClassNotFoundException;

    List<DiscussBean> selectByVisitorId(int visitorId) throws SQLException, ClassNotFoundException;

    int insert(DiscussBean discussBean) throws SQLException, ClassNotFoundException;

    int update(DiscussBean discussBean) throws SQLException, ClassNotFoundException;

    int del(int discussId) throws SQLException, ClassNotFoundException;

    int getCount(int visitorId) throws SQLException, ClassNotFoundException;  //查询某人评论数

    int getArtCount(int articleId) throws SQLException, ClassNotFoundException;  //获取某个文章的评论数

}
