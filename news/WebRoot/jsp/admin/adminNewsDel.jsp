<%@page import="kgc.pojo.News"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@include file="../common/common.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminNewsDel.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <%
   //该页面为删除新闻的处理页面（1.获取要删除新闻的ID  2.调用后台方法，根据ID将该新闻删除)
   int id=Integer.parseInt(request.getParameter("id")); 
   News news=new News();
   news.setId(id);
   String flag="failed";      
   if(newsService.deleteNews(news)){
   		flag="success";
   }
   response.sendRedirect("newsDetailList.jsp?flag="+flag);
   
   
    %>
  </body>
</html>
