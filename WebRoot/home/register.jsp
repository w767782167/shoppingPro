<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

	<head lang="en">
		<meta charset="UTF-8">
		<title>注册</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp" />

		<link rel="stylesheet" href="/shoppingPro/AmazeUI-2.4.2/assets/css/amazeui.min.css" />
		<link href="/shoppingPro/css/dlstyle.css" rel="stylesheet" type="text/css">
		<script src="../AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
		<script src="../AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>

        <script type="text/javascript">
        function getchang(){
		  document.getElementById("randomCodeImg").src="/shoppingPro/randomCode?"+new Date().getTime();
	     }
	     
	     function check(){
	       //alert(1111);
	     var count=$("#phone").val();
	     var tel_reg=/^1[3|4|5|7|8]\d{9}$/;
        //var tel_reg=new RegExp("1[3|4|5|7|8]\\d{9}]$");
	     if(count.trim()==""){
		  //alert("手机号码不能为空");
		  $("#prop").html("亲，手机号码不能为空");
    	}
        else if(!tel_reg.test(count)){
		//alert("输入手机号码格式不正确");
		$("#prop").html("亲，输入手机号码格式不正确");
	    }else{
	    $("#prop").css("visibility","hidden");	
	    }
	   }

	     
        </script>
	</head>

	<body>

		<div class="login-boxtitle">
			<a href="home/demo.html"><img alt="" src="/shoppingPro/images/logobig.png" /></a>
		</div>

		<div class="res-banner">
			<div class="res-main">
				<div class="login-banner-bg"><span></span><img src="/shoppingPro/images/big.jpg" /></div>
				<div class="login-box">

						<div class="am-tabs" id="doc-my-tabs">
							<ul class="am-tabs-nav am-nav am-nav-tabs am-nav-justify">
								<li class="am-active"><a href="">邮箱注册</a></li>
								<li><a href="">手机号注册</a></li>
							</ul>

							<div class="am-tabs-bd">
								<div class="am-tab-panel am-active">
								<span style="color:red">${errorMsg}</span>	
								<!-- 邮箱注册 -->
									<form action="/shoppingPro/register?cmd=email" method="post">
										 
										 
							   <div class="user-email">
										<label for="email"><i class="am-icon-envelope-o"></i></label>
										<input type="email" name="email" id="username" 
										 onblur="checkUsername();" placeholder="请输入你的邮箱">
                 </div>										
                 <div class="user-pass">
								    <label for="password"><i class="am-icon-lock"></i></label>
								    <input type="password" name="password" id="password" placeholder="设置密码">
                 </div>										
                 <div class="user-pass">
								    <label for="passwordRepeat"><i class="am-icon-lock"></i></label>
								    <input type="password" name="passwordRepeat" id="passwordRepeat" placeholder="确认密码">
                 </div>	
                 
										<div class="am-cf">
											<input type="submit" name="注册" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl">
										</div>
                                      </form>
								</div>

								<div class="am-tab-panel">
								<!-- 手机号码注册 -->
									<form action="/shoppingPro/register?cmd=mob" method="post">
									<p id="prop" style="color:red;font-size:12px"/>
                 <div class="user-phone">
								    <label for="phone"><i class="am-icon-mobile-phone am-icon-md"></i></label>
								    <input type="text" name="mobno" id="phone" placeholder="请输入手机号码" onchange="check()" onblur="dis()">
                 </div>																			
										<div class="verification">
											<label for="code"><i class="am-icon-code-fork"></i></label>
											<input type="text" name="randomCode" id="code" placeholder="请输入验证码">
											<img alt="加载失败" onclick="javascript:getchang();" title="看不清,换一张" name="randImage"
									id="randomCodeImg" src="${pageContext.request.contextPath}/randomCode" width="53px" height="38px" border="1" align="absmiddle" style="margin-bottom:-16px">
										</div>
                 <div class="user-pass">
								    <label for="password"><i class="am-icon-lock"></i></label>
								    <input type="password" name="pwd" id="password" placeholder="请输入密码">
                 </div>										
                 <div class="user-pass">
								    <label for="passwordRepeat"><i class="am-icon-lock"></i></label>
								    <input type="password" name="pwdRep" id="" placeholder="请输入密码">
								    <div class="am-cf">
											<input type="submit" name="" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl">
										</div>
                 </div>	
									</form>
									<hr>
								</div>

								<script>
									$(function() {
									    $('#doc-my-tabs').tabs();
									  })
								</script>

							</div>
						</div>

				</div>
			</div>
			
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