<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function confirmReceive(orderNo){
		if(confirm("确认收货？")){
			$.post("order_confirmReceive.action",{status:4,orderNo:orderNo},function(result){
				var result=eval('('+result+')');
				if(result.success){
					alert("确认收货成功！");
					location.reload();
				}else{
					alert("确认收获失败！");
				}
			});
		}
	}
</script>
</head>
<body>
<h2>订单管理</h2>
		<div class="manage">
			<div class="search">
				<form action="order_findOrder.action" method="post">
					订单号：<input type="text" class="text" name="s_order.orderNo" value="${s_order.orderNo}" /> 
					 <label class="ui-blue"><input type="submit"  name="submit" value="查询" /></label>
				</form>
			</div>
			<div class="spacer"></div>
				<table class="list">
				<c:forEach var="order" items="${orderList }">
				<tr style="background-color: #f7f4eb">
					<td colspan="4">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					单号：${order.orderNo }
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					下单时间：<fmt:formatDate value="${order.createTime }" type="date" pattern="yyyy-MM-dd"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					状态：
					<c:choose>
						<c:when test="${order.status==1 }">待审核</c:when>
						<c:when test="${order.status==2 }">待发货</c:when>
						<c:when test="${order.status==3 }"><input type="button" style="border: 1px solid red" value="确实收货" onclick="confirmReceive(${order.orderNo})"/></c:when>
						<c:when test="${order.status==4 }">交易已完成</c:when>
					</c:choose>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					总金额：${order.cost }&nbsp;(元)
					</td>
				</tr>
				<c:forEach var="orderProduct" items="${order.orderProductList }">
					<tr>
						<td width="50%">
							<a href="product_showProduct.action?productId=${orderProduct.product.id }" target="_blank"><img width="72" height="72" src="${orderProduct.product.proPic }"></a>
							&nbsp;&nbsp;
							<a href="product_showProduct.action?productId=${orderProduct.product.id }" target="_blank">${orderProduct.product.name}</a>
						</td>
						<td width="17%">
							&nbsp;&nbsp;
							${orderProduct.product.price}
						</td>
						<td width="17%">
							&nbsp;&nbsp;
							${orderProduct.num}
						</td>
						<td>
							&nbsp;&nbsp;小计：
							${orderProduct.num*orderProduct.product.price}&nbsp;(元)
						</td>
					</tr>
				</c:forEach>
				</c:forEach>
				</table>
		</div>
</body>
</html>