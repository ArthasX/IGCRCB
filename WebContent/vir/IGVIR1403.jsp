<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.deliverik.infogovernor.util.SVCHelper"%>
<html:html>
<bean:define id="id" value="IGVIR1403" toScope="request" />
<bean:define id="title" value="虚机资源管理" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css">
fieldset div {
	clear:left;
	margin-bottom:2px;
	margin-top: 2px;
	margin-left: 0px;
}
</style>
<script type="text/javascript">
//查看
function doLook(url){
	window.location=url;
}
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGVIR1301" styleId="form" onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">虚机资源管理</p>
	</div>
	<div id="search" style="border: 0px; ">
	<div>
		<fieldset style="width: 595px;;float:left;">
			<legend>资源申请流程情况</legend>
			<div style="height: 5px;"></div>
			<div style="height: 200px; overflow: auto; overflow-x:hidden;">
				<table class="table_style">
					<tr align="left" height="28">
	                <th width="100" align="center">编号</th>
	                <th width="155" align="center">名称</th>
	                <th width="75" align="center">类型</th>
	                <th width="105" align="center">开始时间</th>
	                <th width="75" align="center">处理人</th>
					</tr>
					<logic:iterate id="processRecordInfo" name="IGVIR14031VO" indexId="index" length="7" property="resprocessRecordList">
						<tr onclick="doLook('IGPRR0102_Disp.do?prid=<bean:write name="processRecordInfo" property="prid" />&jump=78')" style='cursor:hand' bgcolor="<ig:ProcessOverdueLevelBgColorTag prid="${processRecordInfo.prid }"/>" class="my_work" >
				    		<td>${processRecordInfo.prserialnum}</td>
				    		<td>
					    		<span title="${processRecordInfo.prtitle}">${processRecordInfo.prtitle}</span>
							</td>
				    		<td style="text-align: left"><span title="${processRecordInfo.prpdname }">${processRecordInfo.prpdname }</span></td>
				    		<td>${processRecordInfo.propentime}</td>
				    	
							<td title="<ig:ProcessParticipantForStatusWriteTag prstatus="${processRecordInfo.prstatus }" prid="${processRecordInfo.prid }" />">
							<ig:SubstringShowEllipsisWriteTag len="4" showEllipsis="true">
								<ig:ProcessParticipantForStatusWriteTag prstatus="${processRecordInfo.prstatus }" prid="${processRecordInfo.prid }" />
							</ig:SubstringShowEllipsisWriteTag>
							</td>
						
						</tr>
				     	<logic:equal name="index" value="9">
				     		<tr>
				            <td colspan="9">
				             <a href="IGCOM0202.do?linkID=IGSVC0101&actname=ACT02SVC0101"><img src="images/main_more.gif" border="0" class="more_img"/></a>
				          &nbsp;</td>
				     	</tr>
				     	</logic:equal>
					</logic:iterate>
				</table>
			</div>
		</fieldset>
		<fieldset style="width: 320px; float: right; height: 100%;">
			<legend>资源申请发生数量</legend>
			<div style="height: 5px;"></div>
			<div id="resCount"  style="height: 200px; ">
			</div>
		</fieldset>
	</div>
	<div>
		<fieldset style="width: 595px; float: left;">
			<legend>运维流程情况</legend>
			<div style="height: 5px;"></div>
			<div style="height: 200px; overflow: auto; overflow-x:hidden; ">
				<table class="table_style">
					<tr align="left" height="28">
	                <th width="100" align="center">编号</th>
	                <th width="155" align="center">名称</th>
	                <th width="75" align="center">类型</th>
	                <th width="105" align="center">开始时间</th>
	                <th width="75" align="center">处理人</th>
					</tr>
					<logic:iterate id="processRecordInfo" name="IGVIR14031VO" indexId="index" length="7" property="omprocessRecordList">
						<tr onclick="doLook('IGPRR0102_Disp.do?prid=<bean:write name="processRecordInfo" property="prid" />&jump=78')" style='cursor:hand' bgcolor="<ig:ProcessOverdueLevelBgColorTag prid="${processRecordInfo.prid }"/>" class="my_work" >
				    		<td>${processRecordInfo.prserialnum}</td>
				    		<td>
					    		<span title="${processRecordInfo.prtitle}">${processRecordInfo.prtitle}</span>
							</td>
				    		<td style="text-align: left"><span title="${processRecordInfo.prpdname }">${processRecordInfo.prpdname }</span></td>
				    		<td>${processRecordInfo.propentime}</td>
				    	
							<td title="<ig:ProcessParticipantForStatusWriteTag prstatus="${processRecordInfo.prstatus }" prid="${processRecordInfo.prid }" />">
							<ig:SubstringShowEllipsisWriteTag len="4" showEllipsis="true">
								<ig:ProcessParticipantForStatusWriteTag prstatus="${processRecordInfo.prstatus }" prid="${processRecordInfo.prid }" />
							</ig:SubstringShowEllipsisWriteTag>
							</td>
						
						</tr>
				     	<logic:equal name="index" value="9">
				     		<tr>
				            <td colspan="9">
				             <a href="IGCOM0202.do?linkID=IGSVC0101&actname=ACT02SVC0101"><img src="images/main_more.gif" border="0" class="more_img"/></a>
				          &nbsp;</td>
				     	</tr>
				     	</logic:equal>
					</logic:iterate>
				</table>
			</div>
		</fieldset>
		<fieldset style="width: 320px; float: right;">
			<legend>运维流程发生数量</legend>
			<div style="height: 5px;"></div>
			<div id="omCount"  style="height: 200px; min-width: 300px; margin: 0 auto">
			</div>
		</fieldset>
	</div>
	<fieldset style="clear:left;">
		<legend>Host资源使用情况</legend>
		<div style="float: left; height: 220px; width: 20px; vertical-align: middle;">
			<img id="previous" alt="向前" src="images/arrow-left.gif" style="vertical-align: middle; cursor: pointer; display: none;" onclick="getPrevious()"/>
		</div>
		<div style="float: right; height: 220px; width: 20px;">
			<img id="next" alt="向后" src="images/arrow-right.gif" style="vertical-align: middle; margin: auto; cursor: pointer; display: none;" onclick="getNext()"/>
		</div>
		<div id="countInfo" style="width: 900px; height: 220px; float: right;">
		
		</div>
	</fieldset>
