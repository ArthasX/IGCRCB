<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.util.SVCHelper"%>
<html:html>
<bean:define id="id" value="IGVIR1001" toScope="request" />
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

	<div id="Content">
		<div id="LeftPanel" class="dvPanel">
			<div id="Navi"  class="dvSerMenu">
			<div class="dvTitle"><div class="titText">服务目录</div></div>
			<div id="Menu">
				<ul>
					
					<li><a href="IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01002&ptid=8&actname=ACT17VIR0201"><img alt="" src="./images/vim01.gif"/> 资源使用申请</a></li>
					<li><a href="IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01003&ptid=8&actname=ACT17VIR0301"><img alt="" src="./images/vim02.gif"/> 资源调整申请</a></li>
					<li enable ="false"><a ><img alt="" src="./images/vim03g.gif"/> 资源回收申请</a></li>
					<li><a href="IGVIR0802.do?searchType=user"><img alt="" src="./images/vim04.gif"/> 我的个人资源</a></li>
					<li><a href="IGVIR0802.do?searchType=org"><img alt="" src="./images/vim05.gif"/> 我的部门资源</a></li>
					<li enable ="false"><a><img alt="" src="./images/vim06g.gif"/> 我的待回收资源</a></li>
					<li enable ="false"><a><img alt="" src="./images/vim07g.gif"/> 部门待回收资源</a></li>
				</ul>
			</div>
			</div>
			<div id ="Figure"  class="dvblock">
				<div class="dvTitle"><div class="titText">虚拟化资源费用统计</div></div>
				<div class="dvContent">
					<table class="tbFigure" >
						<tr><td class="tdTitle">个人状况统计(单位:元)</td></tr>
						<tr><td id="tdPerFigure" class="tdContent">0</td></tr>
					</table>
					<table class="tbFigure" >
						<tr><td class="tdTitle">部门状况统计(单位:元) </td></tr>
						<tr><td id="tdOrgFigure" class="tdContent">0</td></tr>
					</table>
				</div>
			</div>
		</div>
		<div id="Main" class="dvPanel">
			<div id="My"  class="dvblock" style="width:453px; height:251px;">
				<div class="dvTitle">
					<div class="titText">资源申请状况</div>
<!-- 					<div class="dvMore"><a href="#">more&gt;&gt;</a></div> -->
				</div>
				<div class="dvContent">
					<table class="table_style">
						<tr>
							<th>序号</th><th>状态</th><th>申请内容</th><th>申请时间</th><th>项目名称</th>
						</tr>
						<logic:present name="IGVIR10011VO" parameter="lstProcessRecord">
							<logic:iterate id="bean" name="IGVIR10011VO" property="lstProcessRecord" indexId="index">
								
								<tr prid="${bean.prid }">
								<td>${index+1 }</td>
								<!-- 状态 -->
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
										<logic:equal value="C" property="prsubstatus" name="bean">
											<td>(中止)</td>
										</logic:equal>
									</logic:equal>
									<logic:notEqual value="WD" name="bean" property="prtype">
										<td >
						  					<logic:notEqual value="" property="prsubstatus" name="bean">
												<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />(<ig:codeValue ccid="${bean.prtype}SUB" cid="${bean.prsubstatus}"/>)
											</logic:notEqual>
											<logic:equal value="" property="prsubstatus" name="bean">
												<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />
											</logic:equal>
										</td>
									</logic:notEqual>
									<!-- 申请内容 -->
									<td>${bean.prtitle} </td>
									<!-- 申请时间 -->
									<td>${bean.propentime }</td>
									
									<!-- 项目名称 -->
									<td><ig:publicProcessInfoValue pidname="项目名称" prid="${bean.prid }"/> </td>
								</tr>
							</logic:iterate>
						</logic:present>
					</table>
				</div>
			</div>
			<div id="MyVm" class="dvblock" style="width: 290px;height:251px; margin: 0px;">
				<div class="dvTitle">
					<div class="titText">我的资源</div>
				</div>
				<div class="dvContent" style="overflow: auto; overflow-x:hidden;height:226px;">
					<table class="table_style" >
					<tr><th width="70px">序号</th><th>名称</th></tr>
						<logic:present name="IGVIR10011VO" property="ownVMlist">
							<logic:iterate id="bean" name="IGVIR10011VO" property="ownVMlist" indexId="index">
								<tr>
								
									<td>${index+1 }</td>
									<td>${bean.vmName }</td>
								</tr>
							</logic:iterate>
						</logic:present>
					</table>
				</div>
			</div>
			<div id="MyTemplate" class="dvblock" style="width:453px;height:260px;">
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
			<div id="Resouce"  class="dvblock"  style="width: 290px; height:251px; margin: 0px;">
				<div class="dvTitle">
					<div class="titText">资源信息</div>
				</div>
				<div class="dvContent">
				
				<div id="resPre" style="min-width: 280px; height: 220px;"></div>
