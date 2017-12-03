<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@page import ="com.java1234.action.*"%>
      <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	function checkForm(){
		var userName=$("#userName").val();
		var password=$("#password").val();
		var rePassWord=$("#rePassWord").val();
		var mobile=$("#mobile").val();
		var address=$("#address").val();
		
		if(userName==""){
			$("#error").html("用户名不能为空！");
			return false;
		}
		if(password==""){
			$("#error").html("密码不能为空！");
			return false;
		}
		if(rePassWord==""){
			$("#error").html("确认密码不能为空！");
			return false;
		}
		if(password!=rePassWord){
			$("#error").html("确认密码和密码不一致，请重新输入！");
			return false;
		}
		if(mobile==""){
			$("#error").html("手机号码不能为空！");
			return false;
		}
		if(address==""){
			$("#error").html("收货地址不能为空！");
			return false;
		}
		return true;
	}

	function checkUserName(userName){
		if($("#userName").val()==""){
			$("#userErrorInfo").html("用户名不能为空！");
			$("#userName").focus();
			return;
		}
		$.post("user_existUserWithUserName.action",{userName:userName},
				function(result){
					var result=eval('('+result+')');
					if(result.exist){
						$("#userErrorInfo").html("用户名已存在，请重新输入！");
						$("#userName").focus();
					}else{
						$("#userErrorInfo").html("");
					}
				}
		);
	}
</script>
</head>
<body>
<center>
<%-- <div id="header" class="wrap">
	<jsp:include page="common/top.jsp"/>
</div> --%>

<div id="register" class="wrap">
	<div class="shadow">
		<em class="corner lb"></em>
		<em class="corner rt"></em>
		<div class="box">
			<h1>欢迎注册健身房管理系统</h1>
			<ul class="steps clearfix">
				<li class="current"><em></em>填写注册信息</li>
				<li class="last"><em></em>注册成功</li>
			</ul>
			<form id="regForm" method="post" action="user_register.action" onsubmit="">
				<table>				
					
					<tr>
						<td class="field">用户名(*)：</td>
						<td><input class="text" type="text" id="userName" name="user.userName" onblur="checkUserName(this.value)" />&nbsp;<font id="userErrorInfo" color="red"></font></td>
					</tr>
					<tr>
						<td class="field">登录密码(*)：</td>
						<td><input class="text"  type="password" id="password" name="user.password"   /></td>
					</tr>
					<tr>
						<td class="field">确认密码(*)：</td>
						<td><input class="text" type="password"  id="rePassWord"  name="rePassWord" /></td>
					</tr>
					
					<tr>
						<td class="field">性别(*)：</td>
						<td>
					    <input type="radio"   name="user.sex" value="男" checked="checked"/>男&nbsp;&nbsp;
					    <input type ="radio" name="user.sex" value="女"/>女					    					    
					    </td>						
					</tr>
					<tr>
						<td class="field">出生日期：</td>
						<td>
							<input  type="text"  id="birthday"  name="user.birthday"  class="Wdate" onClick="WdatePicker()"/>	
						</td> 
					</tr>
					<tr>
						<td class="field">身份证号：</td>
						<td><input class="text" type="text" id="dentityCode" name="user.dentityCode"  /></td>
					</tr>
					<tr>
						<td class="field">Email：</td>
						<td><input class="text" type="text" id="email" name="user.email"  /></td>
					</tr>
					<tr>
						<td class="field">手机号码(*)：</td>
						<td><input class="text" type="text" id="mobile" name="user.mobile" /></td>
					</tr>
					<tr>
						<td class="field">收获地址(*)：</td>
						<td><input class="text" type="text" id="address" name="user.address" /></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-green"><input type="submit" name="submit" value="提交注册" /></label></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><font id="error" color="red"></font> </td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>

<%-- <div id="footer">
	<jsp:include page="common/footer.jsp"/>
</div> --%>
</center>
</body>
</html>