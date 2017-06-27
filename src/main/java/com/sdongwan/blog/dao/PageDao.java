package com.sdongwan.blog.dao;

import com.sdongwan.blog.bean.ArticleBean;
import com.sdongwan.blog.bean.Page;
import com.sdongwan.blog.bean.PicBean;

import java.sql.SQLException;

/**
 * Created by Administrator on 2017/6/23.
 */
public interface PageDao {
    Page<ArticleBean> getArticle(int num) throws SQLException, ClassNotFoundException;

    Page<PicBean> getPic(int num) throws SQLException, ClassNotFoundException;
}
