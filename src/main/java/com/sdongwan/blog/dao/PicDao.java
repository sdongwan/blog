package com.sdongwan.blog.dao;

import com.sdongwan.blog.bean.PicBean;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
public interface PicDao {
    List<PicBean> selectAll() throws SQLException, ClassNotFoundException;

    List<PicBean> selectAll(int num) throws SQLException, ClassNotFoundException;//分页查询

    List<PicBean> selectByTypeId(int picTypeId) throws SQLException, ClassNotFoundException;

    PicBean selectByName(String picName) throws SQLException, ClassNotFoundException;

    PicBean selectById(int picId) throws SQLException, ClassNotFoundException;

    List<PicBean> selectByTime(Date picTime) throws SQLException, ClassNotFoundException;

    List<PicBean> selectByCount(int picCount) throws SQLException, ClassNotFoundException;//根据欢迎度查询

    int insert(PicBean picBean) throws SQLException, ClassNotFoundException;

    int del(int picId) throws SQLException, ClassNotFoundException;

    int update(PicBean picBean) throws SQLException, ClassNotFoundException;

    int getCount(int picTypeId) throws SQLException, ClassNotFoundException;

    int getNum() throws SQLException, ClassNotFoundException;


}
