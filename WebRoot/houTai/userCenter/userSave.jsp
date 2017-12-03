<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkForm(){
		 var trueName=$("#trueName").val();
		 var password=$("#password").val();
		 var birthday=$("#birthday").val();
		 var mobile=$("#mobile").val();
		 var address=$("#address").val();
		 var dentityCode=$("#dentityCode").val();
		 var email=$("#email").val();
		 if(trueName==""){
			 $("#error").html("姓名不能为空！");
			 return false;
		 }
		 if(password==""){
			 $("#error").html("密码不能为空！");
			 return false;
		 }
		 if(birthday==""){
			 $("#error").html("出生日期不能为空！");
			 return false;
		 }
		 if(mobile==""){
			 $("#error").html("手机号码不能为空！");
			 return false;
		 }
		 if(address==""){
			 $("#error").html("送货地址不能为空！");
			 return false;
		 }
		 if(dentityCode==""){
			 $("#error").html("身份证不能为空！");
			 return false;
		 }
		 if(email==""){
			 $("#error").html("邮件不能为空！");
			 return false;
		 }
	}
</script>
</head>
<body>
<h2>修改用户</h2>
<div class="manage">
	<form action="user_save.action" method="post" onsubmit="return checkForm()">
		<table class="form">
			<tr>
				<td class="field">用户名：</td>
				<td><input type="text" class="text" name="user.userName"   value="${user.userName }" readonly="readonly" /></td>
			</tr>
			<tr>
				<td class="field">姓名：</td>
				<td><input type="text" class="text"  id="trueName" name="user.trueName" value="${user.trueName }" /></td>
			</tr>
			<tr>
				<td class="field">密码：</td>
				<td><input type="text" class="text" id="password" name="user.password" value="${user.password }" /></td>
			</tr>
			<tr>
				<td class="field">性别：</td>
				<td>
					<c:choose>
						<c:when test="${user.sex=='男' }">
							<input type="radio" name="user.sex"  value="男" checked="checked" />男 <input type="radio" name="user.sex" value="女" />女
						</c:when>
						<c:otherwise>
							<input type="radio" name="user.sex"  value="男"  />男 <input type="radio" name="user.sex" value="女"  checked="checked"/>女
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td class="field">出生日期：</td>
				<td>
					<input  type="text"  id="birthday"  name="user.birthday" value="<fmt:formatDate value="${user.birthday }" type="date" pattern="yyyy-MM-dd"/>"  class="Wdate" onClick="WdatePicker()"/>	
				</td>
			</tr>
			<tr>
				<td class="field">手机号码：</td>
				<td><input type="text" id="mobile" class="text" name="user.mobile" value="${user.mobile }" /></td>
			</tr>
			<tr>
				<td class="field">送货地址：</td>
				<td><input type="text" class="text"  id="address" name="user.address" value="${user.address }" /></td>
			</tr>
			<tr>
				<td class="field">身份证号：</td>
				<td><input class="text" type="text" id="dentityCode" name="user.dentityCode"  value="${user.dentityCode }" /></td>
			</tr>
			<tr>
				<td class="field">Email：</td>
				<td><input class="text" type="text" id="email" name="user.email"  value="${user.email}" /></td>
			</tr>
			<tr>
				<td>
				    <input type="hidden"  name="user.id" value="${user.id }"/>
					<input type="hidden"  name="user.status" value="${user.status }"/>
				</td>
				<td><label class="ui-blue"><input type="submit" name="submit" value="更新" /></label></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><font id="error" color="red"></font> </td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>