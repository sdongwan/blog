package com.sdongwan.blog.dao.impl;

import com.sdongwan.blog.bean.VisitorBean;
import com.sdongwan.blog.dao.VisitorDao;
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
public class VisitorDaoImpl implements VisitorDao {
    private Connection connection = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;
    private List<VisitorBean> visitorBeans = null;
    private VisitorBean visitorBean = null;

    public VisitorBean selectByEmail(String visitorEmail) throws SQLException, ClassNotFoundException {
        String sql = "select visitorId,visitorName,visitorIp,visitorEmail from visitor where visitorEmail=? ";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, visitorEmail);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            visitorBean = new VisitorBean();
            visitorBean.setVisitorId(resultSet.getInt(1));
            visitorBean.setVisitorName(resultSet.getString(2));
            visitorBean.setVisitorIp(resultSet.getString(3));
            visitorBean.setVisitorEmail(resultSet.getString(4));
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);
        return visitorBean;
    }

    public VisitorBean login(String visitorEmail, String visitorName, String visitorIp) throws SQLException, ClassNotFoundException {
        String sql = "select visitorId,visitorName,visitorIp,visitorEmail from visitor where visitorEmail=? and visitorName=? and visitorTp=?";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, visitorEmail);
        preparedStatement.setString(2, visitorName);
        preparedStatement.setString(3, visitorIp);

        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            visitorBean = new VisitorBean();
            visitorBean.setVisitorId(resultSet.getInt(1));
            visitorBean.setVisitorName(resultSet.getString(2));
            visitorBean.setVisitorIp(resultSet.getString(3));
            visitorBean.setVisitorEmail(resultSet.getString(4));
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);
        return visitorBean;
    }

    public VisitorBean selectById(int visitorId) throws SQLException, ClassNotFoundException {
        String sql = "select visitorId,visitorName,visitorIp,visitorEmail from visitor where visitorId=? ";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, visitorId);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            visitorBean = new VisitorBean();
            visitorBean.setVisitorId(resultSet.getInt(1));
            visitorBean.setVisitorName(resultSet.getString(2));
            visitorBean.setVisitorIp(resultSet.getString(3));
            visitorBean.setVisitorEmail(resultSet.getString(4));
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);
        return visitorBean;
    }

    public List<VisitorBean> selectAll() throws SQLException, ClassNotFoundException {
        String sql = "select visitorId,visitorName,visitorIp,visitorEmail from visitor";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        visitorBeans = new ArrayList<VisitorBean>();
        while (resultSet.next()) {
            visitorBean = new VisitorBean();
            visitorBean.setVisitorId(resultSet.getInt(1));
            visitorBean.setVisitorName(resultSet.getString(2));
            visitorBean.setVisitorIp(resultSet.getString(3));
            visitorBean.setVisitorEmail(resultSet.getString(4));
            visitorBeans.add(visitorBean);
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);
        return visitorBeans;
    }

    public int insert(VisitorBean visitorBean) throws SQLException, ClassNotFoundException {
        String sql = "insert INTO visitor(visitorId,visitorName,visitorIp,visitorEmail) VALUES (NULL ,?,?,?)";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, visitorBean.getVisitorName());
        preparedStatement.setString(2, visitorBean.getVisitorIp());
        preparedStatement.setString(3, visitorBean.getVisitorEmail());

        int result = preparedStatement.executeUpdate();


        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);
        return result;
    }

    public int update(VisitorBean visitorBean) throws SQLException, ClassNotFoundException {
        String sql = "update visitor  SET  visitorName=?,visitorIp=?,visitorEmail=? where visitorId=?";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, visitorBean.getVisitorName());
        preparedStatement.setString(2, visitorBean.getVisitorIp());
        preparedStatement.setString(3, visitorBean.getVisitorEmail());
        preparedStatement.setInt(4, visitorBean.getVisitorId());

        int result = preparedStatement.executeUpdate();


        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);
        return result;
    }

    public int del(int visitorId) throws SQLException, ClassNotFoundException {
        String sql = "delete from visitor  where visitorId=?";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, visitorId);

        int result = preparedStatement.executeUpdate();


        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);
        return result;
    }
}
