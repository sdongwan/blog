package com.sdongwan.blog.dao.impl;

import com.sdongwan.blog.util.DBFactoryUtil;
import com.sdongwan.blog.bean.LinkBean;
import com.sdongwan.blog.dao.LinkDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
public class LinkDaoImpl implements LinkDao {

    private Connection connection = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;
    private List<LinkBean> linkBeans = null;
    private LinkBean linkBean = null;

    public List<LinkBean> selectAll() throws SQLException, ClassNotFoundException {
        String sql = "select linkId,linkUrl,linkName" +
                " from link ";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);

        resultSet = preparedStatement.executeQuery();
        linkBeans = new ArrayList<LinkBean>();
        while (resultSet.next()) {
            linkBean = new LinkBean();
            linkBean.setLinkId(resultSet.getInt(1));
            linkBean.setLinkUrl(resultSet.getString(2));
            linkBean.setLinkName(resultSet.getString(3));

            linkBeans.add(linkBean);
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return linkBeans;
    }

    public List<LinkBean> showLink() throws SQLException, ClassNotFoundException {
        String sql = "select linkId,linkUrl,linkName" +
                " from link ORDER by linkId DESC limit 0,5";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);

        resultSet = preparedStatement.executeQuery();
        linkBeans = new ArrayList<LinkBean>();
        while (resultSet.next()) {
            linkBean = new LinkBean();
            linkBean.setLinkId(resultSet.getInt(1));
            linkBean.setLinkUrl(resultSet.getString(2));
            linkBean.setLinkName(resultSet.getString(3));
            linkBeans.add(linkBean);
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return linkBeans;
    }

    public LinkBean selectById(int linkId) throws SQLException, ClassNotFoundException {
        String sql = "select linkId,linkUrl,linkName" +
                " from link where linkId=?";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, linkId);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            linkBean = new LinkBean();
            linkBean.setLinkId(resultSet.getInt(1));
            linkBean.setLinkUrl(resultSet.getString(2));
            linkBean.setLinkName(resultSet.getString(3));
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);
        return linkBean;
    }

    public int insert(LinkBean linkBean) throws SQLException, ClassNotFoundException {
        String sql = "insert into link(linkId,linkUrl,linkName) VALUES (NULL ,?,?)";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, linkBean.getLinkUrl());
        preparedStatement.setString(2, linkBean.getLinkName());
        int result = preparedStatement.executeUpdate();

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return result;
    }

    public int update(LinkBean linkBean) throws SQLException, ClassNotFoundException {
        String sql = "update link set linkUrl=?,linkName=?  where linkId=?";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, linkBean.getLinkUrl());
        preparedStatement.setString(2, linkBean.getLinkName());
        preparedStatement.setInt(3, linkBean.getLinkId());
        int result = preparedStatement.executeUpdate();

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return result;
    }

    public int del(int linkId) throws SQLException, ClassNotFoundException {
        String sql = "delete from link  where linkId=?";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, linkId);
        int result = preparedStatement.executeUpdate();

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return result;
    }
}
