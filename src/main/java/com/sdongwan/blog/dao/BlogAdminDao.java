package com.sdongwan.blog.dao;

import com.sdongwan.blog.bean.BlogAdminBean;

import java.sql.SQLException;

/**
 * Created by Administrator on 2017/6/23.
 */
public interface BlogAdminDao {
    BlogAdminBean selectById(int adminId) throws SQLException, ClassNotFoundException;

    BlogAdminBean adminLogin(String loginName, String loginPwd) throws SQLException, ClassNotFoundException;
}
