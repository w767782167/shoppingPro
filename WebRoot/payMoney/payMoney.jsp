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
    
    <title>支付界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <!-- <link rel="stylesheet" href="./AmazeUI-2.4.2/assets/css/amazeui.css" /> -->
	<link href="./css/AdminLogin.css" rel="stylesheet" type="text/css">
	
	<style type="text/css">
	body{
	/* background-color: red; */
	background-color: white;
}


/*外部*/
#top img{
	margin-left: 160px;
}

#content{
	background-color: #F08080;
	height: 450px;
}

#content img{
	display: inline-block;
	margin-left: 150px;
}
#panel{
	margin-top:20px;
	position:absolute;
	height:350px;
	width:300px;
	margin-left: 90px;
	background-color: white;
	border: 1px solid #ddd;
	display:inline-block;
	padding: 20px;
	border-radius:5px; 	
}

#panel h3{
	text-align: center;
	margin-top: -6px;
}
/*账号和密码   输入框 */
#panel .group input{
	display: block;
	width: 300px;
	height: 42px;
	padding-left: 8px;
	margin-top:8px;
	border: 1px solid #ddd;
	font-size: 15px;
}
#panel .group1 #lab1{
	margin-top: 20px;
	font-size: 16px;
}
#panel .group1 input{
    
	margin-top: 20px;
}
#panel img{
	margin-top:-40px;
	margin-left: 150px;
}

#panel .group input:focus{
	outline: none;
	border-left-color: #CC865E;
}
/*账户和密码  文字  */
#panel .group label{
	display: block;
	text-align: left;
	font-size: 17px;
}

/*登录  */
#content .login{
	margin-top: 20px;
}

#content .login input{
	font-size: 18px;
	border:0;
	height: 38px;
	width: 300px;
	background-color: #1E90FF;
}
#content .login input:hover{
	background-color: white;
	color: #CC865E;
	border: 1px solid #CC865E;
	cursor: pointer;
}
/*注册  */
#content .reg{
	margin-top: 20px;
	text-align: center;
}
#content .reg a{
	text-decoration: none;
}
#content .reg  a{
    color: white;
	font-size: 15px;
	height: 33px;
	border: 0px;
	width: 180px;
	background-color: #466BAF; 
}
#content .reg  a:hover{
	background-color: white;
	color: #466BAF;
	border: 1px solid #466BAF;
	cursor: pointer;
}

.footer .footer-hd{
	margin-left: 50px;
}

.footer .footer-hd a{
	text-decoration: none;
	font-size: 13px;
	color:gray;
}

.footer .footer-hd b{
	font-size: 13px;
	color:gray;
}

hr{
	margin-left: 30px;
}

.footer .footer-bd {
	margin-left: 50px;
}

.footer .footer-bd a{
	text-decoration: none;
	font-size: 13px;
	color:black;
}
.footer .footer-bd em{
	font-size: 13px;
		color:gray;
}
	
	</style>

  </head>
  
  <body>
    <!--最外层  -->
    <form action="/shoppingPro/payServlet"  method="post">
    <div id="top">
    <img alt="加载失败" src="./images/logobig.png">
    </div>
    <div id="content">
     <img alt="##" src="./images/big.jpg"> 
    	<!--面板  -->
    	<div id="panel">
    	    <h3>支付界面</h3>
    		<!--商品订单号  -->
    		<div class="group">
    		<label>商品订单号:</label>
    		<input id="p1" type="text" value="${sessionScope.SESSION_IN_ORDERNUM}" name="p2_Order">
    		</div>
    		<!--支付金额  -->
    		<div class="group">
    		<label>支付金额:</label>
    		<input id="p2" type="text" placeholder="请输入金额" name="p3_Amt">
    		</div>
    		<div class="group1">
    		<label id="lab1">银行选择:</label><br/>
    		中国农业银行<input type="radio" name="pd_FrpId" value="ABC-NET-B2C">&emsp;&emsp;
    		建设银行<input type="radio" name="pd_FrpId" value="CCB-NET-B2C"><br/>
    		</div>
    		
    		<!--登录  -->
    		<div class="login">
    		     <input type="submit" value="支付">
    		</div>
    		
    	</div>
    </div>

    </form>
        <div class="footer ">
		<div class="footer-hd ">
			<p>
				<a href="# ">恒望科技</a>
				<b>|</b>
				<a href="# ">商城首页</a>
				<b>|</b>
				<a href="# ">支付宝</a>
				<b>|</b>
				<a href="# ">物流</a>
			</p>
		</div>
		<hr/>
			<div class="footer-bd ">
			  <p>
				   <a href="# ">关于恒望</a>
				   <a href="# ">合作伙伴</a>
				   <a href="# ">联系我们</a>
				  <a href="# ">网站地图</a>
				 <em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></em>
			  </p>
			</div>
    </div>
  </body>
</html>
