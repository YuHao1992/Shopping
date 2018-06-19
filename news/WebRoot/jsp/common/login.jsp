<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function validate(){
		//验证
		var userCode = document.getElementById("userCode").value;
		var userPassword = document.getElementById("userPassword").value;
		var userCodeSpan = document.getElementById("userCodeSpan");
		var userPasswordSpan = document.getElementById("userPasswordSpan");
		var flag = true;
		if(userCode == null  || userCode == ''){
			userCodeSpan.innerHTML = "请输入用户名";
			flag = false;
		}
		if(userPassword == null || userPassword == ''){
			userPasswordSpan.innerHTML = "请输入密码";
			flag = false;
		}
		//提交
		var actionForm = document.getElementById("actionForm");
		if(flag){
			actionForm.submit();
		}
		
	}
  </script>


<body>
		<form  action="${pageContext.request.contextPath }/login.do"  name="actionForm" id="actionForm"  method="post" >
			<dl>
				<dt>用户名：</dt>
				<dd><input type="text" id="userCode" name="userCode"/> <span id="userCodeSpan"></span> </dd>
				<dt>密　码：</dt>
				<dd><input type="password"  id="userPassword" name="userPassword"/><span id="userPasswordSpan"></span></dd>
			</dl>
			<div class="buttons">
			    ${error }
				<input type="button"   value="登录系统" onclick="validate();" />
				<input type="reset"  value="重　　填" class="input-button" />
			</div>
		</form>


</body>
</html>