package com.sdongwan.blog.dao.impl;

import com.sdongwan.blog.bean.ArticleBean;
import com.sdongwan.blog.dao.ArticleDao;
import com.sdongwan.blog.util.DBFactoryUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
public class ArticleDaoImpl implements ArticleDao {
    private Connection connection = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;
    private List<ArticleBean> articleBeans = null;
    private ArticleBean articleBean = null;

    public List<ArticleBean> selectAll() throws SQLException, ClassNotFoundException {
        String sql = "select articleId,artTypeId,articleName,article,articleTime,articleTop,articleCount" +
                " from article order by articleTop desc, articleTime desc ";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        articleBeans = new ArrayList<ArticleBean>();
        while (resultSet.next()) {
            articleBean = new ArticleBean();
            articleBean.setArticleId(resultSet.getInt(1));
            articleBean.setArtTypeId(resultSet.getInt(2));
            articleBean.setArticleName(resultSet.getString(3));
            articleBean.setArticle(resultSet.getString(4));
            articleBean.setArticleTime(resultSet.getDate(5));
            articleBean.setArticleTop(resultSet.getInt(6));
            articleBean.setArticleCount(resultSet.getInt(7));
            articleBeans.add(articleBean);
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return articleBeans;
    }

    public List<ArticleBean> selectAll(int num) throws SQLException, ClassNotFoundException {
        String sql = "select articleId,artTypeId,articleName,article,articleTime,articleTop,articleCount" +
                " from article order by articleTop desc, articleTime desc limit ?,?";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, (num - 1) * num);
        preparedStatement.setInt(2, 5);

        resultSet = preparedStatement.executeQuery();
        articleBeans = new ArrayList<ArticleBean>();
        while (resultSet.next()) {
            articleBean = new ArticleBean();
            articleBean.setArticleId(resultSet.getInt(1));
            articleBean.setArtTypeId(resultSet.getInt(2));
            articleBean.setArticleName(resultSet.getString(3));
            articleBean.setArticle(resultSet.getString(4));
            articleBean.setArticleTime(resultSet.getDate(5));
            articleBean.setArticleTop(resultSet.getInt(6));
            articleBean.setArticleCount(resultSet.getInt(7));
            articleBeans.add(articleBean);
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return articleBeans;
    }

    public List<ArticleBean> selectByTypeId(int artTypeId) throws SQLException, ClassNotFoundException {
        String sql = "select articleId,artTypeId,articleName,article,articleTime,articleTop,articleCount" +
                " from article where artTypeId=? order by articleTop desc, articleTime desc  ";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, artTypeId);

        resultSet = preparedStatement.executeQuery();
        articleBeans = new ArrayList<ArticleBean>();
        while (resultSet.next()) {
            articleBean = new ArticleBean();
            articleBean.setArticleId(resultSet.getInt(1));
            articleBean.setArtTypeId(resultSet.getInt(2));
            articleBean.setArticleName(resultSet.getString(3));
            articleBean.setArticle(resultSet.getString(4));
            articleBean.setArticleTime(resultSet.getDate(5));
            articleBean.setArticleTop(resultSet.getInt(6));
            articleBean.setArticleCount(resultSet.getInt(7));
            articleBeans.add(articleBean);
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return articleBeans;
    }

    public List<ArticleBean> selectByNames(String name) throws SQLException, ClassNotFoundException {
        String sql = "select articleId,artTypeId,articleName,article,articleTime,articleTop,articleCount from " +
                "article where articleName like ? order by articleTop desc ,articleTime desc ";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "'%" + name + "%'");
        resultSet = preparedStatement.executeQuery();
        articleBeans = new ArrayList<ArticleBean>();

        while (resultSet.next()) {
            articleBean = new ArticleBean();
            articleBean.setArticleId(resultSet.getInt(1));
            articleBean.setArtTypeId(resultSet.getInt(2));
            articleBean.setArticleName(resultSet.getString(3));
            articleBean.setArticle(resultSet.getString(4));
            articleBean.setArticleTime(resultSet.getDate(5));
            articleBean.setArticleTop(resultSet.getInt(6));
            articleBean.setArticleCount(resultSet.getInt(7));
            articleBeans.add(articleBean);
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);
        return articleBeans;
    }

