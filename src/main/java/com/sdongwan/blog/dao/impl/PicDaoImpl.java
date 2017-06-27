package com.sdongwan.blog.dao.impl;

import com.sdongwan.blog.bean.PicBean;
import com.sdongwan.blog.dao.PicDao;
import com.sdongwan.blog.util.DBFactoryUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
public class PicDaoImpl implements PicDao {

    private Connection connection = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;
    private List<PicBean> picBeans = null;
    private PicBean picBean = null;

    public List<PicBean> selectAll() throws SQLException, ClassNotFoundException {
        String sql = "select picId,picTypeId,picName,picPath,picTime,picDes,picCount" +
                " from pic ";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);

        resultSet = preparedStatement.executeQuery();
        picBeans = new ArrayList<PicBean>();
        while (resultSet.next()) {
            picBean = new PicBean();
            picBean.setPicId(resultSet.getInt(1));
            picBean.setPicTypeId(resultSet.getInt(2));
            picBean.setPicName(resultSet.getString(3));
            picBean.setPicPath(resultSet.getString(4));
            picBean.setPicTime(resultSet.getDate(5));
            picBean.setPicDes(resultSet.getString(6));
            picBean.setPicCount(resultSet.getInt(7));

            picBeans.add(picBean);
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return picBeans;
    }

    public List<PicBean> selectAll(int num) throws SQLException, ClassNotFoundException {
        String sql = "select picId,picTypeId,picName,picPath,picTime,picDes,picCount" +
                " from pic limit ?,?";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, (num - 1) * 6);
        preparedStatement.setInt(2, 6);
        resultSet = preparedStatement.executeQuery();
        picBeans = new ArrayList<PicBean>();
        while (resultSet.next()) {
            picBean = new PicBean();
            picBean.setPicId(resultSet.getInt(1));
            picBean.setPicTypeId(resultSet.getInt(2));
            picBean.setPicName(resultSet.getString(3));
            picBean.setPicPath(resultSet.getString(4));
            picBean.setPicTime(resultSet.getDate(5));
            picBean.setPicDes(resultSet.getString(6));
            picBean.setPicCount(resultSet.getInt(7));

            picBeans.add(picBean);
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return picBeans;
    }

    public List<PicBean> selectByTypeId(int picTypeId) throws SQLException, ClassNotFoundException {
        String sql = "select picId,picTypeId,picName,picPath,picTime,picDes,picCount" +
                " from pic  where picTypeId=?";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, picTypeId);
        resultSet = preparedStatement.executeQuery();
        picBeans = new ArrayList<PicBean>();
        while (resultSet.next()) {
            picBean = new PicBean();
            picBean.setPicId(resultSet.getInt(1));
            picBean.setPicTypeId(resultSet.getInt(2));
            picBean.setPicName(resultSet.getString(3));
            picBean.setPicPath(resultSet.getString(4));
            picBean.setPicTime(resultSet.getDate(5));
            picBean.setPicDes(resultSet.getString(6));
            picBean.setPicCount(resultSet.getInt(7));

            picBeans.add(picBean);
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return picBeans;
    }

