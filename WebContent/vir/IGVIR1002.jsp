<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.util.SVCHelper"%>
<html:html>
<bean:define id="id" value="IGVIR1002" toScope="request" />
<bean:define id="title" value="首页"  toScope="request" >

</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<link type="text/css" href="css/vim_Index.css" rel="stylesheet"/>

<!-- /header1 -->


<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />

	<div id="Content" >
		<div id="LeftPanel" class="dvPanel">
			<div id="Navi" class="dvSerMenu">
				<div class="dvTitle"><div class="titText">服务目录</div></div>
				<div id="Menu">
					<ul>
						<li><a href="IGVIR0801.do"><img alt="" src="./images/vim04.gif"/> 个人资源情况</a></li>
						<li><a href="IGVIR0803.do"><img alt="" src="./images/vim05.gif"/> 部门资源情况</a></li>
						<li><a href="IGCOM0202.do?linkID=IGVIR1104"><img alt="" src="./images/vim08.gif"/> 项目资源情况</a></li>
						<li><a href="IGCOM0202.do?linkID=IGVIR1104"><img alt="" src="./images/vim09.gif"/> 个人资源计费</a></li>
						<li><a href="IGCOM0202.do?linkID=IGVIR1105"><img alt="" src="./images/vim10.gif"/> 部门资源计费</a></li>
						<li><a href="IGCOM0202.do?linkID=IGVIR1103"><img alt="" src="./images/vim11.gif"/> 项目资源计费</a></li>
						<li><a href="IGVIR1201.do"><img alt="IGVIR1201.do" src="./images/vim12.gif"/> 资源分配情况</a></li>
					</ul>
				</div>
			</div>
			<div id="ResouceInfo" class="dvblock">
				<div class="dvTitle">
					<div class="titText">资源概况</div>
<!-- 					<div class="dvMore"><a href="#">more&gt;&gt;</a></div> -->
				</div>
				<div class="dvContent" >
					<table class="rs_tb_style">
						<tr>
						<th>Host总数</th><td>${IGVIR10011VO.resourceSurveyMap["host"]}个</td></tr><tr>
						<th>VM总数</th><td>${IGVIR10011VO.resourceSurveyMap["vm"]}个</td></tr><tr>
						<th>用户总数</th><td>${IGVIR10011VO.resourceSurveyMap["user"]}人</td></tr><tr>
						<th>部门总数</th><td>${IGVIR10011VO.resourceSurveyMap["org"]}个</td></tr><tr>
						<th>项目总数</th><td>${IGVIR10011VO.resourceSurveyMap["proj"]}个</td></tr><tr>
						<th>计费总额</th><td>${IGVIR10011VO.resourceSurveyMap["cost"]}元</td>
						</tr>
					</table>
				</div>
			</div>
			
		</div>
		<div id="Main" class="dvPanel">
			
		
			<div id="My" style="width:453px; height:251px;" class="dvblock">
				<div class="dvTitle">
					<div class="titText">待处理工作</div>
<!-- 					<div class="dvMore"><a href="#">more&gt;&gt;</a></div> -->
				</div>
				<div class="dvContent">
					<table class="table_style">
						<tr>
							<th>状态</th><th>申请内容</th><th>申请时间</th><th>处理人</th><th>项目名称</th>
						</tr>
						<logic:present name="IGVIR10011VO" property="pihList">
							<logic:iterate id="bean" name="IGVIR10011VO" property="pihList" indexId="index">
								
								<tr prid="${bean.prid }">
									
									<logic:equal value="WD" name="bean" property="prtype">
										<logic:notEqual value="W" property="prstatus" name="bean">
											<td onclick="doLook(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />&jump=78');">
												<ig:processDefineTypeValue prid="${bean.prid}"/>
											</td>
										</logic:notEqual>
										<logic:equal value="W" property="prstatus" name="bean">
											<td>
												<a href="javascript:ope(${bean.prid});"><ig:processDefineTypeValue prid="${bean.prid}"/></a>
											</td>
										</logic:equal>
<%-- 										<logic:equal value="C" property="prsubstatus" name="bean"> --%>
<!-- 											<td>(中止)</td> -->
<%-- 										</logic:equal> --%>
									</logic:equal>
									<logic:notEqual value="WD" name="bean" property="prtype">
										<td onclick="doLook(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />&jump=78');">