    public ArticleBean selectByName(String name) throws SQLException, ClassNotFoundException {
        String sql = "select articleId,artTypeId,articleName,article,articleTime,articleTop,articleCount from " +
                "article where articleName = ? order by articleTop desc ,articleTime desc ";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            articleBean = new ArticleBean();
            articleBean.setArticleId(resultSet.getInt(1));
            articleBean.setArtTypeId(resultSet.getInt(2));
            articleBean.setArticleName(resultSet.getString(3));
            articleBean.setArticle(resultSet.getString(4));
            articleBean.setArticleTime(resultSet.getDate(5));
            articleBean.setArticleTop(resultSet.getInt(6));
            articleBean.setArticleCount(resultSet.getInt(7));
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return articleBean;

    }


    public ArticleBean selectById(int articleId) throws SQLException, ClassNotFoundException {


        String sql = "select articleId,artTypeId,articleName,article,articleTime,articleTop,articleCount from " +
                "article where articleId = ? order by articleTop desc ,articleTime desc ";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, articleId);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            articleBean = new ArticleBean();
            articleBean.setArticleId(resultSet.getInt(1));
            articleBean.setArtTypeId(resultSet.getInt(2));
            articleBean.setArticleName(resultSet.getString(3));
            articleBean.setArticle(resultSet.getString(4));
            articleBean.setArticleTime(resultSet.getDate(5));
            articleBean.setArticleTop(resultSet.getInt(6));
            articleBean.setArticleCount(resultSet.getInt(7));
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return articleBean;
    }


    public List<ArticleBean> selectByTop(int articleTop) throws SQLException, ClassNotFoundException {
        String sql = "select articleId,artTypeId,articleName,article,articleTime,articleTop,articleCount from " +
                "article where articleTop = ? order by articleTop desc ,articleTime desc ";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, articleTop);
        resultSet = preparedStatement.executeQuery();
        articleBeans = new ArrayList<ArticleBean>();

        while (resultSet.next()) {
            articleBean = new ArticleBean();
            articleBean.setArticleId(resultSet.getInt(1));
            articleBean.setArtTypeId(resultSet.getInt(2));
            articleBean.setArticleName(resultSet.getString(3));
            articleBean.setArticle(resultSet.getString(4));
            articleBean.setArticleTime(resultSet.getDate(5));
            articleBean.setArticleTop(resultSet.getInt(6));
            articleBean.setArticleCount(resultSet.getInt(7));
            articleBeans.add(articleBean);
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);
        return articleBeans;

    }


    public List<ArticleBean> selectByCount() throws SQLException, ClassNotFoundException {
        String sql = "select articleId,artTypeId,articleName,article,articleTime,articleTop,articleCount from " +
                "article  order by articleCount desc   limit 0,5";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        articleBeans = new ArrayList<ArticleBean>();

        while (resultSet.next()) {
            articleBean = new ArticleBean();
            articleBean.setArticleId(resultSet.getInt(1));
            articleBean.setArtTypeId(resultSet.getInt(2));
            articleBean.setArticleName(resultSet.getString(3));
            articleBean.setArticle(resultSet.getString(4));
            articleBean.setArticleTime(resultSet.getDate(5));
            articleBean.setArticleTop(resultSet.getInt(6));
            articleBean.setArticleCount(resultSet.getInt(7));
            articleBeans.add(articleBean);
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);
        return articleBeans;

    }

    public List<ArticleBean> selectByTime(Date articleTime) throws SQLException, ClassNotFoundException {
        String sql = "select articleId,artTypeId,articleName,article,articleTime,articleTop,articleCount from " +
                "article where articleTime = ? order by articleTop desc ,articleTime desc ";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDate(1, articleTime);
        resultSet = preparedStatement.executeQuery();
        articleBeans = new ArrayList<ArticleBean>();

        while (resultSet.next()) {
            articleBean = new ArticleBean();
            articleBean.setArticleId(resultSet.getInt(1));
            articleBean.setArtTypeId(resultSet.getInt(2));
            articleBean.setArticleName(resultSet.getString(3));
            articleBean.setArticle(resultSet.getString(4));
            articleBean.setArticleTime(resultSet.getDate(5));
            articleBean.setArticleTop(resultSet.getInt(6));
            articleBean.setArticleCount(resultSet.getInt(7));
            articleBeans.add(articleBean);
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);
        return articleBeans;

    }

    public int insert(ArticleBean articleBean) throws SQLException, ClassNotFoundException {
        String sql = "INSERT  INTO  article(articleId,artTypeId,articleName,article,articleTime," +
                "articleTop,articleCount) VALUES (NULL,?,?,?,?,?,?)";

        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, articleBean.getArtTypeId());
        preparedStatement.setString(2, articleBean.getArticleName());
        preparedStatement.setString(3, articleBean.getArticle());
        preparedStatement.setDate(4, articleBean.getArticleTime());
        preparedStatement.setInt(5, articleBean.getArticleTop());
        preparedStatement.setInt(6, articleBean.getArticleCount());

        int result = preparedStatement.executeUpdate();
        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);
        return result;
    }

    public int del(int articleId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE  from article where articleId = ?";

        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, articleId);
        int result = preparedStatement.executeUpdate();

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);
        return result;
    }

    public int update(ArticleBean articleBean) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE article  SET artTypeId=?,articleName=?,article=?,articleTime=?," +
                "articleTop=?,articleCount=? where articleId= ?";

        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, articleBean.getArtTypeId());
        preparedStatement.setString(2, articleBean.getArticleName());
        preparedStatement.setString(3, articleBean.getArticle());
        preparedStatement.setDate(4, articleBean.getArticleTime());
        preparedStatement.setInt(5, articleBean.getArticleTop());
        preparedStatement.setInt(6, articleBean.getArticleCount());
        preparedStatement.setInt(7, articleBean.getArticleId());

        int result = preparedStatement.executeUpdate();
        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);
        return result;
    }

    public int getCount(int artTypeId) throws SQLException, ClassNotFoundException {
        String sql = "select COUNT(articleId) from article WHERE artTypeId=?";

        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, artTypeId);

        resultSet = preparedStatement.executeQuery();
        int result = -1;
        while (resultSet.next()) {
            result = resultSet.getInt(1);
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);
        return result;

    }

    public int getNum() throws SQLException, ClassNotFoundException {
        String sql = "select COUNT(articleId) from article";

        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);


        resultSet = preparedStatement.executeQuery();
        int result = -1;
        while (resultSet.next()) {
            result = resultSet.getInt(1);
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return result;

    }

    public List<ArticleBean> search(String articleName, int artTypeId, int articleTop) throws SQLException, ClassNotFoundException {
        String sql = "select articleId,artTypeId,articleName,article,articleTime,articleTop,articleCount from " +
                "article where 1 = 1 ";
        if (articleName != null) {
            sql = sql + " and articleName =" + articleName;
        }
        if (artTypeId != -1) {
            sql = sql + " and artTypeId =" + artTypeId;
        }
        if (articleTop != -1) {
            sql = sql + "and articleTop=" + articleTop;
        }
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        articleBeans = new ArrayList<ArticleBean>();

        while (resultSet.next()) {
            articleBean = new ArticleBean();
            articleBean.setArticleId(resultSet.getInt(1));
            articleBean.setArtTypeId(resultSet.getInt(2));
            articleBean.setArticleName(resultSet.getString(3));
            articleBean.setArticle(resultSet.getString(4));
            articleBean.setArticleTime(resultSet.getDate(5));
            articleBean.setArticleTop(resultSet.getInt(6));
            articleBean.setArticleCount(resultSet.getInt(7));
            articleBeans.add(articleBean);
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);
        return articleBeans;
    }
}