    public PicBean selectByName(String picName) throws SQLException, ClassNotFoundException {
        String sql = "select picId,picTypeId,picName,picPath,picTime,picDes,picCount" +
                " from pic where picName=?";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, picName);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            picBean = new PicBean();
            picBean.setPicId(resultSet.getInt(1));
            picBean.setPicTypeId(resultSet.getInt(2));
            picBean.setPicName(resultSet.getString(3));
            picBean.setPicPath(resultSet.getString(4));
            picBean.setPicTime(resultSet.getDate(5));
            picBean.setPicDes(resultSet.getString(6));
            picBean.setPicCount(resultSet.getInt(7));

        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return picBean;
    }

    public PicBean selectById(int picId) throws SQLException, ClassNotFoundException {
        String sql = "select picId,picTypeId,picName,picPath,picTime,picDes,picCount" +
                " from pic where picId=?";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, picId);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            picBean = new PicBean();
            picBean.setPicId(resultSet.getInt(1));
            picBean.setPicTypeId(resultSet.getInt(2));
            picBean.setPicName(resultSet.getString(3));
            picBean.setPicPath(resultSet.getString(4));
            picBean.setPicTime(resultSet.getDate(5));
            picBean.setPicDes(resultSet.getString(6));
            picBean.setPicCount(resultSet.getInt(7));

        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return picBean;
    }

    public List<PicBean> selectByTime(Date picTime) throws SQLException, ClassNotFoundException {
        String sql = "select picId,picTypeId,picName,picPath,picTime,picDes,picCount" +
                " from pic WHERE picTime=?";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDate(1, picTime);
        resultSet = preparedStatement.executeQuery();
        picBeans = new ArrayList<PicBean>();
        while (resultSet.next()) {
            picBean = new PicBean();
            picBean.setPicId(resultSet.getInt(1));
            picBean.setPicTypeId(resultSet.getInt(2));
            picBean.setPicName(resultSet.getString(3));
            picBean.setPicPath(resultSet.getString(4));
            picBean.setPicTime(resultSet.getDate(5));
            picBean.setPicDes(resultSet.getString(6));
            picBean.setPicCount(resultSet.getInt(7));

            picBeans.add(picBean);
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return picBeans;
    }

    public List<PicBean> selectByCount(int picCount) throws SQLException, ClassNotFoundException {
        String sql = "select picId,picTypeId,picName,picPath,picTime,picDes,picCount" +
                " from pic WHERE picCount=?";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, picCount);
        resultSet = preparedStatement.executeQuery();
        picBeans = new ArrayList<PicBean>();
        while (resultSet.next()) {
            picBean = new PicBean();
            picBean.setPicId(resultSet.getInt(1));
            picBean.setPicTypeId(resultSet.getInt(2));
            picBean.setPicName(resultSet.getString(3));
            picBean.setPicPath(resultSet.getString(4));
            picBean.setPicTime(resultSet.getDate(5));
            picBean.setPicDes(resultSet.getString(6));
            picBean.setPicCount(resultSet.getInt(7));

            picBeans.add(picBean);
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return picBeans;
    }

    public int insert(PicBean picBean) throws SQLException, ClassNotFoundException {
        String sql = "INSERT  INTO pic(picId,picTypeId,picName,picPath,picTime,picDes,picCount) VALUES (NULL ,?,?,?,?,?,?)";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, picBean.getPicTypeId());
        preparedStatement.setString(2, picBean.getPicName());
        preparedStatement.setString(3, picBean.getPicPath());
        preparedStatement.setDate(4, picBean.getPicTime());
        preparedStatement.setString(5, picBean.getPicDes());
        preparedStatement.setInt(6, picBean.getPicCount());
        int result = preparedStatement.executeUpdate();

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return result;
    }

    public int del(int picId) throws SQLException, ClassNotFoundException {
        String sql = "delete from pic WHERE picId=?";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, picId);

        int result = preparedStatement.executeUpdate();

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return result;
    }

    public int update(PicBean picBean) throws SQLException, ClassNotFoundException {
        String sql = "update pic set picTypeId=?,picName=?,picPath=?,picTime=?,picDes=?,picCount=? WHERE picId=?";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, picBean.getPicTypeId());
        preparedStatement.setString(2, picBean.getPicName());
        preparedStatement.setString(3, picBean.getPicPath());
        preparedStatement.setDate(4, picBean.getPicTime());
        preparedStatement.setString(5, picBean.getPicDes());
        preparedStatement.setInt(6, picBean.getPicCount());
        int result = preparedStatement.executeUpdate();

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return result;
    }

    public int getCount(int picTypeId) throws SQLException, ClassNotFoundException {
        String sql = "select count(picId)" +
                " from pic WHERE picTypeId=?";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, picTypeId);
        resultSet = preparedStatement.executeQuery();
        picBeans = new ArrayList<PicBean>();

        int count = resultSet.getInt(1);
        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return count;
    }

    public int getNum() throws SQLException, ClassNotFoundException {
        String sql = "select count(picId)" +
                " from pic ";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        picBeans = new ArrayList<PicBean>();
        int count = -1;
        if (resultSet.next()) {
            count = resultSet.getInt(1);
        }
        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return count;
    }
}
