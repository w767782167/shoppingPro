<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
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

<title>My JSP 'alert.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>

<script language="javascript">

	var flag2= false;
	
	function dowith(message) {
		$.post(
		"Res_resMessage.action",
		{
			message : message
		},
		function(result) {
			var result = eval('(' + result + ')');
			if (result.error) {
				alert(result.error);
			} else {
				window.location.href = "${pageContext.request.contextPath}/alert.jsp";
			}
		});
	}
	function switchBut2() {
		dowith(flag2 ? 'ff' : 'fn');
		if(flag2) {
			$('#img3').toggle();
			$('#img4').toggle();
		}
		else {
			$('#img3').toggle();
			$('#img4').toggle();
		}
		
		flag2 = !flag2;
		
	}
</script>

</head>

<body>
	<div align="center">
		<img id="img3" src="images/fn.png"
			onclick="switchBut2()"
			style=" width:50px; height:50px;  border:0; background:images/ln.png no-repeat left top">
		<img id="img4" src="images/ff.png"
			onclick="switchBut2()"
			style="display:none; width:50px; height:50px;  border:0; background:images/ln.png no-repeat left top">&nbsp;&nbsp;&nbsp;

	</div>
</body>
</html>
