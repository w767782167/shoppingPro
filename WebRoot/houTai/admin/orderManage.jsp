<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'orderManage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	    body{
	    	background-color:#EAEAEA;
	    }
		#sou{
			margin-top: 20px;
			margin-left:5px;
		}
		#find{
			background-color: #BEBEBE;
			width:55px;
			height:25px;
			border: 0px;
		}
		input{
		   border-radius: 3px;
		}
		table{
		    margin-left:5px;
			width: 90%;
			
		}
		th{
			text-align: center;
		}
		td{
			text-align: center;
		}
	</style>
  </head>
  
  <body>
  <div id="sou">
  	<form  action="/shoppingPro/advancedquery" method="post">
  		<label>订单号:</label>
  		<input type="text" name="orderNum" value="" />&emsp;&emsp;
  		<label>订单人:</label>
  		<input type="text" name="userName" value=""/>&emsp;
  		<input id="find" type="submit" value="搜索"/>
  	</form>
  	</div>
    <table border="1"  cellpadding="0" cellspacing="0" >
    	<tr style="background-color:orange;">
    	  <th>编号</th>
    	  <th>订单号</th>
    	  <th>订单人ID</th>
    	  <th>订单人用户名</th>
    	  <th>创建时间</th>
    	  <th>总金额</th>
    	  <th>支付方式</th>
    	  <th>订单状态</th>
    	</tr>
    	<c:forEach items="${orderItem}" var="pro" varStatus="vs">
    		<tr style="background-color: ${vs.count%2==0?'pink':''}">
    	     <td>${pro.id}</td>
    	     <td>${pro.orderNum}</td>
    	     <td>${pro.userId}</td>
    	     <td>${pro.userName}</td>
    	     <td>${pro.orderDate}</td>
    	     <td>${pro.totalPrice}</td>
    	     <td>${pro.pay}</td>
    	     <td>
    	     <c:choose>
    	     		<c:when test="${pro.info==0}">待审核</c:when>
    	     		<c:when test="${pro.info==1}">卖家已发货</c:when>
    	     		<c:when test="${pro.info==2}">待付款</c:when>
    	     	</c:choose>
    	     </td>
    	     
    	</tr>
    	</c:forEach> 
    </table>
  </body>
</html>
