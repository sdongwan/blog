package com.sdongwan.blog.dao;

import com.sdongwan.blog.bean.PicTypeBean;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
public interface PicTypeDao {
    List<PicTypeBean> selectAll() throws SQLException, ClassNotFoundException;

    PicTypeBean selectById(int picTypeId) throws SQLException, ClassNotFoundException;

    PicTypeBean selectByName(String picTypeName) throws SQLException, ClassNotFoundException;

    int insert(PicTypeBean picTypeBean) throws SQLException, ClassNotFoundException;

    int update(PicTypeBean picTypeBean) throws SQLException, ClassNotFoundException;

    int del(int picTypeId) throws SQLException, ClassNotFoundException;

}
