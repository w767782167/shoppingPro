<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'show.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	
	//设置页面大小
	   function setPageSize(currentPage){
	     var pageSize =document.getElementById("selectPageSize").value;
	        //将当前页面的值 存放在高级查询表单隐藏域中
	     document.getElementById("pageSizeInput").value=pageSize;
	     document.getElementById("currentPageInput").value=currentPage;
	      //提交高级查询的表单
	     document.getElementById("advanceFrom").submit();
	       
	      
	   } 
	    function del(){
	   var msg="确认删除吗";
	   if(confirm(msg)==true){
	   return true;
	   }else{
	   return false;
	   }
	   }
	   
	   
	   function goPage(currentPage,pageSize){
	      
	      //将当前页面的值 存放在高级查询表单隐藏域中
	      document.getElementById("currentPageInput").value=currentPage;
	        document.getElementById("pageSizeInput").value=pageSize;
	      
	      //提交高级查询的表单
	      document.getElementById("advanceFrom").submit();
	   }
	   
	   function setCurrentPage(pageSize){
	     var currentPage = document.getElementById("jumpPage").value;
	    //将当前页面的值 存放在高级查询表单隐藏域中
	      document.getElementById("currentPageInput").value=currentPage;
	      document.getElementById("pageSizeInput").value=pageSize;
	      //提交高级查询的表单
	      document.getElementById("advanceFrom").submit();
	   }
	</script>
	<style type="text/css">
	#f1{
	display: inline-block;
	}
	</style>

</head>

<body>

<h1 style="color: red">${re }</h1><h1 style="color: red">${add }</h1><h1 style="color: red">${delete }</h1>
	<form action="/shoppingPro/upload" method="post" id="advanceFrom">
	
		<input type="hidden" name="currentPage" id="currentPageInput"> <input
			type="hidden" name="pageSize" id="pageSizeInput"> 商品名称:<input type="text"
			name="productName" value="${op.productName}"> 价格:<input
			type="text" name="minPrice" value="${op.minPrice}"> -- <input
			type="text" name="maxPrice" value="${op.maxPrice}">     
			 商品分类：<select name="dir_id">
          <option value="-1">--请选择--</option>
         <c:forEach items="${dirs}" var="dir">
            <option value="${dir.id}" ${op.dir_id==dir.id?"selected='selected'":""}>${dir.bigName}</option>
         </c:forEach>
      
      </select>
       <input type="submit" value="查询">

	</form>
	
	<form id="f1" action="/shoppingPro/addRecommend" method="get" target = '_blank'><input type="submit" value="添加图片至<今日推荐>" ></form>
	<form id="f1" action="/shoppingPro/addActivities" method="get" target = '_blank'><input type="submit" value="添加图片至首页<活动>" ></form>
	<form id="f1" action="/shoppingPro/addDessert" method="get" target = '_blank'><input type="submit" value="添加图片至首页<甜品>" ></form>
	<form id="f1" action="/shoppingPro/addNuts" method="get" target = '_blank'><input type="submit" value="添加图片至首页<坚果>" ></form>
	<form id="f1" action="/shoppingPro/addAllGoods" method="get" target = '_blank'><input type="submit" value="添加图片至首页<全部>" ></form>
	<table border="1" width="75%" cellspacing="0" cellpadding="0">
      <tr style="background-color: orange">
			<th>商品编号</th>
			<th>商品名称</th>
			<th>价格</th>
			<th>原价</th>
			<th>属性</th>
			<th>包装</th>
			<th>库存</th>
			<th>分类编号</th>
			<th>图片</th>
			<th>网页跳转地址</th>
			<th>网页编辑地址</th>
			<th>店面品牌</th>
			<th>商品介绍</th>
			<th>上传时间</th>
			<th width="40px">操 作</th>

		</tr>
		<c:forEach items="${pageResult.listData}" var="item" varStatus="">
			<tr>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td>${item.price}</td>
				<td>${item.costprice}</td>
				<td>${item.property}</td>
				<td>${item.packing}</td>
				<td>${item.stock}</td>
				<td>${item.bigtype_id}</td>
				<td><img style="width: 100px;height: 100px;" src="${item.path} "
					alt="#gss#">
				</td>
				<td><a href="/shoppingPro/home/introduction.jsp?website=${item.website}">${item.website}</a></td>
				<td><a href="/shoppingPro/home/introduction.jsp?website=${item.edit_website}">${item.edit_website}</a></td>
			
				<td>${item.goodsFrom}</td>
				<td>${item.introduce}</td>
				<td>${item.createTime}</td>
				<td><a href="/shoppingPro/deleteGoods?id=${item.id 

}" id="delete" onclick="javascript:return del()">删 除</a><a style="text-decoration: none;" href="/shoppingPro/updateGoods?id=${item.id}">编 辑</a><a style="text-decoration: none;" href="/shoppingPro/tiaozhuan">添 加</a></td>



			</tr>

		</c:forEach>
	</table>
	
	
	<div>

		一共${pageResult.totalCount}条数据
		<%--              <c:choose>
                <c:when test="${pageResult.currentPage>pageResult.totalPage}">当前页${pageResult.totalPage}/${pageResult.totalPage} </c:when>
               
                </c:choose>  --%>

		当前页${pageResult.currentPage}/${pageResult.totalPage} <a
			href="javascript:goPage(1,${pageResult.pageSize})" style="text-decoration: none;">首页</a> <a
			href="javascript:goPage(${pageResult.prePage},${pageResult.pageSize})" style="text-decoration: none;">上一页</a>

		<c:forEach begin="${pageResult.index.beginIndex}"
			end="${pageResult.index.endIndex}" var="index">

			<c:if test="${index==pageResult.currentPage}">
				<span style="color:red;">${index}</span>
			</c:if>
			<c:if test="${index!=pageResult.currentPage}">
				<a href="javascript:goPage(${index},${pageResult.pageSize})">${index}</a>
			</c:if>



		</c:forEach>

		<a
			href="javascript:goPage(${pageResult.nextPage},${pageResult.pageSize})" style="text-decoration: none;">下一页</a>
		<a
			href="javascript:goPage(${pageResult.totalPage},${pageResult.pageSize})" style="text-decoration: none;">尾页</a>
		<form action="/shoppingPro/upload" id="pageSizeForm" method="post">
			每页显示： <select name="pageSize" id="selectPageSize"
				onchange="setPageSize(${pageResult.currentPage});">
				<option ${pageResult.pageSize==3? "selected='selected'":""}>3</option>
				<option ${pageResult.pageSize==5? "selected='selected'":""}>5</option>
				<option ${pageResult.pageSize==8? "selected='selected'":""}>8</option>
				<option ${pageResult.pageSize==10? "selected='selected'":""}>10</option>
			</select> 条数据 <br /> 跳转到第<input type="number" id="jumpPage" name="currentPage"
				min="1" max="${pageResult.totalPage}"
				value="${pageResult.currentPage}">页
			<!-- <input type="submit" value="GO" > -->
			<input type="button" value="GO"
				onclick="setCurrentPage(${pageResult.pageSize});">

		</form>
	</div>
	<!--分页结束  -->
</body>
</html>
