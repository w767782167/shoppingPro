
$(function() {
	
	addTocart()
})
function addTocart() {
	
	var username = $("#usernameId").html();
	$.get("/shoppingPro/shoppingCart?cmd=cartNum&username="+username,function(data,status){
		$("#J_MiniCartNum").html(data);    
	  });
}
function checkChange(ele){
	
	var cartCheckBox = $(".check");
	var username = $("#usernameId").html();
	for(i=0;i<cartCheckBox.length;i++){
		cartCheckBox[i].checked=ele.checked;
		
	}
	$.get("/shoppingPro/shoppingCart?cmd=changeSign&checkBox="+ele.checked+"&userName="+username,
			function(data,status){
		   
		   var jsonObj=eval("("+data+")");
		  /* alert(jsonObj.selectGoodsNum);
		   alert(jsonObj.selectTotalPrice);*/
		   if (typeof (jsonObj) === 'object') { 
			   $(jsonObj).each(function (i) { 
			       $("#J_SelectedItemsCount").html(jsonObj[i].selectGoodsNum);
			       $("#J_Total").html(jsonObj[i].selectTotalPrice);
			   }); 
			   }
		   
	  });
	
}
function selectCart(ele) {
	var username = $("#usernameId").html();
	var id=ele.value;
	
	/*$("input[type='checkbox']:checked").each(function() {
		alert(this.val());
		console.debug(ele.value);
	})*/
	$.get("/shoppingPro/shoppingCart?cmd=changeSingleSign&checkBox="+ele.checked+"&userName="+username+"&id="+id,
			function(data,status){
		 
		   var jsonObj=eval("("+data+")");
		   if (typeof (jsonObj) === 'object') { 
			   $(jsonObj).each(function (i) { 
			       $("#J_SelectedItemsCount").html(jsonObj[i].selectGoodsNum);
			       $("#J_Total").html(jsonObj[i].selectTotalPrice);
			   }); 
			   }
	  });
}
function changeNum(cha,ele) {

	$.get("/shoppingPro/shoppingCart?cmd=changeNum&upOrDowm="+cha+"&id="+ele,
			function(data,status){

		 var jsonObj=eval("("+data+")");
		   if (typeof (jsonObj) === 'object') { 
			   $(jsonObj).each(function (i) { 
			       $(".singleTotalPrice"+ele).html(jsonObj[i].totalPriceById);
			       $("#J_Total").html(jsonObj[i].selectTotalPrice);
			   }); 
			   }
		
			
	
	});
	
	
}

function showCart(id){

	var kouwei=$("#kouwei"+id).val();

	var baozhuang=$("#baozhuang"+id).val();

	var num=$("#text_box").val();

	$.get("/shoppingPro/introduction?cmd=addToCart&id="+id+"&kouwei="+kouwei+"&baozhuang="+baozhuang+"&num="+num,
			function(data,status){
		
	/*	alert(data);*/
		$(".cart_num").html(data);
		
	});
}

