package kgc.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import kgc.pojo.News;
import kgc.pojo.User;
import kgc.service.impl.NewsServiceImpl;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取用户名和密码
		String userCode = request.getParameter("userCode");
		String userPassword = request.getParameter("userPassword");
		//调用service方法，进行用户匹配,返回User对象
		//若登录成功 ——User对象
		User user = new User();
		user.setUserCode(userCode);
		user.setUserPasswod(userPassword);
		
		//.......调用UserService方法验证该用户
		
		if(null != user){//登录成功
			//放入session
			request.getSession().setAttribute("userSession", user);
			//页面跳转（admin.jsp）
			response.sendRedirect("/news/jsp/admin/admin.jsp");
		}else{
			//页面跳转（login.jsp）带出提示信息--转发
		}
	}

}
