<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set scope="page" var="url" value="${pageContext.request.contextPath}"></c:set>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0 ,minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>结算页面</title>

		<link href="${url}/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />

		<link href="${url}/basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link href="${url}/css/cartstyle.css" rel="stylesheet" type="text/css" />

		<link href="${url}/css/jsstyle.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="${url}/js/address.js"></script>
		<script type="text/javascript" src="/jquery-3.2.0.min.js"></script>
		<script type="text/javascript">
			 $(function(){
			
			 var name=document.getElementById("username").innerHTML; 
		 	 var tel=document.getElementById("tel").innerHTML; 
		 	 var adress=document.getElementById("adress").innerHTML; 
		 	 var comadress=document.getElementById("comadress").innerHTML;
		 	 
		 	 document.getElementById("newAdress1").innerHTML=adress;
		 	 document.getElementById("newAdress2").innerHTML=comadress;
		 	 document.getElementById("newname").innerHTML=name;
		 	 document.getElementById("newtel").innerHTML=tel;
		 	 
		 	 document.getElementById("newAdress11").value=adress;
		 	 document.getElementById("newAdress22").value=comadress;
		 	 document.getElementById("newname1").value=name;
		 	 document.getElementById("newtel1").value=tel;
			  
			}); 
		
		
		 function localAdress(){
		     var name=document.getElementById("username").innerHTML; 
		 	 var tel=document.getElementById("tel").innerHTML; 
		 	 var adress=document.getElementById("adress").innerHTML; 
		 	 var comadress=document.getElementById("comadress").innerHTML;
		 	 
		 	 document.getElementById("newAdress1").innerHTML=adress;
		 	 document.getElementById("newAdress2").innerHTML=comadress;
		 	 document.getElementById("newname").innerHTML=name;
		 	 document.getElementById("newtel").innerHTML=tel;
		 	
		 	 document.getElementById("newAdress11").value=adress;
		 	 document.getElementById("newAdress22").value=comadress;
		 	 document.getElementById("newname1").value=name;
		 	 document.getElementById("newtel1").value=tel;
		     } 
        	function newAdress(e){
        	 var name="name"+e;
        	 var tel="tel"+e;
        	 var adress="adress"+e;
        	 var comadress="comadress"+e;
       		 var name1=document.getElementById(name).innerHTML; 
		 	 var tel1=document.getElementById(tel).innerHTML; 
		 	 var adress1=document.getElementById(adress).innerHTML; 
		 	 var comadress1=document.getElementById(comadress).innerHTML;
		 	 
		 	 document.getElementById("newAdress1").innerHTML=adress1;
		 	 document.getElementById("newAdress2").innerHTML=comadress1;
		 	 document.getElementById("newname").innerHTML=name1;
		 	 document.getElementById("newtel").innerHTML=tel1;
		 	
		 	 document.getElementById("newAdress11").value=adress1;
		 	 document.getElementById("newAdress22").value=comadress1;
		 	 document.getElementById("newname1").value=name1;
		 	 document.getElementById("newtel1").value=tel1;
         	}
			
			function checkTel(){
				var tel=document.getElementById("user-phone").value;
				if(tel.trim()==""){
					alert("手机号码不能为空");
				}else{
					if(isNaN(tel)){
						alert("手机号码必须是数字");
					}else{
						var tel_reg=/^1[3|4|5|7|8]\d{9}$/;
						if(tel_reg.test(tel)){
			         }else{
				         alert("手机号码不正确");
			            }
					}
				}
			}
		
		//二级联动
		function getCityById(){
	       var proId = document.getElementById("province").value;
	       //console.debug("mmmmmm"+proId);
	       //1.创建Ajax对象
	       var ajax = createAjax();
	       ajax.open("get","/shoppingPro/linkage?cmd=city&id="+proId);
	       //获取请求状态  异步  回调函数
	       ajax.onreadystatechange = function() {
		    if(ajax.readyState == 4 && ajax.status == 200){//接收响应数据
			var jsonStr=ajax.responseText;

			 //json String----> json obj
			var jsonObj=eval("("+jsonStr+")");
			var html="";
			for ( var i = 0; i < jsonObj.length; i++) {
				html +="<option value='"+jsonObj[i].id+"'>"
				+jsonObj[i].name+"</option>";
			}
			//console.debug(text);
			document.getElementById("city").innerHTML = html;
	 		
		     }
	     };
	
	     //3.发送请求
	       ajax.send();
	
    };


      //二级联动
       window.onload = function () {
	
	   //1.创建Ajax对象
	    var ajax = createAjax();
	
	    ajax.open("get","/shoppingPro/linkage?cmd=province");
	
	
	    //获取请求状态  异步  回调函数
	    ajax.onreadystatechange = function() {
		  if(ajax.readyState == 4 && ajax.status == 200){//接收响应数据
			var jsonStr=ajax.responseText;

			 //json String----> json obj
			var jsonObj=eval("("+jsonStr+")");
			var html="";
			for ( var i = 0; i < jsonObj.length; i++) {
				html +="<option value='"+jsonObj[i].id+"'>"
				+jsonObj[i].name+"</option>";
			}
			//console.debug(text);
			document.getElementById("province").innerHTML = html;
			getCityById();
		}
	};
	
	//3.发送请求
	ajax.send();
	
  };




