package com.sdongwan.blog.dao.impl;

import com.sdongwan.blog.bean.PicTypeBean;
import com.sdongwan.blog.dao.PicTypeDao;
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
public class PicTypeDaoImpl implements PicTypeDao {
    private Connection connection = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;
    private List<PicTypeBean> picTypeBeans = null;
    private PicTypeBean picTypeBean = null;


    public List<PicTypeBean> selectAll() throws SQLException, ClassNotFoundException {
        String sql = "select picTypeId,picTypeName from pictype ";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        picTypeBeans = new ArrayList<PicTypeBean>();
        while (resultSet.next()) {
            picTypeBean = new PicTypeBean();
            picTypeBean.setPicTypeId(resultSet.getInt(1));
            picTypeBean.setPicTypeName(resultSet.getString(2));
            picTypeBeans.add(picTypeBean);
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return picTypeBeans;
    }

    public PicTypeBean selectById(int picTypeId) throws SQLException, ClassNotFoundException {
        String sql = "select picTypeId,picTypeName from pictype where picTypeId=?";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, picTypeId);
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            picTypeBean = new PicTypeBean();
            picTypeBean.setPicTypeId(resultSet.getInt(1));
            picTypeBean.setPicTypeName(resultSet.getString(2));
        }
        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return picTypeBean;
    }

    public PicTypeBean selectByName(String picTypeName) throws SQLException, ClassNotFoundException {
        String sql = "select picTypeId,picTypeName from pictype where picTypeName=?";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, picTypeName);
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            picTypeBean = new PicTypeBean();
            picTypeBean.setPicTypeId(resultSet.getInt(1));
            picTypeBean.setPicTypeName(resultSet.getString(2));
        }
        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return picTypeBean;
    }

    public int insert(PicTypeBean picTypeBean) throws SQLException, ClassNotFoundException {
        String sql = "insert into pictype(picTypeId,picTypeName) VALUES (NULL ,?)";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, picTypeBean.getPicTypeName());
        int result = preparedStatement.executeUpdate();

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return result;
    }

    public int update(PicTypeBean picTypeBean) throws SQLException, ClassNotFoundException {
        String sql = "update  pictype set picTypeName=? where picTypeId=?";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, picTypeBean.getPicTypeName());
        preparedStatement.setInt(2, picTypeBean.getPicTypeId());
        int result = preparedStatement.executeUpdate();

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return result;
    }

    public int del(int picTypeId) throws SQLException, ClassNotFoundException {
        String sql = "delete from  pictype where picTypeId=?";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, picTypeId);
        int result = preparedStatement.executeUpdate();

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return result;
    }
}
