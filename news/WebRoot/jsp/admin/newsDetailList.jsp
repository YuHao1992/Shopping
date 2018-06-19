<%@page import="kgc.util.PageSupport"%>
<%@page import="kgc.pojo.News"%>
<%@page import="java.util.List"%>
<%@page import="kgc.service.impl.NewsServiceImpl"%>
<%@page import="kgc.sercive.NewsService"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../common/common.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
<style type="text/css">
<!--

-->
</style>
<script>
	function addNews(){
		window.location="<%=request.getContextPath()%>/jsp/admin/newsDetailCreateSimple.jsp";
	}
	//提交表单  传递页码
	
	var flag='${param.flag}';
	if(flag!=null&&flag!=''&&undefind!=flag){
		if(flag=='success'){
			alert('删除成功');
		}else{
			alert('删除失败！');
		}
	}
</script>
</head>

<body>
<!--页面顶部-->

<!--主体-->
<!-- <div id="content" class="main-content clearfix"> -->
    <div class="main-content-right">
        <!--即时新闻-->
        <div class="main-text-box">
            <div class="main-text-box-tbg">
                <div class="main-text-box-bbg">
                    <form name ="searchForm" id="searchForm" action="/news/jsp/admin/newsDetailList.jsp" method="post">
		 	          <div>
		 				新闻分类：
		 					<select name="categoryId">
		 						<option value="0">全部</option>
			        			
			        				<option value='1' >国内</option>
			        			
			        				<option value='2' >国际</option>
			        			
			        				<option value='3' >娱乐</option>
			        			
			        				<option value='4' >军事</option>
			        			
			        				<option value='5' >财经</option>
			        			
			        				<option value='6' >天气</option>
			        			
	        				</select>
		 				新闻标题<input type="text" name="title" id="title" value=''/>
		 					<button type="submit" class="page-btn">GO</button>
		 					<button type="button" onclick="addNews();" class="page-btn">增加</button>
		 					<input type="hidden" name="pageIndex" value="1"/>
		 					
		 	</div>
		 	</form>
			<table cellpadding="1" cellspacing="1" class="admin-list">
				<thead >
					<tr class="admin-list-head">
						<th>新闻标题</th>
                        <th>作者</th>
                        <th>时间</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                	<%
                		//分页查询并显示
                		//当前页码
                		String currentPage=request.getParameter("pageIndex");
                		if(currentPage==null){
                		//用户首次访问页面
                			currentPage="1";
                		}
                		int pageIndex=Integer.parseInt(currentPage);	
                		//获取新闻总数量
                		int totalCount=newsService.getTotalCount();
                		//计算 每页显示几条新闻
                		int pageSize=3;
                		//获取总页数
                		PageSupport pageSupport=new PageSupport();
                		pageSupport.setCurrentPageNo(pageIndex);
                		pageSupport.setPageSize(pageSize);
                		pageSupport.setTotalCount(totalCount);
                		//总页数
                		int totalPage=pageSupport.getTotalPageCount();
                		//控制首页和尾页
                		if(pageIndex<1){
                			pageIndex=1;
                		}else if(pageIndex>totalPage){
                			pageIndex=totalPage;
                		}
                		
                		List<News> list=newsService.getPageNewsList(pageIndex, pageSize);
                		request.setAttribute("list", list);
                		
                	 %>
                	 	<input type="hidden" id="totalPage" value="<%=totalPage%>"/>
                	 	<c:forEach items="${list }" var="news" varStatus="status">
		                	<tr <c:if test="${status.count%2==0 }">class="admin-list-td-h2"</c:if>>
		                		<td><a href='newsDetailView.jsp?id=${news.id }'><c:out value="${news.title}" escapeXml="true"/>
		                		</a></td>
		                		<td>${news.author }</td>
		                		<td>
		                			<fmt:formatDate value="${news.createDate }" pattern="yyyy-MM-dd"/>
		                		
		                		</td>
		                		<td><a href='adminNewsCreate.jsp?id=2'>修改</a>
		                			<a href="javascript:if(confirm('确认是否删除此新闻？')) location='<%=request.getContextPath() %>/servlet/DeleteServlet?id=${news.id }'">删除</a>
		                		</td>
		                 	</tr> 
                 		</c:forEach>
                </tbody>
            </table>
           <%//原来的分页条 %>
           <c:import url="rollpage.jsp">
           		<c:param name="totalCount" value="<%=Integer.toString(totalCount) %>"/>
           		<c:param name="pageIndex" value="<%=Integer.toString(pageIndex)  %>"/>
           		<c:param name="totalPage" value="<%=Integer.toString(totalPage) %>"/>
           </c:import>
        </div>
       </div>
   </div>
   </div>
<!-- </div> -->
<!--底部-->

</body></html>