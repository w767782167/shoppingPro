<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">

	var url;
	
	$(function(){
		$("#bName").combobox({
			onSelect:function(record){
				$("#sName").combobox("reload","productSmallType_comboList.action?s_productSmallType.bigType.id="+record.id);
				$("#sName").combobox("setValue","");
			}
		});
	});

	function searchProduct(){
		$("#dg").datagrid('load',{
			"s_product.name":$("#s_productName").val()
		});
	}
	
	function formatProPic(val,row){
		return "<img width=100 height=100 src='${pageContext.request.contextPath}/"+val+"'>";
	}

	function formatSmallTypeId(val,row){
		return row.smallType.id;
	}
	
	function formatSmallTypeName(val,row){
		return row.smallType.name;
	}
	
	function formatBigTypeId(val,row){
		return row.bigType.id;
	}
	
	function formatBigTypeName(val,row){
		return row.bigType.name;
	}
	
	function formatHot(val,row){
		if(val==1){
			return "是";
		}else{
			return "否";
		}
	}
	
	function formatSpecialPrice(val,row){
		if(val==1){
			return "是";
		}else{
			return "否";
		}
	}
	
	function openProductAddDialog(){
		$("#dlg").dialog("open").dialog("setTitle","添加商品信息");
		url="product_save.action";
	}
	
	function openProductModifyDialog(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		var row=selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle","编辑商品信息");
		$("#name").val(row.name);
		$("#price").val(row.price);
		$("#stock").val(row.stock);
		$("#proPic").val(row.proPic);
		$("#hot").val(row.hot);
		$("#hotTime").val(row.hotTime);
		$("#specialPrice").val(row.specialPrice);
		$("#specialPriceTime").val(row.specialPriceTime);
		$("#description").val(row.description);
		$("#bName").combobox("setValue",row.bigType.id);
		$("#sName").combobox("setValue",row.smallType.id);
		url="product_save.action?product.id="+row.id;
	}
	
	
	function saveProduct(){
		$("#fm").form("submit",{
			url:url,
			onSubmit:function(){
				if($('#bName').combobox("getValue")==""){
					$.messager.alert("系统提示","请选择商品大类");
					return false;
				}
				if($('#sName').combobox("getValue")==""){
					$.messager.alert("系统提示","请选择商品小类");
					return false;
				}
				return $(this).form("validate");
			},
			success:function(result){
				var result=eval('('+result+')');
				if(result.success){
					$.messager.alert("系统提示","保存成功");
					resetValue();
					$("#dlg").dialog("close");
					$("#dg").datagrid("reload");
				}else{
					$.messager.alert("系统提示","保存失败");
					return;
				}
			}
		});
		
	}
	
	function resetValue(){
		$("#name").val("");
		$("#price").val("");
		$("#stock").val("");
		$("#pP").val("");
		$("#bName").combobox("setValue","");
		$("#sName").combobox("setValue","");
		$("#description").val("");
		
		$("#id").val("");
		$("#proPic").val("");
		$("#hot").val("");
		$("#hotTime").val("");
		$("#specialPrice").val("");
		$("#specialPriceTime").val("");
	}
	
	function closeProductDialog(){
		$("#dlg").dialog("close");
		resetValue();
	}
	
	function deleteProduct(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要删除的数据！");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].id);
		}
		var ids=strIds.join(",");
		$.messager.confirm("系统提示","您确认要删除这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
			if(r){
				$.post("data_delete.action",{ids:ids},function(result){
					if(result.success){
						$.messager.alert("系统提示","数据已成功删除！");
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert("系统提示","数据删除失败！");
					}
				},"json");
			}
		});
	}
	
	function setProductHot(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要设置热卖的商品！");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].id);
		}
		var ids=strIds.join(",");
		$.messager.confirm("系统提示","您确认要设置这<font color=red>"+selectedRows.length+"</font>个商品为热卖吗？",function(r){
			if(r){
				$.post("product_setProductWithHot.action",{ids:ids},function(result){
					if(result.success){
						$.messager.alert("系统提示","已设置成功！");
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert("系统提示","设置失败！");
					}
				},"json");
			}
		});
	}
	
	function setProductSpecialPrice(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要设置特价的商品！");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].id);
		}
		var ids=strIds.join(",");
		$.messager.confirm("系统提示","您确认要设置这<font color=red>"+selectedRows.length+"</font>个商品为特价吗？",function(r){
			if(r){
				$.post("product_setProductWithSpecialPrice.action",{ids:ids},function(result){
					if(result.success){
						$.messager.alert("系统提示","已设置成功！");
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert("系统提示","设置失败！");
					}
				},"json");
			}
		});
	}
