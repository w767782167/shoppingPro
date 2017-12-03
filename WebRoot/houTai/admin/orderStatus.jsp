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
    
    <title>My JSP 'orderStatus.jsp' starting page</title>
    
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
			width: 100%;
			
		}
		th{
			text-align: center;
		}
		td{
			text-align: center;
			font-size: 14px;
		}
	</style>
  </head>
  
  <body>
  <div id="sou">
  	<form  action="/shoppingPro/statusupdate1" method="post">
  		<label>订单号:</label>
  		<input type="text" name="orderNum" value="" />&emsp;&emsp;
  		<label>收货人:</label>
  		<input type="text" name="consigneeName" value=""/>&emsp;&emsp;
  		<label>发货状态:</label>
  		<select name="info">
  			<option value="0">待审核</option>
  			<option value="1">卖家已发货</option>
  		</select> &emsp;
  		<input id="find" type="submit" value="修改"/>
  	</form>
  	</div>
    <table border="1"  cellpadding="0" cellspacing="0" >
    	<tr style="background-color:orange;">
    	  <th>编号</th>
    	  <th>订单号</th>
    	  <th>收货人</th>
    	  <th>收货人电话</th>
    	  <th>收货地址</th>
    	  <th>物流方式</th>
    	  <th>商品图片</th>
    	  <th>商品名称</th>
    	  <th>属性</th>
    	  <th>包装</th>
    	  <th>数量</th>
    	  <th>状态</th>
    	  <th>卖家留言</th>
    	  <th>下单时间</th>
    	
    	</tr>
    	<c:forEach items="${orderItem1}" var="pro" varStatus="vs">
    		<tr style="background-color: ${vs.count%2==0?'pink':''}">
    	     <td>${pro.id}</td>
    	     <td>${pro.orderNum}</td>
    	     <td>${pro.consignee}</td>
    	     <td>${pro.consigneeTel}</td>
    	     <td>${pro.adress}</td>
    	     <td>${pro.logistics}</td>
    	     <td><img alt="加载失败" src="${pro.productImg}" style="width: 100px;height:100px"> </td>
    	     <td>${pro.productName}</td>
    	     <td>${pro.property}</td>
    	     <td>${pro.packing}</td>
    	     <td>${pro.number}</td>
    	     <td> 
    	     <c:choose>
    	     		<c:when test="${pro.info==0}">待审核</c:when>
    	     		<c:when test="${pro.info==1}">卖家已发货</c:when>
    	     		<c:when test="${pro.info==2}">待付款</c:when>
    	     	</c:choose>
    	     </td>
    	     <td>${pro.message}</td>
    	     <td>${pro.orderDate}</td>
    	</tr>
    	</c:forEach> 
    </table>
  </body>
</html>
