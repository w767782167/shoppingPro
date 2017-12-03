//通过省ID 获取市的数据
function getQuChange(){
	var cityId =  document.getElementById("cityId").value;
	console.debug(cityId);
	//1.创建Ajax对象
	var ajax = createAjax();
	
	ajax.open("get","/shoppingPro/linkage?cmd=qu&cityId="+cityId);
	
	
	//获取请求状态  异步  回调函数
	ajax.onreadystatechange = function() {
		if(ajax.readyState == 4 && ajax.status == 200){//接收响应数据
			var jsonStr =  ajax.responseText;
		    var jsonObj=eval("("+jsonStr+")");
		    var html="";
		    for ( var i = 0; i < jsonObj.length; i++) {
				html +="<option value='"+jsonObj[i].id+"'>"
				+jsonObj[i].name+"</option>";
			}
		   
			document.getElementById("quId").innerHTML = html;
		}
	};
	
	//3.发送请求
	ajax.send();
}
//通过省ID 获取市的数据
function getCityChange(){
	var provinceId =  document.getElementById("provinceId").value;
	
	//1.创建Ajax对象
	var ajax = createAjax();
	
	ajax.open("get","/shoppingPro/linkage?cmd=city&provinceId="+provinceId);
	
	
	//获取请求状态  异步  回调函数
	ajax.onreadystatechange = function() {
		if(ajax.readyState == 4 && ajax.status == 200){//接收响应数据
			var jsonStr =  ajax.responseText;
		    var jsonObj=eval("("+jsonStr+")");
		    var html="";
		    for ( var i = 0; i < jsonObj.length; i++) {
				html +="<option value='"+jsonObj[i].id+"'>"
				+jsonObj[i].name+"</option>";
			}
		   
			document.getElementById("cityId").innerHTML = html;
			getQuChange();
		}
	};
	
	//3.发送请求
	ajax.send();
}



//二级联动
 window.onload = function () {
	
	//1.创建Ajax对象
	var ajax = createAjax();
	
	ajax.open("get","/shoppingPro/linkage?cmd=province");
	
	
	//获取请求状态  异步  回调函数
	ajax.onreadystatechange = function() {
		if(ajax.readyState == 4 && ajax.status == 200){//接收响应数据
			var jsonStr =  ajax.responseText;
		  
		    //json String----> json obj
		    var jsonObj=eval("("+jsonStr+")");
		   
		    var html="";
		    for ( var i = 0; i < jsonObj.length; i++) {
				html +="<option value='"+jsonObj[i].id+"'>"
				+jsonObj[i].name+"</option>";
			}
		    
		    
			document.getElementById("provinceId").innerHTML = html;
			getCityChange();
			getQuChange();
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