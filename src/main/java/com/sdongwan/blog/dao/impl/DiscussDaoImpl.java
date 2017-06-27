package com.sdongwan.blog.dao.impl;

import com.sdongwan.blog.bean.DiscussBean;
import com.sdongwan.blog.dao.DiscussDao;
import com.sdongwan.blog.util.DBFactoryUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
public class DiscussDaoImpl implements DiscussDao {
    private Connection connection = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;
    private List<DiscussBean> discussBeans = null;
    private DiscussBean discussBean = null;

    public List<DiscussBean> selectAll() throws SQLException, ClassNotFoundException {
        String sql = "select discussId,articleId,visitorId,discuss,discussR,discussTime,discussTimeR from discuss ";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        discussBeans = new ArrayList<DiscussBean>();
        while (resultSet.next()) {
            discussBean = new DiscussBean();
            discussBean.setDiscussId(resultSet.getInt(1));
            discussBean.setArticleId(resultSet.getInt(2));
            discussBean.setVisitorId(resultSet.getInt(3));
            discussBean.setDiscuss(resultSet.getString(4));
            discussBean.setDiscussR(resultSet.getString(5));
            discussBean.setDiscussTime(resultSet.getString(6));
            discussBean.setDiscussTimeR(resultSet.getString(7));
            discussBeans.add(discussBean);
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return discussBeans;
    }

    public DiscussBean selectById(int discussId) throws SQLException, ClassNotFoundException {
        String sql = "select discussId,articleId,visitorId,discss,discussR,discussTime,discussTimeR from discuss where discussId=?";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, discussId);
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            discussBean = new DiscussBean();
            discussBean.setDiscussId(resultSet.getInt(1));
            discussBean.setArticleId(resultSet.getInt(2));
            discussBean.setVisitorId(resultSet.getInt(3));
            discussBean.setDiscuss(resultSet.getString(4));
            discussBean.setDiscussR(resultSet.getString(5));
            discussBean.setDiscussTime(resultSet.getString(6));
            discussBean.setDiscussTimeR(resultSet.getString(7));
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return discussBean;
    }

    public List<DiscussBean> selectByArtId(int articleId) throws SQLException, ClassNotFoundException {
        String sql = "select discussId,articleId,visitorId,discuss,discussR,discussTime,discussTimeR from discuss where articleId=? ";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, articleId);
        resultSet = preparedStatement.executeQuery();
        discussBeans = new ArrayList<DiscussBean>();
        while (resultSet.next()) {
            discussBean = new DiscussBean();
            discussBean.setDiscussId(resultSet.getInt(1));
            discussBean.setArticleId(resultSet.getInt(2));
            discussBean.setVisitorId(resultSet.getInt(3));
            discussBean.setDiscuss(resultSet.getString(4));
            discussBean.setDiscussR(resultSet.getString(5));
            discussBean.setDiscussTime(resultSet.getString(6));
            discussBean.setDiscussTimeR(resultSet.getString(7));
            discussBeans.add(discussBean);
        }


        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return discussBeans;
    }

    public List<DiscussBean> selectByVisitorId(int visitorId) throws SQLException, ClassNotFoundException {
        String sql = "select discussId,articleId,visitorId,discuss,discussR,discussTime,discussTimeR from discuss where visitorId=? ";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, visitorId);
        resultSet = preparedStatement.executeQuery();
        discussBeans = new ArrayList<DiscussBean>();
        while (resultSet.next()) {
            discussBean = new DiscussBean();
            discussBean.setDiscussId(resultSet.getInt(1));
            discussBean.setArticleId(resultSet.getInt(2));
            discussBean.setVisitorId(resultSet.getInt(3));
            discussBean.setDiscuss(resultSet.getString(4));
            discussBean.setDiscussR(resultSet.getString(5));
            discussBean.setDiscussTime(resultSet.getString(6));
            discussBean.setDiscussTimeR(resultSet.getString(7));
            discussBeans.add(discussBean);
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return discussBeans;
    }

    public int insert(DiscussBean discussBean) throws SQLException, ClassNotFoundException {
        String sql = "INSERT  INTO discuss(discussId,articleId,visitorId,discuss,discussR,discussTime,discussTimeR) VALUES (NULL ,?,?,?,?,?,?)";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, discussBean.getArticleId());
        preparedStatement.setInt(2, discussBean.getVisitorId());
        preparedStatement.setString(3, discussBean.getDiscuss());
        preparedStatement.setString(4, discussBean.getDiscussR());
        preparedStatement.setString(5, discussBean.getDiscussTime());
        preparedStatement.setString(6, discussBean.getDiscussTimeR());
        int result = preparedStatement.executeUpdate();

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return result;
    }

    public int update(DiscussBean discussBean) throws SQLException, ClassNotFoundException {
        String sql = "update discuss set(visitorId=?,discuss=?,discussR=?,discussTime=?,discussTimeR=?) from discuss  where discussId=?";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, discussBean.getVisitorId());
        preparedStatement.setString(2, discussBean.getDiscuss());
        preparedStatement.setString(3, discussBean.getDiscussR());
        preparedStatement.setString(4, discussBean.getDiscussTime());
        preparedStatement.setString(5, discussBean.getDiscussTimeR());
        preparedStatement.setInt(6, discussBean.getDiscussId());
        int count = preparedStatement.executeUpdate();

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return count;
    }

    public int del(int discussId) throws SQLException, ClassNotFoundException {
        String sql = "delete from discuss  where discussId=?";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, discussId);
        int count = preparedStatement.executeUpdate();

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return count;
    }

    public int getCount(int visitorId) throws SQLException, ClassNotFoundException {
        String sql = "select count(visitorId) from discuss where visitorId=?";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, visitorId);
        resultSet = preparedStatement.executeQuery();
        int count = -1;
        if (resultSet.next()) {
            count = resultSet.getInt(1);
        }
        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return count;
    }

    public int getArtCount(int articleId) throws SQLException, ClassNotFoundException {
        String sql = "select count(visitorId) from discuss where articleId=?";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, articleId);
        resultSet = preparedStatement.executeQuery();
        int count = -1;
        if (resultSet.next()) {
            count = resultSet.getInt(1);
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return count;
    }
}
