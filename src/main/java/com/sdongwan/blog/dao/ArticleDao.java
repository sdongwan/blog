package com.sdongwan.blog.dao;

import com.sdongwan.blog.bean.ArticleBean;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
public interface ArticleDao {

    List<ArticleBean> selectAll() throws SQLException, ClassNotFoundException;

    List<ArticleBean> selectAll(int num) throws SQLException, ClassNotFoundException; //分页获取文章

    List<ArticleBean> selectByTypeId(int artTypeId) throws SQLException, ClassNotFoundException;

    List<ArticleBean> selectByNames(String name) throws SQLException, ClassNotFoundException;

    ArticleBean selectByName(String name) throws SQLException, ClassNotFoundException;

    ArticleBean selectById(int articleId) throws SQLException, ClassNotFoundException;

    List<ArticleBean> selectByTop(int articleTop) throws SQLException, ClassNotFoundException;

    List<ArticleBean> selectByCount() throws SQLException, ClassNotFoundException;//查询访问量前五的文章

    List<ArticleBean> selectByTime(Date articleTime) throws SQLException, ClassNotFoundException;

    int insert(ArticleBean articleBean) throws SQLException, ClassNotFoundException;

    int del(int articleId) throws SQLException, ClassNotFoundException;

    int update(ArticleBean articleBean) throws SQLException, ClassNotFoundException;

    int getCount(int artTypeId) throws SQLException, ClassNotFoundException;

    int getNum() throws SQLException, ClassNotFoundException;//获取文章数量

    List<ArticleBean> search(String articleName, int artTypeId, int articleTop) throws SQLException, ClassNotFoundException;
}
