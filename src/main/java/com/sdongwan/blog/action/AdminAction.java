package com.sdongwan.blog.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sdongwan.blog.bean.BlogAdminBean;
import com.sdongwan.blog.dao.BlogAdminDao;
import com.sdongwan.blog.dao.impl.BlogAdminDaoImpl;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/6/25.
 */
public class AdminAction extends ActionSupport implements ServletRequestAware {
    private BlogAdminBean blogAdminBean = null;

    private HttpServletRequest request;
    private BlogAdminDao blogAdminDao = new BlogAdminDaoImpl();

    public BlogAdminBean getBlogAdminBean() {
        return blogAdminBean;
    }

    public void setBlogAdminBean(BlogAdminBean blogAdminBean) {
        this.blogAdminBean = blogAdminBean;
    }

    public String adminLogin() throws SQLException, ClassNotFoundException {
        if (blogAdminBean == null) {
            return ERROR;
        } else {
            BlogAdminBean blogAdminBean1 = blogAdminDao.adminLogin(blogAdminBean.getLoginName(), blogAdminBean.getLoginPwd());
            if (blogAdminBean1 != null) {
//                ActionContext.getContext().getSession().put("BlogAdmin", blogAdminBean1.getAdminName());
//                ActionContext.getContext().getSession().put("admin", "blogAdmin");
//                ActionContext.getContext().put("adminLogin", "success");

                request.getSession().putValue("BlogAdmin", blogAdminBean1.getAdminName());
                request.getSession().putValue("admin", "blogAdmin");
                request.setAttribute("adminLogin", "success");
                System.out.println("SUCCESS");
                return SUCCESS;
            } else {
//                ActionContext.getContext().getSession().put("admin", "error");
//                ActionContext.getContext().put("adminLogin", "error");
                request.getSession().putValue("admin", "error");
                request.setAttribute("adminLogin", "error");
                return ERROR;
            }

        }


    }

    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }
}
