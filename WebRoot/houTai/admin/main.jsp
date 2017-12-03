<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/houTai/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/houTai/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/houTai/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/houTai/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/houTai/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
	var url;
	
	function openTab(text,url,iconCls){
		if($("#tabs").tabs("exists",text)){
			$("#tabs").tabs("select",text);
		}else{
			var content="<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='/shoppingPro"+url+"'></iframe>";

			$("#tabs").tabs("add",{
				title:text,
				iconCls:iconCls,
				closable:true,
				content:content
			});
		}
	}
	
	
	
	function openPasswordModifyDialog(){
		$("#dlg").dialog("open").dialog("setTitle","修改密码");
		url="user_modifyPassword.action?user.id=${sessionScope.USER_IN_SESSION.id}";
	}
		 function openPasswordModifyDialogs(){
		$("#dlg").dialog("open").dialog("setTitle","修改密码");
		url="MyJsp.jsp";
	} 
	
	function closePasswordModifyDialog(){
		$("#dlg").dialog("close");
		$("#oldPassword").val("");
		$("#newPassword").val("");
		$("#newPassword2").val("");
	}
	
	function modifyPassword(){
	//alert(11111);
	    var admin=$("#userName").val();
	    var pwd=$("#newPassword").val();
		$("#fm").form("submit",{
			url:"/shoppingPro/modifyPwd?admin="+admin+"&pwd="+pwd,
			onSubmit:function(){
				var oldPassword=$("#oldPassword").val();
				var newPassword=$("#newPassword").val();
				var newPassword2=$("#newPassword2").val();
				if(!$(this).form("validate")){
					return false;
				}
				if(oldPassword!='${sessionScope.USER_IN_SESSION.password}'){
					$.messager.alert("系统提示","用户密码输入错误！");
					return false;
				}
				if(newPassword!=newPassword2){
					$.messager.alert("系统提示","确认密码输入错误！");
					return false;
				}
				return true;
			},
			success:function(result){
				var result=eval('('+result+')');
				if(result.success){
					$.messager.alert("系统提示","密码修改成功，下一次登录生效！");
					closePasswordModifyDialog();
				}else{
					$.messager.alert("系统提示","密码修改失败");
					return;
				}
				
			}
			
		});
		$("#fm").submit();
	}
	
	function logout(){
		$.messager.confirm("系统提示","您确定要退出系统吗",function(r){
			if(r){
				//window.location.href="../login.jsp";
				//window.location.href="/shoppingPro/home/home.jsp";
				window.location.href="/shoppingPro/modifyPwd?cmd=exit";
			}
		});
	}
	
	function refreshSystem(){
		$.post("sys_refreshSystem.action",{},function(result){
			if(result.success){
				$.messager.alert("系统提示","已成功刷新系统缓存！");
			}else{
				$.messager.alert("系统提示","刷新系统缓存失败！");
			}
		},"json");
	}
</script>
</head>
<body class="easyui-layout">
<div region="north" style="height: 78px;background-color: #E0ECFF">
	<table style="padding: 5px" width="100%">
		<tr>
			<td width="50%">
			<h1 ><font color="blue">桔子商城后台管理系统</font></h1>
				<%-- <img src="${pageContext.request.contextPath}/images/bglogo.png"/> --%>
			</td>
			<td valign="bottom" align="right" width="50%">
				<font size="3">&nbsp;&nbsp;<strong>欢迎：</strong>【${sessionScope.USER_IN_SESSION.admin}】  登录</font>
			</td>
		</tr>
	</table>
</div>
<div region="center">
	<div class="easyui-tabs" fit="true" border="false" id="tabs">
		<div title="首页" data-options="iconCls:'icon-home'">
			<div align="center" style="padding-top: 100px"><font color="red" size="10">欢迎使用桔子商城管理系统</font></div>
		</div>
	</div>
