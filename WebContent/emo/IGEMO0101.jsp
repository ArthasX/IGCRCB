<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGEMO0101" toScope="request" />
<bean:define id="title" value="Oracle性能监控" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->

<link type="text/css" href="css/vim_Index.css" rel="stylesheet"/>
<style>
.dvblock .dvTitle{
	width: 100%;
	background-image:url("../images/bg_titlevim101.png");
	font-size: 14px;
	height: 25px;
	vertical-align: middle;
	line-height: 25px;
}
.dvblock .dvTitle .titText{
	float:left; 
	width:70%;
	text-align: left;
	text-indent: 15px;
	color: #1C87E1;
	font-weight: 800;
	
}
.dvblock{
	margin-bottom: 10px;
	border: 1px solid #ccc;
	float: left;
	margin-right: 10px;
	width:100%;
	
}
</style>

<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	var jQ = jQuery.noConflict(true);
</script>

<script type="text/javascript" src="js/Highcharts/highcharts.js"></script>
<script type="text/javascript" src="js/Highcharts/modules/exporting.js"></script>
<script type="text/javascript">
//var par1 = {};
// par1.categories = ['s8d8sdf', 's54dc22s', '5s5xcs', 'z52sds0c'];
// par1.series = [{
// 	    name: 'OTHER',
// 	    data: [12, 32, 54,24]
// 	}, {
// 	    name: 'CPU',
// 	    data: [78, 72, 33, 22]
// 	}, {
// 	    name: 'SYS',
// 	    data: [23, 4, 10,10]
// 	}, {
// 	    name: 'MEN',
// 	    data: [13, 24, 35,30]
// 	}, {
// 	    name: 'USER',
// 	    data: [45, 24, 0,20]
// 	}];
// par1.info = [{td1:'2.30',td2:'SELECT',td3:'select * from ig.ss ss where......order by id'},
//              {td1:'2.10',td2:'SELECT',td3:'select * from ig.ss czxcx where......order by id'},
//              {td1:'1.97',td2:'SELECT',td3:'select * from ig.ss sdsa where......order by id'},
//              {td1:'1.84',td2:'SELECT',td3:'select * from ig.ss s where......order by id'}];
             
//var par2 = {};
// par2.categories = ['6545', '8798', '1232', '4575', '4215', '7532', '4532', '7853', '2355', '1235'];
// par2.series = [{
//     name: 'OTHER',
//     data: [12, 32, 54,24,24,0,10,0,1,8]
// }, {
//     name: 'CPU',
//     data: [78, 72, 33, 22, 18,40,20,10,10,0]
// }, {
//     name: 'SYS',
//     data: [23, 4, 10,10,40,10,10,8, 12, 5]
// }, {
//     name: 'MEN',
//     data: [13, 24, 35,30,0,0,0,10, 2, 2]
// }, {
//     name: 'USER',
//     data: [45, 24, 0,20,0,0,0,3, 2, 3]
// }];
// par2.info = [{td1:'2.30',td2:'ZLX',td3:'select * from ig.ss ss where......order by id'},
//          {td1:'2.10',td2:'LSH',td3:'select * from ig.ss czxcx where......order by id'},
//          {td1:'1.97',td2:'EXAM',td3:'select * from ig.ss sdsa where......order by id'},
//          {td1:'1.84',td2:'WANGHL',td3:'select * from ig.ss s where......order by id'},
//          {td1:'1.75',td2:'PDA',td3:'select * from ig.ss dsa where......order by id'},
//          {td1:'1.66',td2:'ZYAN',td3:'select * from ig.ss sds where......order by id'},
//          {td1:'1.57',td2:'ZHAN',td3:'select * from ig.ss sdsdsds where......order by id'},
//          {td1:'1.31',td2:'YHF',td3:'select * from ig.ss sdsa where......order by id'},
//          {td1:'1.11',td2:'WANGLI',td3:'select * from ig.ss where......order by id'},
//          {td1:'0.92',td2:'WANGSY',td3:'select * from ig.ss where......order by id'}];