<%-- 						  					<logic:notEqual value="" property="prsubstatus" name="bean"> --%>
<%-- 											</logic:notEqual> --%>
<%-- 											<logic:equal value="" property="prsubstatus" name="bean"> --%>
<%-- 												<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" /> --%>
<%-- 											</logic:equal> --%>
										</td>
									</logic:notEqual>
									
									<td>${bean.prtitle}</td>
									<td>${bean.propentime }</td>
									<td>${bean.ppusername }</td>
									<td><ig:publicProcessInfoValue pidname="项目名称" prid="${bean.prid }"/> </td>
								</tr>
							</logic:iterate>
						</logic:present>
					</table>
				</div>
			</div>
			<div id="CountMonth" class="dvblock" style="width: 290px;height:251px; margin: 0px;">
				<div class="dvTitle">
					<div class="titText">资源申请数量</div>
<!-- 					<div class="dvMore"><a href="#">more&gt;&gt;</a></div> -->
				</div>
				<div class="dvContent">
					<div id="countInfo" style="min-width: 280px; height: 220px; margin: 0px;"></div>
				</div>
			</div>
			<!-- 模板信息 -->
			<div id="MyTemplate" class="dvblock" style="width:453px;height:259px;">
				<div class="dvTitle">
					<div class="titText">模板资源</div>
				</div>
				<div class="dvContent">
					<table class="table_style" >
						<tr><th width="10%">序号</th><th width="35%" >模板名称</th><th width="15%">CPU数量</th><th width="15%">内存(Gb)</th><th width="15%">硬盘(Gb)</th></tr>
						<logic:present name="IGVIR10011VO" property="templateList">
							<logic:iterate id="bean" name="IGVIR10011VO" property="templateList" indexId="index">
								<tr>
									<td>${index+1 }</td>
									<td title="${bean.name }"  style="overflow: hidden; white-space:nowrap; text-overflow:ellipsis; text-align: left;">${bean.name }</td>
									<td>${bean.numCPU }</td>
									<td>${bean.memoryGB }</td>
									<td>${bean.diskGB }</td>
								</tr>
							</logic:iterate>
						
						</logic:present>
					</table>
				</div>
			</div>
			<!-- 资源分布饼图 -->
			<div id="Resouce" class="dvblock" style="width: 290px;height:259px; margin: 0px;">
				<div class="dvTitle">
					<div class="titText">资源分布情况</div>
<!-- 					<div class="dvMore"><a href="#">more&gt;&gt;</a></div> -->
					
				</div>
				<div class="dvContent">
					<div id="orgRes" style="min-width: 280px; height: 220px; margin: 0px;"></div>
				</div>
			
			</div>

		</div>
		</div>
	</div>
	
	<script>
	var orgRes=new Array(),orgExpiryRes = new Array();
	<logic:iterate id="bean" name ="IGVIR10011VO" property="orgResList">
		orgRes.push(['${bean.orgname}',parseFloat('${bean.count}')]);
	</logic:iterate>
	<logic:iterate id="bean" name ="IGVIR10011VO" property="orgExpiryResList">
		orgExpiryRes.push(['${bean.orgname}',parseFloat('${bean.count}')]);
	</logic:iterate>	
	
	</script>
</body>


<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	var jQ = jQuery.noConflict(true);
</script>

<script type="text/javascript" src="js/Highcharts/highcharts.js"></script>
<script type="text/javascript" src="js/Highcharts/modules/exporting.js"></script>
<script type="text/javascript">

var countInfo={};
var months={};
<logic:iterate id="bean" name ="IGVIR10011VO" property="monthCountData">
 	if(countInfo['${bean[0]}']){
		countInfo['${bean[0]}'][${bean[3]}]='${bean[2]}';
 	}else{
 		countInfo['${bean[0]}']={${bean[3]}:'${bean[2]}'};
 	}
 	if(!months['${bean[3]}']){
 		months['${bean[3]}']=true;
 	}
 	
</logic:iterate>

