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
<title>My JSP 'chart3.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
<script src="${pageContext.request.contextPath}/js/highcharts.js"></script>
<script src="${pageContext.request.contextPath}/js/highstock.js"></script>
<script type="text/javascript">
	$(function() {
		refresh();
		setInterval("refresh()", 5000);
	});
	function refresh() {
	
		$.post('data_listmap.action', function(result) //回传函数
		{
			var result = eval('(' + result + ')');
			var data1 = [];
			var data2 = [];
			var data3 = [];
			var data4 = [];
			var data5 = [];
			var category = [];
			$.each(result.gdata, function(index, json) {
				data1.push(json.shidu * 1);
				data2.push(json.voice * 1);
				data3.push(json.wendu * 1);
				data4.push(json.yanwu * 1);
				data5.push(json.fire * 1);
				category.push(json.data_time);
			});
				
			$('#tempcontainer').highcharts({
				title : {
					text : '数据展示',
					x : -20
				},
				xAxis : {
					categories : category
				},
				yAxis : {
					title : {
						text : '湿度'
					},
					title : {
						text : '声音'
					},
					title : {
						text : '温度'
					},
					title : {
						text : '烟雾'
					},
					title : {
						text : '火焰'
					},
					plotLines : [ {
						value : 0,
						width : 1,
						color : '#808080'
					} ]
				},
				tooltip : {
					valueSuffix : ''
				},
				legend : {
					layout : 'vertical',
					align : 'right',
					verticalAlign : 'middle',
					borderWidth : 0
				},
				series : [ {
					name : '湿度',
					data : data1
				}, {
					data : data2,
					name : '声音'
				}, {
					data : data3,
					name : '温度'
				}, {
					data : data4,
					name : '烟雾'
				}, {
					data : data5,
					name : '火焰'
				} ]
			});
		});
	};
</script>
<body>
	<h4>图表展示</h4>
	<hr>
	<div class="container"></div>
	<div id="tempcontainer"
		style="margin: 0px; padding: 0px; min-width: 100%; height: 300px"></div>
</body>
</html>
