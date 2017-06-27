package com.sdongwan.blog.dao;

import com.sdongwan.blog.bean.VisitorBean;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
public interface VisitorDao {
    VisitorBean selectByEmail(String visitorEmail) throws SQLException, ClassNotFoundException;

    VisitorBean login(String visitorEmail, String visitorName, String visitorIp) throws SQLException, ClassNotFoundException;

    VisitorBean selectById(int visitorId) throws SQLException, ClassNotFoundException;

    List<VisitorBean> selectAll() throws SQLException, ClassNotFoundException;

    int insert(VisitorBean visitorBean) throws SQLException, ClassNotFoundException;

    int update(VisitorBean visitorBean) throws SQLException, ClassNotFoundException;

    int del(int visitorId) throws SQLException, ClassNotFoundException;


}
