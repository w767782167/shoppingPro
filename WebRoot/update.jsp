<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	#f1{
	display: inline-block;
	}
	#f2{
	display: inline-block;
	position: relative;
	left: -250px;
	}
	</style>
  </head>
  
  <body>
   <h2 style="color: red">${update }</h2>
   <h2 style="color: orange;">修改商品属性</h2>

	<form  id="f1" action="/shoppingPro/updateGoods1?id=${empleGoods.id }&path=${empleGoods.path}" method="post" enctype="multipart/form-data">
<!-- &name=${empleGoods.name }&price=${empleGoods.price }&costprice=${empleGoods.costprice }&property=${empleGoods.property }&packing=${empleGoods.packing }&stock=${empleGoods.stock }&bigtype_id=${empleGoods.bigtype_id }&path=${empleGoods.path }&website=${empleGoods.website }&edit_website=${empleGoods.edit_website }&goodsFrom=${empleGoods.goodsFrom }&introduce=${empleGoods.introduce } -->
		商品名称:&emsp;&emsp;<input type="text" name="name" size=50 required=required value="${empleGoods.name }"><br />
		<br /> 价格:&emsp;&emsp;&emsp;&emsp;<input type="text" required=required name="price" size=4 value="${empleGoods.price }"> 原价:<input
			type="text" name="costprice" required=required size=4 value="${empleGoods.costprice }"> 属性:<input type="text"
			name="property"  required=required placeholder="属性之间请用'/'隔开" value="${empleGoods.property }"><br />
		<br /> 包装:&emsp;&emsp;&emsp;&emsp;<input type="text" name="packing" required=required value="${empleGoods.packing }" placeholder="不同包装请用'/'隔开">
		库存:<input type="text" required=required name="stock" size=4 value="${empleGoods.stock }"><br />
		<br /> 分类编号:&emsp;&emsp;<input type="text" name="bigkind" size=4 value="${empleGoods.bigtype_id }">
		<%-- <select id="s1" onchange="getSeleteInput();" >
			<option value="请选择" selected="selected">请选择</option>
			<c:forEach items="${productDirs}" var="dir" varStatus="v">
				<option value="${dir.id}" ${1==dir.id?"selected='selected'
					":""} id="${dir.id} ">${dir.bigname} </option>
			</c:forEach>
			</select> --%>

		上传图片:<input style="width: 200px;height: 30px;" type="file"
			name="imgpath"><br />
			&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<img style="width: 100px;height: 100px;" src="${empleGoods.path} "
					alt="#gss#">
		<br /> 网页跳转地址:<input type="text" name="website" value="${empleGoods.website }"><br />
		<br /> 网页编辑地址:<input type="text" name="edit_website" value="${empleGoods.edit_website }"><br />
		<br /> <%-- <input type="hidden" name="token"
			value="${sessionScope.TOKEN_IN_SESSION }">--%> 店面品牌:&emsp;&emsp;<input
			type="text" required=required name="website" value="${empleGoods.goodsFrom }"><br /> 
		<br /> 商品介绍:&emsp;&emsp;<input type="text" required=required name="introduction" size=45 value="${empleGoods.introduce }"><br /> 
		<%-- <select id="s1">
			<option value="">请选择</option>
			<c:forEach items="${productDirs}" var="dir" varStatus="v">
				<option value="${dir.bigname}" ${1==dir.id?"selected='selected'
					":""} id="${dir.id} ">${dir.bigname}</option>
			</c:forEach> --%>
			<input type="hidden" name="h1"  value="${empleGoods.path }" id="seleteInput" >
				<input type="hidden" name="h2"  value="${empleGoods.id }" id="seleteInput" >
			 <br /> <input type="submit" value="朕要修改商品"
			style="width: 100px;height: 50px" ">
	</form>
	<form action="/shoppingPro/upload" id="f2">
	<input type="submit" value="点击返回"
			style="width: 100px;height: 50px" ">
	</form>
  </body>
</html>
