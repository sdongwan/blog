package com.sdongwan.blog.dao.impl;

import com.sdongwan.blog.util.DBFactoryUtil;
import com.sdongwan.blog.bean.BlogAdminBean;
import com.sdongwan.blog.dao.BlogAdminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
public class BlogAdminDaoImpl implements BlogAdminDao {

    private Connection connection = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;
    private List<BlogAdminBean> blogAdminBeans = null;
    private BlogAdminBean blogAdminBean = null;

    public BlogAdminBean selectById(int adminId) throws SQLException, ClassNotFoundException {
        String sql = "select adminId,loginName,loginPwd,adminName from blogadmin where adminId=? ";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, adminId);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            blogAdminBean = new BlogAdminBean();
            blogAdminBean.setAdminId(resultSet.getInt(1));
            blogAdminBean.setLoginName(resultSet.getString(2));
            blogAdminBean.setLoginPwd(resultSet.getString(3));
            blogAdminBean.setAdminName(resultSet.getString(4));
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return blogAdminBean;
    }

    public BlogAdminBean adminLogin(String loginName, String loginPwd) throws SQLException, ClassNotFoundException {
        String sql = "select adminId,loginName,loginPwd,adminName from blogadmin where loginName=? and loginPwd=?";
        connection = DBFactoryUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, loginName);
        preparedStatement.setString(2, loginPwd);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            blogAdminBean = new BlogAdminBean();
            blogAdminBean.setAdminId(resultSet.getInt(1));
            blogAdminBean.setLoginName(resultSet.getString(2));
            blogAdminBean.setLoginPwd(resultSet.getString(3));
            blogAdminBean.setAdminName(resultSet.getString(4));
        }

        DBFactoryUtil.closeConnection(resultSet, preparedStatement, null, connection);

        return blogAdminBean;

    }
}
