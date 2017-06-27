package com.sdongwan.blog.dao.impl;

import com.sdongwan.blog.bean.ArticleBean;
import com.sdongwan.blog.bean.Page;
import com.sdongwan.blog.bean.PicBean;
import com.sdongwan.blog.dao.ArticleDao;
import com.sdongwan.blog.dao.PageDao;
import com.sdongwan.blog.dao.PicDao;

import java.sql.SQLException;

/**
 * Created by Administrator on 2017/6/23.
 */
public class PageDaoImpl<T> implements PageDao {


    public Page<ArticleBean> getArticle(int num) throws SQLException, ClassNotFoundException {
        Page<ArticleBean> articleBeanPage = new Page<ArticleBean>();
        ArticleDao articleDao = new ArticleDaoImpl();
        int count = articleDao.getNum();
        articleBeanPage.setDataCount(articleDao.getNum());
        articleBeanPage.setPageData(articleDao.selectAll());
        if (count % 5 == 0) {
            articleBeanPage.setPageMax(count % 5);
        } else {
            articleBeanPage.setPageMax(count % 5 + 1);
        }
        articleBeanPage.setPageIndex(num);

        if (articleBeanPage.getPageIndex() > 0) {
            if (articleBeanPage.getPageIndex() < articleBeanPage.getPageMax()) {
                articleBeanPage.setPageCount(5);
            } else if (articleBeanPage.getPageIndex() == articleBeanPage.getPageMax()) {
                articleBeanPage.setPageCount(count % 5);
            } else {
                articleBeanPage.setPageCount(0);
            }
        } else {
            articleBeanPage.setPageCount(0);
        }


        return articleBeanPage;
    }

    public Page<PicBean> getPic(int num) throws SQLException, ClassNotFoundException {
        Page<PicBean> picBeanPage = new Page<PicBean>();
        PicDao picDao = new PicDaoImpl();
        int count = picDao.getNum();
        picBeanPage.setDataCount(picDao.getNum());
        picBeanPage.setPageData(picDao.selectAll());
        if (count % 5 == 0) {
            picBeanPage.setPageMax(count % 5);
        } else {
            picBeanPage.setPageMax(count % 5 + 1);
        }
        picBeanPage.setPageIndex(num);

        if (picBeanPage.getPageIndex() > 0) {
            if (picBeanPage.getPageIndex() < picBeanPage.getPageMax()) {
                picBeanPage.setPageCount(5);
            } else if (picBeanPage.getPageIndex() == picBeanPage.getPageMax()) {
                picBeanPage.setPageCount(count % 5);
            } else {
                picBeanPage.setPageCount(0);
            }
        } else {
            picBeanPage.setPageCount(0);
        }


        return picBeanPage;
    }
}
