//alert(1111);
window.onload=function(){
//1.创建ajax对象
	var ajax=createAjax();
	ajax.open("get","/shoppingPro/linkage?cmd=province",true);
//2.获取请求状态 异步 回调函数
	ajax.onreadystatechange = function(){
		if(ajax.readyState == 4 && ajax.status == 200){//接收响应数据
		var jsonStr=ajax.responseText;
		console.debug(jsonStr);
		//json---->Obj
		var jsonObj=eval("("+jsonStr+")");
		console.debug(jsonObj);
		var html="";
		for ( i= 0; i<jsonObj.length; i++) {
			html +="<option value='"+jsonObj[i].id+"'>"
			+jsonObj[i].name+"</option>";
		}
		console.debug(html);
		document.getElementById("province").innerHTML=html;
		}
		sel();
	};
//3.发送情求
	ajax.send();
};

  
  
function createAjax(){
	var ajax;
	try {
		ajax = new XMLHttpRequest();
		
	} catch (e) {
		// : handle exception
		ajax = new ActiveXObject();
		
	}
	return ajax;
}

//随动市
function sel(){
	//1.创建ajax对象
	var ajax=createAjax();
	//select通过Value获取<option value="id">的 ID,如果<option>里面没有设置value
	//则得到的是<option>内容</option>中间的内容
	var provinceId=document.getElementById("province").value;
	ajax.open("get","/shoppingPro/linkage?cmd=city&id="+provinceId,true);
//2.获取请求状态 异步 回调函数
	ajax.onreadystatechange = function() {
		if(ajax.readyState == 4 && ajax.status == 200){//接收响应数据
			var jsonStr =  ajax.responseText;
		    var jsonObj=eval("("+jsonStr+")");
		    var html="";
		    for ( var i = 0; i < jsonObj.length; i++) {
				html +="<option value='"+jsonObj[i].id+"'>"
				+jsonObj[i].name+"</option>";
			}
		    console.debug(html);
			document.getElementById("city").innerHTML = html;
		}
	};
//3.发送情求
	ajax.send();
}

