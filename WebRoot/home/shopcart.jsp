<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set scope="page" var="url" value="${pageContext.request.contextPath}"></c:set>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

	<title>购物车页面</title>

	<link href="/shoppingPro/AmazeUI-2.4.2/assets/css/amazeui.css"
		rel="stylesheet" type="text/css" />
	<link href="/shoppingPro/basic/css/demo.css" rel="stylesheet"
		type="text/css" />
	<link href="/shoppingPro/css/cartstyle.css" rel="stylesheet"
		type="text/css" />
	<link href="/shoppingPro/css/optstyle.css" rel="stylesheet"
		type="text/css" />

	<script type="text/javascript" src="/shoppingPro/js/jquery.js"></script>
	<script type="text/javascript" src="/shoppingPro/js/ajax.js"></script>
</head>

<body>

	<!--顶部导航条 -->
	<div class="am-container header">
		<ul class="message-l">
			<div class="topMessage">
				<div class="menu-hd">
					<c:choose>
						<c:when test="${USER_IN_SESSION==null}">

							<a href="home/login.jsp" target="_top" class="h">亲，请登录</a>
							<a href="home/register.jsp" target="_top">免费注册</a>
						</c:when>

						<c:when test="${USER_IN_SESSION!=null}">
							<label>欢迎<font style="color:red">【${USER_IN_SESSION.username}】</font>光临悦桔商城</label>
							&emsp;
							<label><a href="${url}/logout">注销</a> </label>
						</c:when>
					</c:choose>
				</div>
			</div>
		</ul>
		<ul class="message-r">
			<div class="topMessage home">
				<div class="menu-hd">
					<a href="/shoppingPro/home/home.jsp" target="_top" class="h">商城首页</a>
				</div>
			</div>
			<div class="topMessage my-shangcheng">
				<div class="menu-hd MyShangcheng">
					<a href="#" target="_top"><c:choose>
							<c:when test="${USER_IN_SESSION!=null}">
						<a href="/shoppingPro/person/information.jsp" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a>
						</c:when>
							<c:when test="${USER_IN_SESSION==null}">
								<a href="#" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a>
							</c:when>
						</c:choose>
				</div>
			</div>
			<div class="topMessage mini-cart">
				<div class="menu-hd">
					<a id="mc-menu-hd" href="#" target="_top"><c:choose>
						<c:when test="${USER_IN_SESSION==null}">
					
						  <a id="mc-menu-hd" href="#" target="_top"><i
							class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong
							id="J_MiniCartNum" class="h">0</strong> </a>
						</c:when>
						<c:when test="${USER_IN_SESSION!=null}">
					
						  <a id="mc-menu-hd" href="#" target="_top"><i
							class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong
							id="J_MiniCartNum" class="h">0${cartNumByName }</strong> </a>
						</c:when>
						</c:choose>
				</div>
			</div>
			<div class="topMessage favorite">
				<div class="menu-hd">
					<a href="#" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span>
					</a>
				</div>
		</ul>
	</div>

	<!--悬浮搜索框-->

	<div class="nav white">
		<div class="logo">
			<img src="/shoppingPro/images/logo.png" />
		</div>
		<div class="logoBig">
			<li><img src="/shoppingPro/images/logobig.png" /></li>
		</div>

		<div class="search-bar pr">
			<a name="index_none_header_sysc" href="#"></a>
			<form action="${url}/search">
				<input id="searchInput" name="index_none_header_sysc" type="text"
					placeholder="搜索" autocomplete="off"> <input
					id="ai-topsearch" class="submit am-btn" value="搜索" index="1"
					type="submit">
			</form>
		</div>
	</div>

	<div class="clear"></div>

	<!--购物车 -->
	<div class="concent">
		<div id="cartTable">
			<div class="cart-table-th">
				<div class="wp">
					<div class="th th-chk">
						<div id="J_SelectAll1" class="select-all J_SelectAll"></div>
					</div>
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
					<div class="th th-op">
						<div class="td-inner">操作</div>
					</div>
				</div>
			</div>

			<c:forEach items="${shopCart}" var="cart" varStatus="vs">

				<div class="clear"></div>
				<tr class="item-list">
					<div class="bundle  bundle-last ">

						<div class="clear"></div>
						<div class="bundle-main">
							<ul class="item-content clearfix">
								<li class="td td-chk">
									<div class="cart-checkbox ">
										<input class="check" id="J_CheckBox_170037950254"
											name="items[]" value="${cart.id}" type="checkbox"
											onchange="selectCart(this)"> <label
											for="J_CheckBox_170037950254"></label>
									</div>
								</li>
								<li class="td td-item">
									<div class="item-pic">
										<a href="#" target="_blank"
											data-title="${cart.productName}${cart.goodsInfo}"
											class="J_MakePoint" data-point="tbcart.8.12"> <img
											src="${cart.picture}" class="itempic J_ItemImg"
											style="height: 80px;width: 80px;">
										</a>
									</div>
									<div class="item-info">
										<div class="item-basic-info">
											<a href="#" target="_blank"
												title="${cart.productName}${cart.goodsInfo}"
												class="item-title J_MakePoint" data-point="tbcart.8.11">${cart.productName}${cart.goodsInfo}</a>
										</div>
									</div>
								</li>
								<li class="td td-info">
									<div class="item-props item-props-can">
										<span class="sku-line">口味：${cart.property}</span> <span
											class="sku-line">包装：${cart.packing}</span>
										<!-- <span tabindex="0" class="btn-edit-sku theme-login">修改</span> -->
										<i class="theme-login am-icon-sort-desc"></i>
									</div>
								</li>
								<li class="td td-price">
									<div class="item-price price-promo-promo">
										<div class="price-content">
											<!-- <div class="price-line">
													<em class="price-original">78.00</em>
												</div> -->
											<div class="price-line">
												<em class="J_Price price-now" tabindex="0">${cart.singlePrice}</em>
											</div>
										</div>
									</div>
								</li>
								<li class="td td-amount">
									<div class="amount-wrapper ">
										<div class="item-amount ">
											<div class="sl">
												<input class="min am-btn" name="" type="button" value="-"
													onclick="changeNum(true,${cart.id})" /> <input
													class="text_box" name="" type="text"
													value="${cart.goodsNum}" style="width:30px;" /> <input
													class="add am-btn" name="" type="button" value="+"
													onclick="changeNum(false,${cart.id})" />
											</div>
										</div>
									</div>
								</li>
								<li class="td td-sum">
									<div class="td-inner">
										<em tabindex="0" class="J_ItemSum number"><div
												class="singleTotalPrice${cart.id}">${cart.totalPrice}</div>
										</em>
									</div>
								</li>
								<li class="td td-op">
									<div class="td-inner">
										<!-- <a title="移入收藏夹" class="btn-fav" href="#">
                  移入收藏夹</a> -->
										<a href="/shoppingPro/shoppingCart?cmd=delete&id=${cart.id}"
											data-point-url="" class="delete"> 删除</a>
									</div>
								</li>
							</ul>

						</div>
					</div>
				</tr>

			</c:forEach>
			<c:choose>
				<c:when test="${empty shopCart}">
					<div style="text-align: center;font-size: 20px;">购物车空空，赶紧去购物吧。。。。</div>
				</c:when>

			</c:choose>

		</div>
		<div class="clear"></div>

		<div class="float-bar-wrapper">
			<div id="J_SelectAll2" class="select-all J_SelectAll">
				<div class="cart-checkbox">
					<input class="check-all check" id="J_SelectAllCbx2"
						name="select-all" value="true" type="checkbox"
						onchange="checkChange(this)"> <label for="J_SelectAllCbx2"></label>
				</div>
				<span>全选</span>
			</div>
			<div class="operations">
				<a href="#" hidefocus="true" class="deleteAll">删除</a>
				<!-- <a href="#" hidefocus="true" class="J_BatchFav">移入收藏夹</a> -->
			</div>
			<div class="float-bar-right">
				<div class="amount-sum">
					<span class="txt">已选商品</span> <em id="J_SelectedItemsCount">0</em><span
						class="txt">件</span>
					<div class="arrow-box">
						<span class="selected-items-arrow"></span> <span class="arrow"></span>
					</div>
				</div>
				<div class="price-sum">
					<span class="txt">合计:</span> <strong class="price">¥<em
						id="J_Total">${totalPrice}0</em> </strong>
				</div>
				<div class="btn-area">
					<a href="${pageContext.request.contextPath}/orderServlet" id="J_Go"
						class="submit-btn submit-btn-disabled"
						aria-label="请注意如果没有选择宝贝，将无法结算"> <span>结&nbsp;算</span> </a>
				</div>
			</div>

		</div>

		<div class="footer">
			<div class="footer-hd">
				<p>
					<a href="#">恒望科技</a> <b>|</b> <a href="#">商城首页</a> <b>|</b> <a
						href="#">支付宝</a> <b>|</b> <a href="#">物流</a>
				</p>
			</div>
			<div class="footer-bd">
				<p>
					<a href="#">关于恒望</a> <a href="#">合作伙伴</a> <a href="#">联系我们</a> <a
						href="${pageContext.request.contextPath}/baiduMap.jsp">网站地图</a> <em>©
						2015-2025 Hengwang.com 版权所有
					</em>

				</p>
			</div>
		</div>

	</div>

	<%--<!--操作页面-->

			<div class="theme-popover-mask"></div>

			 <div class="theme-popover">
				<div class="theme-span"></div>
				<div class="theme-poptit h-title">
					<a href="javascript:;" title="关闭" class="close">×</a>
				</div>
				<div class="theme-popbod dform">
					<form class="theme-signin" name="loginform" action="" method="post">

						<div class="theme-signin-left">

							<li class="theme-options">
								<div class="cart-title">颜色：</div>
								<ul>
									<li class="sku-line selected">12#川南玛瑙<i></i></li>
									<li class="sku-line">10#蜜橘色+17#樱花粉<i></i></li>
								</ul>
							</li>
							<li class="theme-options">
								<div class="cart-title">包装：</div>
								<ul>
									<li class="sku-line selected">包装：裸装<i></i></li>
									<li class="sku-line">两支手袋装（送彩带）<i></i></li>
								</ul>
							</li>
							<div class="theme-options">
								<div class="cart-title number">数量</div>
								<dd>
									<input class="min am-btn am-btn-default" name="" type="button" value="-" />
									<input class="text_box" name="" type="text" value="1" style="width:30px;" />
									<input class="add am-btn am-btn-default" name="" type="button" value="+" />
									<span  class="tb-hidden">库存<span class="stock">1000</span>件</span>
								</dd>

							</div>
							<div class="clear"></div>
							<div class="btn-op">
								<div class="btn am-btn am-btn-warning">确认</div>
								<div class="btn close am-btn am-btn-warning">取消</div>
							</div>

						</div>
						<div class="theme-signin-right">
							<div class="img-info">
								<img src="${cart.picture}" />
							</div>
							<div class="text-info">
								<span class="J_Price price-now">¥39.00</span>
								<span id="Stock" class="tb-hidden">库存<span class="stock">1000</span>件</span>
							</div>
						</div>

					</form>
				</div>
			</div> 
		<!--引导 -->
		 <div class="navCir">
			<li><a href="home.html"><i class="am-icon-home "></i>首页</a></li>
			<li><a href="sort.html"><i class="am-icon-list"></i>分类</a></li>
			<li class="active"><a href="shopcart.html"><i class="am-icon-shopping-basket"></i>购物车</a></li>	
			<li><a href="../person/index.html"><i class="am-icon-user"></i>我的</a></li>					
		</div> --%>
</body>

</html>