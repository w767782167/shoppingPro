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
	
	function searchComment(){
		$("#dg").datagrid('load',{
			"s_Comment.content":$("#s_CommentContent").val()
		});
	}

	function resetValue(){
		$("#content").val("");
		$("#replyContent").val("");
	}
	
	function closeCommentDialog(){
		$("#dlg").dialog("close");
		resetValue();
	}
	
	function deleteComment(){
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
				$.post("comment_delete.action",{ids:ids},function(result){
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
</script>
</head>
<body style="margin:1px;">
	<table id="dg" title="留言管理" class="easyui-datagrid"
	 fitColumns="true" pagination="true" rownumbers="true"
	 url="comment_listComment2.action" fit="true" toolbar="#tb">
	 <thead>
	 	<tr>
	 		<th field="cb" checkbox="true" align="center"></th>
	 		<th field="id" width="50" align="center">编号</th>
	 		<th field="nickName" width="200" align="center">运动次数</th>
	 		<!-- <th field="nickName" width="50" align="center">留言人昵称</th> -->
	 		<th field="createTime" width="50" align="center">时间</th>
	 	<!-- 	<th field="replyContent" width="200" formatter="formatReplyContent" align="center">回复内容</th> -->
	 	<!-- 	<th field="replyTime" width="50" align="center">回复时间</th> -->
	 	</tr>
	 </thead>
	</table>
	
	<div id="tb">
		<div>
			<a href="javascript:deleteComment()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除数据</a>
		</div>
		<div>
			&nbsp;时间：&nbsp;<input type="text" id="s_CommentContent" size="20" onkeydown="if(event.keyCode==13) searchComment()"/>
			<a href="javascript:searchComment()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
		</div>
	</div>
</body>
</html>