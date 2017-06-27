package com.sdongwan.blog.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sdongwan.blog.bean.ArticleBean;
import com.sdongwan.blog.dao.ArticleDao;
import com.sdongwan.blog.dao.impl.ArticleDaoImpl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/6/25.
 */
public class ArticleAction extends ActionSupport {
    private ArticleBean articleBean;
    private ArticleDao articleDao = new ArticleDaoImpl();
    private int articleId;
    private int count;
    private int articleTypeId;
    private List<ArticleBean> articleBeans;


    public int getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(int articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    public List<ArticleBean> getArticleBeans() {
        return articleBeans;
    }

    public void setArticleBeans(List<ArticleBean> articleBeans) {
        this.articleBeans = articleBeans;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public ArticleBean getArticleBean() {
        return articleBean;
    }

    public void setArticleBean(ArticleBean articleBean) {
        this.articleBean = articleBean;
    }


    public String showArticle() throws SQLException, ClassNotFoundException {
        articleBean = articleDao.selectById(articleId);
        if (articleBean == null) {
            return ERROR;
        } else {
            count = articleBean.getArticleCount();
            count++;
            articleBean.setArticleCount(count);
            articleDao.update(articleBean);
            return SUCCESS;
        }
    }

    public String showArticleByType() throws SQLException, ClassNotFoundException {
        articleBeans = articleDao.selectByTypeId(articleTypeId);
        if (articleBeans != null && articleBeans.size() > 0) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String showAllArticles() throws SQLException, ClassNotFoundException {
        articleBeans = articleDao.selectAll();
        if (articleBeans != null && articleBeans.size() > 0) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String addArticle() throws SQLException, ClassNotFoundException {
        System.out.println("addArticle " + articleBean);


        articleBean.setArticleCount(0);
        articleBean.setArticleTime(new Date(System.currentTimeMillis()));
        int result = articleDao.insert(articleBean);
        if (result > 0) {
            return SUCCESS;
        } else {
            return ERROR;
        }

//        ArticleBean articleBean1 = articleDao.selectByName(articleBean.getArticleName());
//        if (articleBean1 != null) {
//            return ERROR;
//        } else {
//            articleBean1.setArticleCount(0);
//            articleBean1.setArticleTime(new Date(System.currentTimeMillis()));
//            int result = articleDao.insert(articleBean1);
//            if (result > 0) {
//                return SUCCESS;
//            } else {
//                return ERROR;
//            }
//        }

    }

    public String updateArticle() throws SQLException, ClassNotFoundException {
        int result = -1;
        articleBean.setArticleTime(new Date(System.currentTimeMillis()));
        result = articleDao.update(articleBean);
        if (result > 0) {
            return SUCCESS;
        } else {
            return ERROR;
        }

//        int result = -1;
//        ArticleBean articleBean1 = articleDao.selectByName(articleBean.getArticleName());
//        if (articleBean1 != null) {
//            if (articleBean1.getArticleId() != articleBean.getArticleId()) {
//                return ERROR;
//            }
//        }
//
//        articleBean.setArticleTime(new Date(System.currentTimeMillis()));
//        result = articleDao.update(articleBean);
//        if (result > 0) {
//            return SUCCESS;
//        } else {
//            return ERROR;
//        }

    }

    public String deleteArticle() throws SQLException, ClassNotFoundException {
        int result = -1;
        System.out.println("delart "+articleId);
        result = articleDao.del(articleId);
        if (result > 0) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String searchArticle() throws SQLException, ClassNotFoundException {
        articleBeans = articleDao.search(articleBean.getArticleName(), articleBean.getArtTypeId(), articleBean.getArticleTop());
        if (articleBeans != null && articleBeans.size() > 0) {
            return SUCCESS;
        } else {
            return ERROR;
        }

    }


}