function setbardata(containerId,par){
	Highcharts.setOptions({
	    colors:par.colors
	});
	jQ(function () {
		jQ("#"+containerId).highcharts({
	        chart: {
	            type: 'bar'
	        },
	        title: {
	            text: ''
	        },
	        xAxis: {
	            categories: par.categories
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: ''
	            }
	        },
	        legend: {
	            backgroundColor: '#FFFFFF',
	            reversed: true
	        },
            exporting:{
          	   enabled:false
            },
	        plotOptions: {
	            series: {
	                stacking: 'normal'
	            }
	        },
	            series: par.series
	    });
	});
	jQ("#"+containerId).css("height","10px");
	var j = 0;
	jQ("#"+containerId).next().find("table").empty();
	jQ(par.info).each(function(i,t){
		td3str = t.td3
		if(td3str.length>35){
			td3str = td3str.substring(0,35)+'...';
		}
		var tdstr = "<tr style='height: 21px'><td width='18%'>"+t.td1+"%</td><td width='20%'>"+t.td2+"</td><td>"+td3str+"</td>"
		+"<td style='display: none;'><pre>"+t.td3+"</pre></td></tr>";
		jQ("#"+containerId).next().find("table").append(tdstr);
		j ++;
	});
	jQ("#"+containerId).next().find("table").find("tr").each(function(){
		jQ(this).attr("title",jQ(this).find("pre").text());
	});
	var theight = j*21+77;
	//alert(theight);
	jQ("#"+containerId).css("height",theight+"px");
}
function init(){
	var initSQLStr =${IGEMO0101VO.initSQLStr};
	var initSessionStr =${IGEMO0101VO.initSessionStr};
	var sid = ${IGEMO0101VO.initSQLStr}.sid;
	if(sid==''){
		alert("该实例没有实时性能分析!");
		window.close();
	}
	setbardata("topSQL",initSQLStr);
	setbardata("topSession",initSessionStr);
	document.getElementById('sid_div').innerHTML="当前实例: "+sid;
}
</script>

<body onload="init()">
<div id="maincontent">
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
 <div id="contentWrap">
	<div id="content">
		<div id="Main" class="dvPanel" style="width: 1001px">
		<div id="sid_div" style="float: left;font-size: 12px;font-weight: bold;">当前实例：</div>
			<div class="title">
				<div class="name">TOP SQL</div>
			</div>
			<div id="My"  class="dvblock" >
				<div>
					<table class="table_style" style="width: 1000px">
						<tr>
							<th width="7%">SQLID</th>
							<th width="37%">&nbsp;</th>
							<th width="10%">活动百分比</th>
							<th width="11%">SQL类型</th>
							<th width="30%">SQL内容</th>
							<th width="0%" >&nbsp;</th>
						</tr>
					</table>
				</div>
				<div class="dvContent" id="topSQL" style="width:440px;border-style: none;height:10px;float: left;">
				</div>
				<div class="dvContent" style="width: 560px; margin: 0px;border-style: none;float: left;">
					<table class="table_style" style="margin-top: 10px">
					</table>
				</div>
			</div>
			<div class="title">
				<div class="name">TOP SESSION</div>
			</div>
			<div id="MyVm" class="dvblock" style="">
				<div>
					<table class="table_style" style="width: 1000px">
						<tr>
							<th width="7%">会话ID</th>
							<th width="37%">&nbsp;</th>
							<th width="10%">活动百分比</th>
							<th width="11%">用户名</th>
							<th width="30%">程序</th>
							<th width="0%">&nbsp;</th>
						</tr>
					</table>
				</div>
				<div class="dvContent" id="topSession" style="width:440px;border-style: none;height:10px;float: left;">
				</div>
				<div class="dvContent" style="width: 560px; margin: 0px;border-style: none;float: left;">
					<table class="table_style" style="margin-top: 10px">
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="zishiying"></div>
</div>

</div>
</body>
</html:html>