package com.sdongwan.blog.dao;

import com.sdongwan.blog.bean.ArticleTypeBean;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
public interface ArticleTypeDao {
    List<ArticleTypeBean> selectAll() throws SQLException, ClassNotFoundException;

    ArticleTypeBean selectById(int artTypeId) throws SQLException, ClassNotFoundException;

    ArticleTypeBean selectByName(String artTypeName) throws SQLException, ClassNotFoundException;

    int insert(ArticleTypeBean articleTypeBean) throws SQLException, ClassNotFoundException;

    int del(int artTypeId) throws SQLException, ClassNotFoundException;

    int update(ArticleTypeBean articleTypeBean) throws SQLException, ClassNotFoundException;
}
