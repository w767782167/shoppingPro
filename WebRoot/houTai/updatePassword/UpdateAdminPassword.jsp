<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AdminLogin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <!-- <link rel="stylesheet" href="./AmazeUI-2.4.2/assets/css/amazeui.css" /> -->
	
	<style type="text/css">
			body{
	/* background-color: red; */
	background-color: white;
}


/*外部*/
#top img{
	margin-left: 80px;
}

#content{
	background-color: #F08080;
	height: 490px;
}

#content img{
	display: inline-block;
	margin-left: 80px;
	margin-top: 25px;
}
#panel{
	margin-top:20px;
	position:absolute;
	height:430px;
	width:300px;
	margin-left: 20px;
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
	font-size: 20px;
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
	font-size: 18px;
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
 
 <script type="text/javascript">
 	function checkPassword(){
 		var password1=document.getElementById("p4").value;
 		var password2=document.getElementById("p3").value;
 		if(password1==""||password2==""){
 			alert("输入密码不能为空");
 		}else{
 			if(password1!=password2){
 			   alert("两次输入的密码不一致");
 			   return false;
 		     }else{
 		     	return true;
 		     }
 		}
 		
 	}
 	
 	function checkOldPassword(){
 	    var password1=document.getElementById("po8").value;
 		var password0=document.getElementById("p0").value;
 		if(password1==""){
 			alert("输入密码不能为空");
 		}else{
 			if(password1!=password0){
 			   alert("输入的原密码不正确");
 		     }
 		}
 	}
 </script>
  
  </head>
  
  <body>
    <!--最外层  -->
    <form action="/shoppingPro/updatePassword" onsubmit="return checkPassword()" method="post">
    <div id="top">
   <img alt="加载失败" src="./images/logobig.png"> 
    </div>
    <div id="content">
      <img alt="##" src="./images/big.jpg">  
    	<!--面板  -->
    	<div id="panel">
    	    <h3>修改密码</h3>
    	    <span style="color: red;">${Msg}</span>
    		<!--账号  -->
    		<div class="group">
    		<label>用户名:</label>
    		 <input id="p0" type="hidden" value="${sessionScope.USER_IN_SESSION.password}">
    		<input id="p1" type="text" value="${sessionScope.USER_IN_SESSION.admin}" name="username">
    		</div>
    		<!--密码  -->
    		<div class="group">
    		<label>原密码:</label>
    		 <input id="po8" type="password" placeholder="请输入原密码" name="password" onblur="checkOldPassword()" >
    		</div>
    		<div class="group">
    		<label>新密码:</label>
    		<input id="p3" type="password" name="password1" placeholder="请输入新密码" >
    		</div>
    		<div class="group">
    		<label>确认新密码:</label>
    		<input id="p4" type="password" name="password2" placeholder="请输入新密码" onblur="checkPassword()">
    		</div>
    		
    		<!--修改  -->
    		<div class="login">
    		     <input type="submit" value="修改">
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
