package com.sdongwan.blog.dao;

import com.sdongwan.blog.bean.LinkBean;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
public interface LinkDao {
    List<LinkBean> selectAll() throws SQLException, ClassNotFoundException;

    List<LinkBean> showLink() throws SQLException, ClassNotFoundException;//显示最新的五条link

    LinkBean selectById(int linkId) throws SQLException, ClassNotFoundException;

    int insert(LinkBean linkBean) throws SQLException, ClassNotFoundException;

    int update(LinkBean linkBean) throws SQLException, ClassNotFoundException;

    int del(int linkId) throws SQLException, ClassNotFoundException;

}
