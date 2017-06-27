package com.sdongwan.blog.dao.impl;

import com.sdongwan.blog.bean.NoticeBean;
import com.sdongwan.blog.dao.NoticeDao;
import com.sdongwan.blog.util.DBFactoryUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
public class NoticeDaoImpl implements NoticeDao {
    private Connection connection = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;
    private List<NoticeBean> noticeBeans = null;
    private NoticeBean noticeBean = null;

    public List<NoticeBean> selectAll() throws SQLException, ClassNotFoundException {
        String sql = "select noticeId,notice,noticeName,noticeTime from notice ";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        noticeBeans = new ArrayList<NoticeBean>();
        while (resultSet.next()) {
            noticeBean = new NoticeBean();
            noticeBean.setNoticeId(resultSet.getInt(1));
            noticeBean.setNotice(resultSet.getString(2));
            noticeBean.setNotice(resultSet.getString(3));
            noticeBean.setNoticeTime(resultSet.getDate(4));
            noticeBeans.add(noticeBean);
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return noticeBeans;
    }

    public NoticeBean selectById(int noticeId) throws SQLException, ClassNotFoundException {
        String sql = "select noticeId,notice,noticeName,noticeTime from notice where noticeId=?";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, noticeId);
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            noticeBean = new NoticeBean();
            noticeBean.setNoticeId(resultSet.getInt(1));
            noticeBean.setNotice(resultSet.getString(2));
            noticeBean.setNotice(resultSet.getString(3));
            noticeBean.setNoticeTime(resultSet.getDate(4));
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);
        return noticeBean;
    }

    public NoticeBean selectByName(String noticeName) throws SQLException, ClassNotFoundException {
        String sql = "select noticeId,notice,noticeName,noticeTime from notice where noticeName=?";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, noticeName);
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            noticeBean = new NoticeBean();
            noticeBean.setNoticeId(resultSet.getInt(1));
            noticeBean.setNotice(resultSet.getString(2));
            noticeBean.setNotice(resultSet.getString(3));
            noticeBean.setNoticeTime(resultSet.getDate(4));
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);
        return noticeBean;
    }

    public NoticeBean selectNew() throws SQLException, ClassNotFoundException {
        String sql = "select noticeId,notice,noticeName,noticeTime from notice order BY noticeTime desc limit 0,1";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            noticeBean = new NoticeBean();
            noticeBean.setNoticeId(resultSet.getInt(1));
            noticeBean.setNotice(resultSet.getString(2));
            noticeBean.setNotice(resultSet.getString(3));
            noticeBean.setNoticeTime(resultSet.getDate(4));
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);
        return noticeBean;
    }

    public List<NoticeBean> selectByTime(Date noticeTime) throws SQLException, ClassNotFoundException {
        String sql = "select noticeId,notice,noticeName,noticeTime from notice where noticeTime=?";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDate(1, noticeTime);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            noticeBean = new NoticeBean();
            noticeBean.setNoticeId(resultSet.getInt(1));
            noticeBean.setNotice(resultSet.getString(2));
            noticeBean.setNoticeName(resultSet.getString(3));
            noticeBean.setNoticeTime(resultSet.getDate(4));
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);
        return noticeBeans;
    }

    public int insert(NoticeBean noticeBean) throws SQLException, ClassNotFoundException {
        String sql = "INSERT into notice(noticeId,notice,noticeName,noticeTime) VALUES (NULL ,?,?,?)";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, noticeBean.getNotice());
        preparedStatement.setString(2, noticeBean.getNoticeName());
        preparedStatement.setDate(3, noticeBean.getNoticeTime());
        int result = preparedStatement.executeUpdate();

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return result;
    }

    public int del(int noticeId) throws SQLException, ClassNotFoundException {
        String sql = "delete from notice  where noticeId=?";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, noticeId);
        int result = preparedStatement.executeUpdate();

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return result;
    }

    public int update(NoticeBean noticeBean) throws SQLException, ClassNotFoundException {
        String sql = "update notice set notice=?,noticeName=?,noticeTime=?  where noticeId=?";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, noticeBean.getNotice());
        preparedStatement.setString(2, noticeBean.getNoticeName());
        preparedStatement.setDate(3, noticeBean.getNoticeTime());
        preparedStatement.setInt(4, noticeBean.getNoticeId());
        int result = preparedStatement.executeUpdate();

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return result;
    }
}