</script>
</head>
<body style="margin:1px;">
	<table id="dg" title="商品管理" class="easyui-datagrid"
	 fitColumns="true" pagination="true" rownumbers="true"
	 url="data_list2.action" fit="true" toolbar="#tb">
	 <thead>
	 	<tr>
	 		<th field="cb" checkbox="true" align="center"></th>
	 		<th field="id" width="50" align="center">编号</th>
	 		<th field="wendu" width="65" align="center">温度</th>
	 		<th field="yanwu" width="65" align="center">烟雾</th>
	 		<th field="shidu" width="50" align="center">湿度</th>
	 		<th field="voice" width="50" align="center">噪音指数</th>
	 		<th field="fire" width="40" align="center">有无火焰</th>
	 		<th field="data_time" width="80" align="center">时间</th>
	 	</tr>
	 </thead>
	</table>
	
	<div id="tb">
		<div>
			<!-- <a href="javascript:openProductAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
			<a href="javascript:openProductModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a> -->
			<a href="javascript:deleteProduct()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
			<!-- <a href="javascript:setProductHot()" class="easyui-linkbutton" iconCls="icon-hot" plain="true">设置为热卖</a>
			<a href="javascript:setProductSpecialPrice()" class="easyui-linkbutton" iconCls="icon-special" plain="true">设置为特价</a> -->
		</div>
		<div>
			&nbsp;编号查找：&nbsp;<input type="text" id="s_productName" size="20" onkeydown="if(event.keyCode==13) searchProduct()"/>
			<a href="javascript:searchProduct()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
		</div>
	</div>
	
	<!-- <div id="dlg" class="easyui-dialog" style="width: 600px;height:450px;padding: 10px 20px"
	  closed="true" buttons="#dlg-buttons">
	 	<form id="fm" method="post" enctype="multipart/form-data">
	 		<table cellspacing="8px">
	 			<tr>
	 				<td>商品名称：</td>
	 				<td colspan="4"><input type="text" id="name" name="product.name" class="easyui-validatebox" required="true" style="width: 300px"/></td>
	 			</tr>
	 			<tr>
	 				<td>价格：</td>
	 				<td colspan="4"><input type="text" id="price" name="product.price" class="easyui-validatebox" required="true"/></td>
	 			</tr>
	 			<tr>
	 				<td>库存：</td>
	 				<td colspan="4"><input type="text" id="stock" name="product.stock" class="easyui-validatebox" required="true"/></td>
	 			</tr>
	 			<tr>
	 				<td>商品图片：</td>
	 				<td colspan="4"><input type="file" id="pP" name="proPic" /></td>
	 			</tr>
	 			<tr>
	 				<td>所属大类：</td>
	 				<td colspan="4">
	 					<input class="easyui-combobox" id="bName" name="product.bigType.id" data-options="panelHeight:'auto',editable:false,valueField:'id',textField:'name',url:'productBigType_comboList.action'"/>
	 				</td>
	 			</tr>
	 			<tr>
	 				<td>所属小类：</td>
	 				<td colspan="4">
	 					<input class="easyui-combobox" id="sName" name="product.smallType.id" data-options="panelHeight:'auto',editable:false,valueField:'id',textField:'name',url:'productSmallType_comboList.action'"/>
	 				</td>
	 			</tr>
	 			<tr>
	 				<td valign="top">备注：</td>
	 				<td colspan="4">
	 					<textarea rows="5" cols="50" id="description" name="product.description"></textarea>
	 					<input type="hidden" id="proPic" name="product.proPic"/>
	 					<input type="hidden" id="hot" name="product.hot"/>
	 					<input type="hidden" id="hotTime" name="product.hotTime"/>
	 					<input type="hidden" id="specialPrice" name="product.specialPrice"/>
	 					<input type="hidden" id="specialPriceTime" name="product.specialPriceTime"/>
	 				</td>
	 			</tr>
	 		</table>
	 	</form>
	</div> -->
	
	<div id="dlg-buttons">
		<a href="javascript:saveProduct()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeProductDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>