<!-- 				<div id="resOrg" style="min-width: 310px; height: 240px; margin-left:80px; float:left; "></div> -->
				</div>
			
			</div>
<!-- 			<div id="Figure"> -->
<!-- 				<div class="dvTitle"> -->
<!-- 					<div class="titText">金额结算</div> -->
<!-- 					<div class="dvMore">more&gt;&gt;</div> -->
<!-- 				</div> -->
			
<!-- 			</div> -->
		</div>
		</div>
	</div>
</body>


<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	var jQ = jQuery.noConflict(true);
</script>

<script type="text/javascript" src="js/Highcharts/highcharts.js"></script>
<script type="text/javascript" src="js/Highcharts/modules/exporting.js"></script>
<script type="text/javascript">

var userExpireCount = parseFloat('${IGVIR10011VO.userExpireCount}'),
	userCount = parseFloat('${IGVIR10011VO.userCount}'),
	orgExpireCount = parseFloat('${IGVIR10011VO.orgExpireCount}'),
	orgCount = parseFloat('${IGVIR10011VO.orgCount}');


jQ(function () {
    
   jQ(document).ready(function () {
	   
	   Highcharts.setOptions({
		    colors: ['#ED6B38', '#FFA82B', '#6AF9C4', '#DDDF00', '#24CBE5', '#64E572', '#FF9655',
		'#FFF263',]
		});
// 	  var userCount = 5;
// 	  var userExpireCount = 3;
	  var userCount = parseFloat('${IGVIR10011VO.userCount}');
	  var userExpireCount = parseFloat('${IGVIR10011VO.userExpireCount}');
// 	  var orgCount = parseFloat('${IGVIR10011VO.orgCount}');
// 	  var orgExpireCount = parseFloat('${IGVIR10011VO.orgExpireCount}');
    	
    if(userCount){
       jQ('#resPre').highcharts({
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },
            title: {
                text: ''
            },
            tooltip: {
        	    pointFormat: '{series.name}: <b>{point.y} 个</b>'
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
            legend:{
         	   layout:'vertical',
        	   align: 'right',
               verticalAlign: 'middle'
            },
            exporting:{
         	   enabled:false
            },
            series: [{
                type: 'pie',
                name: '数量',
                data: [
                   		 {
                        name: '即将回收',
                        y: userExpireCount,
                        sliced: false,
                        selected: false
                    }
                    ,['其他',   userCount-userExpireCount]
                ]
            }]
        });
    }else{
    	showNoData( jQ('#resPre'),'个人资源信息');
    }
//     if(orgCount&&orgExpireCount){
//        jQ('#resOrg').highcharts({
//            chart: {
//                plotBackgroundColor: null,
//                plotBorderWidth: null,
//                plotShadow: false
//            },
//            title: {
//                text: '部门资源信息'
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
//            legend:{
//         	   layout:'vertical'
//            },
//            exporting:{
//         	   enabled:false
//            },
//            series: [{
//                type: 'pie',
//                name: '占全部比例',
//                data: [
                   
//                    {
//                        name: '即将回收',
//                        y: parseFloat('${IGVIR10011VO.orgExpireCount}'),
//                        sliced: true,
//                        selected: true
//                    },
//                    ['其他',   parseFloat('${IGVIR10011VO.orgCount}')-parseFloat('${IGVIR10011VO.orgExpireCount}')]
//                ]
//            }]
//        });
//     }else{
//     	showNoData( jQ('#resOrg'),'部门资源信息');
//     }
 	   var preCount = parseInt('${IGVIR10011VO.usercost}');
 	   var orgCount = parseInt('${IGVIR10011VO.orgcost}');
	   
	   showCount(jQ("#tdPerFigure"),preCount);
	   showCount(jQ("#tdOrgFigure"),orgCount);
	   
	   //LI绑定事件
// 	   jQ("#Menu").find("li").
    	
	   //流程表格绑定点击事件
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

//缓冲效果显示金额
function showCount(obj,targer){
	obj.timer=setTimeout(function(){
		var speed = Math.round((targer-parseInt(obj.html()))*0.8);
		if(obj.html()==targer){
			clearTimeout(obj.timer);
		}else{
			var content = (parseInt(obj.html())+speed);
			obj.html(content);
			showCount(obj,targer);
		}
		
	},15);
	
}
function showNoData(obj,text){
	obj.append("<div style='margin-top:9px;width:100%;color:#274b6d;font-size:16px;font-family: Verdana, Arial, Helvetica, sans-serif;'>"+"</div><div style='text-align:center; width:100%;height:200px;'><img style='vertical-align: middle;' src='./images/nodata.png' border='0px'/></div>");
}
</script>
</html:html>