</div>
<div region="west" style="width: 200px" title="导航菜单" split="true">
	<div class="easyui-accordion" data-options="fit:true,border:false">
	<c:if test="">
		<div title="用户管理" data-options="selected:true,iconCls:'icon-user'" style="padding: 10px">
			<a href="javascript:openTab('用户管理','userManage.jsp','icon-user')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 150px;">管理用户</a>
		</div>
	</c:if>
	<c:choose>
		<c:when test="">
	
		<div title="数据收集与管理"  data-options="iconCls:'icon-product'" style="padding:10px;">
			<a href="javascript:openTab('数据显示','dataManage.jsp','icon-product')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 150px;">数据显示1</a>
			<a href="javascript:openTab('数据显示2','dataManage2.jsp','icon-product')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 150px;">数据显示2</a>
		</div>
		
		</c:when>
					<c:otherwise>
		
		<c:if test="">
		<div title="数据收集与管理"  data-options="iconCls:'icon-product'" style="padding:10px;">
			<a href="javascript:openTab('数据显示','dataManage.jsp','icon-product')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 150px;">数据显示1</a>
		</div>
		</c:if>
		
		<c:if test="">
		<div title="数据收集与管理"  data-options="iconCls:'icon-product'" style="padding:10px;">
			<a href="javascript:openTab('数据显示','dataManage2.jsp','icon-product')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 150px;">数据显示2</a>
		</div>
		</c:if>
		
		</c:otherwise>
		</c:choose>
		
		
		
		<c:choose>
		<c:when test="">
	
		<div title="运动数据管理" data-options="iconCls:'icon-comment'" style="padding:10px">
			<a href="javascript:openTab('运动次数1','commentManage2.jsp','icon-comment')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 150px;">运动次数1</a>
			<a href="javascript:openTab('运动次数2','commentManage.jsp','icon-comment')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 150px;">运动次数2</a>
		</div>
		
		</c:when>
					<c:otherwise>
		
		<c:if test="">
		<div title="运动数据管理" data-options="iconCls:'icon-comment'" style="padding:10px">
			<a href="javascript:openTab('运动次数1','commentManage.jsp','icon-comment')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 150px;">运动次数1</a>
		</div>
		</c:if>
		
		<c:if test="">
		<div title="运动数据管理" data-options="iconCls:'icon-comment'" style="padding:10px">
			<a href="javascript:openTab('运动次数2','commentManage2.jsp','icon-comment')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 150px;">运动次数2</a>
		</div>
		</c:if>
		
		</c:otherwise>
		</c:choose>
		
		
		<c:choose>
		<c:when test="">
	
		<div title="图表管理" data-options="iconCls:'icon-comment'" style="padding:10px">
			<a href="javascript:openTab('图表1','chart1.jsp','icon-comment')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 150px;">图表1</a>
			<a href="javascript:openTab('图表2','chart2.jsp','icon-comment')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 150px;">图表2</a>
		</div>
		
		</c:when>
					<c:otherwise>
		
		<c:if test="">
		<div title="图表管理" data-options="iconCls:'icon-comment'" style="padding:10px">
			<a href="javascript:openTab('图表1','chart1.jsp','icon-comment')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 150px;">图表1</a>
		</div>
		</c:if>
		
		<c:if test="">
		<div title="图表管理" data-options="iconCls:'icon-comment'" style="padding:10px">
			<a href="javascript:openTab('图表2','chart2.jsp','icon-comment')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 150px;">图表2</a>
		</div>
		</c:if>
		
		</c:otherwise>
		</c:choose>

	

		<div title="添加商品" data-options="selected:true,iconCls:'icon-user'" style="padding: 10px">
			<a href="javascript:openTab('添加商品','/tiaozhuan','icon-user')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 150px;">添加商品</a> 
			
			<a href="javascript:openTab('管理商品','/upload','icon-user')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 150px;">管理商品</a>
		 </div>
		 
		 <div title="订单管理" data-options="selected:true,iconCls:'icon-user'" style="padding: 10px">
			<a href="javascript:openTab('订单查询','/orderquery','icon-user')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 150px;">订单查询</a> 
			
			<a href="javascript:openTab('订单状态','/orderstatus','icon-user')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 150px;">订单状态</a>
		 </div>

			<!-- <div title="订单管理" data-options="selected:true,iconCls:'icon-user'" style="padding: 10px">
			<a href="javascript:openTab('订单管理','/orderquery','icon-user')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 150px;">订单查询</a>
			<a href="javascript:openTab1('订单管理','/orderstatus','icon-user')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 150px;">订单状态</a>
			<a href="javascript:openTab('腿部锻炼','MyJsp2.jsp','icon-user')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 150px;">腿部锻炼</a> 
		</div> -->
		
			<div title="用户管理" data-options="selected:true,iconCls:'icon-user'" style="padding: 10px">
			<!-- <a href="javascript:openTab('订单管理','/orderquery','icon-user')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 150px;">订单查询</a>
			<a href="javascript:openTab('订单管理','/orderstatus','icon-user')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 150px;">订单状态</a> -->
			
		</div>
		<div title="公告管理" data-options="selected:true,iconCls:'icon-user'" style="padding: 10px">
			<a href="javascript:openTab('添加公告','/houTai/admin/noticeManage.jsp','icon-user')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 150px;">添加公告</a>
			<a href="javascript:openTab('查看公告','/houTai/admin/showNotice.jsp','icon-user')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 150px;">查看公告</a>
		</div>
		<div title="新闻管理" data-options="selected:true,iconCls:'icon-user'" style="padding: 10px">
			<a href="javascript:openTab('新闻管理','/houTai/admin/alert.jsp','icon-user')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 150px;">新闻管理</a>
			
		</div>
		<div title="系统管理"  data-options="iconCls:'icon-item'" style="padding:10px">
			<a href="javascript:openPasswordModifyDialog()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-modifyPassword'" style="width: 150px;">修改密码</a>
			<a href="javascript:logout()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-exit'" style="width: 150px;">安全退出</a>
			<a href="javascript:refreshSystem()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-refresh'" style="width: 150px;">刷新系统缓存</a>
		</div>
	</div>
</div>
<div region="south" style="height: 25px;padding: 5px;" align="center">
	版权所有 2014 Java知识分享网
</div>


<div id="dlg" class="easyui-dialog" style="width: 400px;height:220px;padding: 10px 20px"
  closed="true" buttons="#dlg-buttons">
 	<form  id="fm" method="post">
 		<table cellspacing="8px">
 			<tr>
 				<td>用户名：</td>
 				<td><input type="text" id="userName" name="user.userName" value="${sessionScope.USER_IN_SESSION.admin}" readonly="readonly" style="width: 200px"/></td>
 			</tr>
 			<tr>
 				<td>原密码：</td>
 				<td><input type="password" id="oldPassword" class="easyui-validatebox" required="true" style="width: 200px"/></td>
 			</tr>
 			<tr>
 				<td>新密码：</td>
 				<td><input type="password" id="newPassword" name="user.password" class="easyui-validatebox" required="true" style="width: 200px"/></td>
 			</tr>
 			<tr>
 				<td>确认新密码：</td>
 				<td><input type="password" id="newPassword2"  class="easyui-validatebox" required="true" style="width: 200px"/></td>
 			</tr>
 		</table>
 	</form>
</div>

<div id="dlg-buttons">
	<a href="javascript:modifyPassword()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
	<a href="javascript:closePasswordModifyDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>
</body>
</html>