function getArr(obj,monthArr){
	var result=[];
	for(var i=0;i<monthArr.length;i++){
		if(obj[monthArr[i]]){
			result.push(parseInt(obj[monthArr[i]]));
		}else{
			result.push(0);
		}
	}
	return result;
}
jQ(function () {
    
   jQ(document).ready(function () {
	   
	   var monthArr = [];
	   for(var k in months){
	   	monthArr.push(k);
	   }
	   
	   if(monthArr.length<3){
		   var arrlength = monthArr.length;
		   for(var i=0;i<3-arrlength;i++){
			   var newMonth =parseInt(monthArr[0])%100>1?parseInt(monthArr[0]-1)+'':parseInt((''+monthArr[0]).substring(0,4))-1+'12';
		 	  monthArr.unshift(parseInt(newMonth));
		   }
	   }
	   
	   var seriesData = '${IGVIR10011VO.monthCountJson}';
	   seriesData = eval("(" + seriesData + ")");
// 	   var seriesData = [];
// 	   for(var k in countInfo){
// 	   	seriesData.push({name:k,data:getArr(countInfo[k],monthArr)});
// 	   }
	   Highcharts.setOptions({
		    colors: ['#ED6B38', '#FFA82B', '#6AF9C4', '#DDDF00', '#24CBE5', '#64E572', '#FF9655',
		'#FFF263',]
		});
	  
    	
    	// Build the chart
    	
    	if(orgRes.length>0){
	       jQ('#orgRes').highcharts({
	            chart: {
	                plotBackgroundColor: null,
	                plotBorderWidth: null,
	                plotShadow: false
	            },
	            title: {
	                text: ''
	            },
	            tooltip: {
	        	    pointFormat: '{series.name}: <b>{point.y}</b>'
	            },
	            legend:{
	         	   layout:'vertical',
	         	  	align: 'right',
	               verticalAlign: 'middle'
	            },
	            plotOptions: {
	                pie: {
	                    allowPointSelect: true,
	                    cursor: 'pointer',
	                    dataLabels: {
	                        enabled: false
	                    },
	                    showInLegend: true
	                }
	            },
	            exporting:{
	         	   enabled:false
	            },
	            series: [{
	                type: 'pie',
	                name: '分配数量',
	                data: orgRes
	            }]
	        });
    	}else{
    		showNoData(jQ('#orgRes'),'资源分布情况');
    	}
    	
    	  // 资源分布情况
    	 jQ('#countInfo').highcharts({
             title: {
            
                 text: '',
                 x: -20 //center
             },
             tooltip: {
	        	    pointFormat: '<b>{point.y}</b>'
	            },
             exporting:{
	         	   enabled:false
	            },
             xAxis: {
                 categories: monthArr
             },
             yAxis: {
                 title: {
                     text: '申请数量(台)'
                 },
                 plotLines: [{
                     value: 0,
                     width: 1,
                     color: '#808080'
                 }]
             },
             tooltip: {
                 valueSuffix: ''
             },
             legend: {
            	 enabled:false
//                  layout: 'vertical',
//                  align: 'right',
//                  verticalAlign: 'middle',
//                  borderWidth: 0
             },
//              series: [{data:[{y:0},{y:0},{y:2}]}]
             series: seriesData
         });

    	
    	
    	
    	
//        jQ('#expRes').highcharts({
//            chart: {
//                plotBackgroundColor: null,
//                plotBorderWidth: null,
//                plotShadow: false
//            },
//            title: {
//                text: '近期待回收资源情况'
//            },
//            legend:{
//         	   layout:'vertical'
//            },
//            tooltip: {
//        	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
//            },
//            plotOptions: {
//                pie: {
//                    allowPointSelect: true,
//                    cursor: 'pointer',
//                    dataLabels: {
//                        enabled: false
//                    },
//                    showInLegend: true
//                }
//            },
//            exporting:{
//         	   enabled:false
//            },
//            series: [{
//                type: 'pie',
//                name: '占全部比例',
//                data: orgExpiryRes
//            }]
//        });
       
//  var preCount = 788.65,orgCount=455441.21;
	   
// 	   showCount(jQ("#tdPerFigure"),preCount);
// 	   showCount(jQ("#tdOrgFigure"),orgCount);
	   jQ("#Menu").find("li").bind({
		   mouseover:function(){
			   jQ(this).addClass("hover_style");
		   },
		   mouseout:function(){
			   jQ(this).removeClass("hover_style");
		   },
		   click:function(){
			   
		   }
	   });
	   jQ("tr[prid]").each(function(i,t){
		   jQ(t).bind({
			   click:function(){
				   doLook(getAppRootUrl()+'/IGPRR0102_Disp.do?prid='+jQ(this).attr("prid")+'&jump=78');
			   },
			   mouseover:function(){
				   jQ(this).addClass("hover_td");
			   },
			   mouseout:function(){
				   jQ(this).removeClass("hover_td");
			   }
			   
		   });
	   });
    	
    });
    
});

function showCount(obj,targer){
	
	obj.timer=setTimeout(function(){
		var speed = Math.round((targer*100-parseFloat(obj.html())*100)*0.8);
		if(obj.html()==targer){
			clearTimeout(obj.timer);
		}else{
			var content = (parseFloat(obj.html())*100+speed)/100;
			obj.html(content.toFixed(2));
			showCount(obj,targer);
		}
		
	},15);
	
}

function showNoData(obj,text){
	obj.append("<div style='width:100%'>"+"</div><div style='text-align:center;'><img src='./images/nodata.png' border='0px'/></div>");
}
</script>
</html:html>
