<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!--  <Context docBase="D:\tomcat\apache-tomcat-7.0.57\webapps\upload\images" path="/pic" reloadable="false"/> -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'add.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	 function getOption(){
	     var s1 =document.getElementById("s1").value;
	        //将当前页面的值 存放在高级查询表单隐藏域中
	       var index=  s1.selectedIndex;
	       var text=s1.options[index].text;
	     
	  
	      
	   } 
	     function getSeleteInput(){
	    
	     var s1 = document.getElementById("s1").value;
	     document.getElementById("seleteInput").value=s1;
	    //将当前页面的值 存放在高级查询表单隐藏域中
	    
	   }
	   </script>
	     <style type="text/css">
    #f1{
	display: inline-block;
}
 #f2{
	display: inline-block;
	position: relative;
	left:-250px;
	 
}
#div1{
	border: 1px solid blue;
	width: 450px;
	height: 50px;
	padding: 10px;
	
	 
}
body{

 background-image: url("houTai/timg1.jpg") ; 
 background-size:cover; 

}
    
    </style>
    	<meta charset="utf-8"> 
	<title>Bootstrap 实例 - 基本表单</title>
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body >
	<%
		//生成随机数
		String token = UUID.randomUUID().toString();
		//把随机数放在session中
		request.getSession().setAttribute("TOKEN_IN_SESSION", token);
	%>
	<h2 style="color: orange">添加商品属性</h2>

	<form action="/shoppingPro/upload" method="post" enctype="multipart/form-data" id="f1" role="form">

		商品名称:&emsp;&emsp;<input type="text" name="name"  size=50 required=required><br />
		<br /> 价格:&emsp;&emsp;&emsp;&emsp;<input type="number" placeholder="请输入数字"  required=required name="price" size=4> 原价:<input
			type="number" placeholder="请输入数字" name="costprice" size=4> 属性:<input type="text"
			name="property" required=required placeholder="属性之间请用'/'隔开"><br />
		<br /> 包装:&emsp;&emsp;&emsp;&nbsp;&nbsp; <input type="text" required=required name="packing" placeholder="不同包装请用'/'隔开">
		库存:<input type="number" placeholder="请输入数字" required=required name="stock" size=4><br />
		<br /> 分类编号:&emsp;&emsp;<select id="s1"  onchange="getSeleteInput();" >
			<option value="请选择" selected="selected">请选择</option>
			<c:forEach items="${productDirs}" var="dir" varStatus="v">
				<option value="${dir.id}" ${1==dir.id?"selected='selected'
					":""} id="${dir.id} ">${dir.bigName} </option>
			</c:forEach>
			</select>

		上传图片:<input style="width: 200px;height: 30px; " id="f1" type="file"
			name="imgpath"><br />
		<br /> 网页跳转地址:<input type="text" name="website"><br />
		<br /> 网页编辑地址:<input type="text" name="website"><br />
		<br /> <input type="hidden" name="token"
			value="${sessionScope.TOKEN_IN_SESSION }" > 店面品牌:&emsp;&emsp;<input
			type="text" name="website" required=required><br />
		<br /> 商品介绍:&emsp;&emsp;<input type="text" required=required name="website" size=45><br /> 
		<%-- <select id="s1">
			<option value="">请选择</option>
			<c:forEach items="${productDirs}" var="dir" varStatus="v">
				<option value="${dir.bigName}" ${1==dir.id?"selected='selected'
					":""} id="${dir.id} ">${dir.bigName}</option>
			</c:forEach> --%>
			<input type="hidden" name="s1" size=5 value="1" id="seleteInput" >
			 <br /> <input class="btn btn-default" type="submit" value="添加商品"
			style="width: 100px;height: 50px" ">
	</form>
	<form action="/shoppingPro/upload" id="f2">
	<input type="submit" class="btn btn-default" value="商品管理"
			style="width: 100px;height: 50px;" >
	</form>
	
	<h2 style="color: red">${success }</h2>
	<h2 style="color: red">${re1 }</h2>
	<div id="div1">
	<form action="/shoppingPro/addKind" method="get"  class="form-inline" role="form">
		<div class="form-group">	商品种类:<input type="text" name="name" required="required" placeholder="添加商品种类"></div>
		<input class="form-control" type="hidden" name="token"
			value="${sessionScope.TOKEN_IN_SESSION }"> <input
			type="submit" class="btn btn-default" value="添加">
			</form>
			</div>
</body>
</html>