</html:form></div>
</div>
<div class="zishiying"></div>
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
jQ(function () {
	 
	 var incidentCount = ${IGVIR14031VO.incidentCount};
	 var problemCount = ${IGVIR14031VO.problemCount};
	 var changeCount = ${IGVIR14031VO.changeCount};
	 jQ('#omCount').highcharts({
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
             name: '数量',
             data: [
                 ['事件', incidentCount],
                 ['问题', problemCount],
                 ['变更', changeCount]
             ]
         }]
     });
	 
	 var resnewCount = ${IGVIR14031VO.resnewCount};
	 var resadjustCount = ${IGVIR14031VO.resadjustCount};
	 var resrecoverCount = ${IGVIR14031VO.resrecoverCount};
	 jQ('#resCount').highcharts({
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
             name: '数量',
             data: [
                 ['资源申请', resnewCount],
                 ['资源调整', resadjustCount],
                 ['资源回收', resrecoverCount]
             ]
         }]
     });
});
var nowPage = 0;
var totalPage = 0;
function getTreeData(){
	jQuery.ajax({
		url:"IGVIR1403_VMCount.do",
		type:"POST",
		dataType :"json",
		data:{nowPage:nowPage,pageDispCount:10},
		async:false,
		cache:false,
		success:function(res){
			var pageform = res.page;
			totalPage = pageform.totalPage;
			
			if(totalPage > 0){
				if (nowPage == 0) {
					jQuery('#previous').css({display:'none'});
				} else {
					jQuery('#previous').css({display:''});
				}
				if (nowPage == (totalPage -1)) {
					jQuery('#next').css({display:'none'});
				} else {
					jQuery('#next').css({display:''});
				}
			}
			initLine(res.name, res.value);
			
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			//alert('出错了');
		}
	});
}

function getNext(){
	nowPage = nowPage + 1;
	getTreeData();
}

function getPrevious(){
	nowPage = nowPage - 1;
	getTreeData();
}

function initLine(categories, series){
	
	// 资源分布情况
  	 jQ('#countInfo').highcharts({
  		chart: {
           type: 'column'
       },
       title: {
           text: ''
       },
       subtitle: {
           text: ''
       },
       exporting:{
     	   enabled:false
       },
       xAxis: {
           categories: categories
       },
       yAxis: {
           min: 0,
           title: {
               text: ''
           }
       },
       tooltip: {
           pointFormat: '<tr><td style="color:{series.color};padding:0; width:100px;">{series.name}: </td>' +
               '<td style="padding:0;"><b>{point.y} </b></td></tr>',
           footerFormat: '</table>',
           shared: true,
           useHTML: true
       },
       plotOptions: {
           column: {
               pointPadding: 0.2,
               borderWidth: 0,
               pointWidth:20
           }
       },
       legend:{
    	   enabled:false
       },
       series: series
      });		 
	
}

getTreeData();
</script>
</html:html>