//创建Ajax对象
function createAjax() {
	var ajax;
	try {
		ajax = new XMLHttpRequest();
		
	} catch (e) {
		// : handle exception
		ajax = new ActiveXObject();
		
	}
	return ajax;
}
		
			
		</script>
	</head>

	<body>

		<!--顶部导航条 -->
		<div class="am-container header">
			<ul class="message-l">
				<div class="topMessage">
					<div class="menu-hd">
						<c:choose>
						<c:when test="${USER_IN_SESSION==null}">
					
						<a href="login.jsp" target="_top" class="h">亲，请登录</a>
						<a href="register.jsp" target="_top">免费注册</a>
						</c:when>
						
							<c:when test="${USER_IN_SESSION!=null}">
				    <label>欢迎<font style="color:red">【${USER_IN_SESSION.username}】</font>光临悦桔商城</label>
				    		&emsp;<label><a href="${url}/logout">注销</a></label>
							</c:when>
						</c:choose>
					</div>
				</div>
			</ul>
			<ul class="message-r">
				<div class="topMessage home">
					<div class="menu-hd"><a href="home.jsp" target="_top" class="h">商城首页</a></div>
				</div>
				<div class="topMessage my-shangcheng">
					<div class="menu-hd MyShangcheng"><a href="#" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
				</div>
				<div class="topMessage mini-cart">
					<div class="menu-hd"><a id="mc-menu-hd" href="#" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
				</div>
				<div class="topMessage favorite">
					<div class="menu-hd"><a href="#" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
			</ul>
			</div>

			<!--悬浮搜索框-->

			<div class="nav white">
				<div class="logo"><img src="${url}/images/logo.png" /></div>
				<div class="logoBig">
					<li><img src="${url}/images/logobig.png" /></li>
				</div>

				<div class="search-bar pr">
					<a name="index_none_header_sysc" href="#"></a>
					<form action="${url}/search" method="post">
						<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
						<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
					</form>
				</div>
			</div>

			<div class="clear"></div>
			<div class="concent">
				<!--地址 -->
				<div class="paycont">
					<div class="address">
						<h3>确认收货地址 </h3>
						<div class="control">
							<div class="tc-btn createAddr theme-login am-btn am-btn-danger">使用新地址</div>
						</div>
						<div class="clear"></div>
						<c:forEach items="${sessionScope.SESSION_IN_USERDETAILS}" var="user">
						<ul>
							<div class="per-border"></div>
							<li onclick="localAdress();" class="user-addresslist defaultAddr">

								<div class="address-left">
									<div class="user DefaultAddr">
										<span class="buy-address-detail">   
                  						 <span id="username" class="buy-user">${user.username}</span>
										<span id="tel" class="buy-phone">${user.telp}</span>
										</span>
									</div>
									<div class="default-address DefaultAddr">
										<span class="buy-line-title buy-line-title-type">收货地址：</span>
										<span class="buy--address-detail">
								   <span id="adress" class="province">${user.adress}</span>
								    <span id="comadress" class="street"></span>
										</span>

									
									</div>
									<ins class="deftip">默认地址</ins>
								</div>
								<div class="address-right">
									<a href="${url}/person/address.html">
										<span class="am-icon-angle-right am-icon-lg"></span></a>
								</div>
								<div class="clear"></div>

								<div class="new-addr-btn">
									<!-- <a href="#" class="hidden">设为默认</a> -->
									<span class="new-addr-bar hidden">|</span>
									<!-- <a href="#">编辑</a> -->
									<!-- <span class="new-addr-bar">|</span> -->
									<!-- <a href="javascript:void(0);" onclick="delClick(this);">删除</a> -->
								</div>

							</li>
							</c:forEach>
							<div class="per-border"></div>
							
							
							 <c:forEach items="${sessionScope.SESSION_IN_ADRESS}" var="address" >
								
							<li onclick="newAdress('${address.id}');" class="user-addresslist">
								<div class="address-left">
									<div class="user DefaultAddr">

										<span class="buy-address-detail"> 
                                        <span id="name${address.id}"  class="buy-user">${address.consignee}</span>
										<span id="tel${address.id}" class="buy-phone">${address.consigneeTel}</span>
										</span>
									</div>
									<div class="default-address DefaultAddr">
										<span class="buy-line-title buy-line-title-type">收货地址：</span>
										<span class="buy--address-detail">
								      <span id="adress${address.id}" class="province">${address.adress}</span>
										<!-- <span class="city">武汉</span>市
										<span class="dist">武昌</span>区 -->
										<span id="comadress${address.id}" class="street">${address.completeAdress}</span>
										</span>

								
									</div>
									<ins class="deftip hidden">新地址</ins>
								</div>
								<div class="address-right">
									<span class="am-icon-angle-right am-icon-lg"></span>
								</div>
								<div class="clear"></div>

								<div class="new-addr-btn">
									<!-- <a href="#">设为默认</a>
									<span class="new-addr-bar">|</span>
									<a href="#">编辑</a>
									<span class="new-addr-bar">|</span> -->
									<a href="/shoppingPro/adress?Adressid=${address.id}">删除</a>
								</div>

							</li>
							</c:forEach>
						</ul>

						<div class="clear"></div>
					</div>
					<!--物流 -->
					<div class="logistics" id="test">
						<h3>选择物流方式</h3>
						<form action="/shoppingPro/success" method="post">
						<ul class="op_express_delivery_hot" >
							<li data-value="yuantong" class="OP_LOG_BTN " ><i class="c-gap-right" style="background-position:0px -468px"></i>圆通 &emsp;<input type="radio" name="logis" value="圆通" checked="checked" /></li>
							<li data-value="shentong" class="OP_LOG_BTN  " ><i class="c-gap-right" style="background-position:0px -1008px"></i>申通 &emsp;<input type="radio" name="logis" value="申通" /></li>
							<li data-value="yunda" class="OP_LOG_BTN  " ><i class="c-gap-right" style="background-position:0px -576px"></i>韵达 &emsp;<input type="radio" name="logis" value="韵达" /></li>
							<li data-value="zhongtong" class="OP_LOG_BTN op_express_delivery_hot_last "><i class="c-gap-right" style="background-position:0px -324px"></i>中通 &emsp;<input type="radio" name="logis" value="中通" /></li>
							<li data-value="shunfeng" class="OP_LOG_BTN  op_express_delivery_hot_bottom"><i class="c-gap-right" style="background-position:0px -180px"></i>顺丰 &emsp;<input type="radio" name="logis" value="顺丰" /></li>
						</ul>
						
					</div>
					<div class="clear"></div>

					<!--支付方式-->
					<div class="logistics">
						<h3>选择支付方式</h3>
						
						<ul class="pay-list">
							<li class="pay card"><img src="${url}/images/wangyin.jpg" />银联&emsp;<input type="radio" name="bank" value="银联" /></li>
							<li class="pay qq"><img src="${url}/images/weizhifu.jpg" />微信 &emsp;<input type="radio" name="bank" value="微信" /></li>
							<li class="pay taobao"><img src="${url}/images/zhifubao.jpg" />支付宝 &emsp;<input type="radio" name="bank" value="支付宝" checked="checked"/></li>
						</ul>
						
					</div>
					<div class="clear"></div>

					<!--订单 -->
					<div class="concent">
						<div id="payTable">
							<h3>确认订单信息</h3>
							<div class="cart-table-th">
								<div class="wp">

									<div class="th th-item">
										<div class="td-inner">商品信息</div>
									</div>
									<div class="th th-price">
										<div class="td-inner">单价</div>
									</div>
									<div class="th th-amount">
										<div class="td-inner">数量</div>
									</div>
									<div class="th th-sum">
										<div class="td-inner">金额</div>
									</div>
									<div class="th th-oplist">
										<div class="td-inner">配送方式</div>
									</div>

								</div>
							
							<div class="clear"></div>
							</div>
							<c:forEach items="${sessionScope.products}" var="item">
							<tr id="J_BundleList_s_1911116345_1" class="item-list">
								<div id="J_Bundle_s_1911116345_1_0" class="bundle  bundle-last">
									<div class="bundle-main">
										<ul class="item-content clearfix">
											<div class="pay-phone">
												<li class="td td-item">
													<div class="item-pic">
														<a href="#" class="J_MakePoint">
												
															<img src="${item.picture}" class="itempic J_ItemImg"></a>
													</div>
													<div class="item-info">
														<div class="item-basic-info">
															<a href="#" target="_blank" title="${item.productName}" class="item-title J_MakePoint" data-point="tbcart.8.11">${item.productName}</a>
														</div>
													</div>
												</li>
												<li class="td td-info">
													<div class="item-props">
														<span class="sku-line">商品属性：${item.property}</span>
														<span class="sku-line">包装：${item.packing}</span>
													</div>
												</li>
												<li class="td td-price">
													<div class="item-price price-promo-promo">
														<div class="price-content">
															<em id="singlePrice" class="J_Price price-now">${item.singlePrice}</em>
														</div>
													</div>
												</li>
											</div>

											<li class="td td-amount">
												<div class="amount-wrapper ">
													<div class="item-amount ">
														<span class="phone-title">购买数量</span>
														<div class="sl">
															<!-- <input class="min am-btn" name="" onclick="sub();"; type="button" value="-" /> -->
															<span>${item.goodsNum}</span>
															<!-- <input id="num" class="text_box" name="" type="text" value="" style="width:30px;" /> -->
															<!-- <input class="add am-btn" name="" onclick="add();" type="button" value="+" /> -->
														</div>
													</div>
												</div>
											</li>
											<li class="td td-sum">
												<div class="td-inner">
													<em tabindex="0" class="J_ItemSum number">${item.totalPrice}</em>
												</div>
											</li>
											<li class="td td-oplist">
												<div class="td-inner">
													<span class="phone-title">配送方式</span>
													<div class="pay-logis">
														${item.joint}
													</div>
												</div>
											</li>

										</ul>
										
										<div class="clear"></div>

									</div>
							</tr>
							</c:forEach>
							</div>
							<div class="clear"></div>
							<div class="pay-total">
						<!--留言-->
							<div class="order-extra">
								<div class="order-user-info">
									<div id="holyshit257" class="memo">
										<label>买家留言：</label>
										<input name="Msg" type="text" title="选填,对本次交易的说明（建议填写已经和卖家达成一致的说明）" placeholder="选填,建议填写和卖家达成一致的说明" class="memo-input J_MakePoint c2c-text-default memo-close">
										<div class="msg hidden J-msg">
											<p class="error">最多输入500个字符</p>
										</div>
									</div>
								</div>

							</div>
							<!--优惠券 -->
							<div class="buy-agio">
								<li class="td td-coupon">

									<span class="coupon-title">优惠券</span>
									<select data-am-selected>
										<option value="a">
											<div class="c-price">
												<strong>￥8</strong>
											</div>
											<div class="c-limit">
												【消费满95元可用】
											</div>
										</option>
										<option value="b" selected>
											<div class="c-price">
												<strong>￥3</strong>
											</div>
											<div class="c-limit">
												【无使用门槛】
											</div>
										</option>
									</select>
								</li>

								<li class="td td-bonus">

									<span class="bonus-title">红包</span>
									<select data-am-selected>
										<option value="a">
											<div class="item-info">
												¥50.00<span>元</span>
											</div>
											<div class="item-remainderprice">
												<span>还剩</span>10.40<span>元</span>
											</div>
										</option>
										<option value="b" selected>
											<div class="item-info">
												¥50.00<span>元</span>
											</div>
											<div class="item-remainderprice">
												<span>还剩</span>50.00<span>元</span>
											</div>
										</option>
									</select>

								</li>

							</div>
							<div class="clear"></div>
							</div>
							<!--含运费小计 -->
							<div class="buy-point-discharge ">
								<p class="price g_price ">
									合计（含运费） <span>¥</span><em class="pay-sum">${sessionScope.totalPrice}</em>
									<input type="hidden" name="totalPrice" value="${sessionScope.totalPrice}" />
								</p>
							</div>

							<!--信息 -->
							<div class="order-go clearfix">
								<div class="pay-confirm clearfix">
									<div class="box">
										<div tabindex="0" id="holyshit267" class="realPay"><em class="t">实付款：</em>
											<span class="price g_price ">
                                    <span>¥</span> <em class="style-large-bold-red " id="J_ActualFee">${sessionScope.totalPrice}</em>
											</span>
										</div>

										<div id="holyshit268" class="pay-address">

											<p class="buy-footer-address">
												<span class="buy-line-title buy-line-title-type">寄送至：</span>
												<span class="buy--address-detail">
											    <input type="hidden" name="newAdress1" id="newAdress11"/> 
												<label id="newAdress1"></label>
											    <input type="hidden" name="newAdress2" id="newAdress22"/> 
												<label id="newAdress2"></label>
								                <!-- <span id="ConfirmAdress" class="province">湖北</span>省
												<span class="city">武汉</span>市
												<span class="dist">洪山</span>区
												<span class="street">雄楚大道666号(中南财经政法大学)</span> 
												</span>
												</span> -->
											</p>
											<p class="buy-footer-address">
												<span class="buy-line-title">收货人：</span>
												<span class="buy-address-detail"> 
											    <input type="hidden" name="newname" id="newname1"/> 
												<label id="newname"></label> 
											    <input type="hidden" name="newtel" id="newtel1"/>
												<label id="newtel"></label>
                                        <!--  <span class="buy-user">艾迪 </span>
												<span class="buy-phone">15871145629</span> -->
												</span>
											</p>
										</div>
									</div>

									<div id="holyshit269" class="submitOrder">
										<div class="go-btn-wrap">
											 <input  style="margin-left: 860px; border: 0px;" class="btn-go" type="submit" value="提交订单"/> 
											 <!-- <a id="J_Go"  class="btn-go" tabindex="0" title="点击此按钮，提交订单"></a>  -->
										</div>
									</div>
									</form>
									<div class="clear"></div>
								</div>
							</div>
						</div>

						<div class="clear"></div>
					</div>
				</div>
				<div class="footer">
					<div class="footer-hd">
						<p>
							<a href="#">恒望科技</a>
							<b>|</b>
							<a href="#">商城首页</a>
							<b>|</b>
							<a href="#">支付宝</a>
							<b>|</b>
							<a href="#">物流</a>
						</p>
					</div>
					<div class="footer-bd">
						<p>
							<a href="#">关于恒望</a>
							<a href="#">合作伙伴</a>
							<a href="#">联系我们</a>
							<a href="#">网站地图</a>
							<em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></em>
						</p>
					</div>
				</div>
			</div>
			<div class="theme-popover-mask"></div>
			<div class="theme-popover">

				<!--标题 -->
				<div class="am-cf am-padding">
					<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">新增地址</strong> / <small>Add address</small></div>
				</div>
				<hr/>

				<div class="am-u-md-12">
					<form action="/shoppingPro/adress" method="post" class="am-form am-form-horizontal" >

						<div class="am-form-group">
							<label for="user-name" class="am-form-label">收货人</label>
							<div class="am-form-content">
								<input name="consignee" type="text" id="user-name" placeholder="收货人">
							</div>
						</div>

				<div class="am-form-group">
					<label for="user-phone" class="am-form-label">手机号码</label>
					<div class="am-form-content">
						<input name="consigneeTel" id="user-phone" placeholder="手机号必填"
							type="text" onblur="checkTel()"/>
					</div>
				</div>
				
				<div class="am-form-group">
							<label for="user-phone" class="am-form-label">所在地</label>
							<div class="am-form-content address">
								<select data-am-selected name="province" id="province" onchange="getCityById()">
									<!-- <option>浙江省</option>
									<option>湖北省</option>
									<option>福建省</option>
									<option>广东省</option>
									<option>江西省</option>
									<option>四川省</option>
									<option>河南省</option>
									<option>陕西省</option> -->
								</select>
								<select data-am-selected name="city" id="city">
									<!-- <option>温州市</option>
									<option>武汉市</option>
									<option>厦门市</option>
									<option>广州市</option>
									<option>南昌市</option>
									<option>成都市</option>
									<option>郑州市</option>
									<option>西安市</option> -->
								</select>
								<select data-am-selected name="district">
									<option>瑞安区</option>
									<option>洪山区</option>
									<option>思明区</option>
									<option>黄埔区</option>
									<option>西湖区</option>
									<option>武侯区</option>
									<option>中原区</option>
									<option>新城区</option>
								</select>
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-intro" class="am-form-label">详细地址</label>
							<div class="am-form-content">
								<textarea name="completeAdress" class="" rows="3" id="user-intro" placeholder="输入详细地址"></textarea>
								<small>100字以内写出你的详细地址...</small>
							</div>
						</div>

						<div class="am-form-group theme-poptit">
							<div class="am-u-sm-9 am-u-sm-push-3">
							   <input class="am-btn am-btn-danger" type="submit" value="保存"/>
								<!-- <div class="am-btn am-btn-danger"></div> -->
								<div class="am-btn am-btn-danger close">取消</div>
							</div>
						</div>
					</form>
				</div>

			</div>

			<div class="clear"></div>
	</body>

</html>