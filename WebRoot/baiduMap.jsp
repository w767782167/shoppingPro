<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.js"></script>
<link rel="stylesheet" href="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.css" />
<style type="text/css">
html {
	height: 100%
}

body {
	height: 100%;
	margin: 0px;
	padding: 0px
}

#container {
    height:100%;
	/* height: 600px;
	width: 600px; */
	
}
</style>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=3wboVj8iN8QPzr5UepU4DlOLannSwZ1L">
	
</script>

</head>

<body>
	<div id="container"></div>
	<script type="text/javascript">
		var map = new BMap.Map("container");
		// 创建地图实例  
		var point = new BMap.Point(118.183, 24.495);
		// 创建点坐标  
		
		 var opts = {    
            width : 250,     // 信息窗口宽度    
            height: 100,     // 信息窗口高度    
            title : "地址"  // 信息窗口标题   
           };    
         var infoWindow = new BMap.InfoWindow("软件园观日路二号", opts);  // 创建信息窗口对象    
         map.openInfoWindow(infoWindow, point);      // 打开信息窗口
			
	     map.addEventListener("click",function(e){
	     map.openInfoWindow(infoWindow, point);
	     });
		
		
		 map.addEventListener("click",function(e){
		
		var point = new BMap.Point(e.point.lng, e.point.lat);
		var marker = new BMap.Marker(point);        // 创建标注    
        map.addOverlay(marker);                     // 将标注添加到地图中 

	    }); 
		
		map.centerAndZoom(point, 15);
		// 初始化地图，设置中心点坐标和地图级别
		map.enableScrollWheelZoom(true);//鼠标扩缩
		map.addControl(new BMap.NavigationControl());    
        map.addControl(new BMap.ScaleControl());    
        map.addControl(new BMap.OverviewMapControl());    
        map.addControl(new BMap.MapTypeControl());     
        map.setCurrentCity("厦门"); // 仅当设置城市信息时，MapTypeControl的切换功能才能可用  
        var opts = {offset: new BMap.Size(150, 5)};
        map.addControl(new BMap.ScaleControl(opts));   
        
        var marker = new BMap.Marker(point);        // 创建标注    
        map.addOverlay(marker);                     // 将标注添加到地图中 
        
       
       
       
     /* var geolocation = new BMap.Geolocation();//定位
	    geolocation.getCurrentPosition(function(r){
		if(this.getStatus() == BMAP_STATUS_SUCCESS){
			var mk = new BMap.Marker(r.point);
			map.addOverlay(mk);
			map.panTo(r.point);
			alert('您的位置：'+r.point.lng+','+r.point.lat);
			
          var driving = new BMap.DrivingRoute(map, {   //导航 
            renderOptions: {    
               map   : map,     
           panel : "results",    
           autoViewport: true    
         }    
          });    
          
            var options = {                          //导航路线
    onSearchComplete: function(results){    
        if (driving.getStatus() == BMAP_STATUS_SUCCESS){    
            // 获取第一条方案   
            var plan = results.getPlan(0);      
            // 获取方案的驾车线路   
            var route = plan.getRoute(0);      
            // 获取每个关键步骤，并输出到页面   
            var s = [];    
            for (var i = 0; i < route.getNumSteps(); i ++){    
                var step = route.getStep(i);    
                s.push((i + 1) + ". " + step.getDescription());    
            }    
            document.getElementById("log").innerHTML = s.join("<br>");    
        }    
    }    
};    
 var driving = new BMap.DrivingRoute(map, options);   

      driving.search(r.point, point);                 //导航结束 
			
			
			
		}
		else {
			alert('failed'+this.getStatus());
		}        
	    },{enableHighAccuracy: true});*/
	//关于状态码
	//BMAP_STATUS_SUCCESS	检索成功。对应数值“0”。
	//BMAP_STATUS_CITY_LIST	城市列表。对应数值“1”。
	//BMAP_STATUS_UNKNOWN_LOCATION	位置结果未知。对应数值“2”。
	//BMAP_STATUS_UNKNOWN_ROUTE	导航结果未知。对应数值“3”。
	//BMAP_STATUS_INVALID_KEY	非法密钥。对应数值“4”。
	//BMAP_STATUS_INVALID_REQUEST	非法请求。对应数值“5”。
	//BMAP_STATUS_PERMISSION_DENIED	没有权限。对应数值“6”。(自 1.1 新增)
	//BMAP_STATUS_SERVICE_UNAVAILABLE	服务不可用。对应数值“7”。(自 1.1 新增)
	//BMAP_STATUS_TIMEOUT	超时。对应数值“8”。(自 1.1 新增)
	</script>

</body>
</html>
