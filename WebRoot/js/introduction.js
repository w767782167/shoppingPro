$(function(){
		$(".showFav").click(function(){
			$.get('/shoppingPro/showFavServlet',
			function(data){
				//将jsonStr转换成对象数组
				var jsonArr=eval(data);
				//alert(jsonArr);
				var html="";
				$.each(jsonArr,function(index,item){
					var key=jsonArr[index].id;
					var value=jsonArr[index].name;
				/*	+jsonArr[index].path.substring(5)+*/
				/*	html+="<li><div class='i-pic limit'>"+"<img src='/E:/tomcat/apache-tomcat-7.0.57-windows-x64/apache-tomcat-7.0.57/webapps/shoppingPro/images/imgsearch1.jpg'/>" +
							"<p>"+"【"+jsonArr[index].goodsFrom+"】"+"<span>"+jsonArr[index].name+"</span>"
							+"</p>"+"<p class='price fl'>"+"<b>¥</b>"+"<strong>"+jsonArr[index].price+"</strong>"+"</p>"
							+"</div>"+"</li>";*/
					html+="<li><div class='i-pic limit'>"+"<img src='"+jsonArr[index].path+"'/>" +
					"<p>"+"【"+jsonArr[index].goodsFrom+"】"+"<span>"+jsonArr[index].name+"</span>"
					+"</p>"+"<p class='price fl'>"+"<b>¥</b>"+"<strong>"+jsonArr[index].price+"</strong>"+"</p>"
					+"</div>"+"</li>";
					
				});
				console.debug(html);
				$("#goodlike").html(html);
			});
			
		});
		//发表评论
		$("#subcomment").click(function(){
				var comment=$("#write").val();
			$.post("/shoppingPro/commentServlet",
					{
							comment:comment
					},
					function(data,status){
						var jsonComment=eval(data);
						//alert(data);
						var html="";
						//new Date(timestamp).format("dd/MM/yyyy hh:mm:ss")
						$.each(jsonComment,function(index,item){
							html+="<li class='am-comment'><a href=''><img class='am-comment-avatar' src=" +
									"/shoppingPro/images/hwbn40x40.jpg"+"></a>"+"<div class='am-comment-main'>"+
								"<header class='am-comment-hd'>"+"<div class='am-comment-meta'>"+"<a href='#link-to-user' class='am-comment-author'>"+
								jsonComment[index].author+"</a>"+"评论于"+jsonComment[index].createtime+"</div></header>"+"<div class='am-comment-bd'>"+
								"<div class='tb-rev-item ' data-id='255776406962'><div class='J_TbcRate_ReviewContent tb-tbcr-content '>"+jsonComment[index].comment+
								"</div></div></div></div></li>";
						});
						console.debug(html);
						$("#commentId").html(html);
					}
			);
		});
		//点击全部评论展示评论
		$("#click").click(function(){
			//alert(11111);
			$.post("/shoppingPro/commentServlet",
					function(data,status){
				var jsonComment=eval(data);
				//alert(data);
				var html="";
				$.each(jsonComment,function(index,item){
					html+="<li class='am-comment'><a href=''><img class='am-comment-avatar' src=" +
							"/shoppingPro/images/hwbn40x40.jpg"+"></a>"+"<div class='am-comment-main'>"+
						"<header class='am-comment-hd'>"+"<div class='am-comment-meta'>"+"<a href='#link-to-user' class='am-comment-author'>"+
						jsonComment[index].author+"</a>"+"评论于"+jsonComment[index].createtime+"</div></header>"+"<div class='am-comment-bd'>"+
						"<div class='tb-rev-item ' data-id='255776406962'><div class='J_TbcRate_ReviewContent tb-tbcr-content '>"+jsonComment[index].comment+
						"</div></div></div></div></li>";
				});
				console.debug(html);
				$("#commentId").html(html);
			}
	);		
		});
		
});