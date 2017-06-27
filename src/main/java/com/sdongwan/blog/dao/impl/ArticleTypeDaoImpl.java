package com.sdongwan.blog.dao.impl;

import com.sdongwan.blog.util.DBFactoryUtil;
import com.sdongwan.blog.bean.ArticleTypeBean;
import com.sdongwan.blog.dao.ArticleTypeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
public class ArticleTypeDaoImpl implements ArticleTypeDao {
    private Connection connection = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;
    private List<ArticleTypeBean> articleTypeBeans = null;
    private ArticleTypeBean articleTypeBean = null;


    public List<ArticleTypeBean> selectAll() throws SQLException, ClassNotFoundException {
        String sql = "select artTypeId,artTypeName from articletype ";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        articleTypeBeans = new ArrayList<ArticleTypeBean>();
        while (resultSet.next()) {
            articleTypeBean = new ArticleTypeBean();
            articleTypeBean.setArtTypeId(resultSet.getInt(1));
            articleTypeBean.setArtTypeName(resultSet.getString(2));
            articleTypeBeans.add(articleTypeBean);
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return articleTypeBeans;
    }

    public ArticleTypeBean selectById(int artTypeId) throws SQLException, ClassNotFoundException {
        String sql = "select artTypeId,artTypeName from articletype where artTypeId=? ";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, artTypeId);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            articleTypeBean = new ArticleTypeBean();
            articleTypeBean.setArtTypeId(resultSet.getInt(1));
            articleTypeBean.setArtTypeName(resultSet.getString(2));
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return articleTypeBean;
    }

    public ArticleTypeBean selectByName(String artTypeName) throws SQLException, ClassNotFoundException {
        String sql = "select artTypeId,artTypeName from articletype where artTypeName=? ";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, artTypeName);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            articleTypeBean = new ArticleTypeBean();
            articleTypeBean.setArtTypeId(resultSet.getInt(1));
            articleTypeBean.setArtTypeName(resultSet.getString(2));
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return articleTypeBean;
    }

    public int insert(ArticleTypeBean articleTypeBean) throws SQLException, ClassNotFoundException {
        String sql = "INSERT  INTO  articletype(artTypeId,artTypeName) VALUES (NULL ,?)";

        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, articleTypeBean.getArtTypeName());

        int result = preparedStatement.executeUpdate();
        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);
        return result;
    }

    public int del(int artTypeId) throws SQLException, ClassNotFoundException {
        String sql = "delete FROM  articleType where artTypeId=? ";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, artTypeId);
        int result = preparedStatement.executeUpdate();

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return result;
    }

    public int update(ArticleTypeBean articleTypeBean) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE articletype  SET artTypeName=? where artTypeId= ?";

        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, articleTypeBean.getArtTypeName());
        preparedStatement.setInt(2, articleTypeBean.getArtTypeId());

        int result = preparedStatement.executeUpdate();

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return result;
    }
}
