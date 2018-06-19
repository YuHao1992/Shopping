<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'doUser.jsp' starting page</title>
    
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
    //表单字符乱码处理
    //request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
    
    //获取用户注册数据：用户名、密码、email、爱好
    	String userName=request.getParameter("username");
    	String pwd=request.getParameter("passpord");
    	String email=request.getParameter("email");
    	String[] hobbys=request.getParameterValues("hobby");
     %>
     用户名：
     <%
     	if(userName!=null&&!userName.equals("")){
     	//userName=new String(userName.getBytes("iso-8859-1"),"utf-8");
     		if(userName.equals("admin")){
     			request.setAttribute("mess", "注册失败");
     			//转发
     		request.getRequestDispatcher("userCreate.jsp").forward(request, response);
     		}else{
     			session.setAttribute("mess", "注册成功");
     			//设置session过期
     			session.setMaxInactiveInterval(5);
     			//重定向
     		response.sendRedirect(request.getContextPath()+"/index.jsp");
     			}
     		out.print(userName);
     	}else{
     	out.println("用户名未填写！");
     	}
	 %><br/>
     用户密码：<%=pwd %><br/>
     用户email：<%=email %><br/>
     用户爱好：
     <%
     if(hobbys!=null && hobbys.length!=0){
     //用户选择了爱好，将爱好获得
	     for(String hobby:hobbys){
	     	out.println(hobby+"<br/>");
	     }
     }else{
   		out.println("您没有选择任何爱好！");
   		}
     %><br/>
  </body>
</html>





















