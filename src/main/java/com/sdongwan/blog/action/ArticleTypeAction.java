package com.sdongwan.blog.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sdongwan.blog.bean.ArticleTypeBean;
import com.sdongwan.blog.dao.ArticleTypeDao;
import com.sdongwan.blog.dao.impl.ArticleTypeDaoImpl;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/6/25.
 */
public class ArticleTypeAction extends ActionSupport {
    private ArticleTypeDao articleTypeDao = new ArticleTypeDaoImpl();
    private ArticleTypeBean articleTypeBean;
    private int articleTypeId;
    private List<ArticleTypeBean> articleTypeBeans;

    public int getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(int articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    public ArticleTypeBean getArticleTypeBean() {
        return articleTypeBean;
    }

    public void setArticleTypeBean(ArticleTypeBean articleTypeBean) {
        this.articleTypeBean = articleTypeBean;
    }

    public List<ArticleTypeBean> getArticleTypeBeans() {
        return articleTypeBeans;
    }

    public void setArticleTypeBeans(List<ArticleTypeBean> articleTypeBeans) {
        this.articleTypeBeans = articleTypeBeans;
    }

    public String showArticleTypes() throws SQLException, ClassNotFoundException {
        articleTypeBeans = articleTypeDao.selectAll();
        if (articleTypeBeans != null && articleTypeBeans.size() > 0) {
            System.out.println("success " + articleTypeBeans);
            return SUCCESS;
        } else {
            System.out.println("Error");
            return ERROR;
        }
    }

    public String addAticleType() throws SQLException, ClassNotFoundException {
        int result = -1;
        ArticleTypeBean articleTypeBean1 = articleTypeDao.selectByName(articleTypeBean.getArtTypeName());
        if (articleTypeBean1 != null) {
            return ERROR;
        } else {
            result = articleTypeDao.insert(articleTypeBean);
            if (result > 0) {
                return SUCCESS;
            } else {
                return ERROR;
            }
        }

    }


    public String updateAtricleType() throws SQLException, ClassNotFoundException {
        System.out.println("updateArticleType" + articleTypeBean);
        int result = -1;
        result = articleTypeDao.update(articleTypeBean);
        if (result > 0) {
            return SUCCESS;
        } else {
            return ERROR;
        }


//        ArticleTypeBean articleTypeBean1 = articleTypeDao.selectByName(articleTypeBean.getArtTypeName());
//        if (articleTypeBean1 != null) {
//            return ERROR;
//        } else {
//            int result = -1;
//            result = articleTypeDao.update(articleTypeBean);
//            if (result > 0) {
//                return SUCCESS;
//            } else {
//                return ERROR;
//            }
//        }
    }


    public String deleteArticleType() throws SQLException, ClassNotFoundException {
        int result = -1;
        result = articleTypeDao.del(articleTypeId);
        if (result > 0) {
            return SUCCESS;
        } else {
            return ERROR;
        }

    }


}
