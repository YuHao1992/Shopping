package kgc.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kgc.pojo.News;
import kgc.sercive.NewsService;
import kgc.service.impl.NewsServiceImpl;

public class DeleteServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id")); 
		   News news=new News();
		   news.setId(id);
		   String flag="failed";   
		   NewsService newsService=new NewsServiceImpl();
		   if(newsService.deleteNews(news)){
		   		flag="success";
		   }
		   response.sendRedirect("/news/jsp/admin/newsDetailList.jsp?flag="+flag);
	}


}
